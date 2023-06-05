import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import PrismCode from './components/PrismCode.vue'

import './fontawesome'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import LoginRouter from './routes/LoginRoutes'
import SystemRouter from './routes/SystemRoutes'

// import './permission.js' 
import VueSidebarMenu from '../../src'

import { getAccessToken } from './utils/auth'
const router = createRouter({
 history: createWebHashHistory(),
 routes: [
 ...SystemRouter,//用sidebar渲染
 ...LoginRouter//不用sidebar渲染
 ]
})

createApp(App)
 .use(router)
 .use(ElementPlus)
 .use(VueSidebarMenu)
 .component('prism-code', PrismCode)
 .component('font-awesome-icon', FontAwesomeIcon)
 .mount('#app')

//  router.beforeEach((to, from, next) => {
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