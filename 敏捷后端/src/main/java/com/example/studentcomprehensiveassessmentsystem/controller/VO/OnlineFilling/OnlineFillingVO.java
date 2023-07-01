package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class OnlineFillingVO {

    private String personalSummary;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Double GPA;
    private ResearchStatus[] researchStatus;
    private StudentService[] studentService;
    private SocialPractice[] socialPractice;

    public Double getGPA() {
        return this.GPA;
    }

    public void setCorrect(Double GPA) {
        this.GPA = GPA;
    }


    // 省略构造函数、getter和setter方法
}


