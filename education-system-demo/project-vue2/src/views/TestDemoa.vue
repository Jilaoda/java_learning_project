<template>
    <div>
        <el-container>
            <el-header>
                <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                    background-color="#545c64" text-color="#fff" active-text-color="red">
                    <el-menu-item index="1" style="text-decoration: none; border-bottom: none;">
                        <img src="https://job.cingta.com/static/image/20180717/f7611a159e534530873a036b4941be6d.png" width="50px" height="50px" />
                        <span class="logo-text">教务管理系统</span>
                    </el-menu-item>
                </el-menu>
            </el-header>
  
  
  
            <el-container>
              <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
              <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-message"></i>教师事务管理
        </template>
        <el-menu-item index="1-1">
          <el-button @click="comehtml='TestShow'" class="login-button" plain>
            个人信息
          </el-button>
        </el-menu-item>
        <el-menu-item index="1-2">
          <el-button @click="comehtml='TestShowa'" class="login-button" plain>
            课程信息
          </el-button>
        </el-menu-item>
        <el-menu-item index="1-3">
          <el-button @click="comehtml='TestShowb'" class="login-button" plain>
            学生管理
          </el-button>
        </el-menu-item>
        <el-menu-item index="1-4">
          <el-button @click="comehtml='TestShowc'" class="login-button" plain>
            成绩管理
          </el-button>
        </el-menu-item>
        <el-menu-item index="1-5">
          <el-button @click="comehtml='TestShowd'" class="login-button" plain>
               通告公告
            </el-button>
        </el-menu-item>
        </el-submenu>
       </el-menu>
    </el-aside>
  
                <el-main>
                    <component :is="comehtml" > </component>
                </el-main>
                
            </el-container>
        </el-container>
    </div>
  </template>
  
  <script type="text/javascript">
  import GunDong from '@/components/GunDong.vue';
  import TestShow from '@/components/TestShow.vue';
  import TestShowa from '@/components/TestShowa.vue';
  import TestShowb from '@/components/TestShowb.vue';
  import TestShowc from '@/components/TestShowc.vue';
  import TestShowd from '@/components/TestShowd.vue';
  
  export default {
    data() {
        return {
          comehtml:'GunDong',
        }
    },
  
  
  components:{
    GunDong,
    TestShow,
    TestShowa,
    TestShowb,
    TestShowc,
    TestShowd,
  },
  
  
    mounted() {
        this.loadImages();
    }
  
  }
  </script>
  <style>
  .logo-text {
  font-size: 18px;
  font-weight: bold;
  color: #fff;
  padding-left: 10px;
  border-left: 1px solid #fff;
  }
  .user-info-container {
    margin-right: 5px;
    display: flex;
    align-items: center;
  }
  .slogan {
    background: linear-gradient(to right, #ff00ff, #00ffff);
   -webkit-background-clip: text;
   -webkit-text-fill-color: transparent;
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  color: #333333;
  margin-top: 20px;
  font-size: 36px;
  font-weight: bold;
  color: #333333;
  text-align: center;
  text-transform: uppercase;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  }
  
  .login-button,
  .register-button {
    margin-right: 5px;
  }
  
  .image-slider {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .slider-nav {
    position: absolute;
    top: 50%;
    font-size: 24px;
    color: #363131;
    cursor: pointer;
    user-select: none;
  }
  
  .left {
    color: aqua;
    left: 20px;
  }
  
  .right {
    color: aqua;
    right: 20px;
  }
  
  .slider-nav:hover {
    color: #ff0000;
  }
  
  .image-container {
    height :"1000px";
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  img {
    max-width: 100%;
    height: auto;
  }
  </style> 