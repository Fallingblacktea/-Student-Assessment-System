package com.example.studentcomprehensiveassessmentsystem.service;


import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPull;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPush;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.importStudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class importStudentsService {

    @Autowired
    private importStudentsMapper ImportStudentsMapper;

    public void insertImportStudents(importStudentsDO importStudentsDO) {
        ImportStudentsMapper.insertStudentsInfo(importStudentsDO);
        ImportStudentsMapper.insertUser(importStudentsDO);
        RoleUserDOPull roleUserDOPull = ImportStudentsMapper.selectRoleUser(importStudentsDO);
        RoleUserDOPush roleUserDOPush=new RoleUserDOPush();
        roleUserDOPush.setUser_id(roleUserDOPull.getId());
        roleUserDOPush.setRole_id(3);
        ImportStudentsMapper.insertRoleUser(roleUserDOPush);
    }

    // 其他处理学生信息的逻辑方法
}

