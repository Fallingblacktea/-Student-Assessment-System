package com.example.studentcomprehensiveassessmentsystem.service;


import com.example.studentcomprehensiveassessmentsystem.controller.VO.FrontPage.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.FrontPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontPageService {
    @Autowired
    private FrontPageMapper frontPageMapper;

    public List<FrontPagePersonalSummaryVODO> getPersonalSummary() {
        List<FrontPagePersonalSummaryVODO> personalSummaryList = frontPageMapper.selectPersonalSummary();
        return personalSummaryList;
    }
    public List<FrontPageVolunteerServiceVODO> getVolunteerService() {
        List<FrontPageVolunteerServiceVODO> volunteerServiceList = frontPageMapper.selectVolunteerService();
        return volunteerServiceList;
    }
    public List<FrontPageStudentScoresVODO> getStudentScores() {
        List<FrontPageStudentScoresVODO> studentScoresList = frontPageMapper.selectStudentScores();
        return studentScoresList;
    }

    public List<FrontPageResearchStatusVODO> getResearchStatus() {
        List<FrontPageResearchStatusVODO> researchStatusList = frontPageMapper.selectResearchStatus();
        return researchStatusList;
    }
    public List<FrontPageStudentServiceVODO> getStudentService() {
        List<FrontPageStudentServiceVODO> studentServiceList = frontPageMapper.selectStudentService();
        return studentServiceList;
    }
    public List<FrontPageSocialPracticeVODO> getSocialPractice() {
        List<FrontPageSocialPracticeVODO> socialPracticeList = frontPageMapper.selectSocialPractice();
        return socialPracticeList;
    }
}
