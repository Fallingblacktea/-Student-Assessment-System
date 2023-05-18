package com.example.studentcomprehensiveassessmentsystem.mapper.DO;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
public class importStudentsDO {
    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private String gender;

    @ExcelProperty(index = 2)
    private String studentId;

    @ExcelProperty(index = 3)
    private String grade;

    @ExcelProperty(index = 4)
    private String classname;

    @ExcelProperty(index = 5)
    private String hometown;

    @ExcelProperty(index = 6)
    private String contact;

    @ExcelProperty(index = 7)
    private double personalSummary;

    @ExcelProperty(index = 8)
    private double GPA;

    @ExcelProperty(index = 9)
    private double volunteerService;

    @ExcelProperty(index = 10)
    private double researchStatus;

    @ExcelProperty(index = 11)
    private double studentService;

    @ExcelProperty(index = 12)
    private double socialPractice;

    @ExcelProperty(index = 13)
    private double summaryScore;

    // 省略setter和getter方法
}

