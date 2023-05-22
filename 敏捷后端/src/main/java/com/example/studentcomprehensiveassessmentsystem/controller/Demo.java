package com.example.studentcomprehensiveassessmentsystem.controller;


import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "演示接口")
@RestController
@RequestMapping("/my-api/demo")
public class Demo {
    @ApiOperation("Hello World接口")
    @GetMapping("/hello")
    public CommonResult<LoginRespVO> hello(@RequestBody @Valid LoginReqVO ReqVO) {
        LoginRespVO RespVO=new LoginRespVO();
        RespVO.setAccessToken("123");
        RespVO.setRefreshToken("321");
        return CommonResult.success(RespVO);
    }
}
