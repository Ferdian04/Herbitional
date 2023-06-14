from flask import Flask, request, jsonify
from flaskext.mysql import MySQL
import joblib
import numpy as np
import tensorflow as tf
import os

# Load the label encoder and model
label_encoder = joblib.load('label_encoder.pkl')
model = tf.keras.models.load_model('./diseasePredict.h5', compile=False)

app = Flask(__name__)

# Konfigurasi koneksi MySQL
app.config['MYSQL_DATABASE_HOST'] = '34.128.76.143'
app.config['MYSQL_DATABASE_USER'] = 'root'
app.config['MYSQL_DATABASE_PASSWORD'] = 'herbitional'
app.config['MYSQL_DATABASE_DB'] = 'herb'

mysql = MySQL(app)

@app.route('/predict', methods=['POST'])
def predict():
    data = request.form.get("symptoms")  # Mendapatkan data input dari permintaan POST
    # symptoms = data['symptoms']  # Mendapatkan gejala dari data input

    array_data = data.split(",")
    array_data = [int(num) for num in array_data]

    # Mengubah gejala menjadi vektor input
    x = np.array(array_data)  # Menggunakan gejala langsung sebagai vektor input
    x = x.reshape(1, -1)  # Mengubah bentuk vektor menjadi (1, panjang_vektor)

    # Melakukan prediksi penyakit menggunakan model
    prediction = model.predict(x)
    predicted_class = np.argmax(prediction)

    # Mengembalikan hasil prediksi dalam bentuk label penyakit
    predicted_disease = label_encoder.inverse_transform([predicted_class])[0]

    # Mengambil semua kolom pada row tertentu di tabel 'gejala'
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM tabel_penyakit WHERE id_penyakit=%s", (predicted_disease,))
    result = cursor.fetchone()

    if result:
        table_data = [
            {
                "anjuran_penanganan_2": result[6],
                "anjuran_penanganan_1": result[5],
                "deskripsi_penyakit_2": result[4],
                "deskripsi_penyakit_1": result[3],
                "links-href": result[2],
                "nama_penyakit": result[1],
                "id_penyakit": result[0],
                # Tambahkan kolom lain sesuai kebutuhan
            }
        ]
        data = {"data": table_data}
        return jsonify(data)
    else:
        # Handle ketika tidak ada data yang ditemukan
        # ...
        return jsonify({"error": "Data not found"})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=int(os.environ.get('PORT', 8080)))
