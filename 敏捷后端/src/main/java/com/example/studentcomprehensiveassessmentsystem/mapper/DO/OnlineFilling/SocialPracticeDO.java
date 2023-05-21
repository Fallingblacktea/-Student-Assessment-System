package com.example.studentcomprehensiveassessmentsystem.mapper.DO.OnlineFilling;

// SocialPracticeDO
import lombok.Data;

@Data
public class SocialPracticeDO {

    private int studentId;
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
