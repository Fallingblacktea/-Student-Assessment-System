package com.example.studentcomprehensiveassessmentsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
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

            // 创建ExcelWriter对象
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ExcelWriter excelWriter = EasyExcel.write(outputStream).build();

            // 设置表头
            WriteSheet writeSheet = EasyExcel.writerSheet(0, "Scores Summary").build();
            excelWriter.write(data, writeSheet);

            // 关闭ExcelWriter对象
            excelWriter.finish();

            // 获取Excel文件内容
            byte[] fileBytes = outputStream.toByteArray();

            // 返回Excel文件给前端
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "scores_summary.xlsx");
            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String errorMessage = "Error exporting data to Excel";
        byte[] errorBytes = errorMessage.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("error.txt").build());

        return new ResponseEntity<>(errorBytes, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
