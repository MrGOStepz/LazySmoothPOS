-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lazy_smooth_pos
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category_info`
--

DROP TABLE IF EXISTS `category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_info` (
  `category_info_id` bigint NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_info`
--

LOCK TABLES `category_info` WRITE;
/*!40000 ALTER TABLE `category_info` DISABLE KEYS */;
INSERT INTO `category_info` VALUES (3,'8.png','หมวดอุด้งร้อน'),(4,'7.png','หมวดอุด้งเย็นๆ ร้อนๆ'),(5,'7.png','หมวดอุด้งร้อน');
/*!40000 ALTER TABLE `category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `id` bigint NOT NULL,
  `amount` double DEFAULT NULL,
  `last_updated_time` datetime(6) DEFAULT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `receipt_json` varchar(255) DEFAULT NULL,
  `started_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` bigint NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `last_updated_time` datetime(6) DEFAULT NULL,
  `order_info_id` bigint DEFAULT NULL,
  `popup_detail_id` bigint DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `started_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_info_id` bigint DEFAULT NULL,
  `popup_info_id` bigint DEFAULT NULL,
  `food_type` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `location_page` int DEFAULT NULL,
  `location_row` int DEFAULT NULL,
  `location_column` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `is_available` bit(1) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'คิทสึเนะอุด้งร้อน',NULL,1,2,'main',99,1,1,1,NULL,'16.png',_binary ''),(2,'ชิกุวะ/ไข่/เต้าหู้ อุด้งร้อน',NULL,1,2,'main',149,1,1,2,NULL,'15.png',_binary ''),(3,'ไก่เทมปุระอุด้งร้อน',NULL,1,2,'main',159,1,2,1,NULL,'14.png',_binary ''),(4,'ไก่ย่างพริกดำอุด้งร้อน',NULL,1,2,'main',159,1,2,2,NULL,'13.png',_binary ''),(5,'กุ้งเทมปุระอุด้งร้อน',NULL,1,2,'main',209,2,1,1,NULL,'12.png',_binary ''),(6,'เนื้อผัดอุด้งร้อน',NULL,1,2,'main',179,2,1,2,NULL,'11.png',_binary ''),(7,'ผักเทมปุระอุด้งร้อน',NULL,1,2,'main',149,2,2,1,NULL,'10.png',_binary ''),(8,'เนื้อตุ๋นอุด้งร้อน',NULL,1,2,'main',189,2,2,2,NULL,'9.png',_binary ''),(9,'หัวหอมทอดอุด้งร้อน',NULL,1,2,'main',109,3,1,1,NULL,'8.png',_binary ''),(10,'หมูชาชูถ่านอุด้งร้อน',NULL,1,2,'main',169,3,1,2,NULL,'7.png',_binary ''),(11,'หัวหอมทอดอุด้งเย็น',NULL,2,2,'main',139,1,1,1,NULL,NULL,_binary ''),(12,'ชิกุวะ/ไข่/เต้าหู้อุด้งเย็น',NULL,2,2,'main',179,1,1,2,NULL,NULL,_binary ''),(13,'หมูชาชูถ่านอุด้งเย็น',NULL,2,2,'main',179,1,2,1,NULL,NULL,_binary ''),(14,'ไก่เทมปุระอุด้งเย็น',NULL,2,2,'main',169,1,2,2,NULL,NULL,_binary ''),(15,'ไก่ย่างพริกดำอุด้งเย็น',NULL,2,2,'main',169,2,1,1,NULL,NULL,_binary ''),(16,'ผักเทมปุระอุด้งเย็น',NULL,2,2,'main',159,2,1,2,NULL,NULL,_binary ''),(17,'กุ้งเทมปุระ(3)อุด้งเย็น',NULL,2,2,'main',219,2,2,1,NULL,NULL,_binary ''),(18,'เนื้อผัดอุด้งเย็น',NULL,2,2,'main',189,2,2,2,NULL,NULL,_binary ''),(19,'เนื้อตุ๋นอุด้งเย็น',NULL,2,2,'main',199,3,1,1,NULL,NULL,_binary ''),(20,'หัวหอมทอดข้าวแกงกะหรี่',NULL,3,1,'main',139,1,1,1,NULL,NULL,_binary ''),(21,'ชิกุวะ/ไข่/เต้าหู้ข้าวแกงกะหรี่',NULL,3,1,'main',179,1,1,2,NULL,NULL,_binary ''),(22,'หมูชาชูถ่านข้าวแกงกะหรี่',NULL,3,1,'main',179,1,2,1,NULL,NULL,_binary ''),(23,'ไก่เทมปุระข้าวแกงกะหรี่',NULL,3,1,'main',169,1,2,2,NULL,NULL,_binary ''),(24,'ไก่ย่างพริกดำข้าวแกงกะหรี่',NULL,3,1,'main',169,2,1,1,NULL,NULL,_binary ''),(25,'ผักเทมปุระข้าวแกงกะหรี่',NULL,3,1,'main',159,2,1,2,NULL,NULL,_binary ''),(26,'กุ้งเทมปุระ(3)ข้าวแกงกะหรี่',NULL,3,1,'main',219,2,2,1,NULL,NULL,_binary ''),(27,'เนื้อผัดข้าวแกงกะหรี่',NULL,3,1,'main',189,2,2,2,NULL,NULL,_binary ''),(28,'เนื้อตุ๋นข้าวแกงกะหรี่',NULL,3,1,'main',199,3,1,1,NULL,NULL,_binary ''),(29,'หัวหอมทอดอุด้งแกงกะหรี่',NULL,4,2,'main',139,1,1,1,NULL,NULL,_binary ''),(30,'ชิกุวะ/ไข่/เต้าหู้อุด้งแกงกะหรี่',NULL,4,2,'main',179,1,1,2,NULL,NULL,_binary ''),(31,'หมูชาชูถ่านอุด้งแกงกะหรี่',NULL,4,2,'main',179,1,2,1,NULL,NULL,_binary ''),(32,'ไก่เทมปุระอุด้งแกงกะหรี่',NULL,4,2,'main',169,1,2,2,NULL,NULL,_binary ''),(33,'ไก่ย่างพริกดำอุด้งแกงกะหรี่',NULL,4,2,'main',169,2,1,1,NULL,NULL,_binary ''),(34,'ผักเทมปุระอุด้งแกงกะหรี่',NULL,4,2,'main',159,2,1,2,NULL,NULL,_binary ''),(35,'กุ้งเทมปุระ(3)อุด้งแกงกะหรี่',NULL,4,2,'main',219,2,2,1,NULL,NULL,_binary ''),(36,'เนื้อผัดอุด้งแกงกะหรี่',NULL,4,2,'main',189,2,2,2,NULL,NULL,_binary ''),(37,'เนื้อตุ๋นอุด้งแกงกะหรี่',NULL,4,2,'main',199,3,1,1,NULL,NULL,_binary ''),(38,'เต้าหู้ทอด',NULL,5,1,'topping',39,1,1,1,NULL,NULL,_binary ''),(39,'ชิกุวะ',NULL,5,1,'topping',39,1,1,2,NULL,NULL,_binary ''),(40,'หมูชาชูถ่าน',NULL,5,1,'topping',79,1,2,1,NULL,NULL,_binary ''),(41,'ไก่เทมปุระ',NULL,5,1,'topping',69,1,2,2,NULL,NULL,_binary ''),(42,'ไก่ย่างพริกดำ',NULL,5,1,'topping',69,2,1,1,NULL,NULL,_binary ''),(43,'กุ้งเทมปุระ(3)',NULL,5,1,'topping',119,2,1,2,NULL,NULL,_binary ''),(44,'เนื้อผัด',NULL,5,1,'topping',89,2,2,1,NULL,NULL,_binary ''),(45,'เนื้อตุ๋น',NULL,5,1,'topping',99,2,2,2,NULL,NULL,_binary ''),(46,'ผักเทมปุระ',NULL,5,1,'topping',69,3,1,1,NULL,NULL,_binary ''),(47,'หัวหอมทอด',NULL,5,1,'topping',49,3,1,2,NULL,NULL,_binary ''),(48,'ไข่ต้มเทมปุระ',NULL,5,1,'topping',20,3,2,1,NULL,NULL,_binary ''),(49,'ข้าวญี่ปุ่น',NULL,5,1,'topping',30,3,2,2,NULL,NULL,_binary ''),(50,'เมนมะหน่อไม้',NULL,5,1,'topping',49,4,1,1,NULL,NULL,_binary ''),(51,'ซุปโชยุปลาแห้ง',NULL,5,1,'topping',49,4,1,2,NULL,NULL,_binary ''),(52,'น้ำเปล่า',NULL,6,1,'beverage',15,1,1,1,NULL,NULL,_binary ''),(53,'โค๊ก',NULL,6,1,'beverage',30,1,1,2,NULL,NULL,_binary ''),(54,'โค๊กซีโร่',NULL,6,1,'beverage',30,1,2,1,NULL,NULL,_binary '');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_info`
--

DROP TABLE IF EXISTS `table_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_info` (
  `table_info_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `order_info_id` int DEFAULT NULL,
  PRIMARY KEY (`table_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_info`
--

LOCK TABLES `table_info` WRITE;
/*!40000 ALTER TABLE `table_info` DISABLE KEYS */;
INSERT INTO `table_info` VALUES (1,'1','COOK',0),(2,'2','FREE',0),(3,'3','COOK',0),(4,'4','FREE',0),(5,'5','FREE',0);
/*!40000 ALTER TABLE `table_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-27 22:47:24
