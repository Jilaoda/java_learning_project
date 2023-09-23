<template>
  <div>
                <div class="user-info">
                  <div class="info-item">
                  <span class="label">学号:</span>
                  <span>{{ userInfo.sno }}</span>
                </div>
                <div class="info-item">
                  <span class="label">姓名:</span>
                  <span>{{ userInfo.sName }}</span>
                </div>
                <div class="info-item">
                  <span class="label">性别:</span>
                  <span>{{ userInfo.sSex }}</span>
                </div>
                <div class="info-item">
                   <span class="label">年龄:</span>
                   <span>{{ userInfo.sAge }}</span>
                </div>
                <div class="info-item">
                  <span class="label">民族:</span>
                  <span>{{ userInfo.sNationality }}</span>
                </div>
                <div class="info-item">
                   <span class="label">专业:</span>
                    <span>{{ userInfo.sProfession }}</span>
                </div>
                <div class="info-item">
                   <span class="label">入学时间:</span>
                    <span>{{ userInfo.entrance_time }}</span>
                </div>
                </div>
  </div>
</template>

<script type="text/javascript">
export default {
  data() {
      return {
          userInfo: null
      }
  },

  mounted() {
      this.getDataFromBackend();
    },
    methods: {
      getDataFromBackend() {
      // 获取当前页面的 URL
    const currentURL = window.location.href;

    // 提取参数
    const urlParams = new URLSearchParams(currentURL.split('?')[1]);
    const username = urlParams.get('username');
    const password = urlParams.get('password');

    // 使用参数
    console.log(username); // 输出：21003104
    console.log(password); // 输出：12345678

        this.axios.get('http://localhost:8080/education-system-demo/system/selectBySnoPasswordFind?username='+username+'&password='+password) // 使用相对路径发起请求
          .then(response => {
            // 在请求成功时获取到后端返回的JSON数据
            const data = response.data;
            console.log(data); // 检查获取到的数据是否正确
            // 将后端数据赋值给userInfo对象
            this.userInfo = data;
          })
          .catch(error => {
            // 在请求发生错误时进行错误处理
            console.error(error);
          });
      }
    }

  }
  
  </script>

<style>
.container {
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
}

.content {
max-width: 400px;
}

.user-info {
display: flex;
flex-direction: column;
gap: 10px;
padding: 20px;
background-color: #f5f5f5;
border-radius: 5px;
}

.info-item {
display: flex;
align-items: center;
}

.label {
font-weight: bold;
margin-right: 10px;
width: 80px;
text-align: left;
}

.value {
font-size: 20px;
color: #333;
text-align: left;
}
</style>
