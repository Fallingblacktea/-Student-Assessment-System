CREATE TABLE `personalsummay` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `statement` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `researchstatus` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  `time` date DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `award` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `socialpractice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `initiatingOrganization` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `teamSize` int DEFAULT NULL,
  `teamPosition` varchar(50) DEFAULT NULL,
  `isOnline` tinyint(1) DEFAULT NULL,
  `hasAward` tinyint(1) DEFAULT NULL,
  `awardName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentgrades` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `isCorrect` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `positionName` varchar(50) DEFAULT NULL,
  `positionTitle` varchar(50) DEFAULT NULL,
  `assessmentLevel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentsinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `studentID` int NOT NULL,
  `grade` varchar(4) NOT NULL,
  `classname` varchar(10) NOT NULL,
  `hometown` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `personalSummary` float DEFAULT NULL,
  `GPA` float NOT NULL,
  `volunteerService` float DEFAULT NULL,
  `researchStatus` float DEFAULT NULL,
  `studentService` float DEFAULT NULL,
  `socialPractice` float DEFAULT NULL,
  `summaryScore` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `volunteerservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `serviceDuration` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

;
;
;
;
;
insert into `studentsinfo` (`GPA`, `classname`, `contact`, `gender`, `grade`, `hometown`, `id`, `name`, `personalSummary`, `researchStatus`, `socialPractice`, `studentID`, `studentService`, `summaryScore`, `volunteerService`) values (0, '1', '1', 'man', '1', '1', 2, 'xzx', 0, 0, 0, 10000, 0, 0, 0), (0, '1', '1', 'man', '1', '1', 3, 'xzx', 0, 0, 0, 12, 0, 0, 0);
;
