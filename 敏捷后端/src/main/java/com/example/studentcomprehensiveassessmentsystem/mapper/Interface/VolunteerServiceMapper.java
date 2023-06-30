package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.VolunteerServiceVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPull;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.RoleUserDOPush;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VolunteerServiceMapper {


    @Insert("INSERT INTO volunteerservice(studentID, serviceDuration ) " +
            "VALUES(#{studentID}, #{serviceDuration})")
    void insertVolunteerService(VolunteerServiceVO volunteerServiceVO);



    // 其他数据库操作方法
}
