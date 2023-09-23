<!--
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-24 18:45:29
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-25 21:37:23
 * @FilePath: \project-vue2\src\components\UserShowc.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <div class="grade-query">
      <h2>成绩查询</h2>
      <table class="grade-table">
        <thead>
          <tr>
            <th>课程名称</th>
            <th>成绩</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="grade in gradeList" :key="grade.id">
            <td>{{ grade.cno }}</td>
            <td>{{ grade.grade }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script type="text/javascript"></script>

  <script>
  export default {
    data() {
      return {
        gradeList: []
      };
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

        // 使用参数
        console.log(username); // 输出：21003104

        this.axios.get('http://localhost:8080/education-system-demo/system/programSelect?username=' + username )
          .then(response => {
            // 在请求成功时获取到后端返回的JSON数据
            const data = response.data;
            console.log(data); // 检查获取到的数据是否正确
            // 将后端数据赋值给 courses 数组
            this.gradeList = data
          })
          .catch(error => {
            // 在请求发生错误时进行错误处理
            console.error(error);
          });
      },


    }

  };
  </script>
  
  <style scoped>
  .grade-query {
    text-align: center;
  }
  
  .grade-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  
  .grade-table th,
  .grade-table td {
    border: 1px solid #ccc;
    padding: 8px;
  }
  
  .grade-table th {
    background-color: #f0f0f0;
  }
  </style>
  