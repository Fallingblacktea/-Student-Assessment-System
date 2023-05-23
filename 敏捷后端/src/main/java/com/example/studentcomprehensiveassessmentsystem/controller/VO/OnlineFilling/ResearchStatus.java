package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// ResearchStatus
@Data
public class ResearchStatus {

    private int ranking;
    private String time;
    private String location;
    private String award;
    private String level;

}
