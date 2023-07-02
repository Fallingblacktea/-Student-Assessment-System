module.exports = {
    devServer: {
      proxy: {
        // 设置代理，将请求转发到目标服务器
        '/': {
          target: 'http://localhost:28080', // 将目标服务器地址替换为实际的目标服务器地址
          changeOrigin: true,
        }
      }
    }
  };
  