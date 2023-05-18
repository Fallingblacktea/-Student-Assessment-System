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

