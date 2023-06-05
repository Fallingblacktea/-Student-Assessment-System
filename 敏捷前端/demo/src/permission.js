// import LoginRouter from './routes/LoginRoutes'
// import SystemRouter from './routes/SystemRoutes'
// import { createRouter, createWebHashHistory } from 'vue-router'
// import { getAccessToken } from './utils/auth'
// const router = createRouter({
//     history: createWebHashHistory(),
//     routes: [
//     ...SystemRouter,//用sidebar渲染
//     ...LoginRouter//不用sidebar渲染
//     ]
//    })
// router.beforeEach((to, from, next) => {
//     if (getAccessToken()) {
//       if (to.path === '/login'||to.path === '/register') {
//         next({ path: '/' })
//       } 
//       next()
//     } else {
//       // 没有token
//       if (to.path === '/login'||to.path === '/register') {
//         // 直接进入
//         next()
//       } else {
//         next('/login') // 否则全部重定向到登录页
//       }
//     }
//   })
  
//   router.afterEach(() => {
    
//   })