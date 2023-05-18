//main.js
// import Vue from 'vue'
// import VueSidebarMenu from 'vue-sidebar-menu'
// import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'
// Vue.use(VueSidebarMenu)
import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import VueSidebarMenu from '../../src'
import PrismCode from './components/PrismCode.vue'

import './fontawesome'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import Installation from './components/Installation.vue'
import BasicUsage from './components/BasicUsage.vue'
import Props from './components/Props.vue'
import Events from './components/Events.vue'
import Styling from './components/Styling.vue'

import importStudents from './components/importStudents.vue'
import scoresSummary from './components/scoresSummary.vue'
import exportData from './components/exportData.vue'
import personalSummary from './components/personalSummary.vue'
import volunteerService from './components/volunteerService.vue'
import studentScores from './components/studentScores.vue'
import researchStatus from './components/researchStatus.vue'
import studentService from './components/studentService.vue'
import socialPractice from './components/socialPractice.vue'
import onlineFilling from './components/onlineFilling.vue'

import personalSummaryDetails from './components/personalSummaryDetails.vue'
import volunteerServiceDetails from './components/volunteerServiceDetails.vue'
import studentScoresDetails from './components/studentScoresDetails.vue'
import researchStatusDetails from './components/researchStatusDetails.vue'
import studentServiceDetails from './components/studentServiceDetails.vue'
import socialPracticeDetails from './components/socialPracticeDetails.vue'





const router = createRouter({
  history: createWebHashHistory(),
  routes: [

    //从此处开始
    {
      path: '/',
      name: 'importStudents',
      component: importStudents
    },
    {
      path: '/scoresSummary',
      name: 'scoresSummary',
      component: scoresSummary
    },
    {
      path: '/exportData',
      name: 'exportData',
      component: exportData
    },
    {
      path: '/personalSummary',
      name: 'personalSummary',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'personalSummaryDefault',
          component: personalSummary,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'personalSummaryDetails',
          component: personalSummaryDetails,
          props: true,
        }
      ]
    },
    {
      path: '/volunteerService',
      name: 'volunteerService',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'volunteerServiceDefault',
          component: volunteerService,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'volunteerServiceDetails',
          component: volunteerServiceDetails,
          props: true,
        }
      ]
    },
    {
      path: '/studentScores',
      name: 'studentScores',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'studentScoresDefault',
          component: studentScores,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'studentScoresDetails',
          component: studentScoresDetails,
          props: true,
        }
      ]
    },
    {
      path: '/researchStatus',
      name: 'researchStatus',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'researchStatusDefault',
          component: researchStatus,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'researchStatusDetails',
          component: researchStatusDetails,
          props: true,
        }
      ]
    },
    {
      path: '/studentService',
      name: 'studentService',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'studentServiceDefault',
          component: studentService,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'studentServiceDetails',
          component: studentServiceDetails,
          props: true,
        }
      ]
    },
    {
      path: '/socialPractice',
      name: 'socialPractice',
      
      children: [
        {
          path: '',  // 子路由的路径，这是相对于父路由的路径的
          name: 'socialPracticeDefault',
          component: socialPractice,
          props: true,
        },
        {
          path: 'details/:studentId',  // 子路由的路径，这是相对于父路由的路径的
          name: 'socialPracticeDetails',
          component: socialPracticeDetails,
          props: true,
        }
      ]
    },
    {
      path: '/onlineFilling',
      name: 'onlineFilling',
      component: onlineFilling
    }
  ]
})

createApp(App)
  .use(router)
  .use(VueSidebarMenu)
  .use(ElementPlus)
  .component('prism-code', PrismCode)
  .component('font-awesome-icon', FontAwesomeIcon)
  .mount('#app')
