package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DetailsPageMapper {


    @Select("SELECT s.name, r.statement FROM studentsinfo s LEFT JOIN personalsummary r ON s.studentID = r.studentID WHERE s.studentID = #{studentID}")
    DetailsPagePersonalSummaryVODOResp getPersonalSummaryDetailsByStudentID(int studentID);

    @Select("SELECT studentsinfo.name, volunteerservice.serviceDuration " +
            "FROM studentsinfo " +
            "INNER JOIN volunteerservice ON studentsinfo.studentID = volunteerservice.studentID " +
            "WHERE studentsinfo.studentID = #{studentID}")
    DetailsPageVolunteerServiceVODOResp getVolunteerServiceDetailsByStudentID(int studentID);

    @Select("SELECT name, GPA " +
            "FROM studentsinfo " +
            "WHERE studentID = #{studentID}")
    DetailsPageStudentScoresVODOResp getStudentScoresDetailsByStudentID(int studentID);

    @Select("SELECT s.name,s.studentID,r.ranking,r.time,r.location,r.award,r.level "
            +"FROM studentsinfo s INNER JOIN researchstatus r ON s.studentID = r.studentID "
            +"WHERE s.studentID = #{studentID}"
    )
    List<DetailsPageResearchStatusVODOResp> getResearchStatusDetailsByStudentID(int studentID);

    @Select("SELECT s.name,s.studentID,r.startTime,r.positionName,r.positionTitle,r.assessmentLevel "
            +"FROM studentsinfo s INNER JOIN studentservice r ON s.studentID = r.studentID "
            +"WHERE s.studentID = #{studentID}"
    )
    List<DetailsPageStudentServiceVODOResp> getStudentServiceDetailsByStudentID(int studentID);

    @Select("SELECT s.name,s.studentID,r.initiatingOrganization,r.location,r.duration,r.teamSize,r.teamPosition,r.isOnline,hasAward,awardName "
            +"FROM studentsinfo s INNER JOIN socialpractice r ON s.studentID = r.studentID "
            +"WHERE s.studentID = #{studentID}"
    )
    List<DetailsPageSocialPracticeVODOResp> getSocialPracticeDetailsByStudentID(int studentID);
}
