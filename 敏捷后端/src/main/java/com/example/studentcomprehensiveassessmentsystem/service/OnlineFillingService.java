package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.OnlineFillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineFillingService {
    @Autowired
    private OnlineFillingMapper onlineFillingMapper;

    public void createPersonalSummary(PersonalSummaryDO personalSummary) {
        onlineFillingMapper.insertPersonalSummary(personalSummary);
    }



    public void createStudentGrades(StudentScoresDO studentGrades) {
        onlineFillingMapper.insertStudentScores(studentGrades);
    }

    public void createResearchStatus(ResearchStatusDO researchStatus) {
        onlineFillingMapper.insertResearchStatus(researchStatus);
    }

    public void createStudentService(StudentServiceDO studentService) {
        onlineFillingMapper.insertStudentService(studentService);
    }

    public void createSocialPractice(SocialPracticeDO socialPractice) {
        onlineFillingMapper.insertSocialPractice(socialPractice);
    }
}

