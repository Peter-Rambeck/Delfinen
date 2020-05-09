CREATE DATABASE Delfin;

USE Delfin;

CREATE TABLE `Delfin`.`medlem` (
  medlemID INT NOT NULL AUTO_INCREMENT,
  forNavn VARCHAR(45) NULL,
  efterNavn VARCHAR(45) NULL,
  alder int NULL,
  email VARCHAR(45) NULL,
  tlfnr VARCHAR(45) NULL,
  balance int NULL,
  statu ENUM("aktiv","passiv"),
  koen ENUM("mand","kvinde"),
  aldersKlasse ENUM ("senior","junior"),
  PRIMARY KEY (`medlemID`));
 
  CREATE TABLE `Delfin`.`konkurrence` (
  konkurrenceID INT NOT NULL AUTO_INCREMENT,
  navn VARCHAR(45) NULL,
  dato DATE,
  PRIMARY KEY (`konkurrenceID`));
  
  CREATE TABLE `Delfin`.`konkurrenceResultat` (
  resultatID INT NOT NULL AUTO_INCREMENT,
  medlemID INT NULL,
  konkurrenceID INT NULL,
  disciplin ENUM("bryst","crawl","rygcrawl","butterfly"),
  tid TIME(3),
  FOREIGN KEY (medlemID) REFERENCES medlem(medlemID),
  FOREIGN KEY (konkurrenceID) REFERENCES konkurrence(konkurrenceID),
  PRIMARY KEY (resultatID));
    
    
    