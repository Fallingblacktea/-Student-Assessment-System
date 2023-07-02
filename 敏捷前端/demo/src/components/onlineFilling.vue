<template>
  <div>
    <el-card>
      <h3 class="card-title">学生信息填写</h3>
      <el-form :model="form" label-position="top">
        <el-form-item label="1. 个人学年总结">
          <el-input
            type="textarea"
            v-model="form.personalSummary"
            placeholder="请输入个人学年总结，字数不超过400字"
            :rows="5"
            :autosize="{ minRows: 5, maxRows: 5 }"
          ></el-input>
        </el-form-item>

        <el-form-item label="2. 成绩(GPA)">
          <el-input-number v-model="form.GPA" :step="0.01" :precision="2" placeholder="请输入gpa" ></el-input-number>
        </el-form-item>

        <el-form-item label="3. 科研情况">
          <el-table :data="form.researchStatus" style="width: 100%">
            <el-table-column prop="ranking" label="名次">
              <template #default="scope">
                <el-input v-model="scope.row.ranking"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="time" label="时间">
              <template #default="scope">
                <el-input v-model="scope.row.time" placeholder="格式为YYYY-MM"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="location" label="地点">
              <template #default="scope">
                <el-input v-model="scope.row.location"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="award" label="奖项">
              <template #default="scope">
                <el-input v-model="scope.row.award"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="level" label="级别">
              <template #default="scope">
                <el-input v-model="scope.row.level"></el-input>
              </template>
            </el-table-column>
            <el-table-column>
              <template #default="scope">
                <el-button type="text" @click="removeResearchItem(scope.$index)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-button @click="addResearchItem">添加</el-button>
        </el-form-item>

        <el-form-item label="4. 学生骨干服务岗位">
          <el-table :data="form.studentService" style="width: 100%">
            <el-table-column prop="startTime" label="起始时间">
              <template #default="scope">
                <el-input v-model="scope.row.startTime" placeholder="格式为YYYY-MM"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="positionName" label="服务岗位名称">
              <template #default="scope">
                <el-input v-model="scope.row.positionName"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="positionTitle" label="职务">
              <template #default="scope">
                <el-input v-model="scope.row.positionTitle"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="assessmentLevel" label="考核级别">
              <template #default="scope">
                <el-input v-model="scope.row.assessmentLevel"></el-input>
              </template>
            </el-table-column>
            <el-table-column>
              <template #default="scope">
                <el-button type="text" @click="removeServiceItem(scope.$index)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-button @click="addServiceItem">添加</el-button>
        </el-form-item>

        <el-form-item label="5. 社会实践情况">
          <el-table :data="form.socialPractice" style="width: 100%">
            <el-table-column prop="initiatingOrganization" label="发起单位">
              <template #default="scope">
                <el-input v-model="scope.row.initiatingOrganization"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="location" label="地点">
              <template #default="scope">
                <el-input v-model="scope.row.location"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="duration" label="天数">
              <template #default="scope">
                <el-input-number v-model="scope.row.duration" :step="1" :precision="0"></el-input-number>
              </template>
            </el-table-column>
            <el-table-column prop="teamSize" label="团队人数">
              <template #default="scope">
                <el-input-number v-model="scope.row.teamSize" :step="1" :precision="0"></el-input-number>
              </template>
            </el-table-column>
            <el-table-column prop="teamPosition" label="团内职务">
              <template #default="scope">
                <el-input v-model="scope.row.teamPosition"></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="isOnline" label="是否线上">
              <template #default="scope">
                <el-checkbox v-model="scope.row.isOnline"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column prop="hasAward" label="是否获得奖励">
              <template #default="scope">
                <el-checkbox v-model="scope.row.hasAward"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column prop="awardName" label="奖励名称">
              <template #default="scope">
                <el-input v-model="scope.row.awardName"></el-input>
              </template>
            </el-table-column>
            <el-table-column>
              <template #default="scope">
                <el-button type="text" @click="removePracticeItem(scope.$index)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-button @click="addPracticeItem">添加</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交以上（1-5项）信息</el-button>
          请勿忘记提交证明材料！
        </el-form-item>
        <div class="form-item-wrapper">
            <el-form-item label="6. 证明材料上传">
            <el-upload
      class="upload-demo"
      action="http://localhost:28080/upload"
      :before-upload="beforeUpload"
      :on-success="onUploadSuccess"
      :on-error="onUploadError"
      :limit="1"
      :file-list="fileList"
      :auto-upload="false"
    >
      <el-button type="primary">点击上传</el-button>
    </el-upload>
          </el-form-item>
          </div>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { ElMessage } from 'element-plus';
import { onlineFillingSubmit } from '/src/api/submit.js'
export default {
  data() {
    return {
      fileList: [],
      form: {
        personalSummary: "",
        GPA: null,
        researchStatus: [],
        studentService: [],
        socialPractice: []
      }
    };
  },
  methods: {
    beforeUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isPNG = file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error('只能上传 JPG/PNG 格式的图片');
        return false;
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB');
        return false;
      }

      this.fileList.push(file);
      return false; // 阻止自动上传
    },
    onUploadSuccess(response, file) {
      this.$message.success('文件上传成功');
      // 处理上传成功的逻辑
    },
    onUploadError(error, file) {
      this.$message.error('文件上传失败');
      // 处理上传失败的逻辑
    },
    addResearchItem() {
      this.form.researchStatus.push({});
    },
    removeResearchItem(index) {
      this.form.researchStatus.splice(index, 1);
    },
    addServiceItem() {
      this.form.studentService.push({});
    },
    removeServiceItem(index) {
      this.form.studentService.splice(index, 1);
    },
    addPracticeItem() {
      this.form.socialPractice.push({});
    },
    removePracticeItem(index) {
      this.form.socialPractice.splice(index, 1);
    },
    submitForm() {
      // 处理表单提交逻辑
      // 执行表单提交
      onlineFillingSubmit(this.form)
        .then(response => {
          ElMessage.success('提交成功');
          // 其他成功处理逻辑
        })
        .catch(error => {
          ElMessage.error('提交失败');
          // 其他失败处理逻辑
        });
    }
  }
};
</script>

<style scoped>
.card-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
}
.form-item-wrapper {
    margin-top: 20px; /* 这里可以调整平移的距离 */
  }
</style>
