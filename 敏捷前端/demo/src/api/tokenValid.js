import request from '../utils/request'
export function validateAccessToken()
{
    return request({
        url: '/auth/validateToken',
        method: 'get',
      });
}