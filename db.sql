-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: deanery
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(255) DEFAULT NULL,
  `session` varchar(255) DEFAULT NULL,
  `exams` varchar(255) DEFAULT NULL,
  `practice` varchar(255) DEFAULT NULL,
  `internship` varchar(255) DEFAULT NULL,
  `diploma` varchar(255) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Математика','23.12.2023-30.12.2023','28.05.2024','01.12.2023-10.12.2023','03.04.2024-03.05.2024','30.06.2024','Исп20-1'),(2,'Английский язык','14.06.2024-21.06.2024','01.06.2024','11.01.2024-30.01.2024','04.05.2024-29.05.2024','30.06.2024','С19-2'),(3,'Системное программирование','23.12.2023-30.12.2023','25.12.2023','14.02.2024-24.02.2024','11.06.2024-25.06.2024','30.06.2024','Исп20-1'),(4,'Химия','05.04.2024-12.04.2024','22.05.2024','10.12.2023-20.12.2023','15.05.2024-01.06.2024','30.06.2024','С19-2'),(5,'Биология','23.08.2024-30.08.2024','11.06.2024','01.12.2023-10.12.2023','11.04.2024-21.04.2024','30.06.2024','Исп20-1'),(6,'История','14.03.2024-21.03.2024','03.06.2024','20.01.2024-30.01.2024','05.05.2024-25.05.2024','30.06.2024','С19-2'),(7,'Литература','30.06.2024-07.07.2024','01.07.2024','11.02.2024-20.02.2024','15.04.2024-05.05.2024','30.06.2024','Исп20-1'),(8,'География','20.10.2023-27.10.2023','08.06.2024','15.03.2024-25.03.2024','01.05.2024-20.05.2024','30.06.2024','С19-2'),(9,'Экономика','11.05.2024-18.05.2024','10.08.2024','01.10.2023-10.10.2023','05.04.2024-25.04.2024','30.06.2024','Исп20-1'),(10,'Психология','27.12.2023-03.01.2024','16.06.2024','05.09.2024-15.09.2024','20.04.2024-10.05.2024','30.06.2024','С19-2'),(11,'Философия','18.09.2024-25.09.2024','07.06.2024','30.11.2023-10.12.2023','10.05.2024-01.06.2024','30.06.2024','Исп20-1'),(12,'Информатика','12.07.2024-19.07.2024','01.08.2024','08.02.2024-18.02.2024','01.05.2024-20.05.2024','30.06.2024','С19-2'),(13,'Театральное искусство','25.04.2024-02.05.2024','30.06.2024','12.12.2023-20.12.2023','15.05.2024-05.06.2024','30.06.2024','Исп20-1'),(14,'Музыка','19.11.2023-26.11.2023','15.07.2024','01.03.2024-10.03.2024','01.05.2024-20.05.2024','30.06.2024','С19-2'),(15,'Физкультура','30.08.2024-06.09.2024','09.06.2024','11.12.2023-20.12.2023','20.04.2024-10.05.2024','30.06.2024','Исп20-1'),(16,'Политология','16.03.2024-23.03.2024','10.06.2024','10.01.2024-20.01.2024','05.05.2024-25.05.2024','30.06.2024','С19-2'),(17,'Бизнес-анализ','05.01.2024-12.01.2024','29.06.2024','12.02.2024-25.02.2024','01.05.2024-20.05.2024','30.06.2024','Исп20-4'),(18,'Маркетинг','22.06.2024-29.06.2024','01.09.2024','01.11.2023-10.11.2023','05.04.2024-25.04.2024','30.06.2024','С19-2'),(19,'Социология','09.09.2024-16.09.2024','20.06.2024','30.10.2023-10.11.2023','01.05.2024-20.05.2024','30.06.2024','Исп20-1'),(20,'Лингвистика','02.02.2024-09.02.2024','10.07.2024','18.12.2023-25.12.2023','15.05.2024-05.06.2024','30.06.2024','С23-1К'),(21,'Логика','26.10.2023-02.11.2023','15.06.2024','05.01.2024-15.01.2024','20.04.2024-10.05.2024','30.06.2024','Исп20-1');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `birth_year` int DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Александр','Соболь','Витальевич',2003,'Группа С19-2'),(2,'Алеся','Дубицкая','Александровна',2004,'Группа Исп20-1'),(3,'Марина','Губанова','Алексеевна',2004,'Группа Исп20-1'),(4,'Елена','Кузнецова','Дмитриевна',2002,'С19-2'),(5,'Максим','Смирнов','Александрович',2000,'Исп20-1'),(6,'Ольга','Морозова','Алексеевна',1999,'С19-2'),(7,'Дмитрий','Павлов','Андреевич',2005,'ИСП20-1'),(8,'Мария','Васильева','Сергеевна',2002,'С19-1'),(9,'Сергей','Федоров','Владимирович',2000,'Исп20-1'),(10,'Александра','Егорова','Александровна',1999,'С19-2'),(11,'Алексей','Николаев','Сергеевич',2005,'ИСП20-1'),(12,'Татьяна','Петрова','Ивановна',2002,'С19-2'),(13,'Евгений','Семенов','Дмитриевич',2000,'Исп20-1'),(14,'Ангелина','Григорьева','Андреевна',1999,'С19-2'),(15,'Виктор','Алексеев','Владимирович',2001,'СР20-4К'),(16,'Юлия','Андреева','Сергеевна',2004,'С19-2'),(17,'Артем','Степанов','Иванович',2004,'Исп20-1'),(18,'София','Фомина','Петровна',1999,'С19-2'),(19,'Ирина','Максимова','Дмитриевна',2001,'Исп20-1'),(20,'Владимир','Дмитриев','Александрович',2002,'С19-2');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `discipline` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'Полина','Мельникова','Андреевна','Математика'),(2,'Мария','Петрова','Алексеевна','Английский язык'),(3,'Алексей','Вахитов','Андреевич','Системное программирование'),(4,'Иван','Смирнов','Петрович','Химия'),(5,'Екатерина','Кузнецова','Игоревна','Биология'),(6,'Виктория','Соколова','Александровна','История'),(7,'Григорий','Михайлов','Павлович','Литература'),(8,'Елизавета','Новикова','Ильинична','Психология'),(9,'Дмитрий','Андреев','Евгеньевич','География'),(10,'Захар','Семенов','Александрович','Физкультура'),(11,'Ирина','Егорова','Николаевна','Философия'),(12,'Леонид','Козлов','Иванович','Информатика'),(13,'Марина','Федорова','Павловна','Театральное искусство'),(14,'Никита','Сорокин','Игоревич','Музыка'),(15,'Олег','Макаров','Николаевич','Политология'),(16,'Полина','Белова','Владимировна','Бизнес-анализ'),(17,'Роман','Григорьев','Петрович','Маркетинг'),(18,'София','Логинова','Максимовна','Социология'),(19,'Александр','Павлов','Владимирович','Лингвистика'),(20,'Виктория','Соколова','Александровна','Логика');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-07 23:17:00
