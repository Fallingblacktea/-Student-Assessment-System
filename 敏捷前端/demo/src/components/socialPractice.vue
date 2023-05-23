<template>
  <div>
    
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="序号" prop="index"></el-table-column>
      <el-table-column label="学号" prop="studentId"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="测评状态" prop="status"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="primary" @click="goToDetails(scope.row.studentId)">测评</el-button>
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

  
  <script>
   import { getSPdata } from '/src/api.getTableData.js'
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
      getPSdata()
    .then((response) => {
      const resultData = response.data; // 获取commonResult的data部分
      this.tableData = resultData.map((item, index) => ({
        index: index + 1, // 自增的序号
        studentId: item.studentId,
        name: item.name,
        status: item.socialPractice ? '已测评' : '未测评',
      }));
    })
    .catch((error) => {
      // 处理错误
      console.error(error);
    });
    },
      goToDetails(studentId) {
        const route = { name: 'socialPracticeDetails', params: { studentId: studentId } };
        
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
  