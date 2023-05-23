package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.DetailsPageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsPageService {
    private final DetailsPageMapper detailsPageMapper;

    public DetailsPageService(DetailsPageMapper detailsPageMapper) {
        this.detailsPageMapper = detailsPageMapper;
    }

    public DetailsPagePersonalSummaryVODOResp getPersonalSummary(int studentID) {
        DetailsPagePersonalSummaryVODOResp personalSummary = detailsPageMapper.getPersonalSummaryDetailsByStudentID(studentID);
        return personalSummary;
    }

    public DetailsPageVolunteerServiceVODOResp getVolunteerServiceDetails(int studentID) {
        DetailsPageVolunteerServiceVODOResp volunteerServiceDetails = detailsPageMapper.getVolunteerServiceDetailsByStudentID(studentID);
        return volunteerServiceDetails;
    }

    public DetailsPageStudentScoresVODOResp getStudentScoresDetails(int studentID) {
        DetailsPageStudentScoresVODOResp studentScoresDetails = detailsPageMapper.getStudentScoresDetailsByStudentID(studentID);
        return studentScoresDetails;
    }
    public List<DetailsPageResearchStatusVODOResp> getResearchStatusDetails(int studentID) {
        List<DetailsPageResearchStatusVODOResp> ResearchStatusDetails = detailsPageMapper.getResearchStatusDetailsByStudentID(studentID);
        return ResearchStatusDetails;
    }
    public List<DetailsPageStudentServiceVODOResp> getStudentServiceDetails(int studentID) {
        List<DetailsPageStudentServiceVODOResp> StudentServiceDetails = detailsPageMapper.getStudentServiceDetailsByStudentID(studentID);
        return StudentServiceDetails;
    }
    public List<DetailsPageSocialPracticeVODOResp> getSocialPracticeDetails(int studentID) {
        List<DetailsPageSocialPracticeVODOResp> socialPracticeDetails = detailsPageMapper.getSocialPracticeDetailsByStudentID(studentID);
        return socialPracticeDetails;
    }
}

