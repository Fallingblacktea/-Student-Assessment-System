package com.example.studentcomprehensiveassessmentsystem.convert;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.importStudentsVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.importStudentsDO;

public class importStudentsConverter {
    public static importStudentsDO importStudentsVOtoDO(importStudentsVO vo) {
        importStudentsDO result = new importStudentsDO();
        result.setName(vo.getName());
        result.setGender(vo.getGender());
        result.setStudentId(vo.getStudentId());
        result.setGrade(vo.getGrade());
        result.setClassname(vo.getClassname());
        result.setHometown(vo.getHometown());
        result.setContact(vo.getContact());
        result.setPersonalSummary(0);
        result.setVolunteerService(0);
        result.setGPA(0);
        result.setResearchStatus(0);
        result.setStudentService(0);
        result.setSocialPractice(0);
        result.setSummaryScore(0);
        return result;
    }
}


