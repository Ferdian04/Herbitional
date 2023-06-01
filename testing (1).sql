-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2023 at 04:38 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testing`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_artikel`
--

CREATE TABLE `tabel_artikel` (
  `id` int(255) NOT NULL,
  `nama_obat` varchar(255) NOT NULL,
  `khasiat` mediumtext NOT NULL,
  `efek_samping` mediumtext NOT NULL,
  `deskripsi` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_artikel`
--

INSERT INTO `tabel_artikel` (`id`, `nama_obat`, `khasiat`, `efek_samping`, `deskripsi`) VALUES
(1, 'Adas', 'Sakit Perut (Mulas), Perut Kembung, Mual, Muntah, ASI Sedikit, Diare, Sakit Kuning (Jaundice), Kurang Nafsu Makan, Batuk, Sesak Napas (Asma), Nyeri Haid, Haid Tidak Tertur, Rematik Goat, Susah Tidur (Insomnia), Buah Pelir Turun (Orchidoptosis), Kolik, Usus Turun Ke Lipat Paha (Hernia Inguinalis), Batu Empedu, Pembengkakan Saluran Sperma (Epididimis), Penimbunan Cairan Dalam Kantung Buah Zakar (Hiodrokel Testis), Keracunan Tumbuhan Obat atau Jamur, Meningkatkan Penglihatan.', 'Bagi yang sedang hamil dan menyusu jangan mengonsumsinya. Bagi anak-anak: sebaiknya tidak mengonsumsi dengan dosis yang berlebihan sebelum berkonsultasi dengan herbalis atau dokter.', 'Terna merumpun, tingginya 0,5 - 2 m. Batang berwarna hijau kebiru-biruan, beralur, beruas, dan berongga, bila dimemarkan keluar bau wangi yang semerbak.\r\n\r\nDuduk daun berseling dengan daun majemuk menyirip ganda dua dengan sirip-sirip yang sempit, bentuk daun jarum, ujung daun dan pangkal daun runcing, tepi rata, mempunyai seludang berwarna putih. Untaian bunga yang ujung batang tersusun dalam bunga payung majemuk yang terdiri atas 6-40 tangkai bunga berwarna kuning.\r\n\r\nBuah muda berwarna hijau, setelah masak berwarna coklat agak kuning sampai sepenuhnya cokelat.'),
(2, 'Ajeran', 'mengobati Bisul, Gatal Gatal, Sakit Gigi, Sakit Mata', 'Karena rasanya yang pahit, sebaiknya tambahkan sedikit gula atau madu. Pemanfaatan ajeran dengan dosis tinggi perlu sikap hati-hati karena dapat menyebabkan iritasi ginjal.', 'Herba dengan tinggi 0,3 - 1 m. Batang bersegi empat hijau, dan ujungnya kadang berbulu kasar. Daun terbagi menjadi tiga dengan bentuk bulat telur pinggirannya bergerigi. Bunga bertangkai panjang, bunga tepi berwarna putih, sedangkan bunga tengahnya berwarna kuning.\r\n\r\nBidens pilosa (ketul) termasuk dalam famili Asteraceae yang berbentuk terna. Jenis ini umumnya ditemukan tumbuh secara liar sebagai gulma, baik di tepi jalan, di kebun, di pekarangan, maupun pada lahan terlantar.\r\n\r\nTumbuhan ini toleran terhadap tanah yang lembab dan daerah yang mendapat sinar matahari penuh. Terna jenis ini banyak dijumpai hingga ketinggian 2.300 meter dari permukaan laut.\r\n\r\nTumbuhan ini dapat berbunga sepanjang tahun. Apabila keadaan atau kondisi lingkungan sesuai, persentase perkecambahan sebesar 35-60% dalam waktu seminggu.\r\n\r\nKelebihan lain adalah walaupun telah tersimpan selama 3-5 tahun, daya kecambah bijinya tetap tinggi sekitar 80% biji masih mampu berkecambah.\r\n\r\nAir rebusan atau perasan daun tumbuhan ini dapat dijadikan obat tradisional, yaitu mengobati beberapa penyakit seperti batuk, sakit kepala, demam, sakit perut, keracunan, sembelit, dan lain-lain. Sedangkan daun muda tumbuhan ini biasa digunakan sebagai bahan campuran lalapan.');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_riwayat_user`
--

CREATE TABLE `tabel_riwayat_user` (
  `id_riwayat` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `artikel_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_riwayat_user`
--

INSERT INTO `tabel_riwayat_user` (`id_riwayat`, `user_id`, `artikel_id`) VALUES
(24, 25, 1),
(25, 25, 1),
(26, 26, 1),
(27, 24, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
  `user_id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `createdAt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`user_id`, `fullname`, `user_email`, `user_password`, `createdAt`) VALUES
(24, 'yahya', 'assaas', '$2b$08$tLLtLies6e0mEb5lLVeJPe.JZzvh25k8dOl6vS77fQlYEDpDK.CPK', '2023-05-21T12:50:35.183Z'),
(25, 'yahya', 'yahyap20@gmail.com', '$2b$08$a1o03QwgIeHcSK.635KEJ.cLYf3ARCqibGY0YSN3j182z09lOAWG2', '2023-05-26T01:27:39.083Z'),
(26, 'adad', 'yahyap167@gmail.com', '$2b$08$Zk.wHwr5HteKF/DCLZ6g2uL9U3F4kfRuMeUZ1HTOSeLguSfxp7Ldi', '2023-05-29T11:14:53.004Z');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_artikel`
--
ALTER TABLE `tabel_artikel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabel_riwayat_user`
--
ALTER TABLE `tabel_riwayat_user`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `FK_USER_ID` (`user_id`),
  ADD KEY `FK_ARTIKEL_ID` (`artikel_id`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_artikel`
--
ALTER TABLE `tabel_artikel`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tabel_riwayat_user`
--
ALTER TABLE `tabel_riwayat_user`
  MODIFY `id_riwayat` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `user_login`
--
ALTER TABLE `user_login`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tabel_riwayat_user`
--
ALTER TABLE `tabel_riwayat_user`
  ADD CONSTRAINT `FK_ARTIKEL_ID` FOREIGN KEY (`artikel_id`) REFERENCES `tabel_artikel` (`id`),
  ADD CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
