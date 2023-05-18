package com.example.studentcomprehensiveassessmentsystem.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.importStudentsVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import com.example.studentcomprehensiveassessmentsystem.service.importStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.studentcomprehensiveassessmentsystem.convert.importStudentsConverter.importStudentsVOtoDO;

@RestController
public class ImportStudentsController {

    @Autowired
    private importStudentsService ImportStudentsService;

    @PostMapping("/importStudents")
    public void importStudents(@RequestParam("file") MultipartFile file) throws IOException {
        List<importStudentsVO> studentsList = new ArrayList<>();

        // 使用 EasyExcel 读取 Excel 文件
        EasyExcel.read(file.getInputStream(), importStudentsVO.class, new AnalysisEventListener<importStudentsVO>() {
            @Override
            public void invoke(importStudentsVO student, AnalysisContext analysisContext) {
                // 将每一行的学生信息保存到列表中
                studentsList.add(student);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 所有数据解析完成后的后续处理逻辑
                processStudentsList(studentsList);
            }
        }).sheet().doRead();
    }

    private void processStudentsList(List<importStudentsVO> studentsList) {
        // 遍历学生信息列表，逐个插入到数据库中
        for (importStudentsVO student : studentsList) {
            // 将importStudentsVO对象转化成importStudentsDO对象
            importStudentsDO ImportStudentsDO = importStudentsVOtoDO(student);
            // 插入到数据库中
            ImportStudentsService.insertImportStudents(ImportStudentsDO);
        }
    }

}


