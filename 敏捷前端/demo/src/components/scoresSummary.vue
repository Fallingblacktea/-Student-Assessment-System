<template>
  <div>
    
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="序号" prop="index"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="性别" prop="gender"></el-table-column>
      <el-table-column label="年级" prop="grade"></el-table-column>
      <el-table-column label="班级" prop="class"></el-table-column>
      <el-table-column label="籍贯" prop="nativePlace"></el-table-column>
      <el-table-column label="联系方式" prop="phone"></el-table-column>
      <el-table-column label="个人学年总结评分" prop="personalSummary"></el-table-column>
      <el-table-column label="志愿服务评分" prop="volunteerService"></el-table-column>
      <el-table-column label="GPA" prop="GPA"></el-table-column>
      <el-table-column label="科研情况评分" prop="researchStatus"></el-table-column>
      <el-table-column label="学生骨干服务岗位评分" prop="studentService"></el-table-column>
      <el-table-column label="社会实践评分" prop="socialPractice"></el-table-column>
      <el-table-column label="总分" prop="total"></el-table-column>
      <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 30]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tableData.length">
    </el-pagination>
      

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
    import { getSMdata } from '/src/api/getTableData.js'

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
      getSMdata()
    .then((response) => {
      const resultData = response.data; // 获取commonResult的data部分
      this.tableData = resultData.map((item, index) => ({
        index: index + 1, // 自增的序号
        studentID: item.studentID,
        name: item.name,
        gender:item.gender,
        grade:item.grade,
        class:item.classname,
        nativePlace:item.hometown,
        phone:item.contact,
        personalSummary:item.personalSummary,
        volunteerService:item.volunteerService,
        GPA:item.gpa,
        researchStatus:item.researchStatus,
        studentService:item.studentService,
        socialPractice:item.socialPractice
      }));
    })
    .catch((error) => {
      // 处理错误
      console.error(error);
    });
  }}}
  </script>
  