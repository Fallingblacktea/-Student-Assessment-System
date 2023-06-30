import request from '../utils/request'
export function running() {
    return request({
      url: '/menu',
      method: 'get',
    });
  }