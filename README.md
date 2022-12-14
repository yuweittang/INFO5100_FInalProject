# INFO5100_FInalProject

### This is a student management system including add update and delete student information.
### To use the system, please download MYSQL DataBase and build a schema as the system connects MySQL DataBase.
### here is the sql code of create table

CREATE TABLE `AdminInform` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`,`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `StudentInfo` (
  `StudentName` varchar(45) NOT NULL,
  `StudentID` varchar(45) NOT NULL,
  `Birthday` varchar(45) DEFAULT NULL,
  `Major` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Credits` decimal(20,0) DEFAULT NULL,
  `Grades` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`StudentName`,`StudentID`),
  UNIQUE KEY `StudentName_UNIQUE` (`StudentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
