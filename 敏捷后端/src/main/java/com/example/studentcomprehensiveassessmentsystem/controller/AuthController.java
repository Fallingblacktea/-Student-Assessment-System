package com.example.studentcomprehensiveassessmentsystem.controller;



import com.example.studentcomprehensiveassessmentsystem.common.CommonResult;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginRespVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import com.example.studentcomprehensiveassessmentsystem.service.LoginService;
import com.example.studentcomprehensiveassessmentsystem.service.RedisService;
import com.example.studentcomprehensiveassessmentsystem.utils.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Api(tags = "注册和登录接口")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisService redisService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public CommonResult<LoginRespVO> hello(HttpServletRequest request, @RequestParam("captchaText") String captchaText, @RequestBody @Valid LoginReqVO loginReqVO) {
        LoginReqDO loginReqDO = loginService.service(loginReqVO);
        String SessionID=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("SessionID")) {
                    // 获取名为"SessionID"的Cookie的值
                    SessionID = cookie.getValue();
                }
            }
        }

        String storedCaptcha = redisService.getValue(SessionID);
        redisService.deleteValue(SessionID); // 删除会话中的验证码
        if (!captchaText.equalsIgnoreCase(storedCaptcha)) {
            // 验证码错误，显示错误消息
            return CommonResult.error(400,"验证码错误");
        }

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
    @GetMapping ("/validateToken")
    public CommonResult<?> validate(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        boolean expired=isTokenExpired(token);
        return CommonResult.success(expired);
    }
    public  boolean isTokenExpired(String token) {
        String secret=jwtTokenUtil.getSecret();
        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            Claims claims = jws.getBody();
            long expirationTime = claims.getExpiration().getTime();
            long currentTime = System.currentTimeMillis();
            return currentTime <= expirationTime;
        } catch (ExpiredJwtException e) {
            System.out.println("expired");
            return false; // 解析时如果捕获到 ExpiredJwtException 异常，则表示令牌已过期
        } catch (Exception e) {
            System.out.println("unknown");
            return false; // 解析时如果捕获到其他异常，则表示令牌无效
        }
    }

}
