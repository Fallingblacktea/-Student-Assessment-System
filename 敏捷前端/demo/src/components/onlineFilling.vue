<template>
  <div>
    <h3>学生信息填写</h3>
    <div>
      <label for="summary"><h3>1.个人学年总结：</h3></label>
      <textarea id="summary" v-model="summary" placeholder="请输入个人学年总结,字数不超过400字" rows="5" cols="50"></textarea>
    </div>

    <div>
      <label for="score"><h3>2.成绩：</h3></label>
      <input id="score" type="number" v-model.number="score" placeholder="请输入你的GPA">
    </div>

    <div>
      <h3>3.科研情况：（请点击添加进行填写）</h3>
      <table>
        <thead>
          <tr>
            <th class="custom-font">名次</th>
            <th class="custom-font">时间</th>
            <th class="custom-font">地点</th>
            <th class="custom-font">奖项</th>
            <th class="custom-font">级别</th>
            <th >
              <button @click="addResearchItem">添加</button>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(researchItem, index) in researchItems" :key="index">
            <td>
              <input type="text" v-model="researchItem.rank">
            </td>
            <td>
              <input type="text" v-model="researchItem.time">
            </td>
            <td>
              <input type="text" v-model="researchItem.location">
            </td>
            <td>
              <input type="text" v-model="researchItem.award">
            </td>
            <td>
              <input type="text" v-model="researchItem.level">
            </td>
            <td>
              <button @click="removeResearchItem(index)">删除</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div>
      <h3>4.学生骨干服务岗位：（请点击添加进行填写）</h3>
      <table>
        <thead>
          <tr>
            <th class="custom-font">起始时间</th>
            <th class="custom-font">服务岗位名称</th>
            <th class="custom-font">职务</th>
            <th class="custom-font">考核级别</th>
            <th>
              <button @click="addServiceItem">添加</button>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(serviceItem, index) in serviceItems" :key="index">
            <td>
              <input type="text" v-model="serviceItem.startDate">
            </td>
            <td>
              <input type="text" v-model="serviceItem.positionName">
            </td>
            <td>
              <input type="text" v-model="serviceItem.role">
            </td>
            <td>
              <input type="text" v-model="serviceItem.assessmentLevel">
            </td>
            <td>
              <button @click="removeServiceItem(index)">删除</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div>
      <h3>5.社会实践情况：（请点击添加进行填写）</h3>
      <table>
        <thead>
          <tr>
            <th class="custom-font">发起单位</th>
            <th class="custom-font">地点</th>
            <th class="custom-font">天数</th>
            <th class="custom-font">团队人数</th>
            <th class="custom-font">团内职务</th>
            <th class="custom-font">是否线上</th>
            <th class="custom-font">是否获得奖励</th>
            <th class="custom-font">奖励名称</th>
            <th>
              <button @click="addPracticeItem">添加</button>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(practiceItem, index) in practiceItems" :key="index">
            <td>
              <input type="text" v-model="practiceItem.initiatingUnit">
            </td>
            <td>
              <input type="text" v-model="practiceItem.location">
            </td>
            <td>
              <input type="number" v-model.number="practiceItem.duration">
            </td>
            <td>
              <input type="number" v-model.number="practiceItem.teamSize">
            </td>
            <td>
              <input type="text" v-model="practiceItem.teamRole">
            </td>
            <td>
              <input type="checkbox" v-model="practiceItem.online">
            </td>
            <td>
              <input type="checkbox" v-model="practiceItem.rewarded">
            </td>
            <td>
              <input type="text" v-model="practiceItem.rewardName">
            </td>
            <td>
              <button @click="removePracticeItem(index)">删除</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script >
export default {
  data() {
    return {
      summary: '',
      score: null,
      researchItems: [],
      serviceItems: [],
      practiceItems: []
    };
  },
  methods: {
    addResearchItem() {
      this.researchItems.push({
        rank: '',
        time: '',
        location: '',
        award: '',
        level: ''
      });
    },
    removeResearchItem(index) {
      this.researchItems.splice(index, 1);
    },
    addServiceItem() {
      this.serviceItems.push({
        startDate: '',
        positionName: '',
        role: '',
        assessmentLevel: ''
      });
    },
    removeServiceItem(index) {
      this.serviceItems.splice(index, 1);
    },
    addPracticeItem() {
      this.practiceItems.push({
        initiatingUnit: '',
        location: '',
        duration: null,
        teamSize: null,
        teamRole: '',
        online: false,
        rewarded: false,
        rewardName: ''
      });
    },
    removePracticeItem(index) {
      this.practiceItems.splice(index, 1);
    }
  }
};
</script>
<style>
.custom-font {
  font-size: 16px;
  color: black;
  font-weight: normal;
  /* 可以添加其他字体样式属性 */
}

</style>