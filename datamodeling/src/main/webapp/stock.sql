-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- springdb 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `springdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springdb`;


-- 테이블 springdb의 구조를 덤프합니다. account
CREATE TABLE IF NOT EXISTS `account` (
  `account_number` varchar(200) NOT NULL,
  `user_id` varchar(200) NOT NULL,
  `account_name` varchar(200) DEFAULT NULL,
  `account_deposit` int(50) DEFAULT NULL,
  `agency_name` varchar(200) DEFAULT NULL,
  `agency_user` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`account_number`,`user_id`),
  KEY `FK_account_user` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 springdb의 구조를 덤프합니다. agency
CREATE TABLE IF NOT EXISTS `agency` (
  `agency_code` varchar(200) NOT NULL,
  `agency_name` varchar(200) DEFAULT NULL,
  `agency_user` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`agency_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 springdb의 구조를 덤프합니다. order
CREATE TABLE IF NOT EXISTS `order` (
  `order_day` varchar(200) NOT NULL,
  `order_number` varchar(200) NOT NULL,
  `account_number` varchar(200) DEFAULT NULL,
  `user_id` varchar(200) DEFAULT NULL,
  `order_itemcode` varchar(200) DEFAULT NULL,
  `order_count` int(50) DEFAULT NULL,
  `order_sum` int(50) DEFAULT NULL,
  PRIMARY KEY (`order_day`,`order_number`),
  KEY `account_number` (`account_number`),
  CONSTRAINT `account_number` FOREIGN KEY (`account_number`) REFERENCES `account` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 springdb의 구조를 덤프합니다. user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(200) NOT NULL,
  `user_password` varchar(200) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `user_addr` varchar(200) DEFAULT NULL,
  `user_phone` varchar(200) DEFAULT NULL,
  `agency_code` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `agency_code` (`agency_code`),
  CONSTRAINT `agency_code` FOREIGN KEY (`agency_code`) REFERENCES `agency` (`agency_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
