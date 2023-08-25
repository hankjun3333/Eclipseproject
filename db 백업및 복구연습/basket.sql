-- MariaDB dump 10.19  Distrib 10.5.22-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: green_shop
-- ------------------------------------------------------
-- Server version	10.5.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket` (
  `midx` int(11) NOT NULL AUTO_INCREMENT,
  `mid` char(50) NOT NULL,
  `pcode` char(7) NOT NULL,
  `bea` char(3) NOT NULL,
  `pdate` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`midx`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket`
--

LOCK TABLES `basket` WRITE;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
INSERT INTO `basket` VALUES (1,'	hankuk1004	','	577891','	1	','2023-08-01 12:01:23'),(2,'	dasiy	','	124174','	1	','2023-08-01 13:22:07'),(3,'	alie	','	803041','	1	','2023-08-01 22:19:37'),(4,'	dasiy	','	678891','	1	','2023-08-01 14:12:07'),(5,'	hankuk1004	','	363234','	1	','2023-08-02 14:20:19'),(6,'	fella	','	698874','	1	','2023-08-02 19:22:00'),(7,'	chelsea	','	213779','	1	','2023-08-03 16:07:51'),(8,'	chelsea	','	612234','	2	','2023-08-03 16:29:09'),(9,'	lisa0913	','	343789','	1	','2023-08-05 19:49:44'),(10,'	fella	','	911456','	3	','2023-08-07 10:59:01'),(11,'	sahiri	','	612234','	1	','2023-08-08 16:19:52'),(12,'	kuper	','	911456','	2	','2023-08-09 19:07:00'),(13,'	hankuk1004	','	412452','	1	','2023-08-11 16:41:21'),(14,'	alie	','	215523','	1	','2023-08-12 11:36:15');
/*!40000 ALTER TABLE `basket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-25  0:08:21
