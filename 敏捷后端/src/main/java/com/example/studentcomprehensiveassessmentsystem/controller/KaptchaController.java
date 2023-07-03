package com.example.studentcomprehensiveassessmentsystem.controller;

import com.example.studentcomprehensiveassessmentsystem.service.RedisService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class KaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private RedisService redisService;

    @GetMapping("/captcha")
    public void showCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码文本
        String captchaText = defaultKaptcha.createText();

        // 将验证码文本存储在会话中，以供后续验证

        redisService.setValueWithExpiration(request.getSession().getId(),captchaText,60);
        String storedCaptcha = redisService.getValue(request.getSession().getId());
        // 生成验证码图片
        BufferedImage captchaImage = defaultKaptcha.createImage(captchaText);


        // 创建一个名为"SessionID"的Cookie
        Cookie cookie = new Cookie("SessionID", request.getSession().getId());
        // 设置Cookie的有效期，单位为秒
        cookie.setMaxAge(60);
        // 将Cookie添加到响应中
        response.addCookie(cookie);
        // 将验证码图片写入响应
        response.setContentType("image/png");
        try (OutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(captchaImage, "png", outputStream);
            outputStream.flush();
        }
    }
}