package com.example.studentcomprehensiveassessmentsystem.mapper.DO.DetailsPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DetailsPageResearchStatusVODOResp {
    private String  name;
    private String studentID;
    private int ranking;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String location;
    private String award;
    private String level;
}
