import request from '../utils/request'
export function getPSdata() {
    return request({
      url: '/personalSummary',
      method: 'get',
    });
  }
  export function getVSdata() {
    return request({
      url: '/volunteerService',
      method: 'get',
    });
  }
  export function getSPdata() {
    return request({
      url: '/socialPractice',
      method: 'get',
    });
  }
  export function getSSdata() {
    return request({
      url: '/studentScores',
      method: 'get',
    });
  }
  export function getRSdata() {
    return request({
      url: '/researchStatus',
      method: 'get',
    });
  }
  export function getSVdata() {
    return request({
      url: '/studentService',
      method: 'get',
    });
  }
  export function getSMdata(){
    return request({
      url: '/scoresSummary',
      method: 'get',
    });
  }