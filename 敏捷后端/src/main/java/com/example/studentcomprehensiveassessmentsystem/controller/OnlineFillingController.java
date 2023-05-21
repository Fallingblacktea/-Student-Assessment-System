package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling.*;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling.*;
import com.example.studentcomprehensiveassessmentsystem.service.OnlineFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onlineFilling")
public class OnlineFillingController {
    @Autowired
    private OnlineFillingService onlineFillingService;



    @PostMapping
    public void onlineFilling(@RequestBody OnlineFillingVO request) {
        // 插入个人陈述表
        PersonalSummaryDO personalSummaryDO = new PersonalSummaryDO();
        personalSummaryDO.setStudentId(request.getStudentID());
        personalSummaryDO.setPersonalSummary(request.getPersonalSummary());
        onlineFillingService.createPersonalSummary(personalSummaryDO);

        // 插入志愿服务表


        // 插入学生成绩表
        StudentScoresDO studentScoresDO = new StudentScoresDO();
        studentScoresDO.setStudentId(request.getStudentID());
        studentScoresDO.setGPA(request.getGPA());
        onlineFillingService.createStudentGrades(studentScoresDO);

        // 插入科研情况表
        for (ResearchStatus researchStatus : request.getResearchStatus()) {
            ResearchStatusDO researchStatusDO = new ResearchStatusDO();
            researchStatusDO.setStudentId(request.getStudentID());
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
            studentServiceDO.setStudentId(request.getStudentID());
            studentServiceDO.setStartTime(studentService.getStartTime());
            studentServiceDO.setPositionName(studentService.getPositionName());
            studentServiceDO.setPositionTitle(studentService.getPositionTitle());
            studentServiceDO.setAssessmentLevel(studentService.getAssessmentLevel());
            onlineFillingService.createStudentService(studentServiceDO);
        }

        // 插入学生社会实践情况表
        for (SocialPractice socialPractice : request.getSocialPractice()) {
            SocialPracticeDO socialPracticeDO = new SocialPracticeDO();
            socialPracticeDO.setStudentId(request.getStudentID());
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

