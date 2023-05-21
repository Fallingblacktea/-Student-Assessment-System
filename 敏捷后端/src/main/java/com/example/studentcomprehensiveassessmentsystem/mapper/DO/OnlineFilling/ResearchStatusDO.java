package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

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

    // 省略构造函数、getter和setter方法
}
