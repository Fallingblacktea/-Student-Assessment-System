<template>
  <div>
    <button @click="showConfirmationDialog">导出数据</button>
    <el-dialog
      :visible.sync="dialogVisible"
      title="确认提示"
      @close="resetDialog"
    >
      <span>确定要执行此操作吗？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelConfirmation">取消</el-button>
        <el-button type="primary" @click="confirmAction">确认</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script >
export default {
  data() {
    return {
      dialogVisible: false
    };
  },
  methods: {
    showConfirmationDialog() {
      this.dialogVisible = true;
    },
    resetDialog() {
      this.dialogVisible = false;
    },
    cancelConfirmation() {
      this.resetDialog();
    },
    confirmAction() {
      // 执行确认操作的逻辑
      this.resetDialog();
    }
  }
};
</script>
