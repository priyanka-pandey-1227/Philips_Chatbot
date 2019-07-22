-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `monitors`
--

DROP TABLE IF EXISTS `monitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `monitors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `monitor_name` varchar(100) NOT NULL,
  `monitor_type` varchar(45) NOT NULL,
  `screen_type` varchar(45) DEFAULT NULL,
  `screen_size` varchar(45) NOT NULL,
  `ECG` varchar(45) DEFAULT 'NO',
  `SPO2` varchar(45) DEFAULT 'NO',
  `NIBP` varchar(45) DEFAULT 'NO',
  `RESPIRATION` varchar(45) DEFAULT 'NO',
  `TEMPERATURE` varchar(45) DEFAULT 'NO',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitors`
--

LOCK TABLES `monitors` WRITE;
/*!40000 ALTER TABLE `monitors` DISABLE KEYS */;
INSERT INTO `monitors` VALUES (5,'IntelliVue MX400','Modular','Touchscreen','9','Yes','Yes','Yes','Yes','Yes'),(6,'IntelliVue MX450','Modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes'),(7,'IntelliVue MX500','Modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes'),(8,'IntelliVue MX550','Modular','Touchscreen','15','Yes','Yes','Yes','Yes','Yes'),(9,'IntelliVue MX600','Modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes'),(10,'IntelliVue MX700','Modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes'),(11,'IntelliVue MX800','Modular','Non-touchscreen','19','Yes','Yes','Yes','Yes','Yes'),(12,'Efficia CM10','Semi-modular','Touchscreen','10','Yes','Yes','Yes','Yes','Yes'),(13,'Efficia CM12','Semi-modular','Touchscreen','12','Yes','Yes','Yes','Yes','Yes'),(14,'Efficia CM100','Semi-modular','Non-touchscreen','10','Yes','Yes','Yes','Yes','Yes'),(15,'Efficia CM100','Semi-modular','Non-touchscreen','10','Yes','Yes','Yes','Yes','Yes'),(16,'Efficia CM150','Semi-modular','Non-touchscreen','15','Yes','Yes','Yes','Yes','Yes'),(17,'Goldway G30E','Preconfigured','Non-touchscreen','10.4','Yes','Yes','Yes','Yes','Yes'),(18,'Goldway G40E','Preconfigured','Non-touchscreen','12.1','Yes','Yes','Yes','Yes','Yes');
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

-- Dump completed on 2019-07-22 15:22:30
