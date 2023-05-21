package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import lombok.Data;

import java.util.Date;

// ResearchStatus
@Data
public class ResearchStatus {

    private int ranking;
    private Date time;
    private String location;
    private String award;
    private String level;

    // 省略构造函数、getter和setter方法
}
