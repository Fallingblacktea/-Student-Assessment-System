import request from '/src/utils/request'

// 提交excel文档
// export function submit(formData) {
//   const data = {
//     formData,
//   }
//   return request({
//     url: '/importStudents',
//     method: 'post',
//     data: data
//   })
// }
export function importStudentsSubmit(file) {
  return request({
    url: '/importStudents',
    method: 'post',
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}
export function submitfile(file) {
  return request({
    url: '/upload',
    method: 'post',
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}
export function importVSSubmit(file) {
  return request({
    url: '/volunteerService/file',
    method: 'post',
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}
export function onlineFillingSubmit(form){
  return request({
    url: '/onlineFilling',
    method: 'post',
    data: form,
    headers: {
      'Content-Type': 'application/json'
    }
  });
}
export function submitScorePS(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/personalSummary/scores',
    method: 'post',
    data: data
  })
}
export function submitScoreRS(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/researchStatus/scores',
    method: 'post',
    data: data
  })
}
export function submitScoreSP(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/socialPractice/scores',
    method: 'post',
    data: data
  })
}
export function submitScoreSS(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/studentScores/scores',
    method: 'post',
    data: data
  })
}
export function submitScoreSV(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/studentService/scores',
    method: 'post',
    data: data
  })
}
export function submitScoreVS(score,studentID) {
  const data = {
    studentID:studentID,
    scores:score
  }
  return request({
    url: '/volunteerService/scores',
    method: 'post',
    data: data
  })
}