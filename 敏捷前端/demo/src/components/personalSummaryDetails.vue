<template>
    <div>
      <h3>{{ student.name }}的学年总结</h3> 
      <p>{{ student.statement }}</p>
  
      <h4>评分</h4>
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
    import { getPSID } from '/src/api/getIndividualInfo.js'
    import { submitScorePS as submitScoreToBackend } from '/src/api/submit.js';
  export default {
    data() {
      return {//后续student要改成数据库里的studentID
        student: {
          name: '',
          statement: '',
        },
        score: null,
      };
    },
    mounted() {
      const studentID = this.$route.params.studentID;
    this.getStudentInfo(studentID);
  },
    methods: {
      getStudentInfo(studentID) {
      getPSID(studentID).then(response => {
        this.student = response.data;
      });
    },
    submitScore() {
      submitScoreToBackend(this.score, this.student.id)
  .then(response => {
    // 显示消息
    this.$message.success(response.data.message);
  })
  .catch(error => {
    // 处理错误
  });

  },
    },
  };
  </script>
  