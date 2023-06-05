package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.ScoresSummaryVOResp;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoresSummaryMapper {
    @Select("SELECT studentID,name,gender,grade,classname,hometown,contact,personalSummary," +
            "volunteerService,GPA,researchStatus,studentService,socialPractice,summaryScore from studentsinfo ")
    List<ScoresSummaryVOResp> getScoresSummary();

}
