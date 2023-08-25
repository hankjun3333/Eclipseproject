-- MariaDB dump 10.19  Distrib 10.5.22-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: shop
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
-- Table structure for table `shop_member`
--

DROP TABLE IF EXISTS `shop_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_member` (
  `midx` int(11) NOT NULL AUTO_INCREMENT,
  `mid` char(50) NOT NULL,
  `mname` char(50) NOT NULL,
  `mtel` char(11) NOT NULL,
  `memail` char(100) NOT NULL,
  `moftel` char(14) NOT NULL,
  `mpost` char(10) NOT NULL,
  `madr` varchar(150) NOT NULL,
  `madrd` char(50) NOT NULL,
  `mlev` int(2) NOT NULL,
  `marea` char(2) NOT NULL,
  PRIMARY KEY (`midx`,`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_member`
--

LOCK TABLES `shop_member` WRITE;
/*!40000 ALTER TABLE `shop_member` DISABLE KEYS */;
INSERT INTO `shop_member` VALUES (1,'alie','박용현','01050313314','x1178@naver.com','02-2205-4801','05321','서울 중구 퇴계로 97, 고려대연각타워 601호','23-1 3F',1,'A'),(2,'amanda','박윤기','01000323139','dopd9999@naver.com','02-441-0291','16442','부산 해운대구 센텀 7로 12 ','607동 806호',3,'P'),(3,'amy','박인숙','01045789692','kurtjeong@naver.com','070-8778-9200','09810','경기 성남시 분당구 야탑로 205번길 8','8동 17호',4,'B'),(4,'ann','박장규','01038442122','hyoun74@naver.com','031-908-7202','05324','서울 서초구 바우뫼로 27길 2','203동 611호',2,'A'),(5,'boss','박재용','01069423772','leavesone@nate.com','02-2038-5905','05325','서울 종로구 대학로 57 홍익대학교 대학로캠퍼스 교육동 3층, 12층','12F 1204호',2,'A'),(6,'billy','박재형','01053524251','wwww1993@naver.com','02-2269-4996','05326','서울 영등포구 경인로 841','803호',2,'A'),(7,'bess','박정선','01031374949','lisa_redsun@naver.com','02-2038-5905','05327','서울 광진구 자양로 76','16-22',1,'A'),(8,'chelsea','박정수','01031111004','k9000sy@naver.com','02-6925-3880','05328','서울 광진구 강변역로 2 (구의동, 우체국시설관리단)','38-1',1,'A'),(9,'syma','박정식','01067884211','neoj76@naver.com','02-595-9166','05241','서울 종로구 종로1길 42, 603호(수송동, 이마빌딩)','9-1',1,'A'),(10,'fella','박정한','01012345678','dawoniron@hanmail.net','031-759-2763','05330','서울 중구 정동길 43','하남빌딩 4F',1,'A'),(11,'hera','박종섭','01022345679','gangnam2020@naver.com','02-438-5166','05331','서울 동작구 신대방1가길77','53-1',1,'A'),(12,'hugh','박주배','01012345680','s-k-w123@hanmail.com','02-449-9991','05332','서울 강남구 테헤란로 305 (역삼동), 한국기술센터 18층','1809호',1,'A'),(13,'edgar','박찬일','01042345681','cois3001@naver.com','02-6954-2665','05054','서울 영등포구 영중로83(영등포동 7가)','11-2',3,'A'),(14,'mavels','박찬정','01012345682','cjt831@hanmail.net','02-2008-1202','04332','서울 동작구 보라매로 5길 35, 401(신대방동)','4F',4,'A'),(15,'hope','박창일','01052345683','kyoung-dong@hanmail.net','062-514-9652','04881','서울 서초구 강남대로27, 601호','22-6',3,'A'),(16,'lsable','박춘식','01012345684','menu008@hanmail.net','070-7794-9400','05336','강원 정선군 사북읍 하이원길 265','38-7',3,'H'),(17,'lucka','박형진','01022345685','gaon@gaon.pe.kr','055-289-8000','05337','경기 김포시 고촌읍 아라육로 270번길 74','61-2 3층',1,'B'),(18,'lsis','방문석','01072345686','9666308@hanmail.net','02-557-0481','05338','경기 유성구 대덕대로 1227','23-1 20F',1,'B'),(19,'lottie','방병기','01012345687','zoro0309@naver.com','02-433-7184','05339','경북 김천시 혁신2로 40(율곡동790)','91-2',2,'M'),(20,'hymphrey','방영주','01092345688','energy8272@naver.com','070-7794-9440','19698','경기 용인시 기흥구 석성로 521번길 169(청덕동)','11동 308호',1,'B'),(21,'mond','배상철','01042345689','gato4996@daum.net','02-511-1727','06811','경기 고양시 일산동구 정발산로 24 웨스턴타워 4동 8층, 9층','9층 32호',2,'B'),(22,'dixie','배종우','01052345690','garamstr2@gmail.com','070-4172-7775','05342','충북 아름서길 21','2-2',1,'G'),(23,'deva','백구현','01015345691','cois3001@naver.com','032-545-3104','01036','강원 강릉시 죽헌길 7','25-1 205동 401호',1,'H'),(24,'goofy','백승완','01013345692','gayadns@hanmail.net','031-388-0828','01024','강원 춘천시 백령로 156','5-2 6F',1,'H'),(25,'laura','백운이','01023456778','nami@nandesign.kr','070-4910-8706','05345','강원 원주시 혁신로 60','23-1 27F',1,'H'),(26,'gili','백인호','01015553909','shs2053@naver.com','02-547-5477','04032','서울 중구 남대문로 109(국제빌딩)','11-6 3F 311호',2,'A'),(27,'leena','백재승','01045121147','bokur@nate.com','02-834-2010','26224','부산 해운대구 센텀서로 39 영상산업센터 1,2층','6동 201호',1,'P'),(28,'justuin','백희영','01036322346','nanamcom@naver.com','02-420-3850','36412','서울 중구 동덕로130','5-5 1F',2,'A'),(29,'jason','서경석','01010383237','kodong9370@naver.com','042-826-1947','09091','서울 중구 달구벌대로 2175','23동 17호',4,'A'),(30,'kate','서유헌','01057129098','green97210@hanmail.net','031-511-9935','04321','전북 진주시 강남로 79','206동 307호',1,'K'),(31,'emma','서정기','01023038704','boomia12@nizspace.com','042-6288-8301','05332','세종 시청대로 370 세종국책연구단지 연구지원동(A) 4, 8~9층','8층 201호',3,'D'),(32,'ellen','서정선','01028849702','krgasi@nate.com','031-948-5435','36412','제주 서귀포시 서호중앙로 63','22',3,'Q'),(33,'darby','서진석','01081425242','goldens_no1@naver.com','062-514-9652','05334','세종 시청대로 370 세종국책연구단지 과학ㆍ인프라동(B동) 5,6,7층, 연구지원동(A동) 3층','7층 705호',2,'D'),(34,'julia','서창옥','01091426704','nurian22@daum.net','070-8819-5647','03034','울산 북구 첨단과기로 123 (오룡동)','61-2',2,'Q'),(35,'dasiy','선경','01097985569','jb@kyungsu.co.kr','031-907-7677','05355','경북 김천시 혁신6로 17(율곡동, 교통안전공단)','5F 504호',2,'M'),(36,'kavin','선우일남','01004020505','sarang9671@nate.com','070-4694-6688','05339','세종 시청대로 370 세종국책연구단지 연구지원동(A동) 5~7층(우30147)','7층 704호',1,'D'),(37,'kuper','성명훈','01036993883','kdf119@naver.com','02-3298-6790','02031','서울 서초구 남부순환로 2557(서초동1365-23번지) ','33-2',1,'A'),(38,'jettysi','성상철','01025233148','care0105@naver.com','062-351-1507','07081','강원 원주시 혁신로 22(반곡동)','64-1',1,'H');
/*!40000 ALTER TABLE `shop_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-24 22:33:04
