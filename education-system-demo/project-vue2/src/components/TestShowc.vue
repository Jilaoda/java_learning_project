<template>
    <div class="grade-management">
      <h2 class="page-title">成绩管理</h2>
      <div class="course-buttons">
        <button v-for="course in teacherCourses" :key="course.id" @click="showCourseGrades(course)">
          {{ course.name }}
        </button>
      </div>
      <table class="grade-table">
        <thead>
          <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>课程</th>
            <th>成绩</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="student in selectedCourseGrades" :key="student.id">
            <td>{{ student.studentNumber }}</td>
            <td>{{ student.name }}</td>
            <td>{{ student.course }}</td>
            <td>{{ student.grade }}</td>
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
        teacherCourses: [
          { id: 1, name: '语文' },
          { id: 2, name: '数学' },
          { id: 3, name: '英语' },
          // ... 其他课程数据
        ],
        selectedCourseGrades: []
      };
    },
    methods: {
      showCourseGrades(course) {
        // 根据所选课程筛选学生成绩数据，例如从后端请求或从已有数据中筛选
        // 将筛选后的数据赋值给 selectedCourseGrades
        // 例如：
        this.selectedCourseGrades = [
          { id: 1, studentNumber: '2101510212', name: '张三', course: course.name, grade: 85 },
          { id: 2, studentNumber: '2101510213', name: '李四', course: course.name, grade: 92 },
          { id: 3, studentNumber: '2101510214', name: '王五', course: course.name, grade: 78 },
          { id: 3, studentNumber: '2101510215', name: '李明', course: course.name, grade: 99 },
          // ... 其他学生成绩数据
        ];
      }
    }
  };
  </script>
  
  <style scoped>
  .grade-management {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .page-title {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .course-buttons {
    display: flex;
    justify-content: flex-start;
    margin-bottom: 10px;
  }
  
  .course-buttons button {
    padding: 8px 16px;
    margin-right: 10px;
    background-color: #e0e0e0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .grade-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .grade-table th,
  .grade-table td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ccc;
  }
  
  .grade-table th {
    background-color: #f0f0f0;
  }
  
  .grade-table td {
    background-color: #fff;
  }
  

  </style>
  