package com.example.studentcomprehensiveassessmentsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Data
public class JwtTokenUtil {


    private String secret="gx4SN/4gh6QPvLfVWCW8Aoo4l2n66d2338IwXyu1koDT1W94XS35OZJPYkA2IIMMgmlz96LCHSNc8jLYuzwB1IreKOZz2TZhsWODfjHAS9bYlduniCUSuSPZ5/OP15O63fn1kN1N5w64frpyWcWbTtiCgLMkJpnfjmqFMAr7fgcOGyt2rmunvFYni9T78Q4fn/0gpx3qm8zXw3oBbFb1Ge9Wnh1UCSapXd/EzLau3iaXqp9f+8FHmSCo9vbEaRSRMPHdcpnB4WKHKySE/BCNSsWM+kHmHyrAbvKErPCz2XXMnIalUoAtquq03LnmYjrBHyI230VcYEVzGmzLOTsSJw==";


    private Long accessTokenExpiration=36000L;


    private Long refreshTokenExpiration=604800L;

    public String generateAccessToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username, accessTokenExpiration);
    }

    public String generateRefreshToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username, refreshTokenExpiration);
    }

    private String doGenerateToken(Map<String, Object> claims, String username, Long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
