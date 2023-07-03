<template>
  <div>
    <h2>导入学生名单</h2>
    <input type="file" @change="handleFileUpload">
    <button @click="submitFile">提交</button>
  </div>
</template>

<script>
import { importStudentsSubmit } from '/src/api/submit.js'
import { ElMessage } from 'element-plus';
export default {
  methods: {
    handleFileUpload(event) {
      this.file = event.target.files[0];
    },
    async submitFile() {
      if (this.file) {
        const formData = new FormData();
        formData.append('file', this.file); // 将文件添加到FormData对象中，'file'是服务器端接收文件的字段名
        try {
          const response = await importStudentsSubmit(formData); // 使用submit函数发送FormData对象
          ElMessage.success('上传成功'); // 处理上传成功后的逻辑
        } catch (error) {
          ElMessage.error('上传失败'); // 处理上传失败的逻辑
        }
        // 可以使用 FormData 或其他方式将文件发送到服务器
        console.log("提交文件:", this.file);
      }
    }
  },
  data() {
    return {
      file: null
    };
  }
};
</script>
