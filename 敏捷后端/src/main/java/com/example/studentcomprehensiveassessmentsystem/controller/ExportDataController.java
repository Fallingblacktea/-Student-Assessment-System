package com.example.studentcomprehensiveassessmentsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
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
    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        try {
            List<ScoresSummaryVOResp> data = scoresSummaryService.service(); // 从数据库获取数据

            // 设置响应头
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=scores_summary.xlsx");

            // 创建 ExcelWriter 对象
            OutputStream outputStream = response.getOutputStream();
            ExcelWriter excelWriter = EasyExcel.write(outputStream, ScoresSummaryVOResp.class).build();

            // 写入数据
            WriteSheet sheet = EasyExcel.writerSheet("Scores Summary").build();
            excelWriter.write(data, sheet);

            // 关闭 ExcelWriter 对象和输出流
            excelWriter.finish();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "Error exporting data to Excel: " + e.getMessage();
            byte[] errorBytes = errorMessage.getBytes();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=error.txt");
            response.getOutputStream().write(errorBytes);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
