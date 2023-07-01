package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling.*;
import com.example.studentcomprehensiveassessmentsystem.service.OnlineFillingService;
import com.example.studentcomprehensiveassessmentsystem.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/onlineFilling")
public class OnlineFillingController {
    @Autowired
    private OnlineFillingService onlineFillingService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public void onlineFilling(@RequestHeader("Authorization") String authHeader,@RequestBody OnlineFillingVO request) throws ParseException {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        int studentID = Integer.parseInt(jwtTokenUtil.getUsernameFromToken(token));

        // 插入个人陈述表
        PersonalSummaryDO personalSummaryDO = new PersonalSummaryDO();
        personalSummaryDO.setStudentId(studentID);
        personalSummaryDO.setPersonalSummary(request.getPersonalSummary());
        onlineFillingService.createPersonalSummary(personalSummaryDO);

        // 修改GPA
        StudentScoresDO studentScoresDO = new StudentScoresDO();
        studentScoresDO.setStudentId(studentID);
        System.out.println(request.getGPA());
        studentScoresDO.setGPA(request.getGPA());
        onlineFillingService.createStudentScores(studentScoresDO);

        // 插入科研情况表
        for (ResearchStatus researchStatus : request.getResearchStatus()) {
            ResearchStatusDO researchStatusDO = new ResearchStatusDO();
            researchStatusDO.setStudentId(studentID);
            researchStatusDO.setRanking(researchStatus.getRanking());
            researchStatusDO.setTime(researchStatus.getTime());
            researchStatusDO.setLocation(researchStatus.getLocation());
            researchStatusDO.setAward(researchStatus.getAward());
            researchStatusDO.setLevel(researchStatus.getLevel());
            onlineFillingService.createResearchStatus(researchStatusDO);
        }

        // 插入学生骨干服务岗位表
        for (StudentService studentService : request.getStudentService()) {
            StudentServiceDO studentServiceDO = new StudentServiceDO();
            studentServiceDO.setStudentId(studentID);
            studentServiceDO.setStartTime(studentService.getStartTime());
            studentServiceDO.setPositionName(studentService.getPositionName());
            studentServiceDO.setPositionTitle(studentService.getPositionTitle());
            studentServiceDO.setAssessmentLevel(studentService.getAssessmentLevel());
            onlineFillingService.createStudentService(studentServiceDO);
        }

        // 插入学生社会实践情况表
        for (SocialPractice socialPractice : request.getSocialPractice()) {
            SocialPracticeDO socialPracticeDO = new SocialPracticeDO();
            socialPracticeDO.setStudentId(studentID);
            socialPracticeDO.setInitiatingOrganization(socialPractice.getInitiatingOrganization());
            socialPracticeDO.setLocation(socialPractice.getLocation());
            socialPracticeDO.setDuration(socialPractice.getDuration());
            socialPracticeDO.setTeamSize(socialPractice.getTeamSize());
            socialPracticeDO.setTeamPosition(socialPractice.getTeamPosition());
            socialPracticeDO.setOnline(socialPractice.isOnline());
            socialPracticeDO.setHasAward(socialPractice.isHasAward());
            socialPracticeDO.setAwardName(socialPractice.getAwardName());
            onlineFillingService.createSocialPractice(socialPracticeDO);

        }
    }
}

