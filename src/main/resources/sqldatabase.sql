/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.21-MariaDB : Database - projekat_stefan_lezaic_1061_17
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekat_stefan_lezaic_1061_17` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `projekat_stefan_lezaic_1061_17`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` int(255) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickoIme` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Lozinka` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`KlijentID`),
  UNIQUE KEY `UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`Email`,`KorisnickoIme`,`Ime`,`Prezime`,`Lozinka`) values 
(1,'pera@gmail.com','Pera','Pera','Peric','123'),
(2,'mika@gmail.com','Mika','Mika','Mikic','123'),
(3,'srba@gmail.com','Srba','Srba','Srbic','123'),
(10,'s.lezaic95@gmail.com','Stefan123','Stefan','Lezaic','123'),
(14,'zika@gmail.com','Zika','Zika','Zikic','123'),
(15,'laza@gmail.com','Laza','Laza','Lazic','123');

/*Table structure for table `linija` */

DROP TABLE IF EXISTS `linija`;

CREATE TABLE `linija` (
  `LinijaID` int(255) NOT NULL AUTO_INCREMENT,
  `NazivLinije` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Minutaza` int(255) NOT NULL,
  `Kilometraza` float DEFAULT NULL,
  `StanicaIDPolazna` int(255) NOT NULL,
  `StanicaIDKrajnja` int(255) NOT NULL,
  `TipLinijeID` int(255) NOT NULL,
  PRIMARY KEY (`LinijaID`),
  UNIQUE KEY `UNIQUE` (`StanicaIDPolazna`,`StanicaIDKrajnja`,`TipLinijeID`),
  KEY `FK_pocetna` (`StanicaIDPolazna`),
  KEY `FK_tip` (`TipLinijeID`),
  KEY `FK_krajnja` (`StanicaIDKrajnja`),
  CONSTRAINT `FK_krajnja` FOREIGN KEY (`StanicaIDKrajnja`) REFERENCES `stanica` (`StanicaID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_pocetna` FOREIGN KEY (`StanicaIDPolazna`) REFERENCES `stanica` (`StanicaID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_tip` FOREIGN KEY (`TipLinijeID`) REFERENCES `tiplinije` (`TipLinijeID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `linija` */

insert  into `linija`(`LinijaID`,`NazivLinije`,`Minutaza`,`Kilometraza`,`StanicaIDPolazna`,`StanicaIDKrajnja`,`TipLinijeID`) values 
(3,'SUBOTICA - NOVI SAD (Brzi voz)',186,108,9,2,1),
(4,'SUBOTICA - NOVI SAD (Regionalni voz)',246,108,9,2,2),
(5,'NOVI SAD - SUBOTICA (Brzi voz)',186,108,2,9,1),
(6,'NOVI SAD - SUBOTICA (Regionalni voz)',246,108,2,9,2);

/*Table structure for table `medjustanica` */

DROP TABLE IF EXISTS `medjustanica`;

CREATE TABLE `medjustanica` (
  `medjustanicaID` int(255) NOT NULL AUTO_INCREMENT,
  `StanicaID` int(255) NOT NULL,
  `LinijaID` int(255) NOT NULL,
  `RedniBroj` int(255) NOT NULL,
  PRIMARY KEY (`medjustanicaID`),
  UNIQUE KEY `Unique` (`StanicaID`,`LinijaID`),
  KEY `LinijaID` (`LinijaID`),
  KEY `StanicaID` (`StanicaID`),
  CONSTRAINT `medjustanica_ibfk_1` FOREIGN KEY (`StanicaID`) REFERENCES `stanica` (`StanicaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `medjustanica_ibfk_2` FOREIGN KEY (`LinijaID`) REFERENCES `linija` (`LinijaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `medjustanica` */

insert  into `medjustanica`(`medjustanicaID`,`StanicaID`,`LinijaID`,`RedniBroj`) values 
(1,10,3,1),
(2,10,4,3),
(3,10,5,6),
(4,10,6,8),
(5,11,3,2),
(6,11,4,4),
(7,11,5,5),
(8,11,6,7),
(9,12,3,3),
(10,12,4,10),
(11,12,5,4),
(12,12,6,1),
(13,13,3,4),
(14,13,4,5),
(15,13,5,3),
(16,13,6,6),
(17,14,3,5),
(18,14,4,6),
(19,14,5,2),
(20,14,6,5),
(21,15,3,6),
(22,15,4,7),
(23,15,5,1),
(24,15,6,4),
(25,17,4,8),
(26,17,6,3),
(27,18,4,9),
(28,18,6,2),
(29,19,4,1),
(30,19,6,10),
(31,20,4,2),
(32,20,6,9);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `MestoID` int(255) NOT NULL AUTO_INCREMENT,
  `NazivMesta` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`MestoID`,`NazivMesta`) values 
(1,'Subotica'),
(2,'Nis'),
(3,'Novi Sad'),
(4,'Indjija'),
(5,'Sremski Karlovci'),
(6,'Beograd'),
(8,'Vrbas'),
(9,'Smederevska palanka'),
(10,'Batajnica'),
(11,'Jagodina'),
(12,'Cuprija'),
(13,'Paracin'),
(14,'Stalac'),
(15,'Aleksinac'),
(16,'Bela Palanka'),
(17,'Pirot'),
(18,'Dimitrovgrad'),
(19,'Kursumlija'),
(20,'Prokuplje'),
(21,'Vrbnica'),
(22,'Prijepolje'),
(23,'Priboj'),
(24,'Uzice'),
(25,'Pozega'),
(26,'Cacak'),
(27,'Kraljevo'),
(28,'Kragujevac'),
(29,'Batocina'),
(30,'Lapovo'),
(31,'Raska'),
(32,'Lajkovac'),
(33,'Valjevo'),
(34,'Mladenovac'),
(36,'Pozarevac'),
(37,'Smederevo'),
(38,'Majdanpek'),
(39,'Bor'),
(40,'Zajecar'),
(41,'Negotin'),
(42,'Prahovo pristaniste'),
(43,'Knjazevac'),
(44,'Svrljig'),
(45,'Sid'),
(46,'Ruma'),
(47,'Sremska Mitrovica'),
(48,'Stara Pazova'),
(49,'Kikinda'),
(50,'Novi Becej'),
(51,'Zrenjanin'),
(52,'Pancevo'),
(53,'Ovca'),
(54,'Vrsac'),
(55,'Mala Krsna'),
(56,'Backa Topola');

/*Table structure for table `polazak` */

DROP TABLE IF EXISTS `polazak`;

CREATE TABLE `polazak` (
  `PolazakID` int(255) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DatumPolaska` datetime NOT NULL,
  `DatumDolaska` datetime NOT NULL,
  `LinijaID` int(255) NOT NULL,
  `VozID` int(255) NOT NULL,
  `Napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PolazakID`),
  KEY `FK_LinijaID` (`LinijaID`),
  KEY `FK_VozID` (`VozID`),
  CONSTRAINT `FK_LinijaID` FOREIGN KEY (`LinijaID`) REFERENCES `linija` (`LinijaID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_VozID` FOREIGN KEY (`VozID`) REFERENCES `voz` (`VozID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `polazak` */

insert  into `polazak`(`PolazakID`,`Naziv`,`DatumPolaska`,`DatumDolaska`,`LinijaID`,`VozID`,`Napomena`) values 
(72,'SUBOTICA - NOVI SAD (Brzi voz) [04.02.2020 00:00 -> 04.02.2020 03:06]','2020-02-04 00:00:00','2020-02-04 03:06:00',3,1,'/'),
(73,'NOVI SAD - SUBOTICA (Brzi voz) [04.02.2020 03:36 -> 04.02.2020 06:42]','2020-02-04 03:36:00','2020-02-04 06:42:00',5,1,'/'),
(74,'SUBOTICA - NOVI SAD (Brzi voz) [05.02.2020 00:00 -> 05.02.2020 03:06]','2020-02-05 00:00:00','2020-02-05 03:06:00',3,1,'/'),
(75,'NOVI SAD - SUBOTICA (Brzi voz) [05.02.2020 03:36 -> 05.02.2020 06:42]','2020-02-05 03:36:00','2020-02-05 06:42:00',5,1,'/'),
(76,'SUBOTICA - NOVI SAD (Brzi voz) [06.02.2020 00:00 -> 06.02.2020 03:06]','2020-02-06 00:00:00','2020-02-06 03:06:00',3,1,'/'),
(77,'NOVI SAD - SUBOTICA (Brzi voz) [06.02.2020 03:36 -> 06.02.2020 06:42]','2020-02-06 03:36:00','2020-02-06 06:42:00',5,1,'/'),
(78,'SUBOTICA - NOVI SAD (Brzi voz) [07.02.2020 00:00 -> 07.02.2020 03:06]','2020-02-07 00:00:00','2020-02-07 03:06:00',3,1,'/'),
(79,'NOVI SAD - SUBOTICA (Brzi voz) [07.02.2020 03:36 -> 07.02.2020 06:42]','2020-02-07 03:36:00','2020-02-07 06:42:00',5,1,'/'),
(80,'SUBOTICA - NOVI SAD (Brzi voz) [08.02.2020 00:00 -> 08.02.2020 03:06]','2020-02-08 00:00:00','2020-02-08 03:06:00',3,1,'/'),
(82,'SUBOTICA - NOVI SAD (Brzi voz) [09.02.2020 00:00 -> 09.02.2020 03:06]','2020-02-09 00:00:00','2020-02-09 03:06:00',3,1,'/'),
(83,'NOVI SAD - SUBOTICA (Brzi voz) [09.02.2020 03:36 -> 09.02.2020 06:42]','2020-02-09 03:36:00','2020-02-09 06:42:00',5,1,'/'),
(84,'SUBOTICA - NOVI SAD (Brzi voz) [10.02.2020 00:00 -> 10.02.2020 03:06]','2020-02-10 00:00:00','2020-02-10 03:06:00',3,1,'/'),
(85,'NOVI SAD - SUBOTICA (Brzi voz) [10.02.2020 03:36 -> 10.02.2020 06:42]','2020-02-10 03:36:00','2020-02-10 06:42:00',5,1,'/'),
(86,'SUBOTICA - NOVI SAD (Brzi voz) [11.02.2020 00:00 -> 11.02.2020 03:06]','2020-02-11 00:00:00','2020-02-11 03:06:00',3,1,'/'),
(87,'NOVI SAD - SUBOTICA (Brzi voz) [11.02.2020 03:36 -> 11.02.2020 06:42]','2020-02-11 03:36:00','2020-02-11 06:42:00',5,1,'/'),
(88,'SUBOTICA - NOVI SAD (Brzi voz) [12.02.2020 00:00 -> 12.02.2020 03:06]','2020-02-12 00:00:00','2020-02-12 03:06:00',3,1,'/'),
(89,'NOVI SAD - SUBOTICA (Brzi voz) [12.02.2020 03:36 -> 12.02.2020 06:42]','2020-02-12 03:36:00','2020-02-12 06:42:00',5,1,'/'),
(90,'SUBOTICA - NOVI SAD (Brzi voz) [13.02.2020 00:00 -> 13.02.2020 03:06]','2020-02-13 00:00:00','2020-02-13 03:06:00',3,1,'/'),
(91,'NOVI SAD - SUBOTICA (Brzi voz) [13.02.2020 03:36 -> 13.02.2020 06:42]','2020-02-13 03:36:00','2020-02-13 06:42:00',5,1,'/'),
(92,'SUBOTICA - NOVI SAD (Brzi voz) [14.02.2020 00:00 -> 14.02.2020 03:06]','2020-02-14 00:00:00','2020-02-14 03:06:00',3,1,'/'),
(93,'NOVI SAD - SUBOTICA (Brzi voz) [14.02.2020 03:36 -> 14.02.2020 06:42]','2020-02-14 03:36:00','2020-02-14 06:42:00',5,1,'/'),
(94,'SUBOTICA - NOVI SAD (Brzi voz) [15.02.2020 00:00 -> 15.02.2020 03:06]','2020-02-15 00:00:00','2020-02-15 03:06:00',3,1,'/'),
(95,'NOVI SAD - SUBOTICA (Brzi voz) [15.02.2020 03:36 -> 15.02.2020 06:42]','2020-02-15 03:36:00','2020-02-15 06:42:00',5,1,'/'),
(96,'SUBOTICA - NOVI SAD (Brzi voz) [16.02.2020 00:00 -> 16.02.2020 03:06]','2020-02-16 00:00:00','2020-02-16 03:06:00',3,1,'/'),
(97,'NOVI SAD - SUBOTICA (Brzi voz) [16.02.2020 03:36 -> 16.02.2020 06:42]','2020-02-16 03:36:00','2020-02-16 06:42:00',5,1,'/'),
(98,'SUBOTICA - NOVI SAD (Brzi voz) [17.02.2020 00:00 -> 17.02.2020 03:06]','2020-02-17 00:00:00','2020-02-17 03:06:00',3,1,'/'),
(99,'NOVI SAD - SUBOTICA (Brzi voz) [17.02.2020 03:36 -> 17.02.2020 06:42]','2020-02-17 03:36:00','2020-02-17 06:42:00',5,1,'/'),
(100,'SUBOTICA - NOVI SAD (Brzi voz) [18.02.2020 00:00 -> 18.02.2020 03:06]','2020-02-18 00:00:00','2020-02-18 03:06:00',3,1,'/'),
(101,'NOVI SAD - SUBOTICA (Brzi voz) [18.02.2020 03:36 -> 18.02.2020 06:42]','2020-02-18 03:36:00','2020-02-18 06:42:00',5,1,'/'),
(103,'SUBOTICA - NOVI SAD (Brzi voz) [03.02.2020 20:23 -> 03.02.2020 23:29]','2020-02-03 20:23:00','2020-02-03 23:29:00',3,1,'/'),
(104,'NOVI SAD - SUBOTICA (Brzi voz) [03.02.2020 23:59 -> 04.02.2020 03:05]','2020-02-03 23:59:00','2020-02-04 03:05:00',5,1,'/'),
(105,'SUBOTICA - NOVI SAD (Brzi voz) [04.02.2020 20:23 -> 04.02.2020 23:29]','2020-02-04 20:23:00','2020-02-04 23:29:00',3,1,'/'),
(106,'NOVI SAD - SUBOTICA (Brzi voz) [04.02.2020 23:59 -> 05.02.2020 03:05]','2020-02-04 23:59:00','2020-02-05 03:05:00',5,1,'/'),
(107,'SUBOTICA - NOVI SAD (Brzi voz) [05.02.2020 20:23 -> 05.02.2020 23:29]','2020-02-05 20:23:00','2020-02-05 23:29:00',3,1,'KASNI 2min'),
(108,'NOVI SAD - SUBOTICA (Brzi voz) [05.02.2020 23:59 -> 06.02.2020 03:05]','2020-02-05 23:59:00','2020-02-06 03:05:00',5,1,'/'),
(109,'SUBOTICA - NOVI SAD (Brzi voz) [06.02.2020 20:23 -> 06.02.2020 23:29]','2020-02-06 20:23:00','2020-02-06 23:29:00',3,1,'/'),
(110,'NOVI SAD - SUBOTICA (Brzi voz) [06.02.2020 23:59 -> 07.02.2020 03:05]','2020-02-06 23:59:00','2020-02-07 03:05:00',5,1,'/'),
(111,'SUBOTICA - NOVI SAD (Brzi voz) [07.02.2020 20:23 -> 07.02.2020 23:29]','2020-02-07 20:23:00','2020-02-07 23:29:00',3,1,'/'),
(112,'NOVI SAD - SUBOTICA (Brzi voz) [07.02.2020 23:59 -> 08.02.2020 03:05]','2020-02-07 23:59:00','2020-02-08 03:05:00',5,1,'/'),
(113,'SUBOTICA - NOVI SAD (Brzi voz) [08.02.2020 20:23 -> 08.02.2020 23:29]','2020-02-08 20:23:00','2020-02-08 23:29:00',3,1,'/'),
(114,'NOVI SAD - SUBOTICA (Brzi voz) [08.02.2020 23:59 -> 09.02.2020 03:05]','2020-02-08 23:59:00','2020-02-09 03:05:00',5,1,'/'),
(115,'SUBOTICA - NOVI SAD (Brzi voz) [09.02.2020 20:23 -> 09.02.2020 23:29]','2020-02-09 20:23:00','2020-02-09 23:29:00',3,1,'OTKAZAN'),
(116,'NOVI SAD - SUBOTICA (Brzi voz) [09.02.2020 23:59 -> 10.02.2020 03:05]','2020-02-09 23:59:00','2020-02-10 03:05:00',5,1,'/'),
(117,'SUBOTICA - NOVI SAD (Brzi voz) [10.02.2020 20:23 -> 10.02.2020 23:29]','2020-02-10 20:23:00','2020-02-10 23:29:00',3,1,'/'),
(118,'NOVI SAD - SUBOTICA (Brzi voz) [10.02.2020 23:59 -> 11.02.2020 03:05]','2020-02-10 23:59:00','2020-02-11 03:05:00',5,1,'/'),
(119,'SUBOTICA - NOVI SAD (Brzi voz) [11.02.2020 20:23 -> 11.02.2020 23:29]','2020-02-11 20:23:00','2020-02-11 23:29:00',3,1,'/'),
(120,'NOVI SAD - SUBOTICA (Brzi voz) [11.02.2020 23:59 -> 12.02.2020 03:05]','2020-02-11 23:59:00','2020-02-12 03:05:00',5,1,'/'),
(121,'SUBOTICA - NOVI SAD (Brzi voz) [12.02.2020 20:23 -> 12.02.2020 23:29]','2020-02-12 20:23:00','2020-02-12 23:29:00',3,1,'/'),
(122,'NOVI SAD - SUBOTICA (Brzi voz) [12.02.2020 23:59 -> 13.02.2020 03:05]','2020-02-12 23:59:00','2020-02-13 03:05:00',5,1,'/'),
(123,'SUBOTICA - NOVI SAD (Brzi voz) [13.02.2020 20:23 -> 13.02.2020 23:29]','2020-02-13 20:23:00','2020-02-13 23:29:00',3,1,'/'),
(124,'NOVI SAD - SUBOTICA (Brzi voz) [13.02.2020 23:59 -> 14.02.2020 03:05]','2020-02-13 23:59:00','2020-02-14 03:05:00',5,1,'/'),
(125,'SUBOTICA - NOVI SAD (Brzi voz) [14.02.2020 20:23 -> 14.02.2020 23:29]','2020-02-14 20:23:00','2020-02-14 23:29:00',3,1,'/'),
(126,'NOVI SAD - SUBOTICA (Brzi voz) [14.02.2020 23:59 -> 15.02.2020 03:05]','2020-02-14 23:59:00','2020-02-15 03:05:00',5,1,'/'),
(127,'SUBOTICA - NOVI SAD (Brzi voz) [15.02.2020 20:23 -> 15.02.2020 23:29]','2020-02-15 20:23:00','2020-02-15 23:29:00',3,1,'/'),
(128,'NOVI SAD - SUBOTICA (Brzi voz) [15.02.2020 23:59 -> 16.02.2020 03:05]','2020-02-15 23:59:00','2020-02-16 03:05:00',5,1,'/'),
(129,'SUBOTICA - NOVI SAD (Brzi voz) [16.02.2020 20:23 -> 16.02.2020 23:29]','2020-02-16 20:23:00','2020-02-16 23:29:00',3,1,'/'),
(130,'NOVI SAD - SUBOTICA (Brzi voz) [16.02.2020 23:59 -> 17.02.2020 03:05]','2020-02-16 23:59:00','2020-02-17 03:05:00',5,1,'/'),
(131,'SUBOTICA - NOVI SAD (Brzi voz) [17.02.2020 20:23 -> 17.02.2020 23:29]','2020-02-17 20:23:00','2020-02-17 23:29:00',3,1,'/'),
(132,'NOVI SAD - SUBOTICA (Brzi voz) [17.02.2020 23:59 -> 18.02.2020 03:05]','2020-02-17 23:59:00','2020-02-18 03:05:00',5,1,'/'),
(133,'NOVI SAD - SUBOTICA (Regionalni voz) [10.02.2020 08:00 -> 10.02.2020 12:06]','2020-02-10 08:00:00','2020-02-10 12:06:00',6,1,'/'),
(134,'SUBOTICA - NOVI SAD (Regionalni voz) [10.02.2020 12:36 -> 10.02.2020 16:42]','2020-02-10 12:36:00','2020-02-10 16:42:00',4,1,'/'),
(135,'NOVI SAD - SUBOTICA (Regionalni voz) [11.02.2020 08:00 -> 11.02.2020 12:06]','2020-02-11 08:00:00','2020-02-11 12:06:00',6,1,'/'),
(136,'SUBOTICA - NOVI SAD (Regionalni voz) [11.02.2020 12:36 -> 11.02.2020 16:42]','2020-02-11 12:36:00','2020-02-11 16:42:00',4,1,'/'),
(137,'NOVI SAD - SUBOTICA (Regionalni voz) [12.02.2020 08:00 -> 12.02.2020 12:06]','2020-02-12 08:00:00','2020-02-12 12:06:00',6,1,'/'),
(138,'SUBOTICA - NOVI SAD (Regionalni voz) [12.02.2020 12:36 -> 12.02.2020 16:42]','2020-02-12 12:36:00','2020-02-12 16:42:00',4,1,'/'),
(139,'NOVI SAD - SUBOTICA (Regionalni voz) [13.02.2020 08:00 -> 13.02.2020 12:06]','2020-02-13 08:00:00','2020-02-13 12:06:00',6,1,'/'),
(140,'SUBOTICA - NOVI SAD (Regionalni voz) [13.02.2020 12:36 -> 13.02.2020 16:42]','2020-02-13 12:36:00','2020-02-13 16:42:00',4,1,'/'),
(141,'NOVI SAD - SUBOTICA (Regionalni voz) [14.02.2020 08:00 -> 14.02.2020 12:06]','2020-02-14 08:00:00','2020-02-14 12:06:00',6,1,'/'),
(142,'SUBOTICA - NOVI SAD (Regionalni voz) [14.02.2020 12:36 -> 14.02.2020 16:42]','2020-02-14 12:36:00','2020-02-14 16:42:00',4,1,'/'),
(143,'NOVI SAD - SUBOTICA (Regionalni voz) [15.02.2020 08:00 -> 15.02.2020 12:06]','2020-02-15 08:00:00','2020-02-15 12:06:00',6,1,'/'),
(144,'SUBOTICA - NOVI SAD (Regionalni voz) [15.02.2020 12:36 -> 15.02.2020 16:42]','2020-02-15 12:36:00','2020-02-15 16:42:00',4,1,'/'),
(145,'NOVI SAD - SUBOTICA (Regionalni voz) [16.02.2020 08:00 -> 16.02.2020 12:06]','2020-02-16 08:00:00','2020-02-16 12:06:00',6,1,'/'),
(146,'SUBOTICA - NOVI SAD (Regionalni voz) [16.02.2020 12:36 -> 16.02.2020 16:42]','2020-02-16 12:36:00','2020-02-16 16:42:00',4,1,'/'),
(147,'NOVI SAD - SUBOTICA (Regionalni voz) [17.02.2020 08:00 -> 17.02.2020 12:06]','2020-02-17 08:00:00','2020-02-17 12:06:00',6,1,'/'),
(148,'SUBOTICA - NOVI SAD (Regionalni voz) [17.02.2020 12:36 -> 17.02.2020 16:42]','2020-02-17 12:36:00','2020-02-17 16:42:00',4,1,'/'),
(149,'NOVI SAD - SUBOTICA (Regionalni voz) [18.02.2020 08:00 -> 18.02.2020 12:06]','2020-02-18 08:00:00','2020-02-18 12:06:00',6,1,'/'),
(150,'SUBOTICA - NOVI SAD (Regionalni voz) [18.02.2020 12:36 -> 18.02.2020 16:42]','2020-02-18 12:36:00','2020-02-18 16:42:00',4,1,'/'),
(151,'NOVI SAD - SUBOTICA (Regionalni voz) [19.02.2020 08:00 -> 19.02.2020 12:06]','2020-02-19 08:00:00','2020-02-19 12:06:00',6,1,'/'),
(152,'SUBOTICA - NOVI SAD (Regionalni voz) [19.02.2020 12:36 -> 19.02.2020 16:42]','2020-02-19 12:36:00','2020-02-19 16:42:00',4,1,'/'),
(153,'NOVI SAD - SUBOTICA (Regionalni voz) [20.02.2020 08:00 -> 20.02.2020 12:06]','2020-02-20 08:00:00','2020-02-20 12:06:00',6,1,'/'),
(154,'SUBOTICA - NOVI SAD (Regionalni voz) [20.02.2020 12:36 -> 20.02.2020 16:42]','2020-02-20 12:36:00','2020-02-20 16:42:00',4,1,'/'),
(155,'NOVI SAD - SUBOTICA (Regionalni voz) [21.02.2020 08:00 -> 21.02.2020 12:06]','2020-02-21 08:00:00','2020-02-21 12:06:00',6,1,'/'),
(156,'SUBOTICA - NOVI SAD (Regionalni voz) [21.02.2020 12:36 -> 21.02.2020 16:42]','2020-02-21 12:36:00','2020-02-21 16:42:00',4,1,'/'),
(157,'NOVI SAD - SUBOTICA (Regionalni voz) [22.02.2020 08:00 -> 22.02.2020 12:06]','2020-02-22 08:00:00','2020-02-22 12:06:00',6,1,'/'),
(158,'SUBOTICA - NOVI SAD (Regionalni voz) [22.02.2020 12:36 -> 22.02.2020 16:42]','2020-02-22 12:36:00','2020-02-22 16:42:00',4,1,'/'),
(159,'NOVI SAD - SUBOTICA (Regionalni voz) [23.02.2020 08:00 -> 23.02.2020 12:06]','2020-02-23 08:00:00','2020-02-23 12:06:00',6,1,'/'),
(160,'SUBOTICA - NOVI SAD (Regionalni voz) [23.02.2020 12:36 -> 23.02.2020 16:42]','2020-02-23 12:36:00','2020-02-23 16:42:00',4,1,'/'),
(161,'NOVI SAD - SUBOTICA (Regionalni voz) [24.02.2020 08:00 -> 24.02.2020 12:06]','2020-02-24 08:00:00','2020-02-24 12:06:00',6,1,'/'),
(163,'NOVI SAD - SUBOTICA (Brzi voz) [10.02.2020 04:00 -> 10.02.2020 07:06]','2020-02-10 04:00:00','2020-02-10 07:06:00',5,1,'/'),
(164,'NOVI SAD - SUBOTICA (Brzi voz) [11.02.2020 04:00 -> 11.02.2020 07:06]','2020-02-11 04:00:00','2020-02-11 07:06:00',5,1,'/'),
(165,'NOVI SAD - SUBOTICA (Brzi voz) [12.02.2020 04:00 -> 12.02.2020 07:06]','2020-02-12 04:00:00','2020-02-12 07:06:00',5,1,'/'),
(166,'NOVI SAD - SUBOTICA (Brzi voz) [13.02.2020 04:00 -> 13.02.2020 07:06]','2020-02-13 04:00:00','2020-02-13 07:06:00',5,1,'/'),
(167,'NOVI SAD - SUBOTICA (Brzi voz) [14.02.2020 04:00 -> 14.02.2020 07:06]','2020-02-14 04:00:00','2020-02-14 07:06:00',5,1,'/'),
(168,'NOVI SAD - SUBOTICA (Brzi voz) [15.02.2020 04:00 -> 15.02.2020 07:06]','2020-02-15 04:00:00','2020-02-15 07:06:00',5,1,'/'),
(169,'NOVI SAD - SUBOTICA (Brzi voz) [16.02.2020 04:00 -> 16.02.2020 07:06]','2020-02-16 04:00:00','2020-02-16 07:06:00',5,1,'/'),
(170,'NOVI SAD - SUBOTICA (Brzi voz) [23.04.2020 00:00 -> 23.04.2020 03:06]','2020-04-23 00:00:00','2020-04-23 03:06:00',5,5,'BLABLABLA'),
(171,'SUBOTICAdsgagasdgsadgs - NOVI SAD (Brzi voz) [26.10.2021 00:00 - 26.10.2021 03:06]','2020-02-04 00:00:00','2020-02-04 00:00:00',3,1,'/');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `RezervacijaID` int(255) NOT NULL AUTO_INCREMENT,
  `KlijentID` int(255) NOT NULL,
  `PolazakID` int(255) NOT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`RezervacijaID`),
  UNIQUE KEY `Unique` (`KlijentID`,`PolazakID`),
  KEY `PolazakID` (`PolazakID`),
  KEY `KlijentID` (`KlijentID`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`),
  CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`PolazakID`) REFERENCES `polazak` (`PolazakID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`RezervacijaID`,`KlijentID`,`PolazakID`,`Date`) values 
(1,1,75,'2020-02-03'),
(2,1,170,'2021-11-05'),
(3,2,170,'2021-11-05'),
(4,3,170,'2021-11-05'),
(5,10,72,'2020-02-01'),
(6,10,170,'2021-11-05'),
(7,14,170,'2021-11-05'),
(8,15,72,'2021-05-30'),
(11,10,171,'2021-11-08');

/*Table structure for table `stanica` */

DROP TABLE IF EXISTS `stanica`;

CREATE TABLE `stanica` (
  `StanicaID` int(255) NOT NULL AUTO_INCREMENT,
  `NazivStanice` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `MestoID` int(255) NOT NULL,
  PRIMARY KEY (`StanicaID`),
  UNIQUE KEY `UNIQUE` (`NazivStanice`,`MestoID`),
  KEY `FK_MestoID` (`MestoID`),
  CONSTRAINT `stanica_ibfk_1` FOREIGN KEY (`MestoID`) REFERENCES `mesto` (`MestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stanica` */

insert  into `stanica`(`StanicaID`,`NazivStanice`,`MestoID`) values 
(19,'ALEKSANDROVO PREDGRADE',3),
(11,'BACKA TOPOLA',56),
(22,'BEOGRAD CENTAR(PROKOP)',6),
(21,'BEOGRAD DUNAV',6),
(1,'BEOGRAD GLAVNA',6),
(5,'INDJIJA',4),
(6,'INDJIJA PUSTARA',4),
(18,'KISAC',3),
(13,'LOVCENAC',55),
(32,'MALA VAROSICA',17),
(12,'MALI IDJOS ',56),
(3,'NIS',2),
(4,'NISKA BANJA',2),
(2,'NOVI SAD',3),
(33,'SDAGASDGAD',1),
(7,'SREMSKI KARLOVCI',5),
(17,'STEPANOVICEVO',3),
(9,'SUBOTICA',1),
(20,'VERUSIC',1),
(14,'VRBAS',8),
(34,'ZABLJAK',29),
(10,'ZEDNIK',1),
(15,'ZMAJEVO',8);

/*Table structure for table `tiplinije` */

DROP TABLE IF EXISTS `tiplinije`;

CREATE TABLE `tiplinije` (
  `TipLinijeID` int(255) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`TipLinijeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tiplinije` */

insert  into `tiplinije`(`TipLinijeID`,`Naziv`) values 
(1,'Brzi voz'),
(2,'Regionalni voz'),
(3,'Putnicki voz');

/*Table structure for table `voz` */

DROP TABLE IF EXISTS `voz`;

CREATE TABLE `voz` (
  `VozID` int(255) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `BrojMesta` int(255) NOT NULL,
  PRIMARY KEY (`VozID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `voz` */

insert  into `voz`(`VozID`,`Naziv`,`BrojMesta`) values 
(1,'Tip100',100),
(2,'Tip200',200),
(3,'Tip300',300),
(4,'Tip400',400),
(5,'Tip5',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
