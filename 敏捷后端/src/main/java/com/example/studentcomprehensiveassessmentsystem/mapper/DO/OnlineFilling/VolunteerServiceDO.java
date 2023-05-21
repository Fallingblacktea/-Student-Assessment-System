package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

import java.util.Date;

import lombok.Data;

@Data
public class VolunteerServiceDO {

    private int studentId;
    private Date startTime;
    private String positionName;
    private String positionTitle;
    private String assessmentLevel;

    // 省略构造函数、getter和setter方法
}
