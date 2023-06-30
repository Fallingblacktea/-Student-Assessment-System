<template>
  <div id="demo" :class="[{'collapsed' : collapsed}, {'onmobile' : isOnMobile}]">
    <div class="demo">
      <div class="container">
        <img src="./assets/images/pku.jpg" class="logo">
        <h2>北京大学学生评奖系统</h2>
        <hr class="divider">
        <router-view />
      </div>
    </div>
  </div>
</template>

<style lang="scss">
.container { 
  text-align: center; 
  background-color: #fafafa; 
  border-radius: 10px; 
  box-shadow: 0 0 10px rgba(0,0,0,0.1); 
  max-width: 800px; 
  margin: 10px ; 
  margin-left: -10px ;
  padding: 10px; 
  font-family: "Helvetica Neue", Arial, sans-serif;
}

.logo {
  display: block;
  margin: 0 auto;
  width: 150px;
  height: 150px;
}

h2 { 
  margin-top: 32px; 
  margin-bottom: 16px; 
  font-size: 48px; 
  font-weight: 300; 
  color: #556677; 
  font-family: "Helvetica Neue", Arial, sans-serif;
} 

.divider {
  margin: 24px auto;
  border: none;
  border-top: 1px solid #ddd;
  width: 50%;
}

@media (max-width: 768px) {
  .container {
      width: 90%;
      font-size: 16px;
  }
}
</style>