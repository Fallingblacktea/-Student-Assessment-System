<template>
  <div>
    <h3>{{ student.name }}的志愿时长</h3> 
    <p>{{ student.hours }}</p>

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
export default {
  data() {
    return {//后续student要改成数据库里的studentID
      student: {
        name: '张三',
        hours: '10小时',
      },
      score: null,
    };
  },
  methods: {
    submitScore() {
      // 在这里执行提交分数的逻辑
      console.log('提交分数:', this.score);
    },
  },
};
</script>
