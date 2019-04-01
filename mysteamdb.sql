-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mysteamdb
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `close_friends`
--
use mysteamdb;
DROP TABLE IF EXISTS `close_friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `close_friends` (
  `user_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follower_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `close_friends`
--

LOCK TABLES `close_friends` WRITE;
/*!40000 ALTER TABLE `close_friends` DISABLE KEYS */;
INSERT INTO `close_friends` VALUES (21,0),(21,29);
/*!40000 ALTER TABLE `close_friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_orders`
--

DROP TABLE IF EXISTS `game_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_orders` (
  `owner_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `state` smallint(6) NOT NULL DEFAULT '0',
  `order_id` varchar(45) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `cur_version` varchar(20) DEFAULT NULL,
  `buy_date` date DEFAULT NULL,
  `cost` double DEFAULT '0',
  PRIMARY KEY (`owner_id`,`game_id`),
  KEY `game_orders_games_game_id_fk` (`game_id`),
  CONSTRAINT `game_orders_games_game_id_fk` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`),
  CONSTRAINT `game_orders_users_user_id_fk` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_orders`
--

LOCK TABLES `game_orders` WRITE;
/*!40000 ALTER TABLE `game_orders` DISABLE KEYS */;
INSERT INTO `game_orders` VALUES (21,28,1,NULL,21,'v1.0','2018-01-20',199.99),(21,29,0,NULL,21,'v1.0','2018-01-20',59.99),(21,31,640,NULL,21,'v3.0','2018-01-25',49.99),(29,31,256,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `game_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(45) NOT NULL,
  `developer` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `version` varchar(20) NOT NULL,
  `state` smallint(5) unsigned NOT NULL DEFAULT '3',
  `on_sale_date` date NOT NULL,
  `introduction` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  KEY `games_users_user_id_fk` (`developer`),
  CONSTRAINT `games_users_user_id_fk` FOREIGN KEY (`developer`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='游戏商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (27,'刺客信条',22,'动作',156,'v3.0',1,'2018-01-20','刺客信条:就是超级厉害的刺客，是兄弟就一起来玩！'),(28,'尼尔次元',22,'动作',199.99,'v1.0',1,'2018-01-20','我的次元，来吧！'),(29,'圣骑士',23,'动作',59.99,'v1.0',0,'2018-01-20','sdasda\r\n'),(30,'121',23,'动作',12,'v1.0',5,'2018-01-20','555555'),(31,'勇者斗恶龙',30,'动作',49.99,'v3.0',5,'2018-01-25','这是恶龙王和美丽勇者的生死战场');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games_on_applying`
--

DROP TABLE IF EXISTS `games_on_applying`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games_on_applying` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(45) NOT NULL,
  `developer` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `price` double DEFAULT '0',
  `version` varchar(20) DEFAULT NULL,
  `state` smallint(5) unsigned NOT NULL DEFAULT '0',
  `introduction` varchar(400) DEFAULT NULL,
  `origin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `games_on_applying_users_user_id_fk` (`developer`),
  CONSTRAINT `games_on_applying_users_user_id_fk` FOREIGN KEY (`developer`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_on_applying`
--

LOCK TABLES `games_on_applying` WRITE;
/*!40000 ALTER TABLE `games_on_applying` DISABLE KEYS */;
INSERT INTO `games_on_applying` VALUES (10,'121',23,'动作',12,'v1.0',32,'555555',30),(11,'尼尔次元',23,'动作',156,'v1.2',16,'尼尔次元，真的好玩！',NULL),(15,'勇者斗恶龙',30,'动作',49.99,'v3.1',4,'这是恶龙王和美丽勇者的生死战场',31);
/*!40000 ALTER TABLE `games_on_applying` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `reviewer_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `rev_date` date NOT NULL,
  `content` varchar(280) NOT NULL,
  `score` smallint(6) NOT NULL,
  `version` varchar(20) NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `new_reviews_users_user_id_fk` (`reviewer_id`),
  KEY `new_reviews_games_game_id_fk` (`game_id`),
  CONSTRAINT `new_reviews_games_game_id_fk` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`),
  CONSTRAINT `new_reviews_users_user_id_fk` FOREIGN KEY (`reviewer_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (3,21,27,'2018-01-25','这是个好游戏！',5,'v3.0'),(4,21,31,'2018-01-25','好玩！听得见！',5,'v3.0');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `authority` int(11) NOT NULL DEFAULT '1',
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `balance` double NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `state` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (19,'wisetim','wisetim',0,1,2000,'zjut','wisetim@163.com',NULL),(21,'xhb','xhb',1,1,1638.01,'zjut.com','773854587@qq.com',NULL),(22,'bob','bob',2,0,2000,'zjut','123@bob.com',0),(23,'bob2','bob2',2,1,2000,'zjut','7777@zjut.com',0),(29,'dc','dc',1,1,2000,'zjut','773854587@qq.com',NULL),(30,'kfz','kfz',2,1,2000,'zjut','kfz@qq.com',0);
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

-- Dump completed on 2018-03-12 18:47:49
