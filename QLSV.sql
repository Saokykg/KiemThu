-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id_account` int(11) NOT NULL AUTO_INCREMENT,
  `tai_khoan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loai_tai_khoan` enum('USER','ADMIN') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_account`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'1851050001nguyen','1851050001','USER'),(2,'1851050002hoa','1851050002','USER'),(3,'1851050003lap','1851050003','USER'),(4,'1851050004tri','1851050004','USER'),(5,'admin','admin','ADMIN');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `diem` (
  `id_lop_hoc` int(11) NOT NULL,
  `id_sinh_vien` int(11) NOT NULL,
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
INSERT INTO `diem` VALUES (1,1,6,5),(2,1,4,9),(3,1,5,9),(7,1,4,8),(8,1,7,8),(9,1,4,7),(10,1,7,7),(11,1,5,6),(12,1,9,8),(13,1,6,8),(14,1,7,6),(15,1,6,6),(16,1,7,5),(17,1,9,7),(18,1,6,9),(19,1,8,9),(20,1,7,6),(1,2,9,7),(2,2,5,7),(7,2,6,7),(8,2,6,9),(9,2,5,8),(10,2,8,8),(11,2,8,8),(12,2,9,9),(13,2,5,9),(14,2,8,7),(15,2,7,7),(16,2,6,6),(17,2,6,8),(18,2,5,9),(19,2,7,9),(20,2,6,7),(7,3,9,8),(8,3,7,7),(9,3,6,5),(10,3,7,9),(11,3,8,6),(12,3,8,6),(13,3,6,8),(14,3,9,8),(15,3,9,8),(16,3,7,9),(17,3,7,9),(18,3,6,9),(19,3,8,7),(20,3,7,6),(7,4,8,7),(8,4,5,6),(9,4,7,6),(10,4,6,7),(11,4,9,7),(12,4,7,7),(13,4,6,7),(14,4,7,5),(15,4,8,6),(16,4,8,6),(17,4,8,9),(18,4,7,8),(19,4,9,6),(20,4,5,7);
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocbong`
--

DROP TABLE IF EXISTS `hocbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hocbong` (
  `id_hoc_bong` int(11) NOT NULL AUTO_INCREMENT,
  `mucdo` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int(11) NOT NULL,
  `tien_thuong` float NOT NULL,
  `hoc_ki` int(11) NOT NULL,
  PRIMARY KEY (`id_hoc_bong`),
  KEY `fk_hocbong_hocki_idx` (`hoc_ki`),
  CONSTRAINT `fk_hocbong_hocki` FOREIGN KEY (`hoc_ki`) REFERENCES `hocki` (`id_hoc_ki`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocbong`
--

LOCK TABLES `hocbong` WRITE;
/*!40000 ALTER TABLE `hocbong` DISABLE KEYS */;
INSERT INTO `hocbong` VALUES (1,'Gioi',1,200000,2),(2,'Kha',2,300000,2),(3,'Kha',2,300000,3);
/*!40000 ALTER TABLE `hocbong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocki`
--

DROP TABLE IF EXISTS `hocki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hocki` (
  `id_hoc_ki` int(11) NOT NULL AUTO_INCREMENT,
  `hoc_ki` int(11) NOT NULL,
  `nam` int(11) NOT NULL,
  PRIMARY KEY (`id_hoc_ki`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocki`
--

LOCK TABLES `hocki` WRITE;
/*!40000 ALTER TABLE `hocki` DISABLE KEYS */;
INSERT INTO `hocki` VALUES (1,1,2020),(2,2,2020),(3,3,2020),(4,1,2021),(5,2,2021),(6,3,2021),(7,1,2022),(8,2,2022),(9,3,2022);
/*!40000 ALTER TABLE `hocki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophoc`
--

DROP TABLE IF EXISTS `lophoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lophoc` (
  `id_lop_hoc` int(11) NOT NULL,
  `id_mon_hoc` int(11) NOT NULL,
  `ngay_bd` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_kt` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hoc_ki` int(11) NOT NULL,
  `so_luong_dk` int(11) NOT NULL,
  `ca_hoc` int(11) DEFAULT NULL,
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
INSERT INTO `lophoc` VALUES (1,1,'20/5/2021','20/8/2021',6,20,1),(2,2,'22/5/2021','20/8/2021',6,20,5),(3,3,'23/5/2021','20/8/2021',6,20,1),(4,4,'01/9/2021','01/12/2021',7,20,1),(5,5,'03/9/2021','03/12/2021',7,20,5),(6,6,'02/9/2021','02/12/2021',7,10,1),(7,7,'1/9/2019','1/12/2019',1,11,1),(8,8,'2/9/2019','2/12/2019',1,11,5),(9,9,'3/9/2019','3/12/2019',1,11,5),(10,10,'1/1/2020','1/4/2020',2,11,5),(11,11,'2/1/2020','2/4/2020',2,11,5),(12,12,'3/1/2020','3/4/2020',2,11,1),(13,13,'1/5/2020','1/8/2020',3,13,1),(14,14,'2/5/2020','2/8/2020',3,12,1),(15,15,'3/5/2020','3/8/2020',3,14,5),(16,16,'1/9/2020','1/12/2020',4,16,1),(17,17,'2/9/2020','2/12/2020',4,13,1),(18,18,'3/9/2020','3/12/2020',4,14,5),(19,19,'1/1/2021','1/4/2021',5,15,1),(20,20,'2/1/2021','2/4/2101',5,12,1),(21,21,'2/9/2021','2/12/2021',7,33,5);
/*!40000 ALTER TABLE `lophoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `monhoc` (
  `id_mon_hoc` int(11) NOT NULL AUTO_INCREMENT,
  `ten_mon_hoc` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `hoc_phi` float NOT NULL,
  `gioi_han_hoc_vien` int(11) NOT NULL,
  `phantram` float NOT NULL,
  PRIMARY KEY (`id_mon_hoc`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Cơ Sở Dữ liệu',4,2000000,20,0.5),(2,'Toán Cao Cấp',3,1500000,20,0.4),(3,'Lập trình Giao Diện',4,2000000,16,0.5),(4,'Lập Trình Hướng Đối Tượng',4,2000000,20,0.5),(5,'Mạng Máy Tính',4,2000000,20,0.5),(6,'Phân Giải Dữ Liệu',3,1500000,20,0.4),(7,'Pháp luật đại cương',3,1500000,30,0.4),(8,'Kiến trúc máy tính',4,1500000,30,0.5),(9,'Thiết kế Web',4,1500000,25,0.5),(10,'Cấu trúc dữ liệu và giải thuật',5,2500000,30,0.5),(11,'Hệ điều hành',4,1980000,30,0.5),(12,'Toán rời rạc',3,1450000,25,0.4),(13,'Phân tích thiết kế hệ thống',4,1560000,30,0.5),(14,'Đường lối CM của Đảng CSVN',2,980000,40,0.4),(15,'An toàn hệ thống thông tin',4,2200000,35,0.5),(16,'Quản trị hệ cơ sở dữ liệu',4,2130000,25,0.5),(17,'Công nghệ phần mềm',4,3120000,25,0.5),(18,'Kỹ năng nghề nghiệp',2,1200000,30,0.4),(19,'Lập trình cơ sở dữ liệu',4,1980000,35,0.5),(20,'Kiểm thử phần mềm',4,2100000,30,0.5),(21,'Toán',5,212321,12,0.5);
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sinhvien` (
  `id_sinh_vien` int(11) NOT NULL AUTO_INCREMENT,
  `mssv` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ho` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `que_quan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_account` int(11) NOT NULL,
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
INSERT INTO `sinhvien` VALUES (1,'1851050001','Đào Văn','Nguyên','17/11/2000','Đắk Nông',1),(2,'1851050002','Phạm Dương','Hòa','21/4/2000','Hà Nội',2),(3,'1851050003','Nguyễn Trần Công','Lập','12/3/2000','Quy Nhơn',3),(4,'1851050004','Nguyễn Minh','Trí','31/5/1999','TP Hồ Chí Minh',4);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien_nhan_hocbong`
--

DROP TABLE IF EXISTS `sinhvien_nhan_hocbong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sinhvien_nhan_hocbong` (
  `id_sinh_vien` int(11) NOT NULL,
  `id_hoc_bong` int(11) NOT NULL,
  PRIMARY KEY (`id_sinh_vien`,`id_hoc_bong`),
  CONSTRAINT `fk_hocbong_sinhvien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinhvien` (`id_sinh_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien_nhan_hocbong`
--

LOCK TABLES `sinhvien_nhan_hocbong` WRITE;
/*!40000 ALTER TABLE `sinhvien_nhan_hocbong` DISABLE KEYS */;
INSERT INTO `sinhvien_nhan_hocbong` VALUES (2,1),(2,3),(3,1),(3,3),(4,1);
/*!40000 ALTER TABLE `sinhvien_nhan_hocbong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'quanlysinhvien'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-12 22:57:26
