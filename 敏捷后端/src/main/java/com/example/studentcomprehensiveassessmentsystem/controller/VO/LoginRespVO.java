package com.example.studentcomprehensiveassessmentsystem.controller.VO;

import lombok.Data;

@Data
public class LoginRespVO {
    private String accessToken;
    private String refreshToken;
}
