import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import PrismCode from './components/PrismCode.vue'
import  SidebarMenu  from './sidebar.vue'
import './fontawesome'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import SystemRouter from './routes/SystemRoutes'
// import './permission.js' 
import VueSidebarMenu from '../../src'
import { getAccessToken ,removeToken} from './utils/auth'

import LoginView from './User/LoginView.vue'
import RegisterView from './User/RegisterView.vue'
import store from './store';
import {validateAccessToken} from './api/tokenValid'
const router = createRouter({
 history: createWebHashHistory(),
 routes: [
  {
    path: '/login',
    name: 'login',
    component: LoginView,
  },
    //注册的路由
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
  },
  ...SystemRouter
]
})
const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.use(VueSidebarMenu)
app.component('prism-code', PrismCode)
app.component('font-awesome-icon', FontAwesomeIcon)



app.mount('#app')

router.beforeEach(async (to, from, next) => {
  if (getAccessToken()) {
    try {
      const response = await validateAccessToken();
      const tokenValid = response.data;
      // 处理验证结果
      if (tokenValid) {
        if (to.path === '/login' || to.path === '/register') {
          next({ path: '/' });
        } else {
          next();
        }
      } else {
        // 访问令牌失效，重定向到登录路径
        removeToken();
        next({ path: '/login' });
      }
    } catch (error) {
      // 处理错误情况
      console.error('验证访问令牌时发生错误:', error);
    }
  } else {
    // 没有token
    if (to.path === '/login' || to.path === '/register') {
      // 直接进入
      next();
    } else {
      next('/login'); // 否则全部重定向到登录页
    }
  }
});

  
  router.afterEach(() => {
    
  })