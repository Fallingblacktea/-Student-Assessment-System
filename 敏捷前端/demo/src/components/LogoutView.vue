<template>
    <div class="logout-page">
      <h1>退出</h1>
      <p>你确定要退出吗？</p>
      <div class="buttons">
        <button @click="confirmLogout">是</button>
        <button @click="cancelLogout">否</button>
      </div>
    </div>
  </template>
  
  <script>
  import { removeToken } from '../utils/auth';
  export default {
    methods: {
      // 确认退出
      confirmLogout() {
        // 这里执行你的退出逻辑，比如调用Userfront.logout()或者this.$store.dispatch('loginService/logout')
        // 然后重定向到你想要的路径，比如this.$router.push('/')
        removeToken()
        this.$router.push({ path: '/login' })
      },
      // 取消退出
      cancelLogout() {
        // 这里执行你的取消逻辑，比如返回上一页或者跳转到主页
        // 比如
        this.$router.go(-1)
      }
    }
  }
  </script>
  
  <style scoped>
  .logout-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 40vh;
  }
  
  h1 {
    font-size: 36px;
  }
  
  p {
    font-size: 24px;
  }
  
  .buttons {
    display: flex;
    gap: 20px;
  }
  
  button {
    padding: 10px 20px;
    font-size: 18px;
  }
  </style>
  