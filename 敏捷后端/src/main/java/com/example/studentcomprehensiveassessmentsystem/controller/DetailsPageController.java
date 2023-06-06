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
            @RequestParam int studentID) {

        DetailsPagePersonalSummaryVODOResp result = detailsPageService.getPersonalSummary(studentID);

        return CommonResult.success(result);
    }

    @GetMapping("/volunteerService/details")
    public CommonResult<DetailsPageVolunteerServiceVODOResp> getVolunteerServiceDetails(
            @RequestParam int studentID) {

        DetailsPageVolunteerServiceVODOResp result=detailsPageService.getVolunteerServiceDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/studentScores/details")
    public CommonResult<DetailsPageStudentScoresVODOResp> getStudentScoresDetails(
            @RequestParam int studentID) {

        DetailsPageStudentScoresVODOResp result=detailsPageService.getStudentScoresDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/researchStatus/details")
    public CommonResult<List<DetailsPageResearchStatusVODOResp>> getResearchStatusDetails(
            @RequestParam int studentID) {

        List<DetailsPageResearchStatusVODOResp> result=detailsPageService.getResearchStatusDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/studentService/details")
    public CommonResult<List<DetailsPageStudentServiceVODOResp>> getStudentServiceDetails(
            @RequestParam int studentID) {

        List<DetailsPageStudentServiceVODOResp> result=detailsPageService.getStudentServiceDetails(studentID);
        return CommonResult.success(result);
    }
    @GetMapping("/socialPractice/details")
    public CommonResult<List<DetailsPageSocialPracticeVODOResp>> getSocialPracticeDetails(
            @RequestParam int studentID) {

        List<DetailsPageSocialPracticeVODOResp> result=detailsPageService.getSocialPracticeDetails(studentID);
        return CommonResult.success(result);
    }
}


