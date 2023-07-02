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
          <div class="captcha-container">
            <div class="captcha-wrapper">
              <img :src="captchaImageUrl" alt="Captcha" @click="refreshCaptcha" style="cursor: pointer;">
            </div>
            <div class="captcha-input">
              <input type="text" name="captchaText" v-model="loginForm.captchaText" placeholder="请输入验证码">
            </div>
          </div>
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
import { setToken } from '../utils/auth'

export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        captchaText: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        captchaText: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
      },
      loading: false,
      captchaImageUrl: 'http://localhost:28080/captcha'
    }
  },

  methods: {
    do_login() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.loading = true;
          login(this.loginForm.username, this.loginForm.password, this.loginForm.captchaText)
            .then(res => {
              const code = res.code;
              if (code === 200){
                setToken(res.data.accessToken);
              this.$router.push({ path: '/' });
              // 更新验证码图片URL
      this.captchaImageUrl = '';
      this.$nextTick(() => {
        this.captchaImageUrl = 'http://localhost:28080/captcha?' + Date.now();
      });
            }else if (code === 400){
              this.$message.error('验证码错误');
              this.loading = false;
              // 更新验证码图片URL
      this.captchaImageUrl = '';
      this.$nextTick(() => {
        this.captchaImageUrl = 'http://localhost:28080/captcha?' + Date.now();
      });
            }
            else if (code === 50007){
              this.$message.error('用户名或密码错误');
              this.loading = false;
              // 更新验证码图片URL
      this.captchaImageUrl = '';
      this.$nextTick(() => {
        this.captchaImageUrl = 'http://localhost:28080/captcha?' + Date.now();
      });
            }
            })
            .catch(() => {
              this.$message.error('未知错误');
              this.loading = false;
            });
        }
      });
    },
    refreshCaptcha() {
      // 更新验证码图片URL
      this.captchaImageUrl = '';
      this.$nextTick(() => {
        this.captchaImageUrl = 'http://localhost:28080/captcha?' + Date.now();
      });
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
.captcha-container {
  text-align: center;
  margin-bottom: 20px;
}

.captcha-wrapper {
  margin-bottom: 10px;
}

.captcha-input {
  text-align: center;
}
}


  </style>