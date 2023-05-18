package com.example.studentcomprehensiveassessmentsystem.controller.VO;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class importStudentsVO {
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
    // 省略getter和setter方法
}

