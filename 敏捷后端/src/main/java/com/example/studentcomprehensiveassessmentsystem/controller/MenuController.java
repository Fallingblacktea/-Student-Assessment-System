package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.service.NodeService;
import com.example.studentcomprehensiveassessmentsystem.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping("/menu")
    public CommonResult<?> getMenu(@RequestHeader("Authorization") String authHeader) {

        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        int[] menu = nodeService.idService(username);

        CommonResult<int[]> result = CommonResult.success(menu);
        return result;
    }

}
