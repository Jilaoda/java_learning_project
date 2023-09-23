<!--
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-31 17:37:18
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-31 21:39:17
 * @FilePath: \vue-admin-template-tag-3.11.0\src\views\user\introduction.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<!--
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-31 17:37:18
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-31 21:35:43
 * @FilePath: \vue-admin-template-tag-3.11.0\src\views\user\introduction.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <el-card class="box-card1">

 
    <el-card class="box-card" >
      <div slot="header" class="clearfix">
        <span>个人简介</span>
      </div>
      <div class="text item">
        java小菜鸟,永远在路上.
      </div>
    </el-card>
 
 </el-card>
</template>

<script>
export default {

}
</script>


<style>

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .box-card {
    width: 70%;
    float: left;
    margin: 2% 6%;
  }
  .box-card1 {
    width: 98%;
    height: 90vh;
    margin: 1%;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .clearfix span {
    font-weight: 600;
  }

</style>
