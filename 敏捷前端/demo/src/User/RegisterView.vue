<template>
    <div class="register-container">
      <div class="register-box">
        <div class="register-form">
          <h1>用户注册</h1>
          <el-form ref="form" :model="registerForm" :rules="rules" label-position="left" label-width="0">
            <el-form-item prop="username">
              <el-input v-model="registerForm.idCard" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input type="password" v-model="registerForm.password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item prop="name">
              <el-input type="name" v-model="registerForm.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item prop="phone">
              <el-input type="phone" v-model="registerForm.phone" placeholder="请输入手机号"></el-input>
            </el-form-item>
            <el-form-item prop="email">
              <el-input type="email" v-model="registerForm.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="do_register" :loading="loading">注册</el-button>
              <el-button type="primary" @click="$router.push('/login')">返回</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
</template>
<script>
import { register } from '../api/login.js'

  export default {
    data() {
      return {
        registerForm: {
          idCard: '',
          password: '',
          name:'',
          phone:'',
          email:''
        },
        rules: {
          idCard: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
          name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
          phone: [{ required: true, message: '请输入手机号', trigger: 'blur' }],
          email: [{ required: true, message: '请输入邮箱', trigger: 'blur' }]
        },
        loading: false
      }
    },
    methods: {
      do_register() {
            this.$refs.form.validate(valid => {
          if (valid) {
            this.loading = true
            //发起网络请求，登录，如果登陆成功，跳转到主页面
            register(this.registerForm.name,this.registerForm.idCard,this.registerForm.password,this.registerForm.phone,this.registerForm.email)
            .then(res =>{
                this.$message.success('注册成功，即将跳转...')
                setTimeout(() => {
                // 跳转到指定页面
                this.$router.push('/login')
                }, 2000) // 延时2秒
            }).catch(() => {
              // 登录失败，显示错误提示
              this.$message.error('注册失败')
              this.loading = false
            })
          }
        })
    
    }
    }
  }
  
  </script>
  
  <style lang="scss">
  .register-container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  
    .register-box {
      width: 400px;
      height: 580px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px #ccc;
  
      .register-logo {
        height: 100px;
        display: flex;
        justify-content: center;
        align-items: center;
  
        img {
          height: 80%;
        }
      }
  
      .register-form {
        padding: 20px;
  
        h3 {
          font-size: 24px;
          margin-bottom: 20px;
          text-align: center;
        }
      }
    }
  }
  </style>