-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2017 at 03:04 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bbp`
--
CREATE DATABASE IF NOT EXISTS `bbp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bbp`;

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE IF NOT EXISTS `bus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `licence_plate` varchar(15) NOT NULL,
  `max_passengers` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cb2nwyyqp62gyoq205vm734cf` (`licence_plate`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`id`, `brand`, `licence_plate`, `max_passengers`) VALUES
(1, 'Toyota', 'PH-19-20', 20),
(2, 'Nissan', 'TE-34-32', 40),
(3, 'Test', '12-34-HT', 9),
(4, 'Lexus', 'TR-57-98', 20),
(5, 'Masda', 'RE-45-32', 40),
(6, 'Nissan', 'TK-31-21', 100),
(7, 'Kappa', 'TS-34-12', 20);

-- --------------------------------------------------------

--
-- Table structure for table `bus_route`
--

CREATE TABLE IF NOT EXISTS `bus_route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `estimated_arrival` datetime NOT NULL,
  `estimated_departure` datetime NOT NULL,
  `bus_id` bigint(20) DEFAULT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oyyvtio54r2gh9gbdecbtauxv` (`bus_id`),
  KEY `FK_3jm843rrevogv362sjqx2vl3w` (`route_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `bus_route`
--

INSERT INTO `bus_route` (`id`, `name`, `estimated_arrival`, `estimated_departure`, `bus_id`, `route_id`) VALUES
(1, 'Toyota PH-19-20 from Nick to Kwarasang', '2017-03-02 00:12:00', '2017-03-01 00:12:00', 1, 1),
(2, 'Toyota PH-19-20 from Parbo to Moengo', '2017-03-03 05:43:00', '2017-03-02 03:43:00', 1, 2),
(3, 'Nissan TE-34-32 from Kwarasang to Parbo', '2017-03-15 16:03:00', '2017-03-15 01:34:00', 2, 5),
(4, 'Masda RE-45-32 from Parbo to Commewijne', '2017-02-27 12:50:00', '2017-02-27 12:12:00', 5, 6),
(5, 'Test 12-34-HT from Parbo to Nick', '2017-03-02 09:09:00', '2017-03-03 08:08:00', 3, 3),
(6, 'Lexus TR-57-98 from Parbo to Moengo', '2017-03-07 00:12:00', '2017-03-03 00:12:00', 4, 2),
(7, 'Nissan TE-34-32 from Parbo to Moengo', '2017-02-28 01:13:00', '2017-02-27 00:12:00', 2, 2),
(8, 'Nissan TK-31-21 from Parbo to Nick', '2017-03-04 17:05:00', '2017-03-04 00:12:00', 6, 3),
(9, 'Test 12-34-HT from Parbo to Moengo', '2017-03-05 00:12:00', '2017-03-04 00:12:00', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `ride`
--

CREATE TABLE IF NOT EXISTS `ride` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actual_arrival` datetime NOT NULL,
  `actual_departure` datetime NOT NULL,
  `sold_tickets` bigint(20) DEFAULT NULL,
  `busRoute_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cmbueee4u4m0lschwg1ielnvs` (`busRoute_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `ride`
--

INSERT INTO `ride` (`id`, `actual_arrival`, `actual_departure`, `sold_tickets`, `busRoute_id`) VALUES
(1, '2017-03-02 12:12:00', '2017-03-01 00:12:00', 20, 1),
(2, '2017-03-04 05:43:00', '2017-03-02 03:43:00', 14, 2),
(3, '2017-03-15 20:03:00', '2017-03-15 01:34:00', 10, 3),
(4, '2017-02-27 13:50:00', '2017-02-27 12:12:00', 35, 4);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `departure` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price_per_passenger` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_juaaskacuya7knu5f8eqqeywe` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `departure`, `destination`, `name`, `price_per_passenger`) VALUES
(1, 'Nick', 'Kwarasang', 'Nick-Kwarasang', 2),
(2, 'Parbo', 'Moengo', 'Parbo-Moengo', 5),
(3, 'Parbo', 'Nick', 'Parbo-Nick', 10),
(4, 'Nick', 'Parbo', 'Nick-Parbo', 10),
(5, 'Kwarasang', 'Parbo', 'Kwarasang-Parbo', 20),
(6, 'Parbo', 'Commewijne', 'Parbo-Commewijne', 15);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE IF NOT EXISTS `user_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(14) NOT NULL,
  `userId` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `email`, `password`, `userId`) VALUES
(1, 'test@email.com', 'DION', 'DION');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bus_route`
--
ALTER TABLE `bus_route`
  ADD CONSTRAINT `FK_3jm843rrevogv362sjqx2vl3w` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`),
  ADD CONSTRAINT `FK_oyyvtio54r2gh9gbdecbtauxv` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`id`);

--
-- Constraints for table `ride`
--
ALTER TABLE `ride`
  ADD CONSTRAINT `FK_cmbueee4u4m0lschwg1ielnvs` FOREIGN KEY (`busRoute_id`) REFERENCES `bus_route` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
