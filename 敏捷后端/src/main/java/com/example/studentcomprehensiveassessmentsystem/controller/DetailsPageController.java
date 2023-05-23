package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.DetailsPage.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage.*;
import com.example.studentcomprehensiveassessmentsystem.service.DetailsPageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailsPageController {
    private final DetailsPageService detailsPageService;

    public DetailsPageController(DetailsPageService detailsPageService) {
        this.detailsPageService = detailsPageService;
    }

    @GetMapping("/personalSummary/details")
    public CommonResult<DetailsPagePersonalSummaryVODOResp> getPersonalSummaryDetails(
            @RequestBody DetailsPagePersonalSummaryVODOReq request) {
        int studentID = request.getStudentID();
        DetailsPagePersonalSummaryVODOResp result = detailsPageService.getPersonalSummary(studentID);

        return CommonResult.success(result);
    }

    @GetMapping("/volunteerService/details")
    public CommonResult<DetailsPageVolunteerServiceVODOResp> getVolunteerServiceDetails(
            @RequestBody DetailsPageVolunteerServiceVODOReq request) {
        int studentID = request.getStudentID();
        DetailsPageVolunteerServiceVODOResp result=detailsPageService.getVolunteerServiceDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/studentScores/details")
    public CommonResult<DetailsPageStudentScoresVODOResp> getStudentScoresDetails(
            @RequestBody DetailsPageStudentScoresVODOReq request) {
        int studentID = request.getStudentID();
        DetailsPageStudentScoresVODOResp result=detailsPageService.getStudentScoresDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/researchStatus/details")
    public CommonResult<List<DetailsPageResearchStatusVODOResp>> getResearchStatusDetails(
            @RequestBody DetailsPageResearchStatusVODOReq request) {
        int studentID = request.getStudentID();
        List<DetailsPageResearchStatusVODOResp> result=detailsPageService.getResearchStatusDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/studentService/details")
    public CommonResult<List<DetailsPageStudentServiceVODOResp>> getStudentServiceDetails(
            @RequestBody DetailsPageStudentServiceVODOReq request) {
        int studentID = request.getStudentID();
        List<DetailsPageStudentServiceVODOResp> result=detailsPageService.getStudentServiceDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/socialPractice/details")
    public CommonResult<List<DetailsPageSocialPracticeVODOResp>> getSocialPracticeDetails(
            @RequestBody DetailsPageSocialPracticeVODOReq request) {
        int studentID = request.getStudentID();
        List<DetailsPageSocialPracticeVODOResp> result=detailsPageService.getSocialPracticeDetails(studentID);
        return CommonResult.success(result);
    }
}


