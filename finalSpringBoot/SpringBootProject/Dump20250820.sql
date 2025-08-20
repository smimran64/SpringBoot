-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelbookingsystem
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpiovo1hsx7hi5f9ax85epqya9` (`user_id`),
  CONSTRAINT `FKgc8dtql9mkq268detxiox7fpm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenities`
--

DROP TABLE IF EXISTS `amenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `air_conditioning` bit(1) NOT NULL,
  `airport_suttle` bit(1) NOT NULL,
  `break_fast` bit(1) NOT NULL,
  `free_parking` bit(1) NOT NULL,
  `free_wifi` bit(1) NOT NULL,
  `gym` bit(1) NOT NULL,
  `health_services` bit(1) NOT NULL,
  `laundry_service` bit(1) NOT NULL,
  `play_ground` bit(1) NOT NULL,
  `restaurant` bit(1) NOT NULL,
  `room_service` bit(1) NOT NULL,
  `swimming_pool` bit(1) NOT NULL,
  `wheelchair_accessible` bit(1) NOT NULL,
  `hotel_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKtb8vbts0tbu3wedo4d9hb9rjm` (`hotel_id`),
  CONSTRAINT `FK23ayav9or91wbe85x0v9svxv1` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenities`
--

LOCK TABLES `amenities` WRITE;
/*!40000 ALTER TABLE `amenities` DISABLE KEYS */;
/*!40000 ALTER TABLE `amenities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `advance_amount` double NOT NULL,
  `check_in` varchar(255) DEFAULT NULL,
  `check_out` varchar(255) DEFAULT NULL,
  `contract_person_name` varchar(255) DEFAULT NULL,
  `due_amount` double NOT NULL,
  `number_of_rooms` int NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `customer_id` bigint NOT NULL,
  `hotel_id` bigint NOT NULL,
  `room_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbvfibgflhsb0g2hnjauiv5khs` (`customer_id`),
  KEY `FK7y09f5lun38jnooaw2hch0ke9` (`hotel_id`),
  KEY `FKrgoycol97o21kpjodw1qox4nc` (`room_id`),
  CONSTRAINT `FK7y09f5lun38jnooaw2hch0ke9` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`),
  CONSTRAINT `FKbvfibgflhsb0g2hnjauiv5khs` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKrgoycol97o21kpjodw1qox4nc` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKrfbvkrffamfql7cjmen8v976v` (`email`),
  UNIQUE KEY `UKeuat1oase6eqv195jvb71a93s` (`user_id`),
  CONSTRAINT `FKrh1g1a20omjmn6kurd35o3eit` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_admin`
--

DROP TABLE IF EXISTS `hotel_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKidx11d5bvbtj7odnpg30c6nms` (`email`),
  UNIQUE KEY `UKemunrxx7vpw58hatvb083ncxi` (`user_id`),
  CONSTRAINT `FKb4nb9l1jn4s1bgdsfvd7t0kep` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_admin`
--

LOCK TABLES `hotel_admin` WRITE;
/*!40000 ALTER TABLE `hotel_admin` DISABLE KEYS */;
INSERT INTO `hotel_admin` VALUES (1,'Azimpur','2025-09-01','mdtusherimran049@gmail.com','MALE','Md_Imran_Mia_463d39ae-c845-4a71-9d4e-7aab6c508cbf','Md Imran Mia','01571407696',1),(2,'Muladi','2025-08-07','abdurrahimkhan214dc@gmail.com','MALE','Md_Rahim_Khan_82802eed-8974-49b2-9001-47733a1b9ad4','Md Rahim Khan','56446546',2);
/*!40000 ALTER TABLE `hotel_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_info`
--

DROP TABLE IF EXISTS `hotel_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_info` (
  `id` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `hotel_policy` varchar(1000) DEFAULT NULL,
  `owner_info` varchar(255) NOT NULL,
  `hotel_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3f1y9bk7a9x2klxs5junnob6q` (`hotel_id`),
  CONSTRAINT `FKrglor4gfjlhfgifqima9qfrts` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotels` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `hotel_admin_id` int DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK10ymd8rb9c8wicjrq3t48i45c` (`hotel_admin_id`),
  KEY `FKqs8u4n6x2f5anae9lllt3857p` (`location_id`),
  CONSTRAINT `FK10ymd8rb9c8wicjrq3t48i45c` FOREIGN KEY (`hotel_admin_id`) REFERENCES `hotel_admin` (`id`),
  CONSTRAINT `FKqs8u4n6x2f5anae9lllt3857p` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` VALUES (1,'Marine Drive, Road, Cox\'s Bazar 4700','1755684770411_Syman beach Resort.jpg','Sayman Beach Resort','4.5',1,1),(2,'Malipara - Digirchala Rd','1755684994613_Sara Resort.jpg','Sara Resort','4.5',1,2),(3,'Rangamati','1755685181341_hilltaj-resort.jpg','The Grand Hill Taj','4.5',1,3);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Cox\'s Bazar_ba818f67-b7c2-4e7c-8b66-37936ec14bac','Cox\'s Bazar'),(2,'Gazipur_f24eedd5-3741-46ab-9416-dbcf8ff7f4c0','Gazipur'),(3,'Rangamati_4e32a71b-eaf7-498d-8700-b88e83a0bcfd','Rangamati'),(4,'Sylhet_0fcf9352-34fb-4ab8-8726-4be922362488','Sylhet');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adults` int NOT NULL,
  `available_rooms` int NOT NULL,
  `booked_rooms` int NOT NULL,
  `children` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `total_rooms` int NOT NULL,
  `hotel_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5lufxy0ghq53ugm93hdc941k` (`hotel_id`),
  CONSTRAINT `FKp5lufxy0ghq53ugm93hdc941k` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,2,10,0,2,'Deluxe_cc856b40-0f29-4b95-b0ce-01ba464cb788',12000,'Deluxe',10,1),(2,2,10,0,2,'Premium _42cb605a-fa0b-44de-af6f-381a50db87f2',15000,'Premium ',10,1),(3,2,10,0,2,'King Size Bed_cb79c1d6-e73a-4534-a1e6-dbdb1c6a02d4',18000,'King Size Bed',10,1),(4,2,10,0,1,'Deluxe_a7baebda-694a-4433-b115-b242ccb384aa',10000,'Deluxe',10,2);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_log_out` bit(1) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`),
  CONSTRAINT `FK2dylsfo39lgjyqml2tbe0b0ss` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES (1,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZHR1c2hlcmltcmFuMDQ5QGdtYWlsLmNvbSIsInJvbGUiOiJIT1RFTF9BRE1JTiIsImlhdCI6MTc1NTY4NDExMCwiZXhwIjoxNzU1NzcwNTEwfQ.un6Lq3ZJGobLZ42mFr-JIY2WfbI9DQ5CNk3gPbkQh5s',1),(2,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZHR1c2hlcmltcmFuMDQ5QGdtYWlsLmNvbSIsInJvbGUiOiJIT1RFTF9BRE1JTiIsImlhdCI6MTc1NTY4NDE3OCwiZXhwIjoxNzU1NzcwNTc4fQ.4b_Vf4AEwEY3pz3Z_qJBn3aBGXnInuyJUO60cJVObzU',1),(3,_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmR1cnJhaGlta2hhbjIxNGRjQGdtYWlsLmNvbSIsInJvbGUiOiJIT1RFTF9BRE1JTiIsImlhdCI6MTc1NTY5NDcxMiwiZXhwIjoxNzU1NzgxMTEyfQ.jmtmOcJgHu_rv5r4nGms-5g8AV_oxSFwiR1Im19sZMo',2),(4,_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmR1cnJhaGlta2hhbjIxNGRjQGdtYWlsLmNvbSIsInJvbGUiOiJIT1RFTF9BRE1JTiIsImlhdCI6MTc1NTY5NDg0OSwiZXhwIjoxNzU1NzgxMjQ5fQ.btm5RjigDX6NY7QLLuqwTggpX1h3LfH31FyBiMqVBrE',2);
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_lock` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','CUSTOMER','HOTEL_ADMIN') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','mdtusherimran049@gmail.com','Md Imran Mia_45c68f64-7dad-41b4-a894-e51d3f0e96cc',_binary '\0','Md Imran Mia','$2a$10$VXeeA3etfkfdz3ZaOQ46rOHUhxFuneAbqVlHShEs77zVvfUl3eoIy','01571407696','HOTEL_ADMIN'),(2,_binary '','abdurrahimkhan214dc@gmail.com','Md Rahim Khan_0e498690-73f4-4ba8-9205-032eb7d7de5e',_binary '\0','Md Rahim Khan','$2a$10$RGyE0EpeWNyATczCoFaBcuWV4VA4E4Fjpn/OfilZHyEQBEUDQMQI2','56446546','HOTEL_ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-20 19:09:19
