-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 10 Oca 2022, 21:55:48
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `mobilya`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanicilar`
--

CREATE TABLE `kullanicilar` (
  `id` int(11) NOT NULL,
  `adsoyad` varchar(45) NOT NULL,
  `telefon` varchar(10) NOT NULL,
  `kullaniciadi` varchar(20) NOT NULL,
  `parola` varchar(200) NOT NULL,
  `kullanicituru` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanicilar`
--

INSERT INTO `kullanicilar` (`id`, `adsoyad`, `telefon`, `kullaniciadi`, `parola`, `kullanicituru`) VALUES
(20, 'Deneme Yöenetici', '9876543210', 'yonetici', 'yonetici', 'ADMINISTRATOR'),
(29, 'Deneme Çalışan', '1122334455', 'calisan', 'calisan', 'EMPLOYEE');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `mevcutstok`
--

CREATE TABLE `mevcutstok` (
  `urunkodu` varchar(45) NOT NULL,
  `miktar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `mevcutstok`
--

INSERT INTO `mevcutstok` (`urunkodu`, `miktar`) VALUES
('urun2', 97),
('urun3', 200),
('urun4', 172),
('urun5', 500),
('urun6', 500),
('urun7', 10),
('urun8', 20);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteriler`
--

CREATE TABLE `musteriler` (
  `id` int(11) NOT NULL,
  `musterikodu` varchar(45) NOT NULL,
  `adsoyad` varchar(45) NOT NULL,
  `lokasyon` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `musteriler`
--

INSERT INTO `musteriler` (`id`, `musterikodu`, `adsoyad`, `lokasyon`, `telefon`) VALUES
(301, 'vip1', 'Ahmet keskin', 'Adana', '9818562354'),
(302, 'vip2', 'Kadir polat', 'ankara', '9650245489'),
(303, 'std1', 'mehmet demir', 'istanbul', '9236215622'),
(304, 'std2', 'salim kaya', 'bursa', '8854612478'),
(306, 'vip3', 'melih çakır', 'bolu', '9826546182');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satinalmabilgisi`
--

CREATE TABLE `satinalmabilgisi` (
  `id` int(11) NOT NULL,
  `tedarikcikodu` varchar(45) NOT NULL,
  `urunkodu` varchar(45) NOT NULL,
  `tarih` varchar(45) NOT NULL,
  `miktar` int(11) NOT NULL,
  `toplamtutar` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `satinalmabilgisi`
--

INSERT INTO `satinalmabilgisi` (`id`, `tedarikcikodu`, `urunkodu`, `tarih`, `miktar`, `toplamtutar`) VALUES
(1002, 'tedarikci1', 'urun6', 'Wed Jan 14 00:15:19 IST 2021', 20, 34000),
(1003, 'tedarikci2', 'urun3', 'Wed Jan 14 00:15:19 IST 2021', 5, 300000),
(1004, 'tedarikci2', 'urun5', 'Wed Jan 14 00:15:19 IST 2021', 5, 10000),
(1005, 'tedarikci3', 'urun2', 'Wed Jan 14 00:15:19 IST 2021', 2, 140000),
(1006, 'tedarikci4', 'urun4', 'Wed Jan 14 00:15:19 IST 2021', 2, 100000),
(1010, 'tedarikci1', 'urun7', 'Wed Sep 01 04:25:06 IST 2021', 10, 30000),
(1011, 'tedarikci2', 'urun8', 'Fri Sep 03 00:00:00 IST 2021', 20, 300000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satisbilgisi`
--

CREATE TABLE `satisbilgisi` (
  `id` int(11) NOT NULL,
  `tarih` varchar(45) NOT NULL,
  `urunkodu` varchar(45) NOT NULL,
  `musterikodu` varchar(45) NOT NULL,
  `miktar` int(11) NOT NULL,
  `gelir` double NOT NULL,
  `satisyapan` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `satisbilgisi`
--

INSERT INTO `satisbilgisi` (`id`, `tarih`, `urunkodu`, `musterikodu`, `miktar`, `gelir`, `satisyapan`) VALUES
(2001, 'Fri Jan 16 23:12:40 IST 2021', 'urun1', 'vip1', 3, 270000, 'stduser1'),
(2002, 'Fri Jan 16 23:12:40 IST 2021', 'urun2', 'vip2', 2, 144000, 'stduser1'),
(2003, 'Fri Jan 16 23:12:40 IST 2021', 'urun3', 'std1', 1, 64000, 'aduser1'),
(2004, 'Fri Jan 16 23:12:40 IST 2021', 'urun4', 'std2', 5, 255000, 'aduser1'),
(2006, 'Thu Aug 05 17:29:36 IST 2021', 'urun1', 'vip1', 2, 180000, 'root'),
(2007, 'Fri Aug 06 00:00:00 IST 2021', 'urun4', 'std1', 1, 51000, 'aduser1'),
(2008, 'Fri Aug 06 02:41:28 IST 2021', 'urun7', 'std1', 1, 3500, 'aduser1'),
(2009, 'Sat Aug 07 00:00:00 IST 2021', 'urun7', 'std1', 5, 17500, 'aduser1'),
(2010, 'Thu Aug 12 00:00:00 IST 2021', 'urun4', 'vip3', 2, 102000, 'root'),
(2011, 'Sun Aug 15 23:08:51 IST 2021', 'urun7', 'vip2', 10, 35000, 'root'),
(2012, 'Thu Aug 26 15:17:48 IST 2021', 'urun4', 'vip3', 5, 255000, 'aduser1'),
(2014, 'Fri Jan 07 00:00:00 EET 2022', 'urun2', 'vip1', 3, 216000, 'yonetici');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tedarikciler`
--

CREATE TABLE `tedarikciler` (
  `id` int(11) NOT NULL,
  `tedarikcikodu` varchar(45) NOT NULL,
  `tedarikciadi` varchar(45) NOT NULL,
  `lokasyon` varchar(45) NOT NULL,
  `telefon` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `tedarikciler`
--

INSERT INTO `tedarikciler` (`id`, `tedarikcikodu`, `tedarikciadi`, `lokasyon`, `telefon`) VALUES
(401, 'tedarikci1', 'tedarikci12', 'ankara', '1800560001'),
(402, 'tedarikci2', 'tedarikci2', 'ankara', '1800560041'),
(403, 'tedarikci3', 'tedarikci3', 'istanbul', '6546521234'),
(404, 'tedarikci4', 'tedarikci4', 'istanbul', '8555202215'),
(407, 'tedarikci5', 'tedarikci5', 'ankara', '8555203300'),
(408, 'tedarikci6', 'tedarikci6', 'ankara', '9696969696');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urunler`
--

CREATE TABLE `urunler` (
  `id` int(11) NOT NULL,
  `urunkodu` varchar(45) NOT NULL,
  `urunadi` varchar(45) NOT NULL,
  `maliyetfiyati` double NOT NULL,
  `satisfiyati` double NOT NULL,
  `marka` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `urunler`
--

INSERT INTO `urunler` (`id`, `urunkodu`, `urunadi`, `maliyetfiyati`, `satisfiyati`, `marka`) VALUES
(111, 'urun1', 'kanepe', 85000, 90000, 'marka1'),
(112, 'urun2', 'kanepe', 70000, 72000, 'marka3'),
(113, 'urun3', 'masa', 60000, 64000, 'marka2'),
(114, 'urun4', 'masa', 50000, 51000, 'marka4'),
(121, 'urun5', 'yatak', 2000, 2100, 'marka2'),
(122, 'urun6', 'mutfak', 1700, 1900, 'marka1'),
(128, 'urun7', 'koltuk', 3000, 3500, 'marka1'),
(129, 'urun8', 'çekyat', 15000, 17000, 'marka2');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `userlogs`
--

CREATE TABLE `userlogs` (
  `username` varchar(45) NOT NULL,
  `in_time` varchar(45) NOT NULL,
  `out_time` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `userlogs`
--

INSERT INTO `userlogs` (`username`, `in_time`, `out_time`) VALUES
('yonetici', '2022-01-10T22:35:33.635', '2022-01-10T22:37:26.249'),
('yonetici', '2022-01-10T22:37:38.641', '2022-01-10T22:40:33.156'),
('yonetici', '2022-01-10T22:44:15.112', '2022-01-10T22:57:03.868');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `kullanicilar`
--
ALTER TABLE `kullanicilar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `mevcutstok`
--
ALTER TABLE `mevcutstok`
  ADD PRIMARY KEY (`urunkodu`);

--
-- Tablo için indeksler `musteriler`
--
ALTER TABLE `musteriler`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `satinalmabilgisi`
--
ALTER TABLE `satinalmabilgisi`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `satisbilgisi`
--
ALTER TABLE `satisbilgisi`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tedarikciler`
--
ALTER TABLE `tedarikciler`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `urunler`
--
ALTER TABLE `urunler`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `urunkodu_UNIQUE` (`urunkodu`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `kullanicilar`
--
ALTER TABLE `kullanicilar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Tablo için AUTO_INCREMENT değeri `musteriler`
--
ALTER TABLE `musteriler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=307;

--
-- Tablo için AUTO_INCREMENT değeri `satinalmabilgisi`
--
ALTER TABLE `satinalmabilgisi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;

--
-- Tablo için AUTO_INCREMENT değeri `satisbilgisi`
--
ALTER TABLE `satisbilgisi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2015;

--
-- Tablo için AUTO_INCREMENT değeri `tedarikciler`
--
ALTER TABLE `tedarikciler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=409;

--
-- Tablo için AUTO_INCREMENT değeri `urunler`
--
ALTER TABLE `urunler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
