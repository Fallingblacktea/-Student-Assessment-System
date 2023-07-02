<template>
  <div>
    <button @click="exportData">导出数据</button>
  </div>
</template>

<script>
import { exportdata } from '../api/exportData';
import * as XLSX from 'xlsx';
export default {
  methods: {
    exportData() {
  exportdata()
    .then((response) => {
      const jsonData = response.data; // 假设 response.data 包含从后端返回的 JSON 数据

// 将 JSON 对象转换为工作簿
const workbook = XLSX.utils.book_new();
const worksheet = XLSX.utils.json_to_sheet(jsonData);
XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');

// 导出工作簿为 Excel 文件
XLSX.writeFile(workbook, 'scores_summary.xlsx');
      this.$message.success('数据导出成功');
    })
    .catch((error) => {
      console.error(error);
      this.$message.error('导出数据失败');
    });
},

  },
};
</script>
