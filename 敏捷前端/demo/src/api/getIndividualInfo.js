import request from '../utils/request'

  export function getPSID(studentID) {
    return request({
      url: '/personalSummary/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }
  export function getRSID(studentID) {
    return request({
      url: '/researchStatus/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }
  export function getSSID(studentID) {
    return request({
      url: '/studentScores/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }
  export function getSPID(studentID) {
    return request({
      url: '/socialPractice/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }
  export function getSVID(studentID) {
    return request({
      url: '/studentService/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }
  export function getVSID(studentID) {
    return request({
      url: '/volunteerService/details',
      method: 'get',
      params: {
        studentID
      }
    });
  }