package com.example.studentcomprehensiveassessmentsystem.utils;


import com.example.studentcomprehensiveassessmentsystem.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Component
public class NodeFilter implements Filter {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 获取请求的相对路径
        String requestURI = request.getRequestURI();

        // 提取第一个斜杠后的所有字符串或者第一个斜杠后和第二个斜杠之间的字符串
        int firstSlashIndex = requestURI.indexOf('/');
        int secondSlashIndex = requestURI.indexOf('/', firstSlashIndex + 1);

        String extractedString ;
        if (secondSlashIndex >= 0) {
            extractedString = requestURI.substring(firstSlashIndex + 1, secondSlashIndex);
        } else {
            extractedString = requestURI.substring(firstSlashIndex + 1);
        }
        if (extractedString.equals("auth")||extractedString.equals("menu")) {
            // 允许访问接口
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        System.out.println(extractedString);
        //判断请求头
        String authHeader = request.getHeader("Authorization");

        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        List<String> menu = nodeService.nameService(username);

        // 进行提取后的字符串判断
        if (menu.contains(extractedString)) {
            // 允许访问接口
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 不允许访问接口，可以进行相应处理，例如返回错误信息
            servletResponse.getWriter().write("Access Denied");
        }
    }
}
