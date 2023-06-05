package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.ScoresSummaryVOResp;
import com.example.studentcomprehensiveassessmentsystem.service.NodeService;
import com.example.studentcomprehensiveassessmentsystem.service.ScoresSummaryService;
import com.example.studentcomprehensiveassessmentsystem.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoresSummaryController {

    @Autowired
    private ScoresSummaryService scoresSummaryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @GetMapping("/scoresSummary")
    public CommonResult<?> getScoresSummary() {

        List<ScoresSummaryVOResp> scoresSummaryVOResp=scoresSummaryService.service();

        CommonResult<List<ScoresSummaryVOResp>> result = CommonResult.success(scoresSummaryVOResp);
        return result;
    }

}
