package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface importStudentsMapper {

    @Insert("INSERT INTO studentsinfo(name, gender, studentID, grade, classname, hometown, contact, personalSummary, GPA, volunteerService, researchStatus, studentService, socialPractice, summaryScore) " +
            "VALUES(#{name}, #{gender}, #{studentId}, #{grade}, #{classname}, #{hometown}, #{contact}, #{personalSummary}, #{GPA}, #{volunteerService}, #{researchStatus}, #{studentService}, #{socialPractice}, #{summaryScore})")
    void insertStudentsInfo(importStudentsDO ImportStudentsDO);

    @Insert("INSERT INTO user(username, password ) " +
            "VALUES(#{studentId}, #{name})")
    void insertUsers(importStudentsDO ImportStudentsDO);

    // 其他数据库操作方法
}
