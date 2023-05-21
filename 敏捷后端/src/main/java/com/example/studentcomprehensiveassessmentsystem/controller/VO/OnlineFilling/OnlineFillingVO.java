package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OnlineFillingVO {
    private int studentID;
    private String personalSummary;
    private double GPA;
    private List<ResearchStatus> researchStatus;
    private List<StudentService> studentService;
    private List<SocialPractice> socialPractice;

    // 省略构造函数、getter和setter方法
}


