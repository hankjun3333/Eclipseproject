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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `midx` int(11) NOT NULL AUTO_INCREMENT,
  `mid` char(50) NOT NULL,
  `mname` char(50) NOT NULL,
  `mpass` char(100) NOT NULL,
  `mage` int(2) NOT NULL,
  `mtel` char(11) NOT NULL,
  `memail` char(50) NOT NULL,
  `mhtel` char(15) NOT NULL,
  `mpost` char(7) NOT NULL,
  `madr` char(100) NOT NULL,
  `madr_d` char(50) NOT NULL,
  PRIMARY KEY (`midx`,`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'alie','박용현','053a6fd2d5e06ec22feca1920508ff694af6aedcfd897bb7b435f540c5b702a6',31,'01050313314','x1178@naver.com','02-2205-4801','05321','서울 중구 퇴계로 97, 고려대연각타워 601호','23-1 3F'),(2,'amanda','박윤기','52e8e47b38e854580afce4aade15dbd5ce0c0464da711afe71da123687d5a4cd',32,'01000323139','dopd9999@naver.com','02-441-0291','16442','부산 해운대구 센텀 7로 12','607동 806호'),(3,'hankuk1004','최한윤','6a33d0352c4e77e08fca877a6a40d024b0a212a560483a49fadae807789a3db9',33,'01045789692','kurtjeong@naver.com','070-8778-9200','09810','경기 성남시 분당구 야탑로 205번길 8','8동 17호'),(4,'ann','박장규','49915e0d7d4b402e3017d010bc1c0e83cac6c797d6c16e66340fe3268693a6a1',40,'01038442122','hyoun74@naver.com','031-908-7202','05324','서울 서초구 바우뫼로 27길 2','203동 611호'),(5,'chan3137','손찬숙','c99a0fbe99306d69bb35179d771ee60daac4b31ec06d1d25eaa1356023747cef',44,'01069423772','leavesone@nate.com','02-2038-5905','05325','서울 종로구 대학로 57 홍익대학교 대학로캠퍼스 교육동 3층, 12층','12F 1204호'),(6,'wjdghks22','김한숙','2cd3be5472a64580249705572e2a58904129e78a4e3441e33fbc5b3afbf8a640',22,'01053524251','wwww1993@naver.com','02-2269-4996','05326','서울 영등포구 경인로 841','803호'),(7,'bess','박정선','220e74213bd759ae33de6ff60713575b64146c25e9599c080fbe496fa132accc',26,'01031374949','lisa_redsun@naver.com','02-2038-5905','05327','서울 광진구 자양로 76','16-22'),(8,'chelsea','박정수','1ecd41c03ef78bd6daeaa6bb008896607a8413bf8ba6266be80327554b370a9e',51,'01031111004','k9000sy@naver.com','02-6925-3880','05328','서울 광진구 강변역로 2 (구의동, 우체국시설관리단)','38-1'),(9,'samksx01','김연채','f95295af8f86275fba8e1fa4a4135d23415a662f6bf4a9a36201c5d28f1fac70',26,'01067884211','neoj76@naver.com','02-595-9166','05241','서울 종로구 종로1길 42, 603호(수송동, 이마빌딩)','9-1'),(10,'fella','박정한','6a1ae2c0cff89ca2a79275e5f3428aa64c71b26d4cee224b5b8a89e6e930167a',39,'01012345678','dawoniron@hanmail.net','031-759-2763','05330','서울 중구 정동길 43','하남빌딩 4F'),(11,'hekate','오창봉','ed8bef0ac59c1b883cf92a5583829401325b64a5ce55cb184ff73d661e85b107',36,'01022345679','gangnam2020@naver.com','02-438-5166','05331','서울 동작구 신대방1가길77','53-1'),(12,'james','정민식','119c9ae6f9ca741bd0a76f87fba0b22cab5413187afb2906aa2875c38e213603',34,'01012345680','s-k-w123@hanmail.com','02-449-9991','05332','서울 강남구 테헤란로 305 (역삼동), 한국기술센터 18층','1809호'),(13,'fallon','홍성욱','4d5cf48bfd182c3a0d5d89cb75dcf1fb24c5113218b49a5cdb9b66fb4a81bde4',28,'01042345681','cois3001@naver.com','02-6954-2665','05054','서울 영등포구 영중로83(영등포동 7가)','11-2'),(14,'lisa0913','최태훈','cc1c615815d65bd9c8759053b1ef295391273c8fdaf71686fa1a55a7c98b368a',30,'01012345682','cjt831@hanmail.net','02-2008-1202','04332','서울 동작구 보라매로 5길 35, 401(신대방동)','4F'),(15,'echemmon','이한','3632642f74e6f46fe875a6c4f78a841217bd17467d04692dd76694fdf3e19d60',40,'01052345683','kyoung-dong@hanmail.net','062-514-9652','04881','서울 서초구 강남대로27, 601호','22-6'),(16,'gyorgy','권열문','8e046e41f3996efdca6afd0d1946cca3805c8e8df346ce62c63580c40ea34d04',42,'01012345684','menu008@hanmail.net','070-7794-9400','05336','강원 정선군 사북읍 하이원길 265','38-7'),(17,'sahiri','신한경','b7d93c993a2a1764c7a7c110480d06efc5699a629e36bb7a5a137d599609cadb',36,'01022345685','gaon@gaon.pe.kr','055-289-8000','05337','경기 김포시 고촌읍 아라육로 270번길 74','61-2 3층'),(18,'milkpilles','편석범','3a0a84e59bd21bd3132ba701ed4cd7000371df07bf9aedaafe8a477b880771f0',38,'01072345686','9666308@hanmail.net','02-557-0481','05338','경기 유성구 대덕대로 1227','23-1 20F'),(19,'paolo70','김한수','906e02dd1c843ade3f76b542b9cbf1c96337a4ee0f1bb78b5bb4456e29591845',38,'01012345687','zoro0309@naver.com','02-433-7184','05339','경북 김천시 혁신2로 40(율곡동790)','91-2'),(20,'suheean','방성옥','d3572175d7bcff339d32c9387135ccef9b9268c124b18dd86aec32a391197933',46,'01092345688','energy8272@naver.com','070-7794-9440','19698','경기 용인시 기흥구 석성로 521번길 169(청덕동)','11동 308호'),(21,'kimchans','김찬욱','6fcfa430f757cc9b34253b0de4cbd127cffd493f6af18c8c7e7c28cd923dbfa1',41,'01042345689','gato4996@daum.net','02-511-1727','06811','경기 고양시 일산동구 정발산로 24 웨스턴타워 4동 8층, 9층','9층 32호'),(22,'jangho83','장선호','072d8726651c2dbb5ff1bb62ed280235010b0aa6d3ef3ac056a197888ba727ba',52,'01052345690','garamstr2@gmail.com','070-4172-7775','05342','충북 아름서길 21','2-2'),(23,'woosang100','최철우','f617999895611f23af9f50d10551a4581c197cb61df36067c0dc38d51a611d3a',63,'01015345691','cois3001@naver.com','032-545-3104','01036','강원 강릉시 죽헌길 7','25-1 205동 401호'),(24,'leeman','이정만','e0f6784323504ff02ef68c1770e36094d54ea6a04a80493c5b11ac390e0c376a',45,'01013345692','gayadns@hanmail.net','031-388-0828','01024','강원 춘천시 백령로 156','5-2 6F'),(25,'gil1048','최한길','b6b4f4c195e115affca6f504b73a6cd7fe27f547ba639938298b959262d2678a',63,'01023456778','nami@nandesign.kr','070-4910-8706','05345','강원 원주시 혁신로 60','23-1 27F'),(26,'parkss99','박선숙','ef44c2ecdfa7b88278b27474a6a52c5b793ee4ffecccb82d4ebf77a2e647747b',61,'01015553909','shs2053@naver.com','02-547-5477','04032','서울 중구 남대문로 109(국제빌딩)','11-6 3F 311호'),(27,'hejin1028','서혜진','08f1d310e28dc8e1112fba0505db207c8f53807eac7fc63ffa16fdd80e472a6b',42,'01045121147','bokur@nate.com','02-834-2010','26224','부산 해운대구 센텀서로 39 영상산업센터 1,2층','6동 201호'),(28,'nalim55','김한규','5d3b878142557121400395f4f7fc6dd246dc3106b7188ac2cc17b0519e3205d6',56,'01036322346','nanamcom@naver.com','02-420-3850','36412','서울 중구 동덕로130','5-5 1F'),(29,'soyoung850612','문소영','4c83ae25ee638f0a383709f7a7a5f113c20a5901fac47fdc7487f2bf23a74a68',49,'01010383237','kodong9370@naver.com','042-826-1947','09091','서울 중구 달구벌대로 2175','23동 17호'),(30,'suk870221','오찬석','a98db5b2439e79c54a839478da1d55b0644959092ad0e1443d0bdd3aa2a88d26',38,'01057129098','green97210@hanmail.net','031-511-9935','04321','전북 진주시 강남로 79','206동 307호'),(31,'jan01022347711','장미희','0cd29f25fd975270e8bcfa8e51da2fed51e7a24ded0a63cb629cb16ff200d3cf',46,'01023038704','boomia12@nizspace.com','042-6288-8301','05332','세종 시청대로 370 세종국책연구단지 연구지원동(A) 4, 8~9층','8층 201호'),(32,'ellen','서정선','7975b4132aaa77d75069a5d2ab3c501413eb91d11d046815158103d5628d7405',53,'01028849702','krgasi@nate.com','031-948-5435','36412','제주 서귀포시 서호중앙로 63','22'),(33,'darby','서진석','d2acd0d6466f49dda00939250c7a9845dcd10617f266a46c9f2334014b3c5ea3',38,'01081425242','goldens_no1@naver.com','062-514-9652','05334','세종 시청대로 370 세종국책연구단지 과학ㆍ인프라동(B동) 5,6,7층, 연구지원동(A동) 3층','7층 705호'),(34,'julia','서창옥','d277670919a94ba361be1887d39852c3f31d7eed817343cbb70fcd8910841f86',46,'01091426704','nurian22@daum.net','070-8819-5647','03034','울산 북구 첨단과기로 123 (오룡동)','61-2'),(35,'dasiy','선경','48bfb3d3fedb0e221b5078eab83ec087f57fc521f81a8bc158ba41b2fa249593',32,'01097985569','jb@kyungsu.co.kr','031-907-7677','05355','경북 김천시 혁신6로 17(율곡동, 교통안전공단)','5F 504호'),(36,'kavin','선우일남','fa3dfff0379b1494153711a9157da9b1101e2990e23068f9a5dcbe18214d55f7',42,'01004020505','sarang9671@nate.com','070-4694-6688','05339','세종 시청대로 370 세종국책연구단지 연구지원동(A동) 5~7층(우30147)','7층 704호'),(37,'kuper','성명훈','37e7dab721b03954ab7ed67d6c600663698fa1dfd4026eaae7e62a94f0ca78e0',31,'01036993883','kdf119@naver.com','02-3298-6790','02031','서울 서초구 남부순환로 2557(서초동1365-23번지)','33-2'),(38,'jettysi','성상철','2bf6fc3565d85e1e0789cedb11a5f2bcc90abacd563edb40ca9b06d8e9863aea',39,'01025233148','care0105@naver.com','062-351-1507','07081','강원 원주시 혁신로 22(반곡동)','64-1');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-25  0:07:39
