<template>
  <div class="course-withdrawal">

    <h2>已选课程列表</h2>

    <div class="selected-courses">

      <div v-for="selectedCourse in selectedCourses" :key="selectedCourse.id" class="selected-course-card">
        <h3>
          <p>课程名称：{{ selectedCourse.cname }}</p>
        </h3>
        <p>课程号：{{ selectedCourse.cno }}</p>
        <p>教师编号：{{ selectedCourse.ctno }}</p>
        <p>学分：{{ selectedCourse.ccredit }}</p>
        <button @click="withdrawCourse(selectedCourse)">退课</button>
      </div>
    </div>
  </div>
</template> 


<script type="text/javascript">
export default {
  data() {
    return {
      selectedCourses: [],
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

      this.axios.get('http://localhost:8080/education-system-demo/system/selectedCourse?username=' + username)
        .then(response => {
          // 在请求成功时获取到后端返回的JSON数据
          const data = response.data;
          console.log(data); // 检查获取到的数据是否正确
          // 将后端数据赋值给 courses 数组
          this.selectedCourses = data;
        })
        .catch(error => {
          // 在请求发生错误时进行错误处理
          console.error(error);
        });
    },


    withdrawCourse(selectedCourse) {
      // 获取当前页面的 URL
      const currentURL = window.location.href;

      // 提取参数
      const urlParams = new URLSearchParams(currentURL.split('?')[1]);
      const username = urlParams.get('username');
      const cno = selectedCourse.cno; // 假设课程对象中有一个 username 属性表示课程的用户名
      const tno = selectedCourse.ctno;
      this.axios.get('http://localhost:8080/education-system-demo/system/deleteCourseByCno?cno=' + cno + '&username=' + username + '&tno=' + tno)
        .then(response => {
          // 处理响应数据
          const data = response.data;
          console.log(data);
        })
        .catch(error => {
          // 处理请求错误
          console.error(error);
        });
    }


  }
};
</script>
  
<style scoped>
.course-withdrawal {
  text-align: center;
}

.selected-courses {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.selected-course-card {
  width: 200px;
  padding: 10px;
  border: 1px solid #ccc;
  margin: 10px;
  text-align: left;
}
</style>
  

  
 
  














  
 
  
  