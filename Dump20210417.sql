-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id_account` int NOT NULL AUTO_INCREMENT,
  `tai_khoan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loai_tai_khoan` enum('USER','ADMIN') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_hoc_bong`
--

DROP TABLE IF EXISTS `chi_tiet_hoc_bong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_hoc_bong` (
  `id_chi_tiet_hoc_bong` int NOT NULL AUTO_INCREMENT,
  `id_hoc_bong` int NOT NULL,
  `ten_chi_tiet` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int NOT NULL,
  `tien_thuong` float NOT NULL,
  PRIMARY KEY (`id_chi_tiet_hoc_bong`),
  KEY `fk_chitiet_hocbong_idx` (`id_hoc_bong`),
  CONSTRAINT `fk_chitiet_hocbong` FOREIGN KEY (`id_hoc_bong`) REFERENCES `hoc_bong` (`id_hoc_bong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_hoc_bong`
--

LOCK TABLES `chi_tiet_hoc_bong` WRITE;
/*!40000 ALTER TABLE `chi_tiet_hoc_bong` DISABLE KEYS */;
/*!40000 ALTER TABLE `chi_tiet_hoc_bong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem` (
  `id_lop_hoc` int NOT NULL,
  `id_sinh_vien` int NOT NULL,
  `diem_giua_ki` float NOT NULL,
  `diem_cuoi_ki` float NOT NULL,
  `phan_tram` float NOT NULL,
  PRIMARY KEY (`id_sinh_vien`,`id_lop_hoc`),
  KEY `fk_diem_sv_idx` (`id_sinh_vien`),
  KEY `fk_diem_lophoc_idx` (`id_lop_hoc`),
  CONSTRAINT `fk_diem_lophoc` FOREIGN KEY (`id_lop_hoc`) REFERENCES `lophoc` (`id_lop_hoc`),
  CONSTRAINT `fk_diem_sv` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinhvien` (`id_sinh_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoc_bong`
--

DROP TABLE IF EXISTS `hoc_bong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_bong` (
  `id_hoc_bong` int NOT NULL AUTO_INCREMENT,
  `ten_hoc_bong` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hoc_ki` int NOT NULL,
  PRIMARY KEY (`id_hoc_bong`),
  KEY `fk_hocbong_hocki_idx` (`hoc_ki`),
  CONSTRAINT `fk_hocbong_hocki` FOREIGN KEY (`hoc_ki`) REFERENCES `hocki` (`id_hoc_ki`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_bong`
--

LOCK TABLES `hoc_bong` WRITE;
/*!40000 ALTER TABLE `hoc_bong` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoc_bong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocki`
--

DROP TABLE IF EXISTS `hocki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocki` (
  `id_hoc_ki` int NOT NULL AUTO_INCREMENT,
  `hoc_ki` int NOT NULL,
  `nam` int NOT NULL,
  PRIMARY KEY (`id_hoc_ki`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocki`
--

LOCK TABLES `hocki` WRITE;
/*!40000 ALTER TABLE `hocki` DISABLE KEYS */;
/*!40000 ALTER TABLE `hocki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophoc`
--

DROP TABLE IF EXISTS `lophoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophoc` (
  `id_lop_hoc` int NOT NULL,
  `id_mon_hoc` int NOT NULL,
  `ngay_bd` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_kt` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hoc_ki` int NOT NULL,
  `so_luong_dk` int NOT NULL,
  `ca_hoc` int DEFAULT NULL,
  PRIMARY KEY (`id_lop_hoc`),
  KEY `fk_lophoc_monhoc_idx` (`id_mon_hoc`),
  KEY `fk_lophoc_hocki_idx` (`hoc_ki`),
  CONSTRAINT `fk_lophoc_hocki` FOREIGN KEY (`hoc_ki`) REFERENCES `hocki` (`id_hoc_ki`),
  CONSTRAINT `fk_lophoc_monhoc` FOREIGN KEY (`id_mon_hoc`) REFERENCES `monhoc` (`id_mon_hoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `lophoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `id_mon_hoc` int NOT NULL AUTO_INCREMENT,
  `ten_mon_hoc` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_tin_chi` int NOT NULL,
  `hoc_phi` float NOT NULL,
  `gioi_han_hoc_vien` int NOT NULL,
  PRIMARY KEY (`id_mon_hoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `id_sinh_vien` int NOT NULL AUTO_INCREMENT,
  `mssv` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ho` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `que_quan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_account` int NOT NULL,
  PRIMARY KEY (`id_sinh_vien`),
  KEY `fk_sinhvien_taikhoan_idx` (`id_account`),
  CONSTRAINT `fk_sinhvien_taikhoan` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien_nhan_hocbong`
--

DROP TABLE IF EXISTS `sinhvien_nhan_hocbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien_nhan_hocbong` (
  `id_sinh_vien` int NOT NULL,
  `id_chitiet_hb` int NOT NULL,
  PRIMARY KEY (`id_sinh_vien`,`id_chitiet_hb`),
  KEY `fk_loai_hocbong_idx` (`id_chitiet_hb`),
  CONSTRAINT `fk_id_sinhvien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinhvien` (`id_sinh_vien`),
  CONSTRAINT `fk_loai_hocbong` FOREIGN KEY (`id_chitiet_hb`) REFERENCES `chi_tiet_hoc_bong` (`id_chi_tiet_hoc_bong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien_nhan_hocbong`
--

LOCK TABLES `sinhvien_nhan_hocbong` WRITE;
/*!40000 ALTER TABLE `sinhvien_nhan_hocbong` DISABLE KEYS */;
/*!40000 ALTER TABLE `sinhvien_nhan_hocbong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-17 15:02:58