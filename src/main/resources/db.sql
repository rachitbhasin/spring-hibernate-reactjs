-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for uam
DROP DATABASE IF EXISTS `uam`;
CREATE DATABASE IF NOT EXISTS `uam` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `uam`;

-- Dumping structure for table uam.book
DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime DEFAULT NULL,
  `last_modified_on` datetime DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkjuhf186v8xfqqig9k2hsol5r` (`created_by`),
  KEY `FKrnsfwynoxerx5sx66acqm0nq7` (`last_modified_by`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table uam.book: 1 rows
DELETE FROM `book`;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `created_on`, `last_modified_on`, `author`, `title`, `created_by`, `last_modified_by`) VALUES
	(1, '2018-02-03 00:20:57', NULL, 'Rachit', 'test', 1, NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping structure for table uam.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table uam.role: 2 rows
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table uam.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime DEFAULT NULL,
  `last_modified_on` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FKdltbr5t0nljpuuo4isxgslt82` (`created_by`),
  KEY `FKhatngr6juyosue20sjqnhe4ed` (`last_modified_by`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table uam.user: 2 rows
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `created_on`, `last_modified_on`, `deleted`, `email`, `first_name`, `last_name`, `password`, `status`, `created_by`, `last_modified_by`, `role_id`) VALUES
	(1, '2018-02-02 13:27:15', '2018-02-02 13:27:16', b'0', 'admin@admin.com', 'admin', 'lastname', '123456', 1, NULL, NULL, 1),
	(2, '2018-02-02 13:28:12', '2018-02-02 13:28:14', b'0', 'user@user.com', 'user', 'lastname', '123456', 1, NULL, NULL, 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
