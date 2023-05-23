package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;


import com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

    @Mapper
    public interface OnlineFillingMapper {
        @Insert("INSERT INTO personalsummary (studentID, statement) VALUES (#{studentId}, #{personalSummary})")
        void insertPersonalSummary(PersonalSummaryDO personalSummary);



    @Update("UPDATE studentsinfo SET GPA = #{GPA} WHERE studentID = #{studentId}")
    void updateStudentScores(StudentScoresDO studentScoresDO);


    @Insert("INSERT INTO researchstatus (studentID, ranking, time, location, award, level) " +
                "VALUES (#{studentId}, #{ranking}, #{time}, #{location}, #{award}, #{level})")
        void insertResearchStatus(ResearchStatusDO researchStatus);

        @Insert("INSERT INTO studentservice (studentID, startTime, positionName, positionTitle, assessmentLevel) " +
                "VALUES (#{studentId}, #{startTime}, #{positionName}, #{positionTitle}, #{assessmentLevel})")
        void insertStudentService(StudentServiceDO studentService);

        @Insert("INSERT INTO socialpractice (studentID, initiatingOrganization, location, duration, teamSize, " +
                "teamPosition, isOnline, hasAward, awardName) " +
                "VALUES (#{studentId}, #{initiatingOrganization}, #{location}, #{duration}, #{teamSize}, " +
                "#{teamPosition}, #{isOnline}, #{hasAward}, #{awardName})")
        void insertSocialPractice(SocialPracticeDO socialPractice);
    }


