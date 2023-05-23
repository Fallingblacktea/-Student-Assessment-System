import request from '/src/utils/request'

  export function getPSID(studentID) {
    return request({
      url: '/personalSummary/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }
  export function getRSID(studentID) {
    return request({
      url: '/researchStatus/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }
  export function getSSID(studentID) {
    return request({
      url: '/studentScores/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }
  export function getSPID(studentID) {
    return request({
      url: '/socialPractice/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }
  export function getSVID(studentID) {
    return request({
      url: '/studentService/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }
  export function getVSID(studentID) {
    return request({
      url: '/socialPractice/details',
      method: 'get',
      data:{
        studentID:studentID
      }
    });
  }