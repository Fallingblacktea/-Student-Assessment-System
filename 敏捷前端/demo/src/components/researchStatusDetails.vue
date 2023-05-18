<template>
  <div>
    <h3>科研情况</h3>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" label="序号" ></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="学号" prop="studentID"></el-table-column>
      <el-table-column label="名次" prop="rank"></el-table-column>
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
export default {
  data() {
    return {
      tableData: [
        {
          name: 'John',
          studentID: '12345',
          rank: 1,
          time: '2022-01-01',
          location: '某地',
          award: '优秀奖',
          level: '省级'
        }
      ]
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
