-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	8.0.23

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','admin','ADMIN'),(2,'user1','u1','USER'),(3,'3BB','u2','USER'),(4,'user3','u3','USER');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
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
  `diem_giua_ki` float DEFAULT NULL,
  `diem_cuoi_ki` float DEFAULT NULL,
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
INSERT INTO `diem` VALUES (1,1,8,10),(2,1,7,2),(3,1,3,7),(1,2,4,4),(2,2,3,3),(1,3,2,7),(2,3,8,4),(1,4,6,6),(3,4,6,8);
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocbong`
--

DROP TABLE IF EXISTS `hocbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocbong` (
  `id_hoc_bong` int NOT NULL AUTO_INCREMENT,
  `Muc do` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int NOT NULL,
  `tien_thuong` float NOT NULL,
  `hoc_ki` int NOT NULL,
  PRIMARY KEY (`id_hoc_bong`),
  KEY `fk_hocbong_hocki_idx` (`hoc_ki`),
  CONSTRAINT `fk_hocbong_hocki` FOREIGN KEY (`hoc_ki`) REFERENCES `hocki` (`id_hoc_ki`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocbong`
--

LOCK TABLES `hocbong` WRITE;
/*!40000 ALTER TABLE `hocbong` DISABLE KEYS */;
INSERT INTO `hocbong` VALUES (1,'Xuat sac',10,300000,8),(2,'Gioi',10,200000,8),(3,'Kha',10,500000,8),(4,'Xuat sac',10,800000,9),(5,'Gioi',10,200000,9),(6,'Xuat sac',10,100000,7);
/*!40000 ALTER TABLE `hocbong` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocki`
--

LOCK TABLES `hocki` WRITE;
/*!40000 ALTER TABLE `hocki` DISABLE KEYS */;
INSERT INTO `hocki` VALUES (1,1,2019),(2,2,2019),(3,3,2019),(4,1,2020),(5,2,2020),(6,3,2020),(7,1,2021),(8,2,2021),(9,3,2021),(10,1,2022);
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
INSERT INTO `lophoc` VALUES (1,3,'01/02/2020','01/04/2020',4,20,5),(2,1,'02/02/2020','02/04/2020',4,20,10),(3,2,'12/11/2019','01/01/2020',3,20,15),(4,1,'01/05/2021','01/08/2021',9,20,5),(5,2,'02/05/2021','02/08/2021',9,20,10),(6,3,'03/05/2021','03/08/2021',9,20,5),(7,3,'03/05/2021','03/08/2021',9,10,5);
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
  `phantram` float NOT NULL,
  PRIMARY KEY (`id_mon_hoc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Toan',4,2000000,30,0.4),(2,'Ly',4,3000000,30,0.5),(3,'Hoa',4,1000000,40,0.5);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (1,'1','Pham Duong','Hoa','21/02/2000','Kien Giang',1),(2,'2','Tran Van','C','04/02/1992','HCM',2),(3,'3','Nguyen Trong','BB','10/03/1993','Ha Noi',3),(4,'4','Do Thi Yen','A','12/11/1999','HCM',4);
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
  `id_hoc_bong` int NOT NULL,
  PRIMARY KEY (`id_sinh_vien`,`id_hoc_bong`),
  CONSTRAINT `fk_hocbong_sinhvien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinhvien` (`id_sinh_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien_nhan_hocbong`
--

LOCK TABLES `sinhvien_nhan_hocbong` WRITE;
/*!40000 ALTER TABLE `sinhvien_nhan_hocbong` DISABLE KEYS */;
INSERT INTO `sinhvien_nhan_hocbong` VALUES (2,1),(2,4),(3,2),(4,3);
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

-- Dump completed on 2021-05-02 21:06:20
