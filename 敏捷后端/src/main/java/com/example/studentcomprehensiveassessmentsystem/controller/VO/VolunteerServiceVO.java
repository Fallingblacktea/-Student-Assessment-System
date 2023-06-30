package com.example.studentcomprehensiveassessmentsystem.controller.VO;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class VolunteerServiceVO {
    @ExcelProperty(index = 0)
    private int studentID;
    @ExcelProperty(index = 1)
    private int serviceDuration;
}
