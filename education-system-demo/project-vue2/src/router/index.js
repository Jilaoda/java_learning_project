import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    redirect:'/Demo'
  },


  {
    path: '/test',
    name: 'test',
    component: () => import(/* webpackChunkName: "about" */ '../views/TestDemo.vue')
  },

  {
    path:'/Demo',
    name:'Demo',
    component : () => import(/* webpackChunkName: "about" */ '../views/TestDemoa.vue')

  },

]





const router = new VueRouter({
  routes
})

export default router
