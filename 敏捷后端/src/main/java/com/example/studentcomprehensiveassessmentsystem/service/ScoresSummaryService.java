package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.ScoresSummaryVOResp;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.LoginMapper;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.ScoresSummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresSummaryService {
    @Autowired
    private ScoresSummaryMapper scoresSummaryMapper;

    public List<ScoresSummaryVOResp> service(){
        return scoresSummaryMapper.getScoresSummary();
    }
}
