# Herbitional ML

This is ML Model and API Service for Capstone Project on Bangkit 2022. For Api Documentation you can see below

## Built with

- flask 2.0
- joblib 1.2.0
- nltk 3.8.1
- numpy 1.24.3
- pandas 2.0.2
- scikit-learn 1.2.2
- tensorflow 2.9.3
- mysql 0.0.3
- Flask-MySQLdb 1.0.1

# Herbitional ML API Documentation

URL: https://search-engine-v5-hzyvjvw72a-uc.a.run.app/{endpoint}

### [1] - Predict Disease

- URL:
  - https://search-engine-v5-hzyvjvw72a-uc.a.run.app/predict
- Endpoint:
  - `/predict`
- Method:
  - `POST`
- Request Body:
  - `input-text` : string, `NOT NULL`
  ```
  {
      "input-text": "sakit"
  }
  ```
- Response (example) :
  ```
  {
      "input_text": "sakit",
      "predictions": [
          {
              "deskripsi": "Terna dapat mencapai tinggi hingga im. Batang bersegi empat. Daun membundar telur lonjong dengan pinggiran bergigi menggergaji. Perbungaan berupa tandan yang tertutup rapat oleh bulu-bulu biasa dan bulu kelenjar, panjang 6-18 cm, mahkota bunga berwarna ungu kemerahan 2-2,5 cm panjangnya.",
              "efek_samping": "Herba liar ini termasuk kelompok tumbuhan mint yang banyak dikenal sebagai bahan obat-obatan. Sangketan termasuk tumbuhan endemik tropis yang oleh beberapa negara Asia Tenggara digunakan sebagai tanaman hias sekaligus bahan obat alami, tetapi saat ini mulai sulit ditemukan di alam. Di antara suku Kalanguya dari Tinoc, Ifugao, daun yang telah dihancurkan digunakan untuk mengobati luka bakar dan kudis. Benihnya dapat dimakan untuk mengusir cacing dari perut.",
              "foto": "https://storage.googleapis.com/herbitionalbucket/foto_obat/sangketan.jpg",
              "id": 242,
              "khasiat": "Sakit Pinggang dan Sakit Perut.",
              "label": "Sangketan",
              "predicted_id": 242,
              "predicted_label": "Sangketan",
              "probability": 0.31162551045417786
          },
          {
              "deskripsi": "Tanaman memanjat pada pohon dengan panjang 10-15 m, batang silindris, tunggal atau bercabang berwarna hijau gelap, dan mempunyai akar adventif berwarna keputihan. Daun berselingan, tebal berdaging, helaian daun bulat- elips-lanset, berukuran 8-25 x 2-8 cm, pangkal batang membundar, ujung daun runcing-meruncing. Perbungaan keluar dari ketiak daun dalam malai pendek berukuran 5-10 cm, jumlah bunga 6-30 bunga, diameter bunga sampai 10 cm, berlilin, wangi, berwarna hijau-kuning Buah menggantung, berbentuk kapsul silindris pipih, terbuka membujur saat matang. Biji sangat banyak, bulat, diameter 0,4 mm berwarna hitam.",
              "efek_samping": "Meskipun belum ditemukan literatur yang menyebutkan adanya kontraindikasi maupun efek samping dari konsumsi buah vanili. Sebaiknya beberapa hal ini perlu diperhatikan sebagai sikap kewaspadaan.\r\n\r\n1. Bagi yang sedang hamil dan menyusui: jangan mengonsumsinya.\r\n\r\n2. Bagi anak-anak: sebaiknya tidak mengonsumsi dengan dosis yang berlebihan sebelum berkonsultasi dengan herbalis atau dokter.",
              "foto": "https://storage.googleapis.com/herbitionalbucket/foto_obat/vanili.jpg",
              "id": 262,
              "khasiat": "Sakit Kepala.",
              "label": "Vanili",
              "predicted_id": 262,
              "predicted_label": "Vanili",
              "probability": 0.2529505491256714
          },
          {
              "deskripsi": "Herba semusim, tumbuh tegak hingga 40 cm. Daun hijau berbentuk oval atau elips dan duduk berhadapan, tepinya bergerigi, dan berambut kasar pada kedua permukaannya. Bunga kecil berwarna kuning 3-8 bunga pita, braktea pada pembalut bunga seperti daun. Buah berwarna hitam atau cokelat tua disertai 2-3 pappus kaku.",
              "efek_samping": "Belum ditemukan literatur yang menyebutkan adanya kontraindikasi maupun efek samping dari konsumsi tanaman jotang kuda. Sebaiknya tidak mengonsumsi dengan dosis yang berlebihan sebelum berkonsultasi dengan herbalis atau dokter.",
              "foto": "https://storage.googleapis.com/herbitionalbucket/foto_obat/jotang-kuda.jpg",
              "id": 105,
              "khasiat": "Sakit Perut dan Rematik.",
              "label": "Jotang Kuda",
              "predicted_id": 105,
              "predicted_label": "Jotang Kuda",
              "probability": 0.1504046767950058
          }
      ]
  }
  ```
