<template>
  <div>
    <h3>请导入志愿时长：</h3>
    <input type="file" @change="handleFileUpload">
    <button @click="submitFile">提交</button>
    <div class="empty-space"></div>
    <h3>请进行测评：</h3>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="序号" prop="index"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="测评状态" prop="status"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="primary" @click="goToDetails(scope.row.studentID)">测评</el-button>
        </template>
      </el-table-column>

    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 30]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tableData.length">
    </el-pagination>
  </div>
</template>

  
  <script >
    import { getVSdata } from '/src/api/getTableData.js'
    import { ElMessage } from 'element-plus'
    import { importVSSubmit } from '/src/api/submit.js';
  export default {
    data() {
    return {
      tableData: [],
      currentPage: 1,
      pageSize: 10,
      counter: 1, // 自增的序号起始值
    };
  },
  mounted() {
    this.fetchData();
  },
    methods: {
      handleFileUpload(event) {
      this.file = event.target.files[0];
    },
    async submitFile() {
      if (this.file) {
        const formData = new FormData();
        formData.append('file', this.file); // 将文件添加到FormData对象中，'file'是服务器端接收文件的字段名
        try {
          const response = await importVSSubmit(formData); // 使用submit函数发送FormData对象
          ElMessage.success('上传成功'); // 处理上传成功后的逻辑
        } catch (error) {
          ElMessage.error('上传失败'); // 处理上传失败的逻辑
        }
        // 可以使用 FormData 或其他方式将文件发送到服务器
        console.log("提交文件:", this.file);
      }
    },
      fetchData() {
      // 调用后端接口获取数据
      getVSdata()
    .then((response) => {
      const resultData = response.data; // 获取commonResult的data部分
      this.tableData = resultData.map((item, index) => ({
        index: index + 1, // 自增的序号
        studentID: item.studentID,
        name: item.name,
        status: item.volunteerService ? '已测评' : '未测评',
      }));
    })
    .catch((error) => {
      // 处理错误
      console.error(error);
    });
    },
      goToDetails(studentID) {
        const route = { name: 'volunteerServiceDetails', params: { studentID: studentID } };
        
        this.$router.push(route);
        console.log("123");
}
,

      updateStatus(row) {
        // 在这里执行修改测评状态的逻辑
        // 根据row对象中的信息来更新状态
        console.log('修改状态:', row);
      },
      handleSizeChange(size) {
        this.pageSize = size;
      },
      handleCurrentChange(page) {
        this.currentPage = page;
      }
    }
  };
  </script>
  <style>
  .empty-space {
  margin-bottom: 1em; /* 可根据需要调整空白的大小 */
}

</style>