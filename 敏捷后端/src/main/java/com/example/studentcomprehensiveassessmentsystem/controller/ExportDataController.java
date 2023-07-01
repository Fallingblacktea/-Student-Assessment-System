package com.example.studentcomprehensiveassessmentsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.ScoresSummaryVOResp;
import com.example.studentcomprehensiveassessmentsystem.service.ScoresSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
public class ExportDataController {
    @Autowired
    private ScoresSummaryService scoresSummaryService;

    @GetMapping("/exportData")
    public ResponseEntity<byte[]> exportDataToExcel() {
        try {
            List<ScoresSummaryVOResp> data = scoresSummaryService.service(); // 从数据库获取数据

            // 创建 ExcelWriter 对象
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            EasyExcel.write(outputStream, ScoresSummaryVOResp.class).sheet("Scores Summary").doWrite(data);

            // 获取 Excel 文件内容
            byte[] fileBytes = outputStream.toByteArray();

            // 返回 Excel 文件给前端
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("scores_summary.xlsx").build());
            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "Error exporting data to Excel: " + e.getMessage();
            byte[] errorBytes = errorMessage.getBytes();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));

            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("error.txt").build());
            return new ResponseEntity<>(errorBytes, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
