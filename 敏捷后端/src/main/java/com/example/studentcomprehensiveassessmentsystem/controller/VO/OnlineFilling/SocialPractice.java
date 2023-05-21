package com.example.studentcomprehensiveassessmentsystem.controller.VO.OnlineFilling;

import lombok.Data;

// SocialPractice
@Data
public class SocialPractice {

    private String initiatingOrganization;
    private String location;
    private int duration;
    private int teamSize;
    private String teamPosition;
    private boolean isOnline;
    private boolean hasAward;
    private String awardName;

    // 省略构造函数、getter和setter方法
}
