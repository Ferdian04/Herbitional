from flask import Flask, request, jsonify
import joblib
import numpy as np
import tensorflow as tf

# Load the label encoder and model
label_encoder = joblib.load('label_encoder.pkl')
model = tf.keras.models.load_model('diseasePredict.h5', compile=False)

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json  # Mendapatkan data input dari permintaan POST
    symptoms = data['symptoms']  # Mendapatkan gejala dari data input

    # Mengubah gejala menjadi vektor input
    x = np.array(symptoms)  # Menggunakan gejala langsung sebagai vektor input
    x = x.reshape(1, -1)  # Mengubah bentuk vektor menjadi (1, panjang_vektor)

    # Melakukan prediksi penyakit menggunakan model
    prediction = model.predict(x)
    predicted_class = np.argmax(prediction)

    # Mengembalikan hasil prediksi dalam bentuk label penyakit
    predicted_disease = label_encoder.inverse_transform([predicted_class])[0]

    response = {'predicted_disease': predicted_disease}
    return jsonify(response)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=int(os.environ.get('PORT', 8080)))
