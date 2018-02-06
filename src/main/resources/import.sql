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

USE `uam`;

-- Dumping data for table uam.role: 2 rows
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES (1, 'ROLE_ADMIN'),	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping data for table uam.user: 2 rows
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `created_on`, `last_modified_on`, `deleted`, `email`, `first_name`, `last_name`, `password`, `status`, `created_by`, `last_modified_by`, `role_id`) VALUES (1, '2018-02-02 13:27:15', '2018-02-02 13:27:16', b'0', 'admin@admin.com', 'admin', 'lastname', '123456', 1, NULL, NULL, 1), (2, '2018-02-02 13:28:12', '2018-02-02 13:28:14', b'0', 'user@user.com', 'user', 'lastname', '123456', 1, NULL, NULL, 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table uam.book: 1 rows
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `created_on`, `last_modified_on`, `author`, `title`, `created_by`, `last_modified_by`) VALUES (1, '2018-02-03 00:20:57', NULL, 'Rachit', 'test', 1, NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
