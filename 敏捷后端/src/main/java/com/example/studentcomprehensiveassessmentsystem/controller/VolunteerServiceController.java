package com.example.studentcomprehensiveassessmentsystem.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.VolunteerServiceVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.importStudentsVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;
import com.example.studentcomprehensiveassessmentsystem.service.VolunteerServiceService;
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
public class VolunteerServiceController {

    @Autowired
    private VolunteerServiceService volunteerServiceService;

    @PostMapping("/volunteerService/file")
    public CommonResult<String> VolunteerServiceFile(@RequestParam("file") MultipartFile file) throws IOException {
        List<VolunteerServiceVO> studentsList = new ArrayList<>();

        // 使用 EasyExcel 读取 Excel 文件
        EasyExcel.read(file.getInputStream(), VolunteerServiceVO.class, new AnalysisEventListener<VolunteerServiceVO>() {
            @Override
            public void invoke(VolunteerServiceVO student, AnalysisContext analysisContext) {
                // 将每一行的学生信息保存到列表中
                studentsList.add(student);

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 所有数据解析完成后的后续处理逻辑
                processStudentsList(studentsList);
            }
        }).sheet().doRead();
        return  CommonResult.success("Successful Import");
    }

    private void processStudentsList(List<VolunteerServiceVO> studentsList) {
        // 遍历学生信息列表，逐个插入到数据库中
        for (VolunteerServiceVO student : studentsList) {
            // 将importStudentsVO对象转化成importStudentsDO对象

            // 插入到数据库中
            volunteerServiceService.insertVolunteerService(student);
        }
    }

}
