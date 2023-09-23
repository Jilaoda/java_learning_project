<template>
    <div class="notice-page">
      <h2>通知公告</h2>
      <table>
        <thead>
          <tr>
            <th>标题</th>
            <th>发布日期</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="notice in notices" :key="notice.id" @click="showNoticeDetails(notice)">
            <td>{{ notice.title }}</td>
            <td>{{ notice.date }}</td>
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
        notices: [
          { id: 1, title: '通知1', date: '2023-01-01', content: '通知内容1' },
          { id: 2, title: '通知2', date: '2023-01-02', content: '通知内容2' },
          { id: 3, title: '通知3', date: '2023-01-03', content: '通知内容3' },
        ],
      };
    },
    methods: {
      showNoticeDetails(notice) {
        // 根据通知的ID进行页面跳转或显示弹窗等操作
        console.log('显示通知详情', notice);
      },
    },
  };
  </script>
  
  <style scoped>
  .notice-page {
    padding: 20px;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    border: 1px solid #ccc;
    padding: 8px;
  }
  
  th {
    background-color: #f0f0f0;
  }
  
  tr:hover {
    background-color: #f5f5f5;
    cursor: pointer;
  }
  </style>
  