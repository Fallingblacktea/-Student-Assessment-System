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
          const blob = new Blob([response.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
          const fileName = 'scores_summary.xlsx';
          if (window.navigator.msSaveOrOpenBlob) {
            // For IE browser
            window.navigator.msSaveOrOpenBlob(blob, fileName);
          } else {
            // For other browsers
            const link = document.createElement('a');
            const url = URL.createObjectURL(blob);
            link.href = url;
            link.download = fileName;
            link.click();
            URL.revokeObjectURL(url);
          }
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
