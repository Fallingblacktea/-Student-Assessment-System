package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SubmmitScoresMapper {
    @Update("UPDATE studentsinfo SET personalsummary = #{scores} WHERE studentID = #{studentID}")
    void updatePersonalSummary(SubmitScoresVODO submitScoresVODO);

    @Update("UPDATE studentsinfo SET volunteerservice = #{scores} WHERE studentID = #{studentID}")
    void updateVolunteerservice(SubmitScoresVODO submitScoresVODO);

    @Insert("INSERT INTO studentgrades (studentID,isCorrect) VALUES (#{studentID},#{correct})" )
    void insertStudentScores(CheckScoresVODO checkScoresVODO);

    @Update("UPDATE studentsinfo SET researchstatus = #{scores} WHERE studentID = #{studentID}")
    void updateResearchstatus(SubmitScoresVODO submitScoresVODO);

    @Update("UPDATE studentsinfo SET studentservice = #{scores} WHERE studentID = #{studentID}")
    void updateStudentservice(SubmitScoresVODO submitScoresVODO);

    @Update("UPDATE studentsinfo SET socialpractice = #{scores} WHERE studentID = #{studentID}")
    void updateSocialpractice(SubmitScoresVODO submitScoresVODO);
}
