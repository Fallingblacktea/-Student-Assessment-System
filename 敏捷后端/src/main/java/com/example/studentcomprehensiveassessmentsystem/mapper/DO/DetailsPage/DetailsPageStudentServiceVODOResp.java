package com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DetailsPageStudentServiceVODOResp {
    private String name;
    private String studentID;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    private String positionName;
    private String positionTitle;
    private String assessmentLevel;
}
