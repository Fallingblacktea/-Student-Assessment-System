import request from '/src/utils/request'

export function getPSData() {
    return request({
      url: '/personalSummary',
      method: 'get',
    });
  }
  export function getVSData() {
    return request({
      url: '/volunteerService',
      method: 'get',
    });
  }
  export function getSPData() {
    return request({
      url: '/socialPractice',
      method: 'get',
    });
  }
  export function getSSData() {
    return request({
      url: '/studentScores',
      method: 'get',
    });
  }
  export function getRSData() {
    return request({
      url: '/researchStatus',
      method: 'get',
    });
  }
  export function getSVData() {
    return request({
      url: '/studentService',
      method: 'get',
    });
  }