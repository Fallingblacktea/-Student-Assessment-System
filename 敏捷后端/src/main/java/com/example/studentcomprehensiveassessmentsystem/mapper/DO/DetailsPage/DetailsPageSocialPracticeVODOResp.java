package com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage;
import lombok.Data;

@Data
public class DetailsPageSocialPracticeVODOResp {
    private String  name;
    private int  studentID;
    private String  initiatingOrganization;
    private String  location;
    private int  days;
    private int  teamSize;
    private String  teamPosition;
    private boolean  online;
    private boolean  hasAward;
    private String  awardName;
}
