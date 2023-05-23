package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OnlineFillingVO {
    private int studentID;
    private String personalSummary;
    private double GPA;
    private ResearchStatus[] researchStatus;
    private StudentService[] studentService;
    private SocialPractice[] socialPractice;



    // 省略构造函数、getter和setter方法
}


