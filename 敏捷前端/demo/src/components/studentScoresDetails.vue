<template>
  <div>
    <h3>{{ student.name }}的GPA</h3> 
    <p>{{ student.gpa }}</p>

    <h4>是否正确</h4>
    
    <el-radio-group v-model="present">
      <el-radio label="true">是</el-radio>
      <el-radio label="false">否</el-radio>
    </el-radio-group>

    <el-button type="primary" @click="submitScore">提交</el-button>
    <el-button @click="$router.go(-1)">返回</el-button>
  </div>
</template>

<script>
    import { getSSID } from '/src/api/getIndividualInfo.js'
    import { submitScoreSS as submitScoreToBackend } from '/src/api/submit.js';

export default {
  data() {
    return {
      student: {
        name: '',
        gpa: '',
      },
      present:''
    };
  },
  mounted() {
      const studentID = this.$route.params.studentID;
    this.getStudentInfo(studentID);
  },
  methods: {
    getStudentInfo(studentID) {
      getSSID(studentID).then(response => {
        this.student = response.data;
      });
    },
    submitScore() {
      submitScoreToBackend(this.present, this.$route.params.studentID)
  .then(response => {
    // 显示消息
    this.$message.success(response.data.message);
  })
  .catch(error => {
    // 处理错误
  });  // 在这里执行提交分数的逻辑
      console.log('是否正确:', this.present);
    },
  },
};
</script>
