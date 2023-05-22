package com.example.studentcomprehensiveassessmentsystem.controller.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@ApiModel(description = "用户登录请求")
public class LoginReqVO {

    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度不正确")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "用户名为身份证号，只能为数字以及字母")

    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度为 6-20 位")

    private String password;
}
