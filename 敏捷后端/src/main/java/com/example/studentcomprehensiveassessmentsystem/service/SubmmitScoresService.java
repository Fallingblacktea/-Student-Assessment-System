package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores.CheckScoresVODO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores.SubmitScoresVODO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.SubmmitScoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmmitScoresService {
    @Autowired
    private SubmmitScoresMapper submmitScoresMapper;

    public void personalSummaryService(SubmitScoresVODO submitScoresVODO) {
        submmitScoresMapper.updatePersonalSummary(submitScoresVODO);
    }

    public void volunteerServiceService(SubmitScoresVODO submitScoresVODO) {
        submmitScoresMapper.updateVolunteerservice(submitScoresVODO);
    }

    public void studentScoresService(CheckScoresVODO checkScoresVODO) {
        submmitScoresMapper.insertStudentScores(checkScoresVODO);
    }

    public void researchStatusService(SubmitScoresVODO submitScoresVODO) {
        submmitScoresMapper.updateResearchstatus(submitScoresVODO);
    }

    public void studentServiceService(SubmitScoresVODO submitScoresVODO) {
        submmitScoresMapper.updateStudentservice(submitScoresVODO);
    }

    public void socialPracticeService(SubmitScoresVODO submitScoresVODO) {
        submmitScoresMapper.updateSocialpractice(submitScoresVODO);
    }
}
