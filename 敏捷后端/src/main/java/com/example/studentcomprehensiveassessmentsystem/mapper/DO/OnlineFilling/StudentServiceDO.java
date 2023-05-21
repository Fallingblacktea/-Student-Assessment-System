package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

import java.util.Date;

// StudentServiceDO
import lombok.Data;

@Data
public class StudentServiceDO {

    private int studentId;
    private Date startTime;
    private String positionName;
    private String positionTitle;
    private String assessmentLevel;

    // 省略构造函数、getter和setter方法
}
