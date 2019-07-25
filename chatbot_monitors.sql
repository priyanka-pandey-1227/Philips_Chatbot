-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: chatbot
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `monitors`
--

DROP TABLE IF EXISTS `monitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monitor_name` varchar(100) NOT NULL,
  `monitor_type` varchar(45) NOT NULL,
  `screen_type` varchar(45) DEFAULT NULL,
  `screen_size` varchar(45) NOT NULL,
  `ecg` varchar(45) DEFAULT 'NO',
  `spo2` varchar(45) DEFAULT 'NO',
  `nibp` varchar(45) DEFAULT 'NO',
  `respiration` varchar(45) DEFAULT 'NO',
  `temperature` varchar(45) DEFAULT 'NO',
  `link` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitors`
--

LOCK TABLES `monitors` WRITE;
/*!40000 ALTER TABLE `monitors` DISABLE KEYS */;
INSERT INTO `monitors` VALUES (5,'IntelliVue MX400','Modular','Touchscreen','9','Yes','Yes','Yes','Yes','Yes',NULL),(6,'IntelliVue MX450','Modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes',NULL),(7,'IntelliVue MX500','Modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes',NULL),(8,'IntelliVue MX550','Modular','Touchscreen','15','Yes','Yes','Yes','Yes','Yes',NULL),(9,'IntelliVue MX600','Modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes',NULL),(10,'IntelliVue MX700','Modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes',NULL),(11,'IntelliVue MX800','Modular','Non-touchscreen','19','Yes','Yes','Yes','Yes','Yes',NULL),(12,'Efficia CM10','Semi-modular','Touchscreen','10','Yes','Yes','Yes','Yes','Yes',NULL),(13,'Efficia CM12','Semi-modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes',NULL),(14,'Efficia CM100','Semi-modular','Non-touchscreen','10','Yes','Yes','Yes','Yes','Yes',NULL),(15,'Efficia CM120','Semi-modular','Non-touchscreen','12','Yes','Yes','Yes','Yes','Yes',NULL),(16,'Efficia CM150','Semi-modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes',NULL),(17,'Goldway G30E','Preconfigured','Non-touchscreen','10.4','Yes','Yes','Yes','Yes','Yes',NULL),(18,'Goldway G40E','Preconfigured','Non-touchscreen','12.1','Yes','Yes','Yes','Yes','Yes',NULL);
/*!40000 ALTER TABLE `monitors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-23 14:43:32
