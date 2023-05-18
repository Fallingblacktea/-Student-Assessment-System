<template>
  <div>
    
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="性别" prop="gender"></el-table-column>
      <el-table-column label="年级" prop="grade"></el-table-column>
      <el-table-column label="班级" prop="class"></el-table-column>
      <el-table-column label="籍贯" prop="nativePlace"></el-table-column>
      <el-table-column label="联系方式" prop="phone"></el-table-column>
      <el-table-column label="个人学年总结评分" prop="personalSummery"></el-table-column>
      <el-table-column label="志愿服务评分" prop="volunteerService"></el-table-column>
      <el-table-column label="GPA" prop="GPA"></el-table-column>
      <el-table-column label="科研情况评分" prop="researchStatus"></el-table-column>
      <el-table-column label="学生骨干服务岗位评分" prop="studentService"></el-table-column>
      <el-table-column label="社会实践评分" prop="socialPractice"></el-table-column>
      <el-table-column label="总分" prop="total"></el-table-column>
      

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
  export default {
    data() {
      return {
        tableData: [
  {
    studentID: '001',
    name: '张三',
    gender: '男',
    grade: '一年级',
    class: '1班',
    nativePlace: '北京',
    phone: '123456',
    personalSummery: 90,
    volunteerService: 80,
    GPA: 3.5,
    researchStatus: 85,
    studentService: 75,
    socialPractice: 95,
    total: 510
  },
  {
    studentID: '002',
    name: '李四',
    gender: '女',
    grade: '二年级',
    class: '2班',
    nativePlace: '上海',
    phone: '234567',
    personalSummery: 85,
    volunteerService: 90,
    GPA: 3.8,
    researchStatus: 80,
    studentService: 85,
    socialPractice: 90,
    total: 515
  },
  // 其他学生数据
],
        
        currentPage: 1,
        pageSize: 10
      };
    },
    
  };
  </script>
  