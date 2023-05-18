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
export function submit(file) {
  return request({
    url: '/importStudents',
    method: 'post',
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}


