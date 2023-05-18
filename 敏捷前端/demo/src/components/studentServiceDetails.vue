<template>
  <div>
    <h3>学生骨干服务岗位</h3>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" label="序号"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="起始时间" prop="startTime"></el-table-column>
      <el-table-column label="服务岗位名称" prop="position"></el-table-column>
      <el-table-column label="职务" prop="duty"></el-table-column>
      <el-table-column label="考核级别" prop="assessment"></el-table-column>
    </el-table>
    <el-input
      v-model="score"
      placeholder="请输入分数(1-10)"
      style="width: 200px;"
    ></el-input>

    <el-button type="primary" @click="submitScore">提交</el-button>
    <el-button @click="$router.go(-1)">返回</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        {
          name: 'John',
          studentID: '12345',
          startTime: '2022-01-01',
          position: '部门A',
          duty: '职务A',
          assessment: 'A级'
        }
      ],
      score: ''
    };
  },
  methods: {
    submitScore() {
      // 在这里执行提交分数的逻辑
      console.log('提交分数:', this.score);
    }
  }
};
</script>
