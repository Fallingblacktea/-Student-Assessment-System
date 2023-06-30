<template>
  <div>
    <h3>学生社会实践情况</h3>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" label="序号"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="发起单位" prop="organization"></el-table-column>
      <el-table-column label="地点" prop="location"></el-table-column>
      <el-table-column label="天数" prop="days"></el-table-column>
      <el-table-column label="团队人数" prop="teamSize"></el-table-column>
      <el-table-column label="团内职务" prop="teamRole"></el-table-column>
      <el-table-column label="是否线上" prop="online"></el-table-column>
      <el-table-column label="是否获得奖励" prop="hasAward"></el-table-column>
      <el-table-column label="奖励名称" prop="awardName"></el-table-column>
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
    import { getSPID } from '/src/api/getIndividualInfo.js'
    import { submitScoreSP as submitScoreToBackend } from '/src/api/submit.js';

export default {
  data() {
    return {
      tableData: [
        {
          name: '',
          studentID: '',
          organization: '',
          location: '',
          days: null,
          teamSize: null,
          teamRole: '',
          online: '',
          hasAward: '',
          awardName: ''
        }
      ],
      score: ''
    };
  },
  mounted() {
      const studentID = this.$route.params.studentID;
    this.getStudentInfo(studentID);
  },
  methods: {
    getStudentInfo(studentID) {
      getSPID(studentID).then(response => {
        this.tableData = response.data;
      });
    },
    submitScore() {
      submitScoreToBackend(this.score, this.$route.params.studentID)
  .then(response => {
    // 显示消息
    this.$message.success(response.data.message);
  })
  .catch(error => {
    // 处理错误
  });  // 在这里执行提交分数的逻辑
      console.log('提交分数:', this.score);
    }
  }
};
</script>
