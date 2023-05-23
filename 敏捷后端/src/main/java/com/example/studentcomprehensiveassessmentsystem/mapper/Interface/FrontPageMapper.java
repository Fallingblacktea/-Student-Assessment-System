package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.FrontPage.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface FrontPageMapper {
    @Select("SELECT  studentID, name, personalSummary FROM studentsinfo")
    List<FrontPagePersonalSummaryVODO> selectPersonalSummary();
    @Select("SELECT  studentID, name, volunteerService FROM studentsinfo")
    List<FrontPageVolunteerServiceVODO> selectVolunteerService();
    @Select("SELECT s.studentID, s.name, CASE WHEN r.studentID IS NOT NULL THEN true ELSE false END AS isPresent " +
            "FROM studentsinfo s " +
            "LEFT JOIN studentgrades r ON s.studentID = r.studentID")
    List<FrontPageStudentScoresVODO> selectStudentScores();
    @Select("SELECT  studentID, name, researchStatus FROM studentsinfo")
    List<FrontPageResearchStatusVODO> selectResearchStatus();

    @Select("SELECT  studentID, name, studentService FROM studentsinfo")
    List<FrontPageStudentServiceVODO> selectStudentService();
    @Select("SELECT  studentID, name, socialPractice FROM studentsinfo")
    List<FrontPageSocialPracticeVODO> selectSocialPractice();
}
