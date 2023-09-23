<template>
    <div class="course-management">
      <h2 class="page-title">课程管理</h2>
  
      <table class="course-table">
        <thead>
          <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>已选人数</th>
            <th>学分</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="course in teacherCourses" :key="course.id">
            <td>{{ course.cno }}</td>
            <td>{{ course.cname }}</td>
            <td>{{ course.cstudents }}</td>
            <td>{{ course.ccredit }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  

  <script type="text/javascript">
  export default {
    data() {
      return {
        teacherCourses: [],
      }
    },

    mounted() {
      this.getDataFromBackend();
    },

    methods: {
      methods: {
      getDataFromBackend() {
        // 获取当前页面的 URL
      const currentURL = window.location.href;

      // 提取参数
      const urlParams = new URLSearchParams(currentURL.split('?')[1]);
      const username = urlParams.get('username');

      // 使用参数
      console.log(username); // 输出：21003104

          this.axios.get('http://localhost:8080/education-system-demo/system/selectedCourseTno?username='+username) // 使用相对路径发起请求
            .then(response => {
              // 在请求成功时获取到后端返回的JSON数据
              const data = response.data;
              console.log(data); // 检查获取到的数据是否正确
              // 将后端数据赋值给userInfo对象
              this.teacherCourses = data;
            })
            .catch(error => {
              // 在请求发生错误时进行错误处理
              console.error(error);
            });
        }
      }

    },
  };
  </script>
  
  <style scoped>
  .course-management {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .page-title {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .course-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .course-table th,
  .course-table td {
    padding: 10px;
    border: 1px solid #ccc;
  }
  
  .course-table th {
    background-color: #f5f5f5;
  }
  
  .edit-button,
  .delete-button,
  .add-button {
    padding: 6px 12px;
    background-color: #e0e0e0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .add-course {
    display: flex;
    align-items: center;
    margin-top: 20px;
  }
  
  .add-course input[type="text"] {
    flex-grow: 1;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .add-button {
    margin-left: 10px;
    background-color: #4caf50;
    color: #fff;
  }
  </style>
  