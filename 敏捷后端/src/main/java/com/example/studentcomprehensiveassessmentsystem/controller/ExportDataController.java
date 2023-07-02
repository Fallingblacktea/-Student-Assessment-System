package com.example.studentcomprehensiveassessmentsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.ScoresSummaryVOResp;
import com.example.studentcomprehensiveassessmentsystem.service.ScoresSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
public class ExportDataController {
    @Autowired
    private ScoresSummaryService scoresSummaryService;

    @RequestMapping("/exportData")
    public CommonResult<List<ScoresSummaryVOResp>> exportDataToExcel(HttpServletResponse response) throws IOException {
        List<ScoresSummaryVOResp> data = scoresSummaryService.service(); // 从数据库获取数据
        return CommonResult.success(data);

    }
}