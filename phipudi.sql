-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2020 at 12:21 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phipudi`
--

-- --------------------------------------------------------

--
-- Table structure for table `hupi`
--

CREATE TABLE `hupi` (
  `hupiid` int(11) NOT NULL,
  `orang` varchar(30) NOT NULL,
  `keterangan` text DEFAULT NULL,
  `tipe` char(7) NOT NULL,
  `jumlah` float NOT NULL,
  `cicilan` float DEFAULT 0,
  `jatuhtempo` date DEFAULT NULL,
  `createdat` datetime NOT NULL DEFAULT current_timestamp(),
  `updatedat` datetime NOT NULL DEFAULT current_timestamp(),
  `deletedat` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hupi`
--

INSERT INTO `hupi` (`hupiid`, `orang`, `keterangan`, `tipe`, `jumlah`, `cicilan`, `jatuhtempo`, `createdat`, `updatedat`, `deletedat`) VALUES
(34, 'Tukiem', 'Senggol Bacouek', 'hutang', 10092, 778, '2019-12-25', '2019-12-29 08:07:47', '2019-12-29 08:07:47', '2020-01-08 17:23:14'),
(35, 'ye', 'as', 'hutang', 1888, 900, '2019-12-16', '2019-12-29 08:37:32', '2019-12-29 13:59:29', '2019-12-30 01:04:10'),
(36, 'Hontou', 'Hazakura', 'piutang', 12000, 12000, '2019-12-12', '2019-12-29 13:02:02', '2019-12-30 00:27:37', '2019-12-30 00:36:09'),
(37, 'Lin Dong', 'Bayar di Taman', 'piutang', 18000, 3000, '2020-01-09', '2019-12-30 00:32:07', '2020-01-08 16:37:45', NULL),
(38, 'Pakarsen', 'Bayar Secepatnya lebih baik dunia akhirat. Kalau jatuh tempo takutnya malaikat Izrail juga ikutan tagih nyawa anda.', 'hutang', 89000, 3000, '2020-01-09', '2020-01-08 15:58:12', '2020-01-08 16:01:12', NULL),
(39, 'Mokhamad Wijaya', 'Hutang dengan diri sendiri rasanya beda dari yang lain', 'piutang', 45000, 1200, '2020-01-09', '2020-01-08 16:50:31', '2020-01-08 16:59:03', NULL),
(40, 'AILA', 'Modal Besar. Kerja Kudu Kasar', 'hutang', 1000200, 3000, '2020-01-10', '2020-01-08 17:00:25', '2020-01-08 17:00:58', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hupi`
--
ALTER TABLE `hupi`
  ADD PRIMARY KEY (`hupiid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hupi`
--
ALTER TABLE `hupi`
  MODIFY `hupiid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
