import request from '../utils/request'
// 用户登录
export function login(username, password,captchaText) {
  const data = {
    username,
    password
  }
  return request({
    url: '/auth/login',
    method: 'post',
    data: data,
    params: {
      captchaText
    }
  })
}
//接收验证码
export function getCaptcha() {
  return request({
    url: '/captcha',
    method: 'get',
    responseType: 'blob',
    withCredentials: true // 设置withCredentials为true来处理Cookie
  })
};
//用户注册
export function register(name,idCard,password,phone,email) {
  const data = {
    name,
    idCard,
    password,
    phone,
    email
  }
  return request({
    url: '/auth/register',
    method: 'post',
    data: data
  })
}
// 获取用户信息
export function getInfo() {
  return request({
    url: '/profile/get',
    method: 'get'
  })
}