-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2018 at 05:20 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_showroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `VEHICLE_ID` int(11) NOT NULL,
  `BRAND` varchar(50) NOT NULL,
  `MODEL` varchar(50) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `COLOUR` varchar(50) NOT NULL,
  `STATUS` varchar(50) NOT NULL,
  `RENT_PRICE` int(11) NOT NULL,
  `SELLING_PRICE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`VEHICLE_ID`, `BRAND`, `MODEL`, `TYPE`, `COLOUR`, `STATUS`, `RENT_PRICE`, `SELLING_PRICE`) VALUES
(1001, 'Porsche', 'Cayenne', 'SUV', 'White', 'Available', 1000, 100000),
(1002, 'Chevrolet', 'Camaro', 'Muscle', 'Red', 'Available', 700, 70000),
(1003, 'Chevrolet', 'Corvette', 'Sport', 'Red', 'Available', 3000, 300000),
(1004, 'Koenigsegg', 'AgeraR', 'Sport', 'Blue', 'Unavailable', 3500, 650000),
(1005, 'Dodge', 'Challenger', 'Muscle', 'Black', 'Available', 750, 75000),
(1008, 'Hennessey', 'VenomGT', 'Sport', 'Black', 'Available', 15000, 700000),
(1009, 'LandRover', 'RangeRover', 'SUV', 'Black', 'Unavailable', 1000, 700000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `username`, `password`) VALUES
(1, 'haha', 'lol'),
(2, 'test', 'test'),
(3, 'tf', 'pass'),
(4, 'x', 'x');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`VEHICLE_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `VEHICLE_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1010;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
