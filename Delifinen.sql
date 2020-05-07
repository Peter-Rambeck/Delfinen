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
 
  
    
    
    