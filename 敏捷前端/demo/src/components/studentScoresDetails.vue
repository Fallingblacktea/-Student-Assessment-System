<template>
  <div>
    <h3>{{ student.name }}的GPA</h3> 
    <p>{{ student.gpa }}</p>

    <h4>是否正确</h4>
    
    <el-radio-group v-model="isCorrect">
      <el-radio label="true">是</el-radio>
      <el-radio label="false">否</el-radio>
    </el-radio-group>

    <el-button type="primary" @click="submitScore">提交</el-button>
    <el-button @click="$router.go(-1)">返回</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      student: {
        name: 'John',
        gpa: '3.5',
      },
      isCorrect: 'true', // 初始化是否正确的选项
    };
  },
  methods: {
    submitScore() {
      // 在这里执行提交分数的逻辑
      console.log('提交分数:', this.score);
      console.log('是否正确:', this.isCorrect);
    },
  },
};
</script>
