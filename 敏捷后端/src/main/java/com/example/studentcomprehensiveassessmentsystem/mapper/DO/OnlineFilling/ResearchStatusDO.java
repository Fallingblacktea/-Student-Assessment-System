package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// ResearchStatusDO
import lombok.Data;

@Data
public class ResearchStatusDO {

    private int studentId;
    private int ranking;
    private Date time;
    private String location;
    private String award;
    private String level;
    public void setTime(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.time = dateFormat.parse(time);
    }
    // 省略构造函数、getter和setter方法
    // 省略构造函数、getter和setter方法
}
