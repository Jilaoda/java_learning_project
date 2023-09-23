/*
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-30 21:14:14
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-31 22:01:02
 * @FilePath: \vue-admin-template-tag-3.11.0\src\main.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/*
 * @Author: liweiliang93 2529018799@qq.com
 * @Date: 2023-05-30 21:14:14
 * @LastEditors: liweiliang93 2529018799@qq.com
 * @LastEditTime: 2023-05-30 21:17:01
 * @FilePath: \vue-admin-template-tag-3.11.0\src\main.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import locale from 'element-ui/lib/locale/lang/en' // lang i18n
import locale from 'element-ui/lib/locale/lang/zh-CN' 
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

import '@/icons' // icon
import '@/permission' // permission control

/**
 * This project originally used easy-mock to simulate data,
 * but its official service is very unstable,
 * and you can build your own service if you need it.
 * So here I use Mock.js for local emulation,
 * it will intercept your request, so you won't see the request in the network.
 * If you remove `../mock` it will automatically request easy-mock data.
 */
// import '../mock' // simulation data

Vue.use(ElementUI, { locale })
Vue.use(mavonEditor)
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
