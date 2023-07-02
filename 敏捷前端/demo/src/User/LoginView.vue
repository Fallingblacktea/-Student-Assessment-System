<template>
  <div class="login-container">
    <div class="login-box">
      <div class="login-form">
        <h1>用户登录</h1>
        <el-form ref="form" :model="loginForm" :rules="rules" label-position="left" label-width="0">
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item prop="captcha">
            <img src="http://localhost:28080/captcha" alt="Captcha">
            <input type="text" name="captchaText" v-model="loginForm.captcha" placeholder="请输入验证码">
          </el-form-item>
        </el-form>
        <div class="button-container">
          <el-button type="primary" @click="do_login" :loading="loading">登录</el-button>
          <el-button type="primary" @click="$router.push('/register')">注册</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
import { login } from '../api/login.js'
import {setToken} from '../utils/auth'
  export default {
    data() {
      return {
        loginForm: {
          username: '',
          password: '',
          captcha: ''
        },
        rules: {
          username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
          captcha: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
        },
        loading: false,
        captchaImageUrl: '' // 添加验证码图片地址属性
      }
    },
    created() {
    this.refreshCaptcha() // 在组件创建时获取验证码图片地址
  },
    methods: {
      do_login() {
        this.$refs.form.validate(valid => {
          if (valid) {
            this.loading = true
            //发起网络请求，登录，如果登陆成功，跳转到主页面
            login(this.loginForm.username,this.loginForm.password,this.loginForm.captcha).then(res =>{
            setToken(res.data.accessToken)
            this.$router.push({ path: '/' })
            }).catch(() => {
              // 登录失败，显示错误提示
              this.$message.error('用户名或密码错误')
              this.loading = false
            })
          }
        })
      }
    }
  }
  </script>
  
  <style lang="scss">
  .button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
.login-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login-form .el-button {
  margin: 0 10px;
}
.login-box {
  width: 400px;
  height: 400px;
  border-radius: 5px;
  box-shadow: 0px 0px 10px #ccc;
}
.login-logo {
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;

img {
    height: 80%;
}
}
.login-form {
padding:20px;
text-align:center;

h1 {
font-size:40px;
margin-bottom:20px;
text-align:center;
}
}


  </style>