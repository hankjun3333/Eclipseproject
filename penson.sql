-- MariaDB dump 10.19  Distrib 10.5.22-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: pensonlife
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
-- Table structure for table `member_penson`
--

DROP TABLE IF EXISTS `member_penson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_penson` (
  `pidx` int(11) NOT NULL AUTO_INCREMENT,
  `pid` char(16) NOT NULL,
  `pname` char(30) NOT NULL,
  `ppass` char(12) NOT NULL,
  `pemail` char(100) NOT NULL,
  `ptel` char(11) NOT NULL,
  `ptime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`pidx`),
  UNIQUE KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_penson`
--

LOCK TABLES `member_penson` WRITE;
/*!40000 ALTER TABLE `member_penson` DISABLE KEYS */;
INSERT INTO `member_penson` VALUES (1,'','','','','','2023-09-01 07:59:47'),(8,'asdfasdfasdf','asdf','123123','hankjun333@naver.com','01100','2023-09-02 09:16:01'),(9,'asdgasd','aef','asdfasdf','aasdfasdf@','sadfasdfas','2023-09-02 09:17:03'),(10,'hankjun333','박병준','qkrqudwns','hankjun333@naver.com','01073317701','2023-09-02 10:30:50'),(11,'hankjun','박병준','qkrqudwns','hankjun333@naver.com','01073317701','2023-09-03 02:14:55'),(12,'kkk123','홍길동','ghdrlfehd','hong@','01044447777','2023-09-03 02:21:44'),(13,'hong1ssssss','호옹기일도옹','111111','hong@','01073317701','2023-09-03 02:26:04'),(14,'123qwe','도니쥬','apapglgl','jineunwww1@naver.com','01041813218','2023-09-03 02:33:44');
/*!40000 ALTER TABLE `member_penson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penson_room`
--

DROP TABLE IF EXISTS `penson_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penson_room` (
  `ridx` int(11) NOT NULL AUTO_INCREMENT,
  `roomname` char(20) NOT NULL,
  `roomchoice` enum('1','2','3','4','5') NOT NULL DEFAULT '1',
  `pdate` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  `roomprice` int(6) NOT NULL,
  `reserve_name` char(30) NOT NULL,
  `rid` char(30) NOT NULL,
  `rtel` char(11) NOT NULL,
  `pcount` int(2) NOT NULL,
  `email` char(50) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ridx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penson_room`
--

LOCK TABLES `penson_room` WRITE;
/*!40000 ALTER TABLE `penson_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `penson_room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-03 16:30:30
