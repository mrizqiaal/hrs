-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 21 Jun 2016 pada 16.29
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `dbhotelsystem`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `guestid` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `guestname` varchar(254) NOT NULL,
  `guestemail` varchar(254) NOT NULL,
  `guestphone` bigint(13) NOT NULL,
  `guestaddress` varchar(254) NOT NULL,
  PRIMARY KEY (`guestid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data untuk tabel `guest`
--

INSERT INTO `guest` (`guestid`, `guestname`, `guestemail`, `guestphone`, `guestaddress`) VALUES
(001, 'Amilio Asmaramis', 'ami@gmail.com', 628783333222, 'Jl. Penaton 19'),
(002, 'Muh. Yudhistira Fuady', 'yudhis@gmail.com', 628572222333, 'Jl. Lemah Gempal 1 Gang Buntu'),
(003, 'Bravura Auriga Dywan', 'auriga@orion.com', 62858000222, 'Jl. Banowati Selatan'),
(004, 'Febriawan Rizky Yuwono', 'febz@gmail.com', 62877772222, 'Jl. Lemah Gempal 1 Gang Buntu'),
(005, 'Satria Bintang Perkasa', 'babon@jos.com', 628579922992, 'Jl. Penaton 19'),
(006, 'Zia Ulkhaq', 'zia@gmail.com', 628588882222, 'Jl. Bulu Stalan 5'),
(007, 'Septian Ridho Kurniawan', 'ido@ronaldo.com', 628139999222, 'Jl. Penaton 19'),
(008, 'Abdullah Dolly', 'dolly@alkaf.com', 62281634377, 'Jl. Lemah Gempal 1 Gang Buntu'),
(009, 'Kadek Dwi Budi Utama', 'kadek@gmail.com', 628571111111, 'Jl. Lemah Gempal 1 Gang Buntu'),
(010, 'Hico Purwanto', 'hico@tjdn.com', 62858555444, 'Jl. Lemah Gempal 1 Gang Buntu'),
(011, 'Ibnu Yasin', 'iyas@gmail.com', 62858000222, 'Jl. Arjuna'),
(012, 'aaa', 'a@a.com', 6666, 'Jl. tes'),
(013, 'Firman Aswani Ansah', 'firmanaswani20agt@gmail.com', 6285747714730, 'Jl. Maluku no. 21 Karang Tempel Semarang');

-- --------------------------------------------------------

--
-- Stand-in structure for view `report`
--
CREATE TABLE IF NOT EXISTS `report` (
`guestid` int(3) unsigned zerofill
,`guestname` varchar(254)
,`roomid` char(3)
,`roomnumber` int(3)
,`roomtype` char(11)
,`checkin_date` date
,`checkout_date` date
,`roomprice` decimal(9,2)
,`lama` double
,`total` double
);
-- --------------------------------------------------------

--
-- Struktur dari tabel `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `guestid` int(3) unsigned zerofill NOT NULL,
  `roomid` char(3) NOT NULL,
  `checkin_date` date NOT NULL,
  `checkout_date` date NOT NULL,
  KEY `guestid` (`guestid`),
  KEY `roomid` (`roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `reservation`
--

INSERT INTO `reservation` (`guestid`, `roomid`, `checkin_date`, `checkout_date`) VALUES
(001, 'S01', '2016-06-12', '2016-06-13'),
(002, 'F01', '2016-06-13', '2016-06-15'),
(003, 'S02', '2016-06-13', '2016-06-16'),
(004, 'D01', '2016-06-13', '2016-06-15'),
(005, 'D02', '2016-06-13', '2016-06-14'),
(006, 'F02', '2016-06-13', '2016-06-16'),
(007, 'S01', '2016-06-14', '2016-06-16'),
(008, 'S03', '2016-06-14', '2016-06-16'),
(009, 'F03', '2016-06-14', '2016-06-15'),
(010, 'D03', '2016-06-14', '2016-06-17'),
(011, 'D02', '2016-06-15', '2016-06-16'),
(012, 'F01', '2016-06-16', '2016-06-17'),
(013, 'D01', '2016-06-21', '2016-06-22');

-- --------------------------------------------------------

--
-- Struktur dari tabel `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `roomid` char(3) NOT NULL,
  `roomnumber` int(3) NOT NULL,
  `roomtype` char(11) NOT NULL,
  `roomprice` decimal(9,2) NOT NULL,
  `roomstatus` enum('Available','Unavailable') NOT NULL,
  PRIMARY KEY (`roomid`),
  UNIQUE KEY `roomnumber` (`roomnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `room`
--

INSERT INTO `room` (`roomid`, `roomnumber`, `roomtype`, `roomprice`, `roomstatus`) VALUES
('D01', 301, 'Double Room', 350000.00, 'Unavailable'),
('D02', 302, 'Double Room', 350000.00, 'Unavailable'),
('D03', 303, 'Double Room', 350000.00, 'Unavailable'),
('D04', 304, 'Double Room', 350000.00, 'Available'),
('D05', 305, 'Double Room', 350000.00, 'Available'),
('D06', 306, 'Double Room', 350000.00, 'Available'),
('D07', 307, 'Double Room', 350000.00, 'Available'),
('D08', 308, 'Double Room', 350000.00, 'Available'),
('D09', 309, 'Double Room', 350000.00, 'Available'),
('D10', 310, 'Double Room', 350000.00, 'Available'),
('D11', 311, 'Double Room', 350000.00, 'Available'),
('F01', 401, 'Family Room', 475000.00, 'Available'),
('F02', 402, 'Family Room', 475000.00, 'Unavailable'),
('F03', 403, 'Family Room', 475000.00, 'Available'),
('F04', 404, 'Family Room', 475000.00, 'Available'),
('F05', 405, 'Family Room', 475000.00, 'Available'),
('F06', 406, 'Family Room', 475000.00, 'Available'),
('F07', 407, 'Family Room', 475000.00, 'Available'),
('F08', 408, 'Family Room', 475000.00, 'Available'),
('F09', 409, 'Family Room', 475000.00, 'Available'),
('F10', 410, 'Family Room', 475000.00, 'Available'),
('F11', 411, 'Family Room', 475000.00, 'Available'),
('S01', 201, 'Single Room', 275000.00, 'Unavailable'),
('S02', 202, 'Single Room', 275000.00, 'Unavailable'),
('S03', 203, 'Single Room', 275000.00, 'Unavailable'),
('S04', 204, 'Single Room', 275000.00, 'Available'),
('S05', 205, 'Single Room', 275000.00, 'Available'),
('S06', 206, 'Single Room', 275000.00, 'Available'),
('S07', 207, 'Single Room', 275000.00, 'Available'),
('S08', 208, 'Single Room', 275000.00, 'Available'),
('S09', 209, 'Single Room', 275000.00, 'Available'),
('S10', 210, 'Single Room', 275000.00, 'Available'),
('S11', 211, 'Single Room', 275000.00, 'Available'),
('S12', 212, 'Single Room', 275000.00, 'Available'),
('S13', 213, 'Single Room', 275000.00, 'Available'),
('S14', 214, 'Single Room', 275000.00, 'Available');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userid` varchar(10) NOT NULL,
  `userpass` varchar(254) NOT NULL,
  `username` varchar(254) DEFAULT NULL,
  `useremail` varchar(254) DEFAULT NULL,
  `usergender` enum('L','P') DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`userid`, `userpass`, `username`, `useremail`, `usergender`) VALUES
('admin', 'admin', NULL, NULL, NULL),
('kadekutama', 'xxxx', 'Kadek Dwi Budi Utama', 'kadek@gmail.com', 'L'),
('manager', 'manager', NULL, NULL, NULL),
('papwa', 'papwa123', 'Gogor Dewantara Rimba', 'gogor@dr.com', 'L'),
('tes', 'tes123', 'tes', 'tes@gmail.com', 'P'),
('tess', 'papwa', 'tesss', 'tes@gmail.com', 'L');

-- --------------------------------------------------------

--
-- Struktur untuk view `report`
--
DROP TABLE IF EXISTS `report`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `report` AS (select `guest`.`guestid` AS `guestid`,`guest`.`guestname` AS `guestname`,`room`.`roomid` AS `roomid`,`room`.`roomnumber` AS `roomnumber`,`room`.`roomtype` AS `roomtype`,`reservation`.`checkin_date` AS `checkin_date`,`reservation`.`checkout_date` AS `checkout_date`,`room`.`roomprice` AS `roomprice`,(`reservation`.`checkout_date` - `reservation`.`checkin_date`) AS `lama`,((`reservation`.`checkout_date` - `reservation`.`checkin_date`) * `room`.`roomprice`) AS `total` from ((`guest` join `room`) join `reservation`) where ((`room`.`roomid` = `reservation`.`roomid`) and (`guest`.`guestid` = `reservation`.`guestid`)));

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`guestid`) REFERENCES `guest` (`guestid`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`roomid`) REFERENCES `room` (`roomid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
