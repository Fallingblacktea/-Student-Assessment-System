package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.FrontPage.*;
import com.example.studentcomprehensiveassessmentsystem.service.FrontPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontPageController {
    @Autowired
    private FrontPageService frontPageService;

    @GetMapping("/personalSummary")
    public CommonResult<List<FrontPagePersonalSummaryVODO>> getPersonalSummary() {
        return CommonResult.success(frontPageService.getPersonalSummary());
    }
    @GetMapping("/researchStatus")
    public CommonResult<List<FrontPageResearchStatusVODO>> getResearchStatus() {
        return CommonResult.success(frontPageService.getResearchStatus());
    }
    @GetMapping("/volunteerService")
    public CommonResult<List<FrontPageVolunteerServiceVODO>> getVolunteerService() {
        return CommonResult.success(frontPageService.getVolunteerService());
    }
    @GetMapping("/studentScores")
    public CommonResult<List<FrontPageStudentScoresVODO>> getStudentScores() {
        return CommonResult.success(frontPageService.getStudentScores());
    }
    @GetMapping("/studentService")
    public CommonResult<List<FrontPageStudentServiceVODO>> getStudentService() {
        return CommonResult.success(frontPageService.getStudentService());
    }
    @GetMapping("/socialPractice")
    public CommonResult<List<FrontPageSocialPracticeVODO>> getSocialPractice() {
        return CommonResult.success(frontPageService.getSocialPractice());
    }
}
