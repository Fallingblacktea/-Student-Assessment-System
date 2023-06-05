package com.example.studentcomprehensiveassessmentsystem.controller.VO.SubmitScores;

import lombok.Data;

import lombok.Data;

@Data
public class CheckScoresVODO {
    private String studentID;
    private boolean correct;

    public boolean isCorrect() {
        return this.correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

