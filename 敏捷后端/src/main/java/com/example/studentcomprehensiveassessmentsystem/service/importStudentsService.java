package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.importStudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class importStudentsService {

    @Autowired
    private importStudentsMapper ImportStudentsMapper;

    public void insertImportStudents(importStudentsDO importStudentsDO) {
        ImportStudentsMapper.insert(importStudentsDO);
    }

    // 其他处理学生信息的逻辑方法
}

