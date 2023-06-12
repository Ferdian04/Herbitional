# Herbitional API

This is API Service for Capstone Project on Bangkit 2022. For Api Documentation you can see below

## Built with

- Express 4.18.2
- bcrypt 5.1.0
- body-parser 1.20.2
- cookie-parser 1.4.6
- cors 2.8.5
- dotenv 16.0.3
- jsonwebtoken 9.0.0
- module-name 0.0.1-security
- multer 1.4.5-lts.1
- mysql 2.18.1
- validator 13.9.0

# Herbitional API Planning & Documentation

URL: https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/{version}/{Group}/{endpoint}

---

## Group: Auth

### [1] - Register

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/auth/register
- Endpoint:
  - `/register`
- Method:
  - `POST`
- Request Body:
  - `fullname` : string, `NOT NULL`,
  - `user_email_address` : string, `NOT NULL`
  - `user_password`: string, `NOT NULL`
  ```
  {
    fullname: "example",
    user_email_address: "email@email.com",
    user_password: "examplepass123"
  }
  ```
- Response (example) :
  ```
  status: "Success",
  code: 201,
  ```
- Error Response:
  - `400` : EMAIL_REQUIRED, PASSWORD_REQUIRED,
  - `409` : EMAIL_ALREADY_EXIST,

### [2] - Login

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/auth/login
- Endpoint:
  - `/login`
- Method:
  - `POST`
- Request Body:
  - `user_email_address` : string, email need to be valid
  - `user_password`: string, email and password need to be match

```
{
    user_email_address : "example@email.com",
    user_password: "exmaplepassword123"
}
```

- Response (example) :

```
{
    status: "Success",
    code: 200,
    message: "logged in successfully",
    Token
}
```

- Err Response:
  - `400` : EMAIL_REQUIRED, PASS_REQUIRED
  - `401` : USER_NOT_FOUND, EMAIL_NOT_REGISTERED, PASSWORD_INVALID

## Group: User

### [1] - Profile

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/user/profile/:id
- Endpoint:
  - `/profile/:id`
- Method:
  - `GET`
- Headers:
  - `Authorization` : Bearer < Access-Token >
- Response (example):

```
{
    status: "Success",
    riwayat: [
        {
            id_riwayat: 26,
            id_penyakit: 1,
            nama_penyakit: "Batuk"
        }
    ]
}
```

### [2] - Input History

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/user/inshistori
- Endpoint:
  - `/inshistori`
- Method:
  - `POST`
- Headers:
  - `Authorization` : Bearer < Access-Token >
- Request Body:
  - `user_id` : integer
  - `penyakit_id`: integer

```
{
    user_id : 26,
    penyakit_id: 1
}
```
- Response (example):

```
{
    status: "Success",
    code: 201
}
```

## Group: Medicine

### [1] - Home

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/medicine/home
- Endpoint:
  - `/home`
- Method:
  - `GET`
- Headers:
  - `Authorization` : Bearer < Access-Token >
- Response (example) :

```
{
    status: "Success",
    code: 201,
    artikel: [
        {
            id: 20,
            nama_obat: "Anggur",
            deskripsi: "Tanaman berbentuk semak menjalar yang panjangnya dapat mencapai 8 m. Batang berkayu, silindris, menjalar, berwarna hijau kecoklatan dengan permukaan halus. Daun tunggal, tersusun berseling, berwarna hijau, berbentuk bundar.",
            foto_obat: "example.jpg"
        },
        {
            id: 26,
            nama_obat: "Bambu Kuning",
            deskripsi: "Rumpun, tumbuh tegak dan tidak terlalu rapat, rebung kuning atau hijau tertutup bulu cokelat hingga hitam. Percabangan tumbuh 1,5 m dari permukaan tanah. Buluh muda hijau mengkilap atau kuning bergaris hijau. Pelepah buluh mudah luruh, tertutup bulu hitam hingga cokelat",
            foto_obat: "example.jpg"
        },
        {
            id: 60,
            nama_obat: "Cabai rawit",
            deskripsi: "Batang utama tumbuh tegak dan kuat. Percabangan terbentuk setelah batang tanaman mencapai ketinggian 30-45 cm. Daun berbentuk bulat telur dengan ujung runcing dan tepi daun rata. Bunga tunggal berbentuk bintang, tumbuh menunduk pada ketiak daun, mahkota bunga berwarna putih. Buah dapat berbentuk bulat pendek dengan ujung runcing atau berbentuk kerucut. Warna buah bervariasi, buah muda berwarna hijau a putih, sedangkan buah yang telah masa berwarna merah menyala. Biji berwarna putih kekuningan-kuningan, berbentuk bulat pipih, tersusun berkelompok, dan saling melekat pada empulur.",
            foto_obat: "example.jpg"
        },
        {
            id: 28,
            nama_obat: "Bangle",
            deskripsi: "Herba semusim, tumbuh tegak, tinggi 1-1,5 m, berbatang semu, terdiri dari pelepah daun yang di pinggirnya berambut sikat. Daun tunggal, letak 35 cm. Bunga majemuk tandan, muncul di ujung batang, kelopak tersusun seperti sisik tebal, warna merah menyala. Bibir bunga bentuknya bundar memanjang, warnanya putih atau pucat. Rimpang bentuknya hampir bundar sampai jorong atau tidak beraturan",
            foto_obat: "example.jpg"
        },
        {
            id: 73,
            nama_obat: "Daun Jinten",
            deskripsi: "Herba sukulen yang tingginya dapat mencapai i m. Percabangannya banyak, berbulu padat terutama pada bagian yang masih muda. Daunnya tebal berdaging, berbentuk bulat atau seperti ginjal dengan posisi berhadapan, pinggiran daun bergerigi dan permukaannya berbulu seperti beludru. Perbungaan muncul di ketiak daun atau di ujung percabangan berupa tandan. Bunga- bunga berkelompok, berwarna biru. Biji berbentuk gepeng keras, berwarna cokelat.",
            foto_obat: "example.jpg"
        }
    ]
}
```

### [2] - Specific Medicine

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/medicine/specificmed/:id_artikel
- Endpoint:
  - `specificmed/:id_artikel`
- Method:
  - `GET`
- Headers:
  - `Authorization` : Bearer < Access-Token >
- Response (example) :

```
{
    status: "Success",
    code: 201,
    artikel: [
        {
            id: 26,
            nama_obat: "Bambu Kuning",
            khasiat: "Hepatitis dan Kolesterol.",
            efek_samping: "Belum ditemukan literatur yang menyebutkan adanya kontraindikasi maupun efek samping dari konsumsi rebung bambu kuning. Namun, sebaiknya beberapa hal ini perlu diperhatikan sebagai sikap kewaspadaan.\r\n\r\n1. Bagi yang sedang hamil dan menyusui: jangan mengkonsumsi rebung bambu kuning.\r\n\r\n2. Bagi anak-anak: sebaiknya tidak mengkonsumsi dengan dosis yang berlebihan sebelum berkonsultasi dengan herbalis atau dokter.",
            deskripsi: "Rumpun, tumbuh tegak dan tidak terlalu rapat, rebung kuning atau hijau tertutup bulu cokelat hingga hitam. Percabangan tumbuh 1,5 m dari permukaan tanah. Buluh muda hijau mengkilap atau kuning bergaris hijau. Pelepah buluh mudah luruh, tertutup bulu hitam hingga cokelat",
            foto_obat: "example.jpg"
        }
    ]
}
```

### [3] - Search Medicine (DO NOT USE)

- URL:
  - https://herbitional-v3-hzyvjvw72a-uc.a.run.app/api/v1/medicine/searchmed/:search
- Endpoint:
  - `searchmed/:search`
- Method:
  - `GET`
- Headers:
  - `Authorization` : Bearer < Access-Token >
- Response (example) :

```
{
    status: "Success",
    code: 201,
    artikel: [
        {
            id: 1,
            nama_obat: "Adas",
            deskripsi: "Terna merumpun, tingginya 0,5 - 2 m. Batang berwarna hijau kebiru-biruan, beralur, beruas, dan berongga, bila dimemarkan keluar bau wangi yang semerbak.\r\n\r\nDuduk daun berseling dengan daun majemuk menyirip ganda dua dengan sirip-sirip yang sempit, bentuk daun jarum, ujung daun dan pangkal daun runcing, tepi rata, mempunyai seludang berwarna putih. Untaian bunga yang ujung batang tersusun dalam bunga payung majemuk yang terdiri atas 6-40 tangkai bunga berwarna kuning.\r\n\r\nBuah muda berwarna hijau, setelah masak berwarna coklat agak kuning sampai sepenuhnya cokelat.",
            foto_obat: "example.jpg"
        },
        {
            id: 2,
            nama_obat: "Ajeran",
            deskripsi: "Herba dengan tinggi 0,3 - 1 m. Batang bersegi empat hijau, dan ujungnya kadang berbulu kasar. Daun terbagi menjadi tiga dengan bentuk bulat telur pinggirannya bergerigi. Bunga bertangkai panjang, bunga tepi berwarna putih, sedangkan bunga tengahnya berwarna kuning.\r\n\r\nBidens pilosa (ketul) termasuk dalam famili Asteraceae yang berbentuk terna. Jenis ini umumnya ditemukan tumbuh secara liar sebagai gulma, baik di tepi jalan, di kebun, di pekarangan, maupun pada lahan terlantar.\r\n\r\nTumbuhan ini toleran terhadap tanah yang lembab dan daerah yang mendapat sinar matahari penuh. Terna jenis ini banyak dijumpai hingga ketinggian 2.300 meter dari permukaan laut.\r\n\r\nTumbuhan ini dapat berbunga sepanjang tahun. Apabila keadaan atau kondisi lingkungan sesuai, persentase perkecambahan sebesar 35-60% dalam waktu seminggu.\r\n\r\nKelebihan lain adalah walaupun telah tersimpan selama 3-5 tahun, daya kecambah bijinya tetap tinggi sekitar 80% biji masih mampu berkecambah.\r\n\r\nAir rebusan atau perasan daun tumbuhan ini dapat dijadikan obat tradisional, yaitu mengobati beberapa penyakit seperti batuk, sakit kepala, demam, sakit perut, keracunan, sembelit, dan lain-lain. Sedangkan daun muda tumbuhan ini biasa digunakan sebagai bahan campuran lalapan.",
            foto_obat: "example.jpg"
        },
        {
            id: 13,
            nama_obat: "Akar Kuning ",
            deskripsi: "Liana berkayu, panjangnya dapat mencapai 20 m, diameter batang 5 - 10 cm. Kayunya kuning dan mengeluarkan getah yang berwarna kuning pula jika dipotong.\r\n\r\nDaun bulat dengan ukuran 10-25 cm x 5,5-19 cm, urat daun menjari lima pada pangkalnya, tangkai daun menggembung pada kedua pangkalnya, tidak berdaun penumpu.\r\n\r\nPerbungaan malai, di ketiak daun atau di batang, warna kelopak dan mahkota kuning. Buah membulat kotak dengan tiga rusuk, kulit agak berbulu dan hijau hingga coklat kehitaman. Biji tunggal, kecil, cokelat.",
            foto_obat: "example.jpg"
        },
        {
            id: 17,
            nama_obat: "Amargo",
            deskripsi: "Tanaman perdu dapat mencapai tinggi 4 m. Batang tegak dan bercabang banyak. Daun majemuk, berbentuk lonjong dengan panjang 5-10 cm, ujung tumpul, pangkal membulat, permukaan halus.\r\n\r\nBunga majemuk di ujung percabangan, panjang hingga 20 cm, berwarna merah keunguan. Buah bulat berwarna putih kecoklatan dengan biji bulat berwarna putih.",
            foto_obat: "example.jpg"
        },
        {
            id: 19,
            nama_obat: "Anggrek Tanah",
            deskripsi: "Herba semusim dengan tinggi mencapai 1 meter. Berbatang bulat dan lunak agak berbulu, batang bagian dalam tanah membentuk umbi. Daun tunggal berbentuk lonjong dengan panjang 5-8 cm dan berujung runcing. Bunga majemuk berbentuk tandan terdapat di ujung batang, tangkai bunga silindris panjangnya 40-50 cm berwarna hijau. Buah lonjong berwarna kuning pucat dengan biji bulat kecil berwarna putih kehitaman.",
            foto_obat: "example.jpg"
        },
        {
            id: 21,
            nama_obat: "Anjeran",
            deskripsi: "Tumbuhan ini dikenal sebagai tanaman semak yang banyak tumbuh di pinggir jalan atau sengaja ditanam di pekarangan rumah sebagai tanaman hias. Tumbuhan ini mudah tumbuh, tidak suka air, tinggi mencapai 1,5 meter. Batang berbentuk agak lonjong dengan pinggir bergerigi. Bunga bertangkai panjang, mahkota bunga berwarna putih dengan putik berwarna kuning.",
            foto_obat: "example.jpg"
        },
        {
            id: 23,
            nama_obat: "Aren (Enau)",
            deskripsi: "Palem pohon yang tidak bercabang, tingginya bisa mencapai 20 m. Batang ditutupi oleh bekas pangkal tangkai daun dan serat-serat panjang berwarna hitam keabu-abuan. Daun menyirip dengan panjang 6-10 m, tangkai daun 1-1,5 m. Perbungaan berumah satu, tumbuh di antara ketiak daun, merunduk bisa lebih dari 2 m panjangnya, bunga betina ada di ujung dan bunga jantan tumbuh di bagian bawah batangnya. Buah batu, berbentuk bulat atau bulat telur dengan panjang 5- 8 cm, berdaging, terdiri atas 2-3 biji hitam.",
            foto_obat: "example.jpg"
        },
        {
            id: 28,
            nama_obat: "Bangle",
            deskripsi: "Herba semusim, tumbuh tegak, tinggi 1-1,5 m, berbatang semu, terdiri dari pelepah daun yang di pinggirnya berambut sikat. Daun tunggal, letak 35 cm. Bunga majemuk tandan, muncul di ujung batang, kelopak tersusun seperti sisik tebal, warna merah menyala. Bibir bunga bentuknya bundar memanjang, warnanya putih atau pucat. Rimpang bentuknya hampir bundar sampai jorong atau tidak beraturan",
            foto_obat: "example.jpg"
        },
        {
            id: 29,
            nama_obat: "Bangle Hantu (Lempuyang) ",
            deskripsi: "Herba berbatang semu, tegak, tinggi mencapai 2 m, tumbuh merumpun. Daun tunggal berbentuk lanset dan ujungnya meruncing. Bunga majemuk berbentuk bulir memanjang. Buah kotak berbiji bulat berwarna hitam. Rimpang berwarna ungu kotor dan berbau tajam.",
            foto_obat: "example.jpg"
        },
        {
            id: 33,
            nama_obat: "Bawang Merah",
            deskripsi: "Tanaman semusim yang berbentuk seperti rumput, berbatang pendek dan berakar serabut, tinggi dapat mencapai 25 cm dan membentuk numpun. Daun berbentuk seperti pipa, bulat kecil memanjang so-70 cm, berlubang, bagian ujungnya meruncing, berwarna hijau muda sampai hijau tua Batang semu yang berada di dalam tanah berubah bentuk dan menjadi umbi lapis Tangkai bunga keluar dari dasar umbi. Bunga majemuk berbentuk tandan yang terdiri atas 50-200 kuntum bunga. Buah berbentuk bulat dengan ujung tumpul yang membungkus bij yang berbentuk agak pipih",
            foto_obat: "example.jpg"
        },
        {
            id: 35,
            nama_obat: "Bayam Duri",
            deskripsi: "Herba semusim, tumbuh tegak, tinggi mencapai a m Batang berwarna hijau atau kemerahan, bagian pangkal polos, bagian atas sedikit berambut, sering bercabang banyak dan berduri. Daun tunggal, bertangkai panjang, letak berseling, tepi rata kadang beringgit. Pada ketiak daun terdapat sepasang duri keras yang mudah lepas. Bunga keluar di ketiak daun atau vjung batang, warnanya hijau keputihan. Buah bulat panjang, hijau, berbiji bulat, kecil, dan berwarna hitam.",
            foto_obat: "example.jpg"
        },
        {
            id: 41,
            nama_obat: "Biduri",
            deskripsi: "Perdu mencapai tinggi 2 m. Batang silindris, berwarna putih kotor, dengan permukaan halus. Daun tunggal, tidak bertangkai, tersusun berhadapan, warna hijau keputih-putihan, panjang 8-20 cm, lebar 4-15 cm, helaian daun tebal, berbentuk bulat telur, ujung tumpul, pangkal berlekuk, tepi rata, permukaan",
            foto_obat: "example.jpg"
        },
        {
            id: 51,
            nama_obat: "Bun Peron",
            deskripsi: "Tumbuhan merambat berkayu dengan banyak sulur, dapat mencapai panjang 3 m. Daun terbagi dua masing-masing bercangap tiga. Bunga kecil-kecil hampir tidak terlihat, berwarna putih. Buah kapsul berwarna cokelat, berkulit tipis, berdiameter hingga 1 cm. Terdapat tiga biji hitam yang berbentuk jantung.",
            foto_obat: "example.jpg"
        },
        {
            id: 56,
            nama_obat: "Bunga Tahi Kotok",
            deskripsi: "Herba tegak dengan tinggi mencapai a m Batang bulat, hijau kecokelatan dengan permukaan agak kasar. Daun majemuk bertangkai, anak daun saling berhadapan. Permukaan atas dan bawah daun berbulu halus dan rapat. Bunga bonggol di ujung, bertangkai pendek, berwarna kuning atau orange.",
            foto_obat: "example.jpg"
        },
        {
            id: 59,
            nama_obat: "Cabai Jawa",
            deskripsi: "Tumbuhan memanjat, menjalar atau melilit, panjang bisa mencapai 1o m. Akar melekat pada pohon lain. Daun tunggal, bentuk elips, ujung runcing, tepi rata, permukaan atas mengilap. Bunga berkelamin tunggal, bentuk bulir memanjang, bulir jantan lebih pendek daripada yang betina. Buah majemuk, berupa bulir, bulat memanjang 2-7 cm, mengecil di bagian atas, ketika muda berwarna hijau kemudian menjadi merah.",
            foto_obat: "example.jpg"
        },
        {
            id: 60,
            nama_obat: "Cabai rawit",
            deskripsi: "Batang utama tumbuh tegak dan kuat. Percabangan terbentuk setelah batang tanaman mencapai ketinggian 30-45 cm. Daun berbentuk bulat telur dengan ujung runcing dan tepi daun rata. Bunga tunggal berbentuk bintang, tumbuh menunduk pada ketiak daun, mahkota bunga berwarna putih. Buah dapat berbentuk bulat pendek dengan ujung runcing atau berbentuk kerucut. Warna buah bervariasi, buah muda berwarna hijau a putih, sedangkan buah yang telah masa berwarna merah menyala. Biji berwarna putih kekuningan-kuningan, berbentuk bulat pipih, tersusun berkelompok, dan saling melekat pada empulur.",
            foto_obat: "example.jpg"
        },
        {
            id: 64,
            nama_obat: "Ceplukan",
            deskripsi: "Herba yang berperawakan tinggi dapat mencapai 1 m. Akarnya berupa akar tunggang dan berwarna putih. Batangnya tegak berbentuk segi empat, berkayu, lunak, hijau pucat Daun tunggal, duduk daun berseling, berbentuk lonjong dengan tepi bergelombang, panjang 8-11 cm, lebar 5-7 cm, ujung daun runcing, pangkal daun tumpul. Bunga berbentuk corong keluar dari ketiak daun dengan kelopak berlekatan, bercangap lima, berwarna hijau, benang sari lima, tangkai sari kuning, kepala sari biru dengan satu putik, berbulu dan berwarna kuning pucat. Buah lonjong terbungkus kelopak, ketika muda berwarna hijau dan setelah masak berwarna kuning pucat.",
            foto_obat: "example.jpg"
        },
        {
            id: 75,
            nama_obat: "Daun Panahan",
            deskripsi: "Herba menahun dan banyak membentuk anakan. Batangnya panjang dan tumbuh ke atas, sering membentuk akar o,5- im panjangnya pada bagian kaki. Daun tunggal berhadapan, berbentuk lanset dengan pangkal dan ujung meruncing, tepi rata, berwarna hijau keunguan. Bunga di ujung batang berwarna hijau keunguan. Buah berupa buah kendaga.",
            foto_obat: "example.jpg"
        }
    ]
}
```
