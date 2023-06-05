package com.example.studentcomprehensiveassessmentsystem.controller;


import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginRespVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.LoginMapper;
import com.example.studentcomprehensiveassessmentsystem.service.LoginService;
import com.example.studentcomprehensiveassessmentsystem.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "注册和登录接口")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public CommonResult<LoginRespVO> hello(@RequestBody @Valid LoginReqVO loginReqVO) {
        LoginReqDO loginReqDO = loginService.service(loginReqVO);

        if (loginReqDO == null) {
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }


        String username = loginReqDO.getUsername();

        // 生成访问令牌和刷新令牌
        String accessToken = jwtTokenUtil.generateAccessToken(username);
        String refreshToken = jwtTokenUtil.generateRefreshToken(username);
        LoginRespVO loginRespVO = new LoginRespVO(accessToken,refreshToken);

        CommonResult<LoginRespVO> result = CommonResult.success(loginRespVO);

        return result;
    }
}
