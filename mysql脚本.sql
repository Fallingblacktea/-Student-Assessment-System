CREATE TABLE `node` (
  `id` int unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `personalsummary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `statement` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `researchstatus` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  `time` date DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `award` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `role_node` (
  `id` int unsigned NOT NULL,
  `role_id` int DEFAULT NULL,
  `node_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
CREATE TABLE `role_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentgrades` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `isCorrect` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `positionName` varchar(50) DEFAULT NULL,
  `positionTitle` varchar(50) DEFAULT NULL,
  `assessmentLevel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `studentsinfo` (
  `ID` int NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` char(20) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `volunteerservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `studentID` int DEFAULT NULL,
  `serviceDuration` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

insert into `node` (`id`, `name`) values (0, 'importStudents'), (1, 'scoresSummary'), (2, 'exportData'), (3, 'personalSummary'), (4, 'volunteerService'), (5, 'studentScores'), (6, 'researchStatus'), (7, 'studentService'), (8, 'socialPractice'), (9, 'onlineFilling');
insert into `role` (`id`, `name`) values (1, '学生管理员'), (2, '评委主席'), (3, '学生'), (4, '个人总结评委'), (5, '志愿服务评委'), (6, '学生成绩评委'), (7, '科研情况评委'), (8, '学生骨干评委'), (9, '社会实践评委');
insert into `role_node` (`id`, `node_id`, `role_id`) values (1, 0, 1), (2, 1, 1), (3, 2, 1), (4, 3, 4), (5, 4, 5), (6, 5, 6), (7, 6, 7), (8, 7, 8), (9, 8, 9), (10, 9, 3);
insert into `role_user` (`id`, `role_id`, `user_id`) values (1, 1, 1), (2, 2, 2), (3, 3, 3), (4, 3, 13), (5, 3, 14), (6, 3, 15), (7, 3, 16), (8, 3, 17), (9, 3, 18), (10, 3, 19), (11, 3, 20), (12, 3, 21), (13, 4, 22), (14, 5, 23), (15, 6, 24), (16, 7, 25), (17, 8, 26), (18, 9, 27);
insert into `user` (`id`, `password`, `username`) values (1, 'password1', '001'), (2, 'password2', '002'),  (22, '1', 'pingwei1'), (23, '2', 'pingwei2'), (24, '3', 'pingwei3'), (25, '4', 'pingwei4'), (26, '5', 'pingwei5'), (27, '6', 'pingwei6');
