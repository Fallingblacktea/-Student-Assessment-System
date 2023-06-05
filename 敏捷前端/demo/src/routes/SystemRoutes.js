import '../fontawesome'
import 'element-plus/dist/index.css'
import importStudents from '../components/importStudents.vue'
import scoresSummary from '../components/scoresSummary.vue'
import exportData from '../components/exportData.vue'
import personalSummary from '../components/personalSummary.vue'
import volunteerService from '../components/volunteerService.vue'
import studentScores from '../components/studentScores.vue'
import researchStatus from '../components/researchStatus.vue'
import studentService from '../components/studentService.vue'
import socialPractice from '../components/socialPractice.vue'
import onlineFilling from '../components/onlineFilling.vue'
import personalSummaryDetails from '../components/personalSummaryDetails.vue'
import volunteerServiceDetails from '../components/volunteerServiceDetails.vue'
import studentScoresDetails from '../components/studentScoresDetails.vue'
import researchStatusDetails from '../components/researchStatusDetails.vue'
import studentServiceDetails from '../components/studentServiceDetails.vue'
import socialPracticeDetails from '../components/socialPracticeDetails.vue'
import LogoutView from '../components/LogoutView.vue'


import  SidebarMenu  from '../sidebar.vue'
const runningroute = [
  {
    path: 'importStudents',
      name: 'importStudents',
      component: importStudents
  },{
    path: 'scoresSummary',
    name: 'scoresSummary',
    component: scoresSummary
  },
  {
    path: 'exportData',
    name: 'exportData',
    component: exportData
  },
  {
    path: 'personalSummary',
    name: 'personalSummary',
    
    children: [
      {
        path: '',  // 子路由的路径，这是相对于父路由的路径的
        name: 'personalSummaryDefault',
        component: personalSummary,
        props: true,
      },
      {
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
        path: 'details/:studentID',  // 子路由的路径，这是相对于父路由的路径的
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
  },
  {
    path: '/logout',
    name: 'logout',
    component: LogoutView
  }
]
  const SystemRouter = [
    {
    path:'/',
    component:SidebarMenu,
    children:[
    //从此处开始
    runningroute[0],
    runningroute[1],
    runningroute[2],
    runningroute[3],
    runningroute[4],
    runningroute[5],
    runningroute[6],
    runningroute[7],
    runningroute[8],
    runningroute[9],
    runningroute[10]
  ]}]
  export default SystemRouter
