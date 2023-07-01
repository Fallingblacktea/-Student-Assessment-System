<template>
  <div>
    <button @click="exportData">导出数据</button>
  </div>
</template>

<script>
import { exportdata } from '../api/exportData';

export default {
  methods: {
    exportData() {
      exportdata()
      .then((response) => {
          const fileName = 'scores_summary.xlsx';
          const url = window.URL.createObjectURL(new Blob([response.data], { type: 'application/octet-stream' }));
          const link = document.createElement('a');
          link.href = url;
          link.setAttribute('download', fileName);
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
          window.URL.revokeObjectURL(url);
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
