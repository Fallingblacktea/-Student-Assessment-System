export function refreshCaptcha() {
    // 更新验证码图片URL
    this.captchaImageUrl = '';
    this.$nextTick(() => {
      this.captchaImageUrl = 'http://localhost:28080/captcha?' + Date.now();
    });
  }