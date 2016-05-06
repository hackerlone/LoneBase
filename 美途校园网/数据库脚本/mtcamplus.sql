-- MySQL dump 10.13  Distrib 5.6.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mtcampus
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL DEFAULT '1',
  `a_name` varchar(20) DEFAULT NULL,
  `a_pwd` varchar(32) DEFAULT NULL,
  `a_emalil` varchar(20) DEFAULT NULL,
  `a_phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','21232F297A57A5A743894A0E4A801FC3','ew@163.com','13623453465'),(6,'老大','21232F297A57A5A743894A0E4A801FC3',NULL,'15855555555'),(7,'坑货','21232F297A57A5A743894A0E4A801FC3',NULL,'13977687678'),(8,'阿斯顿','21232F297A57A5A743894A0E4A801FC3',NULL,'18875676564');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enterprise`
--

DROP TABLE IF EXISTS `enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enterprise` (
  `q_id` int(11) NOT NULL,
  `q_name` varchar(20) DEFAULT NULL,
  `q_pwd` varchar(32) DEFAULT NULL,
  `q_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `q_xingzhi` varchar(10) DEFAULT NULL,
  `q_guimo` varchar(10) DEFAULT NULL,
  `q_area` varchar(20) DEFAULT NULL,
  `q_youbian` varchar(11) DEFAULT NULL,
  `q_email` varchar(20) DEFAULT NULL,
  `q_phone` varchar(11) DEFAULT NULL,
  `q_miaoshu` text,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise`
--

LOCK TABLES `enterprise` WRITE;
/*!40000 ALTER TABLE `enterprise` DISABLE KEYS */;
INSERT INTO `enterprise` VALUES (1,'阿斯法','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','合资','30','重庆','400014','123@16333.com','123456','世界50强'),(2,'东风店','21232F297A57A5A743894A0E4A801FC3','2015-10-27 16:00:00','合资','21','四川','401121','456@163.com','654321','世界500强'),(3,'稻飞虱','21232F297A57A5A743894A0E4A801FC3','2015-10-28 16:00:00','外资','50','成都','412201','789@163.com','147852','啊啊啊啊啊啊'),(4,'阿萨德1','21232F297A57A5A743894A0E4A801FC3','2015-11-02 16:00:00','外资','200','渝北','500012','147@163.com','852369','啦啦啦啦啦啦啦'),(5,'热武器','21232F297A57A5A743894A0E4A801FC3','2015-11-02 06:22:09','国企','400','郫县','854785','258@163.com','569842','急急急急急急'),(6,'存钱罐','21232F297A57A5A743894A0E4A801FC3','2015-11-18 16:00:00','国企','500','澳门','523698','369@163.com','1426387','呵呵呵呵'),(7,'魔法','21232F297A57A5A743894A0E4A801FC3','2015-11-18 16:00:00','民营','5000','香港','99999','wrq@163.com','15876767877','哈哈哈哈哈哈'),(8,'黑手党','21232F297A57A5A743894A0E4A801FC3','2015-11-27 16:00:00','民营','6000','美国','3423424','hsd@11.com','5766666','嘎嘎嘎嘎阿哥'),(9,'长毛','21232F297A57A5A743894A0E4A801FC3','2015-12-09 16:00:00','上市','10005','长白山','252','349865@15','1458752','秘党'),(10,'本周','21232F297A57A5A743894A0E4A801FC3','1970-01-25 16:00:00','上市','19000','地中海','888','888','8888','搓搓粗凑粗凑'),(11,'强娃','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','合资','43','达拉然','34234','23@16333.','124554','阿斯顿发生'),(12,'黄河','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','外资','500','幽暗城','34234','23@16333.','124554','阿斯顿发生'),(13,'东流去','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','外资','1000','暴风城','34234','23@16333.','124554','阿斯顿发生'),(14,'朝露昙花','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','政府机关','2000','酒馆','34234','23@16333.','124554','阿斯顿发生'),(15,'咫尺天涯','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','国企','800','迪拜','34234','23@16333.','124554','阿斯顿发生'),(17,'任道师','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','上市公司','250','西海岸','34234','23@16333.','124554','阿斯顿发生'),(18,'十曲','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','创业公司','300','暗黑城','34234','23@16333.','124554','阿斯顿发生'),(19,'八千年','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','政府机关','356','天空之城','34234','23@16333.','124554','阿斯顿发生'),(20,'御老','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','事业单位','765','雷霆崖','34234','23@16333.','124554','阿斯顿发生'),(21,'一夜','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','非营利机构','900','纳格兰','34234','23@16333.','124554','阿斯顿发生'),(22,'问苍天','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','非营利机构','10','影月谷','34234','23@16333.','124554','阿斯顿发生'),(23,'此生','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','非营利机构','450','奥格瑞玛','34234','23@16333.','124554','阿斯顿发生'),(24,'风吹出','21232F297A57A5A743894A0E4A801FC3','2010-09-30 16:00:00','非营利机构','80','丧钟镇','34234','23@16333.','124554','阿斯顿发生'),(25,'落英','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','非营利机构','52','奥的灰烬','34234','23@16333.','124554','阿斯顿发生'),(26,'听谁细数','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','事业单位','9000','四方阁','34234','23@16333.','124554','阿斯顿发生'),(27,'御风弄影','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','合资','10000','时间塔','34234','23@16333.','124554','阿斯顿发生'),(28,'谁人','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','事业单位','600','世界树','34234','23@16333.','124554','阿斯顿发生'),(29,'与共','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','合资','500','蠕动之城','34234','23@16333.','124554','阿斯顿发生'),(30,'阿尔萨斯','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','事业单位','4360','比尔马特','34234','23@16333.','124554','阿斯顿发生'),(31,'冰霜巨龙','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','合资','4200','格林之森','34234','23@16333.','124554','阿斯顿发生'),(32,'德拉诺','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','创业公司','1300','虚祖','34234','23@16333.','124554','阿斯顿发生'),(33,'古尔丹','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','上市公司','43','天界','34234','23@16333.','124554','阿斯顿发生'),(34,'帕萨丽丽','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','创业公司','950','曙光','34234','23@16333.','124554','阿斯顿发生'),(35,'格雷','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','政府机关','700','大漩涡','34234','23@16333.','124554','阿斯顿发生'),(36,'艾露莎','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','创业公司','43','外域','34234','23@16333.','124554','阿斯顿发生'),(37,'温蒂','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','国企','8500','潘达利安','34234','23@16333.','124554','阿斯顿发生'),(38,'洛丹伦','21232F297A57A5A743894A0E4A801FC3','2015-09-30 16:00:00','民营公司','99999','艾泽拉斯','34234','23@16333.','124554','阿斯顿发生');
/*!40000 ALTER TABLE `enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `z_id` int(11) NOT NULL,
  `q_id` int(11) DEFAULT NULL,
  `z_name` varchar(20) DEFAULT NULL,
  `z_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `z_area` varchar(20) DEFAULT NULL,
  `z_renshu` varchar(6) DEFAULT NULL,
  `z_zhineng` varchar(10) DEFAULT NULL,
  `z_miaoshu` text,
  `z_xinzi` varchar(10) DEFAULT NULL,
  `z_xl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`z_id`),
  KEY `FK_fabu` (`q_id`),
  CONSTRAINT `FK_fabu` FOREIGN KEY (`q_id`) REFERENCES `enterprise` (`q_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (6,4,'c++','2020-11-11 16:00:00','重庆','3','c+=','会c++','6000','大专'),(7,2,'运营师','2010-11-11 16:00:00','重庆','6','会安装','会windos','6000','本科'),(8,2,'游戏测试人员','2015-11-12 15:53:19','武汉','9','1615','161561','500','初中及以下'),(9,2,'JAVA初级工程师','2015-11-13 02:27:38','上海','11','ww','aa','300','初中及以下'),(11,4,'厨师','2015-09-13 02:32:01','广州','6','会炒菜','会炒菜','3000','初中及以下'),(12,3,'JAVA攻城狮','2015-11-13 02:35:52','广安','9','会切菜','切槽','3000','初中及以下'),(13,5,'程序员鼓励师','2015-11-13 02:36:51','深圳','10','贴心','会鼓励人','4000','初中及以下'),(14,6,'JAVA程序员','2015-11-12 16:00:00','西安','1','会','JAVA','7000','大专'),(15,2,'JAVA初级工程师','2015-11-13 03:17:50','上海','3','会JAVA编程','1212','12000','大专'),(16,12,'c#工程师','2013-11-12 16:00:00','天津','3','C#编程','C#','10000','中专'),(17,13,'技术总监','2015-11-14 16:32:59','南京','1','管理过团队','5656','30000','大专'),(18,19,'JAVA攻城狮','2015-11-14 16:32:51','上海','3','熟悉','265','30000','大专'),(19,23,'客服经理','2015-11-14 16:33:05','重庆','4','熟悉业务','联系客户','5000','大专'),(20,23,'销售','2015-11-15 11:03:53','重庆','9','打牌','111','5000','大专'),(22,23,'销售','2015-11-15 11:03:52','重庆','4','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(23,13,'JAVA高级工程师','2015-11-15 11:03:49','成都','2','勤奋有上进心','111','5000','大专及以上'),(25,17,'医生','2015-11-15 11:03:47','北京','1','勤奋有上进心','勤奋有上进心','5000','本科及以上'),(26,18,'司机','2015-11-15 11:03:57','深圳','1','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(27,18,'主持人','2015-11-15 11:03:59','广州','1','勤奋有上进心','勤奋有上进心','5000','初中及以下'),(28,19,'JAVA攻城狮','2015-11-15 11:04:01','广安','5','勤奋','勤奋','5000','初中及以下'),(37,23,'网管','2015-11-15 11:06:18','杭州','3','有责任心做事踏实细心','有责任心做事踏实细心','5000','大专及以上'),(38,30,'JAVA工程师','2015-11-15 11:01:27','南京','4','有责任心做事踏实细心','有责任心做事踏实细心','5000','大专及以上'),(39,12,'C#工程师','2015-11-15 11:06:59','南京','4','任心做事踏实细心','实细心','5000','大专及以上'),(40,12,'JAVA架构师','2015-11-15 11:07:43','南京','1','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(41,11,'销售','2015-11-15 11:07:46','成都','6','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(42,10,'JAVA攻城狮','2015-11-15 11:07:48','万州','3','勤奋有上进心','111勤奋有上进心','5000','大专及以上'),(43,12,'技术支持','2015-11-15 11:07:49','合肥','4','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(44,11,'销售','2015-11-15 11:07:50','武汉','8','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(45,8,'会计','2015-11-15 11:08:00','武汉','4','勤奋有上进心','勤奋有上进心','5000','大专及以上'),(46,8,'JAVA攻城狮','2015-11-15 11:08:01','武汉','8','勤奋有上进心','愿意同企业共同发展','5000','初中及以下'),(47,7,'司机','2015-11-15 11:08:02','长沙','3','勤奋有上进心','愿意同企业共同发展','5000','初中及以下'),(48,7,'JAVA攻城狮','2015-11-15 11:08:03','长沙','7','打牌勤奋有上进心','愿意同企业共同发展','5000','初中及以下'),(49,7,'主持人','2015-11-15 11:08:04','深圳','4','勤奋有上进心','愿意同企业共同发展','5000','大专及以上'),(50,6,'JAVA攻城狮','2015-11-15 11:08:10','石家庄','2','勤奋有上进心','愿意同企业共同发展','5000','初中及以下'),(51,6,'主持人','2015-11-15 11:08:20','太原','9','勤奋有上进心','愿意同企业共同发展','5000','初中及以下'),(52,2,'JAVA攻城狮','2015-11-10 16:00:00','hgg','12','fgfh','vh',NULL,NULL),(53,4,'司机','2015-11-14 16:00:00','北京','6','有信心','努力','3000','本科'),(54,4,'JAVA攻城狮','2015-11-14 16:00:00','北京','6','有信心','努力','3000','本科'),(55,4,'司机','2015-11-14 16:00:00','北京','6','有信心','努力','3000','本科'),(56,4,'JAVA攻城狮','2015-11-14 16:00:00','北京','6','有信心','努力','3000','本科'),(57,4,'司机','2015-11-14 16:00:00','北京','6','有信心','努力','3000','本科');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jz`
--

DROP TABLE IF EXISTS `jz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jz` (
  `z_id` int(11) NOT NULL,
  `j_id` int(11) NOT NULL,
  `t_date` date DEFAULT NULL,
  `k_date` date DEFAULT NULL,
  `jz_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`jz_id`),
  KEY `FK_jz` (`z_id`),
  KEY `FK_jz2` (`j_id`),
  CONSTRAINT `FK_jz` FOREIGN KEY (`z_id`) REFERENCES `job` (`z_id`),
  CONSTRAINT `FK_jz2` FOREIGN KEY (`j_id`) REFERENCES `vita` (`j_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jz`
--

LOCK TABLES `jz` WRITE;
/*!40000 ALTER TABLE `jz` DISABLE KEYS */;
/*!40000 ALTER TABLE `jz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `m_id` int(11) NOT NULL,
  `a_id` int(11) DEFAULT NULL,
  `j_id` int(11) DEFAULT NULL,
  `m_url` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FK_add` (`a_id`),
  KEY `FK_xuanze` (`j_id`),
  CONSTRAINT `FK_add` FOREIGN KEY (`a_id`) REFERENCES `admin` (`a_id`),
  CONSTRAINT `FK_xuanze` FOREIGN KEY (`j_id`) REFERENCES `vita` (`j_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!50001 DROP VIEW IF EXISTS `stu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `stu` AS SELECT 
 1 AS `u_id`,
 1 AS `u_name`,
 1 AS `u_pwd`,
 1 AS `u_sex`,
 1 AS `u_email`,
 1 AS `u_phone`,
 1 AS `u_touxiang`,
 1 AS `u_birthday`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(20) DEFAULT NULL,
  `u_pwd` varchar(32) DEFAULT NULL,
  `u_sex` varchar(4) DEFAULT NULL,
  `u_email` varchar(20) DEFAULT NULL,
  `u_phone` varchar(11) DEFAULT NULL,
  `u_touxiang` varchar(200) DEFAULT NULL,
  `u_birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'张三','21232F297A57A5A743894A0E4A801FC3','1','1113@11.cnm','123456789','2015-12-04-02-27-28.jpg','1992-08-17 16:00:00'),(2,'李四','21232F297A57A5A743894A0E4A801FC3','0','222@22.cn','123456789','1.jpg','1993-11-02 16:00:00'),(3,'王二','21232F297A57A5A743894A0E4A801FC3','1','111@111','79416','1.jpg','1995-11-02 16:00:00'),(4,'赵六','21232F297A57A5A743894A0E4A801FC3','0','111@111','1641616','1.jpg','1998-11-02 16:00:00'),(5,'陈七','21232F297A57A5A743894A0E4A801FC3','1','111@111','191616','1.jpg','1995-11-02 16:00:00'),(6,'孙八','21232F297A57A5A743894A0E4A801FC3','0','111@111','54161','1.jpg','2000-11-02 16:00:00'),(7,'竹文','21232F297A57A5A743894A0E4A801FC3','0','1111@1111','541611','1.jpg','1994-11-02 16:00:00'),(8,'嘻哈','21232F297A57A5A743894A0E4A801FC3','1','46161@446','456456','1.jpg','2000-11-02 16:00:00'),(9,'测试','21232F297A57A5A743894A0E4A801FC3','1','22@222','5161','1.jpg','2015-11-22 16:00:00'),(10,'666','21232F297A57A5A743894A0E4A801FC3','0','66666','66666','1.jpg','2015-11-24 16:00:00'),(11,'王二','21232F297A57A5A743894A0E4A801FC3','0','72405347@qq.com','110200','1.jpg','2015-11-24 16:00:00'),(12,'656','21232F297A57A5A743894A0E4A801FC3','0','2326@232','232656','1.jpg','2015-11-30 16:00:00'),(13,'ghh','21232F297A57A5A743894A0E4A801FC3','1','qwewe','23344444',NULL,'2015-11-02 16:00:00');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_no` char(6) NOT NULL,
  `user_pwd` char(6) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `pid` varchar(10) DEFAULT NULL,
  `cid` varchar(10) DEFAULT NULL,
  `aid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','123','summer',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vita`
--

DROP TABLE IF EXISTS `vita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vita` (
  `j_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `j_face` varchar(20) DEFAULT NULL,
  `j_dizhi` varchar(20) DEFAULT NULL,
  `j_byxx` varchar(20) DEFAULT NULL,
  `j_zy` varchar(20) DEFAULT NULL,
  `j_gzjl` varchar(50) DEFAULT NULL,
  `j_xl` varchar(6) DEFAULT NULL,
  `j_jianjie` text,
  PRIMARY KEY (`j_id`),
  KEY `FK_createing` (`u_id`),
  CONSTRAINT `FK_createing` FOREIGN KEY (`u_id`) REFERENCES `student` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vita`
--

LOCK TABLES `vita` WRITE;
/*!40000 ALTER TABLE `vita` DISABLE KEYS */;
INSERT INTO `vita` VALUES (1,1,NULL,'成都 ','机电校 ','计算机','8年 ','大专','6666666 '),(4,5,'共青团员','郫县','千星','数学','3年','专科','嘿嘿嘿嘿');
/*!40000 ALTER TABLE `vita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `stu`
--

/*!50001 DROP VIEW IF EXISTS `stu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `stu` AS (select `student`.`u_id` AS `u_id`,`student`.`u_name` AS `u_name`,`student`.`u_pwd` AS `u_pwd`,`student`.`u_sex` AS `u_sex`,`student`.`u_email` AS `u_email`,`student`.`u_phone` AS `u_phone`,`student`.`u_touxiang` AS `u_touxiang`,((year(curdate()) - year(`student`.`u_birthday`)) + (date_format(`student`.`u_birthday`,'%m%d') <= date_format(curdate(),'%m%d'))) AS `u_birthday` from `student`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-04 21:59:04
