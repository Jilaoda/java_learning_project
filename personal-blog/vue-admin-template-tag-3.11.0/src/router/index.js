import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '控制台', icon: '控制台' }
    }]
  }, {
    path: '/operation',
    component: Layout,
    redirect: '/operation/list',
    name: 'Operation',
    meta: { title: '日志中心', icon: '日志中心' },
    children: [
      {
        path: 'list',
        name: 'OperationList',
        component: () => import('@/views/operation/index'),
        meta: { title: '操作日志', icon: '操作日志' }
      },
      {
        path: 'loginlog',
        name: 'LoginLogList',
        component: () => import('@/views/operation/loginlog'),
        meta: { title: '登录日志', icon: '登录日志' }
      }
    ]
  }, {
    path: '/user',
    component: Layout,
    redirect: '/user/list',
    name: 'User',
    meta: { title: '用户管理', icon: '用户管理' },
    children: [
      {
        path: 'list',
        name: 'UserList',
        component: () => import('@/views/user/list'),
        meta: { title: '用户列表', icon: '用户列表' }
      },
      {
        path: 'introduction',
        name: 'Introduction',
        component: () => import('@/views/user/introduction'),
        meta: { title: '个人介绍', icon: '个人介绍' }
      },
    ]
  }, {
    path: '/notice',
    component: Layout,
    redirect: '/notice/list',
    name: 'Notice',
    meta: { title: '公告管理', icon: '公告管理' },
    children: [
      {
        path: 'list',
        name: 'NoticeList',
        component: () => import('@/views/notice/list'),
        meta: { title: '公告列表', icon: '公告列表' }
      },
      {
        path: 'add',
        name: 'AddNotice',
        component: () => import('@/views/notice/add'),
        meta: { title: '发布公告', icon: '发布公告' }
      },
    ]
  }, {
    path: '/articles',
    component: Layout,
    redirect: '/articles/list',
    name: 'Articles',
    meta: { title: '文章管理', icon: '文章管理' },
    children: [
      {
        path: 'list',
        name: 'ArticlesList',
        component: () => import('@/views/articles/list'),
        meta: { title: '文章列表', icon: '文章列表' }
      },
      {
        path: 'add',
        name: 'Addrticles',
        component: () => import('@/views/articles/add'),
        meta: { title: '发布文章', icon: '发布文章' }
      },
    ]
  }, {
    path: '/tag',
    component: Layout,
    redirect: '/tag/list',
    name: 'Tag',
    meta: { title: '标签管理', icon: '标签管理' },
    children: [
      {
        path: 'list',
        name: 'TagList',
        component: () => import('@/views/tag/list'),
        meta: { title: '标签管理', icon: '标签管理' }
      },
    ]
  }, {
    path: '/categories',
    component: Layout,
    redirect: '/categories/list',
    name: 'Categories',
    meta: { title: '分类管理', icon: '分类管理' },
    children: [
      {
        path: 'list',
        name: 'CategoriesList',
        component: () => import('@/views/categories/list'),
        meta: { title: '分类管理', icon: '分类管理' }
      },
    ]
  },

]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
