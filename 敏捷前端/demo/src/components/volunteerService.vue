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