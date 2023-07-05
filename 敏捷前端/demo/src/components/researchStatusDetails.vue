<template>
  <div>
    <h3>科研情况</h3>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" label="序号" ></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="名次" prop="ranking"></el-table-column>
      <el-table-column label="时间" prop="time"></el-table-column>
      <el-table-column label="地点" prop="location"></el-table-column>
      <el-table-column label="奖项" prop="award"></el-table-column>
      <el-table-column label="级别" prop="level"></el-table-column>
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
    import { getRSID } from '/src/api/getIndividualInfo.js'
    import { submitScoreRS as submitScoreToBackend } from '/src/api/submit.js';

export default {
  data() {
    return {
      tableData: [
        {
          name: '',
          studentID: '',
          ranking: null,
          time: '',
          location: '',
          award: '',
          level: ''
        }
      ],
      score:null,
    };
  },
  mounted() {
      const studentID = this.$route.params.studentID;
    this.getStudentInfo(studentID);
  },
  methods: {
    getStudentInfo(studentID) {
      getRSID(studentID).then(response => {
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
  });
        console.log('提交分数:', this.score);
      },
    },
};
</script>
