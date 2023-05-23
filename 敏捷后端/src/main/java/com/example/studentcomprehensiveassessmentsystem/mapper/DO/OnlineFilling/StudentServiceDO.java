package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void setStartTime(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        this.startTime = dateFormat.parse(time);
    }

    // 省略构造函数、getter和setter方法
}
