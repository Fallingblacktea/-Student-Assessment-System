package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    @Select("SELECT id,username,password from user "+
            "WHERE username = #{username} "+
            "AND password = #{password} ")
    LoginReqDO findUser(LoginReqVO loginReqVO);

}
