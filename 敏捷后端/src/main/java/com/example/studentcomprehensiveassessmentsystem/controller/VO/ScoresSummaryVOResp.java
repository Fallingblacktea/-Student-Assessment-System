package com.example.studentcomprehensiveassessmentsystem.controller.VO;

import lombok.Data;

@Data
public class ScoresSummaryVOResp {
    private String studentID;
    private String name;
    private String gender;
    private String grade;
    private String classname;
    private String hometown;
    private String contact;
    private String personalSummary;
    private String volunteerService;
    private double GPA;
    private String researchStatus;
    private String studentService;
    private String socialPractice;
    private String summaryScore;
}
