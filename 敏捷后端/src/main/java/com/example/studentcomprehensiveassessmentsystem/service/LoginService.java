package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public LoginReqDO service(LoginReqVO loginReqVO){
        return loginMapper.findUser(loginReqVO);
    }
}
