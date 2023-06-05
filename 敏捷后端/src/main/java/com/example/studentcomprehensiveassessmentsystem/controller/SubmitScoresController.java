package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores.CheckScoresVODO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores.SubmitScoresVODO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage.DetailsPageResearchStatusVODOResp;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.SubmmitScoresMapper;
import com.example.studentcomprehensiveassessmentsystem.service.SubmmitScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubmitScoresController {

    @Autowired
    private SubmmitScoresService submmitScoresService;

    @PostMapping("/personalSummary/scores")
    public CommonResult<String> submitPersonalSummary(
            @RequestBody SubmitScoresVODO request) {

        submmitScoresService.personalSummaryService(request);
        return CommonResult.success("success assessment");
    }

    @PostMapping("/volunteerService/scores")
    public CommonResult<String> submitVolunteerService(
            @RequestBody SubmitScoresVODO request) {

        submmitScoresService.volunteerServiceService(request);
        return CommonResult.success("success assessment");
    }

    @PostMapping("/studentScores/scores")
    public CommonResult<String> submitStudentScores(
            @RequestBody CheckScoresVODO request) {
        System.out.println(request.isCorrect());
        submmitScoresService.studentScoresService(request);
        return CommonResult.success("success assessment");
    }

    @PostMapping("/researchStatus/scores")
    public CommonResult<String> submitResearchStatus(
            @RequestBody SubmitScoresVODO request) {

        submmitScoresService.researchStatusService(request);
        return CommonResult.success("success assessment");
    }

    @PostMapping("/studentService/scores")
    public CommonResult<String> submitStudentService(
            @RequestBody SubmitScoresVODO request) {

        submmitScoresService.studentServiceService(request);
        return CommonResult.success("success assessment");
    }

    @PostMapping("/socialPractice/scores")
    public CommonResult<String> submitSocialPractice(
            @RequestBody SubmitScoresVODO request) {

        submmitScoresService.socialPracticeService(request);
        return CommonResult.success("success assessment");
    }
}
