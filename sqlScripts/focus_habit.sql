-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: focus
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `habit`
--

DROP TABLE IF EXISTS `habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habit` (
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `streak` int DEFAULT NULL,
  `lastModified` date DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habit`
--

LOCK TABLES `habit` WRITE;
/*!40000 ALTER TABLE `habit` DISABLE KEYS */;
INSERT INTO `habit` VALUES ('abcd','Drink 8 glasses of water per day',6,'2023-04-30','2023-04-01'),('b','ab',4,'2023-04-30','2023-04-29'),('c','ab',9,'2023-04-30','2023-04-29'),('d','ab',6,'2023-04-30','2023-04-29'),('Drink water','Drink 8 glasses of water per day',6,'2023-04-30','2023-04-01'),('Drink water habit wala','Drink 8 glasses of water per day',6,'2023-04-30','2023-04-01'),('e','ab',9,'2023-04-30','2023-04-29'),('Exercise','Do 30 minutes of exercise every day',4,'2023-04-30','2023-04-01'),('Exercise hehehe','Do 30 minutes of exercise every day',4,'2023-04-30','2023-04-01'),('g','ab',10,'2023-04-30','2023-04-29'),('hehehehejr','Do 30 minutes of exercise every day',4,'2023-04-30','2023-04-01'),('Meditation','Meditate for 15 minutes every day',3,'2023-04-30','2023-04-01'),('Meditation yo','Meditate for 15 minutes every day',3,'2023-04-30','2023-04-01'),('yooooo','Meditate for 15 minutes every day',3,'2023-04-30','2023-04-01');
/*!40000 ALTER TABLE `habit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-01  0:03:30
