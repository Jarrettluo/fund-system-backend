-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: fund_system
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `fund_system`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `fund_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `fund_system`;

--
-- Table structure for table `chinamutualfunddescription`
--

DROP TABLE IF EXISTS `chinamutualfunddescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chinamutualfunddescription` (
  `object_id` int(11) NOT NULL,
  `f_info_fullname` varchar(100) DEFAULT NULL,
  `f_info_front_code` varchar(45) DEFAULT NULL,
  `f_info_backend_code` varchar(45) DEFAULT NULL,
  `f_info_setupdate` datetime DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chinamutualfunddescription`
--

LOCK TABLES `chinamutualfunddescription` WRITE;
/*!40000 ALTER TABLE `chinamutualfunddescription` DISABLE KEYS */;
/*!40000 ALTER TABLE `chinamutualfunddescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chinamutualfundmanager`
--

DROP TABLE IF EXISTS `chinamutualfundmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chinamutualfundmanager` (
  `object_id` varchar(100) NOT NULL,
  `f_info_windcode` varchar(45) DEFAULT NULL,
  `f_info_fundmanager` varchar(45) DEFAULT NULL,
  `f_info_manager_gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chinamutualfundmanager`
--

LOCK TABLES `chinamutualfundmanager` WRITE;
/*!40000 ALTER TABLE `chinamutualfundmanager` DISABLE KEYS */;
/*!40000 ALTER TABLE `chinamutualfundmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chinamutualfundnav`
--

DROP TABLE IF EXISTS `chinamutualfundnav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chinamutualfundnav` (
  `object_id` varchar(100) NOT NULL,
  `f_info_windcode` varchar(45) DEFAULT NULL COMMENT 'Wind代码',
  `ann_date` date DEFAULT NULL COMMENT '公告日期',
  `price_date` date DEFAULT NULL COMMENT '截至日期',
  `f_nav_unit` float DEFAULT NULL COMMENT '单位净值\n',
  `f_nav_accumulated` float DEFAULT NULL COMMENT '累计净值',
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chinamutualfundnav`
--

LOCK TABLES `chinamutualfundnav` WRITE;
/*!40000 ALTER TABLE `chinamutualfundnav` DISABLE KEYS */;
/*!40000 ALTER TABLE `chinamutualfundnav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funduser`
--

DROP TABLE IF EXISTS `funduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funduser` (
  `user_id` varchar(10) NOT NULL COMMENT '用户编号',
  `user_name` varchar(10) DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(45) DEFAULT NULL COMMENT '加密后的用户密码',
  `user_telephone` varchar(11) DEFAULT NULL COMMENT '用户手机号码',
  `user_register_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',
  `user_state` varchar(1) DEFAULT '0' COMMENT '用户状态0正常 1冻结',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funduser`
--

LOCK TABLES `funduser` WRITE;
/*!40000 ALTER TABLE `funduser` DISABLE KEYS */;
/*!40000 ALTER TABLE `funduser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myfund`
--

DROP TABLE IF EXISTS `myfund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `myfund` (
  `id` varchar(10) NOT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `fund_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myfund`
--

LOCK TABLES `myfund` WRITE;
/*!40000 ALTER TABLE `myfund` DISABLE KEYS */;
/*!40000 ALTER TABLE `myfund` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-09 12:00:19
