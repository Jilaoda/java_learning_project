/*
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-24 18:45:29
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-24 21:22:45
 * @FilePath: \project-vue2\src\main.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios';
import VueAxios from 'vue-axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')



Vue.use(VueAxios, axios);

Vue.axios.defaults.baseURL = ''; // 设置基础URL，代理请求时会添加此前缀
