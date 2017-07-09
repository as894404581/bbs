-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: BBS_DB
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ATTACHMENT_INFO`
--

DROP TABLE IF EXISTS `ATTACHMENT_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ATTACHMENT_INFO` (
  `ID` int(11) NOT NULL,
  `ATTACHMENT_URL` varchar(200) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `POST_ID` int(11) NOT NULL,
  `ATTACHMENT_FORMERLY` varchar(200) NOT NULL,
  `ATTACHMENT_SIZE` bigint(20) NOT NULL,
  `UPLOAD_TIME` datetime NOT NULL,
  `TYPE` varchar(45) NOT NULL,
  `RID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ATTACHMENT_INFO`
--

LOCK TABLES `ATTACHMENT_INFO` WRITE;
/*!40000 ALTER TABLE `ATTACHMENT_INFO` DISABLE KEYS */;
INSERT INTO `ATTACHMENT_INFO` VALUES (34,'/upload//2017/02/11/6efd5201-34f3-4184-aa43-31ffbdf7d10c.jpg',12,1,'Bristle Grass.jpg',3829428,'2017-02-11 14:22:33','rep',90),(35,'/upload//2017/02/11/bef415e1-b9f6-463d-8796-d43871476efd.jpg',12,1,'Pink Forest.jpg',2830299,'2017-02-11 14:22:41','rep',90),(36,'/upload//2017/02/11/0e831590-a93d-4dc7-aa31-981ec5523a92.jpg',12,1,'Snow.jpg',2126390,'2017-02-11 14:22:41','rep',90),(37,'/upload//2017/02/11/9905b394-be98-4b5a-8f80-e37e0d1b5542.jpg',12,1,'Moon.jpg',1951862,'2017-02-11 14:22:41','rep',90),(38,'/upload//2017/02/11/735ddb01-d873-49dc-b41f-540babe0081a.jpg',12,1,'Isles.jpg',1915078,'2017-02-11 14:22:41','rep',90),(39,'/upload//2017/02/11/8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg',12,1,'Eagle & Waterfall.jpg',1722473,'2017-02-11 14:22:41','rep',90),(40,'/upload//2017/02/11/d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',12,1,'Galaxy.jpg',3860401,'2017-02-11 14:26:49','post',90),(41,'/upload//2017/02/11/e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',12,1,'Isles.jpg',1915078,'2017-02-11 14:34:47','post',NULL),(42,'/upload//2017/02/11/6e39d48e-c79e-46a7-9193-930d46db17aa.jpg',12,1,'Eagle & Waterfall.jpg',1722473,'2017-02-11 14:34:59','rep',90),(43,'/upload//2017/02/13/bad4cbb0-52d2-47d2-9ccf-8120d6b1de88.jpg',12,1,'6e39d48e-c79e-46a7-9193-930d46db17aa.jpg',1722473,'2017-02-13 19:35:48','post',NULL),(44,'/upload//2017/02/14/dbcd18f1-d4c8-466f-92e7-42526c8962b6.jpg',12,1,'d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'2017-02-14 15:04:58','post',NULL),(45,'/upload//2017/02/14/19f4338a-d7d9-4341-ae8f-a8ea140c124f.jpg',12,2,'e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'2017-02-14 15:12:18','post',NULL),(46,'/upload//2017/02/14/5918440f-922b-4237-8e4c-5641c271541e.jpg',12,2,'d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'2017-02-14 17:04:37','rep',NULL),(47,'/upload//2017/02/14/d2c26716-fff6-4b9b-b707-e8734c7752e5.jpg',12,2,'6e39d48e-c79e-46a7-9193-930d46db17aa.jpg',1722473,'2017-02-14 18:51:43','post',NULL),(48,'/upload//2017/02/14/142673bc-723d-426f-9065-6c321392fc3c.jpg',12,1,'8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg',1722473,'2017-02-14 19:00:22','rep',NULL),(59,'/upload//2017/02/14/689c2b22-7de9-4b0c-a0cb-599ab0b691c0.docx',12,2,'数据库字典.docx',497604,'2017-02-14 19:29:28','post',NULL),(60,'/upload//2017/02/14/5b1d7bfc-6f82-4c17-9908-1fa8919d2665.pages',12,2,'数据库字典.pages',183315,'2017-02-14 19:29:46','post',NULL),(61,'/upload//2017/02/14/50cb3a5e-8ead-4e74-8004-9acd45840fc1.docx',12,2,'数据库字典.docx',497604,'2017-02-14 19:31:06','post',NULL),(62,'/upload//2017/02/14/d7746b4f-41ac-4b87-aa38-b6ceca08ce5b.pages',12,2,'数据库字典.pages',183315,'2017-02-14 19:32:51','post',NULL),(63,'/upload//2017/02/15/13a9df94-c401-4dc9-8525-267a22a2be65.jpg',12,2,'e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'2017-02-15 15:17:22','post',NULL),(64,'/upload//2017/02/15/069d8629-9d5d-4d39-aa7f-b7837a9fad54.jpg',12,2,'bef415e1-b9f6-463d-8796-d43871476efd.jpg',2830299,'2017-02-15 15:18:49','post',NULL),(65,'/upload//2017/02/15/6f2bfd77-ad77-405d-b055-7c797f9cdef3.jpg',12,2,'e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'2017-02-15 15:19:09','post',NULL),(66,'/upload//2017/02/15/3e41db5a-0a5d-403e-9e6e-4af7f55ed586.jpg',12,2,'9905b394-be98-4b5a-8f80-e37e0d1b5542.jpg',1951862,'2017-02-15 15:21:18','post',NULL);
/*!40000 ALTER TABLE `ATTACHMENT_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ATTACHMENT_UNUSED`
--

DROP TABLE IF EXISTS `ATTACHMENT_UNUSED`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ATTACHMENT_UNUSED` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(45) NOT NULL,
  `UPLOAD_TIME` datetime NOT NULL,
  `ATTACHMENT_FORMERLY` varchar(200) NOT NULL,
  `ATTACHMENT_SIZE` int(11) NOT NULL,
  `ATTACHMENT_URL` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ATTACHMENT_UNUSED`
--

LOCK TABLES `ATTACHMENT_UNUSED` WRITE;
/*!40000 ALTER TABLE `ATTACHMENT_UNUSED` DISABLE KEYS */;
INSERT INTO `ATTACHMENT_UNUSED` VALUES (1,'12','2017-02-16 14:57:51','735ddb01-d873-49dc-b41f-540babe0081a.jpg',1915078,'/upload//2017/02/16/4f57ced7-6d3b-4015-a15d-0a0982750bbd.jpg'),(2,'12','2017-02-16 14:58:17','cloud_note.sql',110899,'/upload//2017/02/16/005c0759-4f29-4f71-b966-48e3df0ddd1a.sql'),(3,'12','2017-02-16 15:01:06','Document.png',5466,'/upload//2017/02/16/c5e29a72-e382-4dc6-b395-e83aba9e8ae6.png'),(4,'12','2017-02-16 15:01:16','c5e29a72-e382-4dc6-b395-e83aba9e8ae6.png',5466,'/upload//2017/02/16/ff6ce320-b5cd-471f-9495-bc678cbd3cb5.png'),(5,'12','2017-02-16 15:01:23','ff6ce320-b5cd-471f-9495-bc678cbd3cb5.png',5466,'/upload//2017/02/16/88eae9a8-1b22-4fe6-b971-c04b16ef8691.png'),(6,'12','2017-02-16 15:01:26','c5e29a72-e382-4dc6-b395-e83aba9e8ae6.png',5466,'/upload//2017/02/16/657b4a50-ca12-49f2-9d0b-e1c25b52d7d6.png'),(7,'12','2017-02-16 15:02:50','f8e6e29a-4240-4c8a-a10b-aca4b1545d18.jpg',3860401,'/upload//2017/02/16/c75b35c9-06d8-43ea-b7c7-97b8e2f30c50.jpg'),(8,'12','2017-02-16 15:15:24','88eae9a8-1b22-4fe6-b971-c04b16ef8691.png',5466,'/upload//2017/02/16/cf624620-5371-401c-810c-d627671e35a2.png'),(9,'12','2017-02-16 15:18:38','84b70b0b-5128-4b99-9140-8537d22f5fc0.jpg',1915078,'/upload//2017/02/16/4785deba-6164-4889-8b9a-2cc29b216997.jpg'),(10,'12','2017-02-16 15:19:09','88eae9a8-1b22-4fe6-b971-c04b16ef8691.png',5466,'/upload//2017/02/16/3eb625fb-f05e-4202-a84e-a30ab303a6a1.png'),(11,'12','2017-02-16 15:20:33','84b70b0b-5128-4b99-9140-8537d22f5fc0.jpg',1915078,'/upload//2017/02/16/a4d4dd16-6b44-487f-937b-c9331ad5bd77.jpg'),(12,'12','2017-02-16 15:21:57','90a289f0-1d64-47ff-953a-6e9850d4f342.jpg',1915078,'/upload//2017/02/16/7fa0dafc-4b62-404a-8c6b-13635b9f3afa.jpg'),(13,'12','2017-02-16 15:33:58','90a289f0-1d64-47ff-953a-6e9850d4f342.jpg',1915078,'/upload//2017/02/16/8b03798c-a087-4e2b-ab22-1ccf211f2100.jpg'),(14,'12','2017-02-16 15:34:02','0426b86c-c037-4a4a-815e-0463fe4bd991.jpg',2830299,'/upload//2017/02/16/d39bfef2-7de2-4806-bcbd-576bfa5ad236.jpg'),(15,'12','2017-02-16 15:34:33','18e5d678-1959-4af1-a530-868159be3e08.jpg',1951862,'/upload//2017/02/16/a711a2b7-1cb0-48b4-b790-af30760d0409.jpg'),(16,'12','2017-02-16 15:35:05','88eae9a8-1b22-4fe6-b971-c04b16ef8691.png',5466,'/upload//2017/02/16/84c93b63-ec84-451b-95f4-6e9e32d9662c.png'),(17,'12','2017-02-16 15:35:14','7fa0dafc-4b62-404a-8c6b-13635b9f3afa.jpg',1915078,'/upload//2017/02/16/dbb7ee17-c049-4485-92d0-987dd200c91f.jpg'),(18,'12','2017-02-16 15:36:17','18e5d678-1959-4af1-a530-868159be3e08.jpg',1951862,'/upload//2017/02/16/ceee8d9b-9e6f-45a0-9b64-0b6324e03549.jpg'),(19,'12','2017-02-16 15:37:01','8b03798c-a087-4e2b-ab22-1ccf211f2100.jpg',1915078,'/upload//2017/02/16/3444e57a-2fec-4de9-8245-2ab20f8b7822.jpg'),(20,'12','2017-02-16 15:37:15','3eb625fb-f05e-4202-a84e-a30ab303a6a1.png',5466,'/upload//2017/02/16/82e86de1-43ca-4a55-86b9-5e076b48e555.png'),(21,'12','2017-02-16 15:37:15','84c93b63-ec84-451b-95f4-6e9e32d9662c.png',5466,'/upload//2017/02/16/86f860b2-fe4d-4447-ad38-98009dd7d44b.png'),(22,'12','2017-02-16 15:37:15','88eae9a8-1b22-4fe6-b971-c04b16ef8691.png',5466,'/upload//2017/02/16/0f32d8ce-d5cd-408c-ad0d-ea840e9e3cb5.png'),(23,'12','2017-02-16 15:37:15','657b4a50-ca12-49f2-9d0b-e1c25b52d7d6.png',5466,'/upload//2017/02/16/be9490e5-3f16-4cc0-9785-ccca6768071b.png'),(24,'12','2017-02-16 15:37:15','c5e29a72-e382-4dc6-b395-e83aba9e8ae6.png',5466,'/upload//2017/02/16/2b1a8231-3c2a-478e-995e-b0e30c169616.png'),(25,'12','2017-02-16 15:37:15','cf624620-5371-401c-810c-d627671e35a2.png',5466,'/upload//2017/02/16/e968e6a0-601f-42ea-90f5-6504decd24c4.png'),(26,'12','2017-02-16 15:37:15','ff6ce320-b5cd-471f-9495-bc678cbd3cb5.png',5466,'/upload//2017/02/16/a6447658-23c1-4037-b1e8-33d565ebee2d.png'),(27,'12','2017-02-16 15:47:27','千图网_4图标文件_图片编号15567728.zip',3590,'/upload//2017/02/16/ed14b547-f886-4a97-ac3a-9167a0f21b54.zip'),(28,'12','2017-02-16 15:47:35','Document.png',16806,'/upload//2017/02/16/2dcbc79e-9d3e-4fd3-8bbc-8ed9a0317ab9.png'),(29,'12','2017-02-17 17:14:05','Document.png',16806,'/upload//2017/02/17/7422a617-659f-49c1-ba12-dcf265c94df5.png'),(30,'12','2017-02-17 17:15:46','8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg',1722473,'/upload//2017/02/17/035e3d4d-698a-4abd-915b-50ffb1010241.jpg'),(31,'12','2017-02-17 17:16:10','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'/upload//2017/02/17/f6c42b94-36e2-4268-be3c-59bdd5ec7a40.jpg'),(32,'12','2017-02-17 17:16:43','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'/upload//2017/02/17/b3d9e1a2-2244-41e8-8b30-bd3c23065d34.jpg'),(33,'12','2017-02-17 17:16:55','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'/upload//2017/02/17/67c183c6-3da6-4815-aaa1-f23ddd41960b.jpg'),(34,'12','2017-02-17 17:17:12','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'/upload//2017/02/17/b0ab48c9-19fa-4a69-a37c-4b9853708659.jpg'),(35,'12','2017-02-19 10:00:19','IMG_0803.PNG',2184823,'/upload//2017/02/19/401a467b-593c-41bd-862e-f7d75ce2354d.PNG'),(36,'12','2017-02-19 13:36:15','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload//2017/02/19/31936ab1-e074-4b58-b674-058e4743a45b.jpg'),(37,'12','2017-02-19 13:38:19','735ddb01-d873-49dc-b41f-540babe0081a.jpg',1915078,'upload//2017/02/19/f4017197-f98b-42e8-a6a0-4bc0e7a03406.jpg'),(38,'12','2017-02-19 13:38:23','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload//2017/02/19/ed722b47-43f9-4128-afe1-9736253fbe46.jpg'),(39,'12','2017-02-19 13:39:27','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload//2017/02/19/28e924a4-b77f-459d-9f07-028fe0bed014.jpg'),(40,'12','2017-02-19 13:42:45','735ddb01-d873-49dc-b41f-540babe0081a.jpg',1915078,'upload//2017/02/19/aff3ace9-73ce-462a-995b-a38caae9fea8.jpg'),(41,'12','2017-02-19 13:44:47','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload//2017/02/19/0e7f1987-bbe3-4293-8713-e1597ab169f0.jpg'),(42,'12','2017-02-19 13:46:53','9905b394-be98-4b5a-8f80-e37e0d1b5542.jpg',1951862,'upload//2017/02/19/8bb74da9-1392-4a58-9399-c2ee8fd0170b.jpg'),(43,'12','2017-02-19 13:48:12','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'upload//2017/02/19/136787ef-64d4-4088-8e71-c1e28ec32343.jpg'),(44,'12','2017-02-19 13:48:19','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload//2017/02/19/5471e62a-4302-439d-b057-edc54a4e332d.jpg'),(45,'12','2017-02-19 13:48:43','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'upload//2017/02/19/b694e0db-a3e1-40bc-8149-5a9f2daf70cc.jpg'),(46,'12','2017-02-19 13:49:39','735ddb01-d873-49dc-b41f-540babe0081a.jpg',1915078,'upload//2017/02/19/c82dc926-7876-423b-81e4-179a993374ca.jpg'),(47,'12','2017-02-19 19:46:58','9905b394-be98-4b5a-8f80-e37e0d1b5542.jpg',1951862,'upload//2017/02/19/931ec410-7c27-4f08-835d-a53c177419e2.jpg'),(48,'12','2017-02-20 00:08:20','8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg',1722473,'upload//2017/02/20/2594836d-17df-479b-b1ac-9244eeeca000.jpg'),(49,'12','2017-02-20 12:55:23','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'/upload/2017/02/20/442bb0f5-c772-41a4-801e-ce18e30844e0.jpg'),(50,'12','2017-02-20 12:58:29','6efd5201-34f3-4184-aa43-31ffbdf7d10c.jpg',3829428,'upload/2017/02/20/b43d287c-bc38-43c7-8fa8-d25448544327.jpg'),(51,'12','2017-02-20 13:03:43','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/02/20/c65ea062-f62f-4bc1-9773-fd3285869e69.jpg'),(52,'12','2017-02-20 13:09:06','bef415e1-b9f6-463d-8796-d43871476efd.jpg',2830299,'upload/2017/02/20/e1b6a3a9-5179-46b3-9440-d265568d11f0.jpg'),(53,'12','2017-02-20 13:19:27','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/02/20/c539a0f8-659d-4564-b8dd-673c9bf7566b.jpg'),(54,'12','2017-02-20 15:01:14','8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg',1722473,'upload/2017/02/20/844edab8-6864-46a7-8101-d8c27d28b299.jpg'),(55,'12','2017-02-20 15:02:05','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/02/20/6397819c-f6c9-40bf-9007-4e35c2a8ba4a.jpg'),(56,'12','2017-02-20 15:07:22','bef415e1-b9f6-463d-8796-d43871476efd.jpg',2830299,'upload/2017/02/20/493a731b-c1b9-4d56-88b0-f64a3b63901e.jpg'),(57,'12','2017-02-20 15:53:16','6e39d48e-c79e-46a7-9193-930d46db17aa.jpg',1722473,'upload/2017/02/20/06b2f242-5443-4648-8800-df6a686c2a49.jpg'),(58,'12','2017-02-28 14:51:07','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/02/28/246e1db3-7725-40a6-8bf4-ff0f98e639f4.jpg'),(59,'12','2017-02-28 14:51:18','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/02/28/7df6f5fa-4962-4b64-9b3e-d381511fb064.jpg'),(60,'12','2017-03-01 14:07:28','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/01/44c346d8-822e-4178-93bb-d652a7203a52.jpg'),(61,'12','2017-03-01 14:11:45','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/01/f0167b79-f0de-40a7-9fac-615b5cae08cc.jpg'),(62,'12','2017-03-01 14:27:33','735ddb01-d873-49dc-b41f-540babe0081a.jpg',1915078,'upload/2017/03/01/cb4710af-4be4-4ee6-bcbf-16e646f16595.jpg'),(63,'12','2017-03-01 14:29:35','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/01/507f35fb-f0e2-4805-8645-199eaa55805c.jpg'),(64,'12','2017-03-01 14:30:23','bef415e1-b9f6-463d-8796-d43871476efd.jpg',2830299,'upload/2017/03/01/a65c2d17-3f42-4040-81be-16bb3b7e0aad.jpg'),(65,'12','2017-03-01 14:35:12','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/01/cfb88316-91a3-4c03-9b71-d192e01c431a.jpg'),(66,'12','2017-03-07 21:28:35','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/07/b09d3dbe-a10c-4b26-989d-e31bf2857660.jpg'),(67,'12','2017-03-07 21:39:10','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/07/3744d7be-6f79-4fff-b918-587c7db0bf6a.jpg'),(68,'12','2017-03-07 21:55:37','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/07/4b13be37-c09a-4a4e-b751-dcc28da8bd23.jpg'),(69,'12','2017-03-08 13:42:07','d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg',3860401,'upload/2017/03/08/11853a7e-5250-44c5-aac2-2a7b00ce9654.jpg'),(70,'12','2017-03-08 13:43:24','e1740512-6d3b-4739-b67f-1eb6b296d463.jpg',1915078,'upload/2017/03/08/37d5ae4f-d3b2-4397-b817-52efd6faac37.jpg'),(71,'12','2017-03-17 19:51:34','chrome.exe',945496,'upload/2017/03/17/16000c2c-6900-452c-9bca-d599622615c6.exe'),(72,'12','2017-03-17 19:51:46','16M.png',16749527,'upload/2017/03/17/a6a6f1e8-0ad5-4b2c-bc19-0ba90cb73b93.png');
/*!40000 ALTER TABLE `ATTACHMENT_UNUSED` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BBS_INFO`
--

DROP TABLE IF EXISTS `BBS_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BBS_INFO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BBS_NAME` varchar(50) NOT NULL,
  `BBS_INFO` varchar(200) DEFAULT NULL,
  `BBS_USER_COUNT` int(11) NOT NULL,
  `BBS_POST` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BBS_INFO`
--

LOCK TABLES `BBS_INFO` WRITE;
/*!40000 ALTER TABLE `BBS_INFO` DISABLE KEYS */;
INSERT INTO `BBS_INFO` VALUES (1,'ZHTBBS测试论坛','测试',2,43);
/*!40000 ALTER TABLE `BBS_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMAIL`
--

DROP TABLE IF EXISTS `EMAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMAIL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(50) NOT NULL,
  `EMAIL_CHECK` varchar(20) NOT NULL,
  `EMAIL_URL` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMAIL`
--

LOCK TABLES `EMAIL` WRITE;
/*!40000 ALTER TABLE `EMAIL` DISABLE KEYS */;
INSERT INTO `EMAIL` VALUES (24,'894404581@qq.com','true','ae4c9d9af3de79a43c5d3eb08d33dfdd'),(65,'1604183676@qq.com','true','23abd22d2b74c8f3f4b0a34411116f91');
/*!40000 ALTER TABLE `EMAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INDEX_HEAD_PLIOT`
--

DROP TABLE IF EXISTS `INDEX_HEAD_PLIOT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INDEX_HEAD_PLIOT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PLIOT_NAME` varchar(200) NOT NULL,
  `PLIOT_URL` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INDEX_HEAD_PLIOT`
--

LOCK TABLES `INDEX_HEAD_PLIOT` WRITE;
/*!40000 ALTER TABLE `INDEX_HEAD_PLIOT` DISABLE KEYS */;
INSERT INTO `INDEX_HEAD_PLIOT` VALUES (1,'论坛','index.do'),(2,'测试','index.do');
/*!40000 ALTER TABLE `INDEX_HEAD_PLIOT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOOK_FORPASS`
--

DROP TABLE IF EXISTS `LOOK_FORPASS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOOK_FORPASS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_ID` int(11) NOT NULL,
  `EMAIL_CHECK` varchar(200) NOT NULL,
  `EMAIL_URL` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOOK_FORPASS`
--

LOCK TABLES `LOOK_FORPASS` WRITE;
/*!40000 ALTER TABLE `LOOK_FORPASS` DISABLE KEYS */;
INSERT INTO `LOOK_FORPASS` VALUES (2,47,'false','7749c35726f684923d861331eed1a40a'),(5,12,'true','1f303a3a5139cf0bdbd192c46aba4fee'),(6,12,'true','d30bfc368378518c7d2e6dee7ab4091f'),(7,12,'true','ae4c9d9af3de79a43c5d3eb08d33dfdd569a96c6-7b96-4b6c-a941-4e01e70fc3d0c20ad4d76fe97759aa27a0c99bff6710f1ea8c9e-d0f1-43b7-a764-bb1d2dd81d5b'),(8,12,'true','ae4c9d9af3de79a43c5d3eb08d33dfdd74cd0477-51f1-4a85-a58c-73ec59361bc0c20ad4d76fe97759aa27a0c99bff6710017b21a1-8733-4546-8e30-3724baea5788'),(9,12,'true','ae4c9d9af3de79a43c5d3eb08d33dfdd24809271-db19-4caf-a931-779d49e2f7dcc20ad4d76fe97759aa27a0c99bff671004150e6d-0cca-42f5-a870-b20edd326415'),(10,12,'true','ae4c9d9af3de79a43c5d3eb08d33dfdd13fc9092-afab-4211-9230-b90d0bc09f7dc20ad4d76fe97759aa27a0c99bff6710936c65b0-bf4e-4321-819e-a283ab11a7e2'),(11,12,'false','ae4c9d9af3de79a43c5d3eb08d33dfdd488528bd-79bd-405e-8d9e-42897b7d1468c20ad4d76fe97759aa27a0c99bff6710a702089e-4c35-47b3-972b-f9421b484d70');
/*!40000 ALTER TABLE `LOOK_FORPASS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLATE`
--

DROP TABLE IF EXISTS `PLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLATE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PLATE_NAME` varchar(20) NOT NULL,
  `LAST_ISSUE` varchar(50) DEFAULT NULL,
  `IMG_URL` varchar(200) NOT NULL,
  `POST_COUNT` int(11) NOT NULL,
  `POST_URL` varchar(200) NOT NULL,
  `ACCESS_RIGHTS` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLATE`
--

LOCK TABLES `PLATE` WRITE;
/*!40000 ALTER TABLE `PLATE` DISABLE KEYS */;
INSERT INTO `PLATE` VALUES (1,'测试1','2017-03-17 19:51:59.0','image/ISSUE.png',42,'1',1),(2,'测试2',NULL,'image/ISSUE.png',0,'2',1),(3,'测试3','2017-03-17 19:52:29.0','image/ISSUE.png',1,'3',1),(4,'测试4',NULL,'image/ISSUE.png',0,'4',20);
/*!40000 ALTER TABLE `PLATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `POST`
--

DROP TABLE IF EXISTS `POST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `POST` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) NOT NULL,
  `CONTENT` text NOT NULL,
  `ISSUE_TIME` datetime NOT NULL,
  `ISSUE_USERID` int(11) NOT NULL,
  `PLATE_ID` int(11) unsigned NOT NULL,
  `SEE_COUNT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `POST`
--

LOCK TABLES `POST` WRITE;
/*!40000 ALTER TABLE `POST` DISABLE KEYS */;
INSERT INTO `POST` VALUES (1,'图片测试1','<div style=\"text-align: center;\"><img src=\"/upload//2017/02/11/d94a5d98-4aed-47fc-9b27-6dfeadcc208e.jpg\" style=\"width: 60%; height: 60%;\"><br></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/e1740512-6d3b-4739-b67f-1eb6b296d463.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/13/bad4cbb0-52d2-47d2-9ccf-8120d6b1de88.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/14/dbcd18f1-d4c8-466f-92e7-42526c8962b6.jpg\"></div>','2017-02-11 09:46:38',12,1,168),(2,'图片1','<div style=\"text-align: center;\"><br></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/14/19f4338a-d7d9-4341-ae8f-a8ea140c124f.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/14/d2c26716-fff6-4b9b-b707-e8734c7752e5.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/15/3e41db5a-0a5d-403e-9e6e-4af7f55ed586.jpg\"></div>','2017-02-11 11:26:50',12,1,53),(3,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/0426b86c-c037-4a4a-815e-0463fe4bd991.jpg\"></div>','2017-02-16 14:53:37',12,1,4),(4,'6666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/cf624620-5371-401c-810c-d627671e35a2.png\"></div>','2017-02-16 15:15:36',12,1,4),(5,'6666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/4785deba-6164-4889-8b9a-2cc29b216997.jpg\"></div>','2017-02-16 15:18:46',12,1,3),(6,'666','<div><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/3eb625fb-f05e-4202-a84e-a30ab303a6a1.png\"></div>','2017-02-16 15:19:12',12,1,6),(7,'666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/a4d4dd16-6b44-487f-937b-c9331ad5bd77.jpg\"></div>','2017-02-16 15:20:40',12,1,9),(8,'44rwfefefefd','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/7fa0dafc-4b62-404a-8c6b-13635b9f3afa.jpg\"></div>','2017-02-16 15:22:03',12,1,97),(9,'666666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/7422a617-659f-49c1-ba12-dcf265c94df5.png\"></div>','2017-02-17 17:14:14',12,1,1),(10,'666666','77766656','2017-02-17 17:15:32',12,1,2),(11,'44334dfdfdfdf','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/035e3d4d-698a-4abd-915b-50ffb1010241.jpg\"></div>','2017-02-17 17:15:50',12,1,4),(12,'55555','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/f6c42b94-36e2-4268-be3c-59bdd5ec7a40.jpg\"></div>','2017-02-17 17:16:16',12,1,2),(13,'66666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/b3d9e1a2-2244-41e8-8b30-bd3c23065d34.jpg\"></div><div style=\"text-align: center;\"><br></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/67c183c6-3da6-4815-aaa1-f23ddd41960b.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/19/401a467b-593c-41bd-862e-f7d75ce2354d.PNG\"></div>','2017-02-17 17:16:48',12,1,14),(14,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload//2017/02/20/2594836d-17df-479b-b1ac-9244eeeca000.jpg\"></div><div style=\"text-align: center;\"><br></div>','2017-02-20 00:09:09',12,1,7),(15,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/02/20/b43d287c-bc38-43c7-8fa8-d25448544327.jpg\"></div>','2017-02-20 12:58:45',12,1,7),(16,'测试','<div><br></div><div><img style=\"width:60%;height:60%;\" src=\"upload/2017/02/20/e1b6a3a9-5179-46b3-9440-d265568d11f0.jpg\"></div>','2017-02-20 13:06:49',12,1,14),(17,'6666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/02/20/c539a0f8-659d-4564-b8dd-673c9bf7566b.jpg\"></div>','2017-02-20 13:19:38',12,1,10),(18,'5','<div style=\"text-align: center;\"><br></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/02/28/246e1db3-7725-40a6-8bf4-ff0f98e639f4.jpg\"></div>','2017-02-20 14:55:05',12,1,44),(19,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/44c346d8-822e-4178-93bb-d652a7203a52.jpg\"></div>','2017-03-01 14:07:37',12,1,1),(20,'66666','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/f0167b79-f0de-40a7-9fac-615b5cae08cc.jpg\"></div>','2017-03-01 14:11:50',12,1,4),(21,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/cb4710af-4be4-4ee6-bcbf-16e646f16595.jpg\"></div>','2017-03-01 14:27:38',12,1,1),(22,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/507f35fb-f0e2-4805-8645-199eaa55805c.jpg\"></div>','2017-03-01 14:29:38',12,1,2),(23,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/a65c2d17-3f42-4040-81be-16bb3b7e0aad.jpg\"></div>','2017-03-01 14:30:28',12,1,2),(24,'非法','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/01/cfb88316-91a3-4c03-9b71-d192e01c431a.jpg\"></div>','2017-03-01 14:35:18',12,1,2),(25,'deedewdew','dewddeed','2017-03-01 14:37:35',12,1,4),(26,'reggrgrgregr','rrgger','2017-03-01 14:39:12',12,1,13),(27,'测试','测试','2017-03-07 19:10:39',50,1,9),(28,'测试','<h1 style=\"text-align: center;\">测试</h1>','2017-03-07 21:28:45',12,1,9),(29,'和v','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/07/4b13be37-c09a-4a4e-b751-dcc28da8bd23.jpg\"></div>','2017-03-07 21:55:45',12,1,2),(30,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/08/11853a7e-5250-44c5-aac2-2a7b00ce9654.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/08/11853a7e-5250-44c5-aac2-2a7b00ce9654.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/08/11853a7e-5250-44c5-aac2-2a7b00ce9654.jpg\"></div>','2017-03-08 13:42:25',12,1,10),(31,'测试','测试','2017-03-16 13:59:22',12,1,1),(32,'测试','测试','2017-03-16 13:59:27',12,1,1),(33,'测试','测试','2017-03-16 13:59:30',12,1,1),(34,'测试','测试','2017-03-16 13:59:34',12,1,1),(35,'测试','测试','2017-03-16 13:59:38',12,1,1),(36,'测试','测试','2017-03-16 13:59:42',12,1,1),(37,'测试','测试','2017-03-16 14:00:11',12,1,1),(38,'测试','测试','2017-03-16 14:00:14',12,1,1),(39,'测试','测试','2017-03-16 14:00:17',12,1,1),(40,'测试测试','测试','2017-03-16 14:00:21',12,1,1),(41,'测试','测试','2017-03-16 14:00:24',12,1,8),(42,'测试','<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/17/a6a6f1e8-0ad5-4b2c-bc19-0ba90cb73b93.png\"></div>','2017-03-17 19:51:59',12,1,5),(43,'测试','测试','2017-03-17 19:52:29',12,3,2);
/*!40000 ALTER TABLE `POST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REPLY_POST`
--

DROP TABLE IF EXISTS `REPLY_POST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REPLY_POST` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` int(11) NOT NULL,
  `CONTENT` text NOT NULL,
  `REPLY_USERID` int(11) NOT NULL,
  `ISSUE_TIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REPLY_POST`
--

LOCK TABLES `REPLY_POST` WRITE;
/*!40000 ALTER TABLE `REPLY_POST` DISABLE KEYS */;
INSERT INTO `REPLY_POST` VALUES (14,22,'<div style=\"text-align: center;\">adswadsadshafsukygfuygauyfguyasfadfasdfasdfaf</div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1733226232.jpg\"></div>',12,'2016-12-20 14:16:29'),(15,11,'<div style=\"text-align: center;\"><i><b><u>666666666666</u></b></i></div>',12,'2016-12-20 14:28:24'),(16,22,'<div style=\"text-align: center;\">&nbsp;bhnrbfgtfgbbfgtdbdffbdvbdfvsbfvds</div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/161685275.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/161685275.jpg\"></div>',12,'2016-12-20 14:50:11'),(17,22,'<div style=\"text-align: center;\">eqwewfqqwaeaerwewfsewafsefswefswaeswes</div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div><div style=\"text-align: center;\"><img style=\"width: 60%;height: 60%;\" src=\"upload/-1507787301.jpg\"></div>',34,'2016-12-20 17:01:24'),(48,1,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/c0509f27-747b-419b-a421-4050f81aaf8b.jpg\"></div>',12,'2017-02-11 09:55:11'),(49,1,'555',12,'2017-02-11 11:16:20'),(50,1,'7777777',12,'2017-02-11 11:16:27'),(51,1,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/98bc259c-7a7f-486e-a951-6f66698add2f.jpg\"></div>',12,'2017-02-11 14:00:54'),(52,1,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/6efd5201-34f3-4184-aa43-31ffbdf7d10c.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/8ce29ba0-df44-4225-b2cb-c71696260d2a.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/735ddb01-d873-49dc-b41f-540babe0081a.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/9905b394-be98-4b5a-8f80-e37e0d1b5542.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/0e831590-a93d-4dc7-aa31-981ec5523a92.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/bef415e1-b9f6-463d-8796-d43871476efd.jpg\"></div>',12,'2017-02-11 14:23:13'),(53,2,'<div><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/11/6e39d48e-c79e-46a7-9193-930d46db17aa.jpg\"></div>',12,'2017-02-11 14:35:03'),(54,2,'回复',49,'2017-02-14 15:21:11'),(55,2,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/14/5918440f-922b-4237-8e4c-5641c271541e.jpg\"></div>',12,'2017-02-14 17:05:08'),(56,1,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/14/142673bc-723d-426f-9065-6c321392fc3c.jpg\"></div>',12,'2017-02-14 19:00:28'),(57,3,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/c75b35c9-06d8-43ea-b7c7-97b8e2f30c50.jpg\"></div>',12,'2017-02-16 15:02:54'),(58,8,'<h2><br></h2>\n\n				<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/3444e57a-2fec-4de9-8245-2ab20f8b7822.jpg\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/82e86de1-43ca-4a55-86b9-5e076b48e555.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/86f860b2-fe4d-4447-ad38-98009dd7d44b.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/0f32d8ce-d5cd-408c-ad0d-ea840e9e3cb5.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/be9490e5-3f16-4cc0-9785-ccca6768071b.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/a6447658-23c1-4037-b1e8-33d565ebee2d.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/e968e6a0-601f-42ea-90f5-6504decd24c4.png\"></div><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/2b1a8231-3c2a-478e-995e-b0e30c169616.png\"></div>',12,'2017-02-16 15:37:56'),(59,8,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/16/2dcbc79e-9d3e-4fd3-8bbc-8ed9a0317ab9.png\"></div>',12,'2017-02-16 15:47:44'),(60,8,'m',12,'2017-02-16 16:23:27'),(61,8,'n',12,'2017-02-16 16:23:30'),(62,8,'n',12,'2017-02-16 16:23:33'),(63,8,'g',12,'2017-02-16 16:23:36'),(64,8,'f',12,'2017-02-16 16:23:39'),(65,8,'r',12,'2017-02-16 16:23:41'),(66,8,'erfrregrg',12,'2017-02-16 16:23:43'),(67,8,'w',12,'2017-02-16 16:23:45'),(68,8,'w',12,'2017-02-16 16:23:47'),(69,8,'w',12,'2017-02-16 16:23:49'),(70,8,'w',12,'2017-02-16 16:23:50'),(71,8,'w',12,'2017-02-16 16:23:52'),(72,8,'w',12,'2017-02-16 16:23:54'),(73,8,'w',12,'2017-02-16 16:23:55'),(74,8,'w',12,'2017-02-16 16:23:56'),(75,8,'w',12,'2017-02-16 16:23:58'),(76,8,'w',12,'2017-02-16 16:24:00'),(77,8,'w',12,'2017-02-16 16:24:01'),(78,13,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"/upload//2017/02/17/b0ab48c9-19fa-4a69-a37c-4b9853708659.jpg\"></div>',12,'2017-02-17 17:17:16'),(79,1,'c',12,'2017-02-20 13:36:25'),(80,1,'c',12,'2017-02-20 13:36:27'),(81,1,'c',12,'2017-02-20 13:36:31'),(82,1,'c',12,'2017-02-20 13:36:35'),(83,1,'c',12,'2017-02-20 13:36:37'),(84,1,'c',12,'2017-02-20 13:36:39'),(85,1,'c',12,'2017-02-20 13:36:41'),(86,1,'c',12,'2017-02-20 13:36:42'),(87,1,'1',12,'2017-02-20 13:41:22'),(88,1,'1',12,'2017-02-20 13:41:25'),(89,1,'1',12,'2017-02-20 13:41:28'),(90,1,'2',12,'2017-02-20 13:41:30'),(91,1,'3',12,'2017-02-20 13:41:34'),(92,1,'4',12,'2017-02-20 13:41:37'),(93,1,'5',12,'2017-02-20 13:41:39'),(94,1,'6',12,'2017-02-20 13:41:41'),(95,1,'7',12,'2017-02-20 13:41:43'),(96,1,'8',12,'2017-02-20 13:41:44'),(97,1,'1',12,'2017-02-20 13:41:46'),(98,1,'11',12,'2017-02-20 13:41:48'),(99,1,'13',12,'2017-02-20 13:41:49'),(100,1,'21',12,'2017-02-20 13:41:52'),(101,1,'32ddd',12,'2017-02-20 13:41:54'),(102,1,'dwdwdwdd',12,'2017-02-20 13:41:55'),(103,1,'dddd',12,'2017-02-20 13:41:57'),(104,1,'dwdwwdwd',12,'2017-02-20 13:41:59'),(105,1,'dwdwdsdssd',12,'2017-02-20 13:42:00'),(106,1,'wwdwddw',12,'2017-02-20 13:42:02'),(107,6,'3',12,'2017-02-20 14:54:43'),(108,7,'5',12,'2017-02-20 14:54:52'),(109,7,'5',12,'2017-02-20 14:54:54'),(110,18,'<div style=\"text-align: center;\"><img src=\"upload/2017/02/28/7df6f5fa-4962-4b64-9b3e-d381511fb064.jpg\" style=\"width: 60%; height: 60%;\"><br></div>',12,'2017-02-20 15:01:09'),(111,27,'测试',50,'2017-03-07 19:10:44'),(112,27,'ces',12,'2017-03-07 21:25:29'),(113,26,'<br><div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/07/3744d7be-6f79-4fff-b918-587c7db0bf6a.jpg\"></div>',12,'2017-03-07 21:38:29'),(114,30,'<div style=\"text-align: center;\"><img style=\"width:60%;height:60%;\" src=\"upload/2017/03/08/37d5ae4f-d3b2-4397-b817-52efd6faac37.jpg\"></div>',12,'2017-03-08 13:43:29');
/*!40000 ALTER TABLE `REPLY_POST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SETTING`
--

DROP TABLE IF EXISTS `SETTING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SETTING` (
  `KEY` varchar(255) NOT NULL,
  `VALUE` text NOT NULL,
  PRIMARY KEY (`KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SETTING`
--

LOCK TABLES `SETTING` WRITE;
/*!40000 ALTER TABLE `SETTING` DISABLE KEYS */;
INSERT INTO `SETTING` VALUES ('Forum_Name','ZHT测试论坛'),('Forum_Post_Count','2'),('Forum_User_Count','2');
/*!40000 ALTER TABLE `SETTING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERS` varchar(40) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `PORTRAIT` varchar(200) NOT NULL DEFAULT 'static/image/Head_portrait.png',
  `GID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERS_UNIQUE` (`USERS`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (12,'894404581','82175ddea55314b0f5ae13e91d2ed4f7','894404581@qq.com','static/image/Head_portrait.png',1),(50,'1604183676','82175ddea55314b0f5ae13e91d2ed4f7','1604183676@qq.com','static/image/Head_portrait.png',2);
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_GROUP`
--

DROP TABLE IF EXISTS `USER_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_GROUP` (
  `GID` int(11) NOT NULL AUTO_INCREMENT,
  `GNAME` varchar(20) NOT NULL,
  `GROUP_TYPE` varchar(10) NOT NULL,
  `INTEGRAL_MAX` int(11) NOT NULL,
  `INTEGRAL_MINI` int(11) NOT NULL,
  `ALLOWVISIT` tinyint(1) NOT NULL,
  `ACCESS_RIGHTS` int(3) NOT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_GROUP`
--

LOCK TABLES `USER_GROUP` WRITE;
/*!40000 ALTER TABLE `USER_GROUP` DISABLE KEYS */;
INSERT INTO `USER_GROUP` VALUES (1,'管理员','sys',0,0,0,255),(2,'板块管理员','sys',0,0,0,150),(3,'邮箱未验证','sys',0,0,0,1),(4,'游客','sys',0,0,0,1),(5,'禁止访问','sys',0,0,1,0),(6,'扩展管理员','custom',0,0,0,150);
/*!40000 ALTER TABLE `USER_GROUP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_INTEGRAL`
--

DROP TABLE IF EXISTS `USER_INTEGRAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_INTEGRAL` (
  `USER_ID` int(11) unsigned NOT NULL,
  `INTEGRAL1` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL2` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL3` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL4` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL5` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL6` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL7` int(11) NOT NULL DEFAULT '0',
  `INTEGRAL8` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_INTEGRAL`
--

LOCK TABLES `USER_INTEGRAL` WRITE;
/*!40000 ALTER TABLE `USER_INTEGRAL` DISABLE KEYS */;
INSERT INTO `USER_INTEGRAL` VALUES (12,0,0,0,0,0,0,0,0),(50,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `USER_INTEGRAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_SIGN_IN_INFO`
--

DROP TABLE IF EXISTS `USER_SIGN_IN_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_SIGN_IN_INFO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL,
  `REGISTER_TIME` datetime NOT NULL,
  `REGISTER_IP` varchar(20) NOT NULL,
  `LAST_SIGN_IN_TIME` datetime NOT NULL,
  `LAST_SIGN_IN_IP` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_SIGN_IN_INFO`
--

LOCK TABLES `USER_SIGN_IN_INFO` WRITE;
/*!40000 ALTER TABLE `USER_SIGN_IN_INFO` DISABLE KEYS */;
INSERT INTO `USER_SIGN_IN_INFO` VALUES (1,12,'2017-01-16 15:39:21','127.0.0.1','2017-03-17 19:51:15','192.168.0.120'),(7,50,'2017-03-07 19:07:59','0:0:0:0:0:0:0:1','2017-03-07 19:10:21','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `USER_SIGN_IN_INFO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-17 21:42:17
