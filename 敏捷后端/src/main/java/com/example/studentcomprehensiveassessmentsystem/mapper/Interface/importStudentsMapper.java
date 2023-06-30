package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPull;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPush;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface importStudentsMapper {

    @Insert("INSERT INTO studentsinfo(name, gender, studentID, grade, classname, hometown, contact, personalSummary, GPA, volunteerService, researchStatus, studentService, socialPractice, summaryScore) " +
            "VALUES(#{name}, #{gender}, #{studentID}, #{grade}, #{classname}, #{hometown}, #{contact}, #{personalSummary}, #{GPA}, #{volunteerService}, #{researchStatus}, #{studentService}, #{socialPractice}, #{summaryScore})")
    void insertStudentsInfo(importStudentsDO ImportStudentsDO);

    @Insert("INSERT INTO user(username, password ) " +
            "VALUES(#{studentID}, #{name})")
    void insertUser(importStudentsDO ImportStudentsDO);

    @Select("SELECT  id FROM user WHERE username=#{studentID}")
    RoleUserDOPull selectRoleUser(importStudentsDO ImportStudentsDO);


    @Insert("INSERT INTO role_user(user_id,role_id ) " +
            "VALUES(#{user_id}, #{role_id})")
    void insertRoleUser(RoleUserDOPush roleUserDO);

    // 其他数据库操作方法
}
