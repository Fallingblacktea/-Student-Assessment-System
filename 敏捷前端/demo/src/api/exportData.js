import request from '../utils/request'
export function exportdata() {
    return request({
      url: '/exportData',
      method: 'get',
    });
  }