package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.VolunteerServiceVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPull;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPush;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.VolunteerServiceMapper;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.importStudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerServiceService {

    @Autowired
    private VolunteerServiceMapper volunteerServiceMapper;

    public void insertVolunteerService(VolunteerServiceVO volunteerServiceVO) {
        volunteerServiceMapper.insertVolunteerService(volunteerServiceVO);
    }

    // 其他处理学生信息的逻辑方法
}
