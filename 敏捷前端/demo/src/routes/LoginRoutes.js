//import Vue from 'vue'
import LoginView from '../User/LoginView.vue'
import RegisterView from '../User/RegisterView.vue'
//Vue.use(VueRouter)

const LoginRouter = [
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
]



export default LoginRouter

