# Herbitional ML

This is ML

## Built with

- Express 4.18.2
- flask 2.0
- flask-mysql 1.5.2
- joblib 1.2.0
- nltk 3.8.1
- numpy 1.24.3
- pandas 2.0.2
- scikit-learn 1.2.2
- tensorflow 2.9.3

# Herbitional ML API Documentation

URL: http://www.url-api.com/{endpoint}

### [1] - Predict Disease

- URL:
  - http://www.url-api.com/predict
- Endpoint:
  - `/predict`
- Method:
  - `POST`
- Request Body:
  - `symptoms` : array, `NOT NULL`
  ```
  {
      "symptoms": [0,1,1,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0]
  }
  ```
- Response (example) :
  ```
  {
      "data": [
          {
              "anjuran_penanganan_1": "Segerakan mengunjungi dokter jika Anda mengalami gejala-gejala berikut: Demam tinggi disertai gejala-gejala setelah mengunjungi daerah dengan risiko penyakit malaria yang tinggi, Demam tinggi disertai gejala seperti lemas, penurunan nafsu makan dan tinggal seorang diri atau jauh dari fasilitas kesehatan Mengalami penurunan kesadaran, Kejang.",
              "anjuran_penanganan_2": "",
              "deskripsi_penyakit_1": "Malaria adalah penyakit menular yang disebarkan melalui gigitan nyamuk. Biasanya pasien akan mengeluhkan gejala demam, lemas, dan menggigil.",
              "deskripsi_penyakit_2": "",
              "id_penyakit": 30,
              "links-href": "https://www.klikdokter.com/penyakit/masalah-infeksi/malaria",
              "nama_penyakit": "Malaria"
          }
      ]
  }
  ```
