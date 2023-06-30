<template>
    <sidebar-menu
      v-model:collapsed="collapsed"
      :menu="menu"
      :theme="selectedTheme"
      :show-one-child="true"
      @update:collapsed="onToggleCollapse"
      @item-click="onItemClick"
    />
    <div
      v-if="isOnMobile && !collapsed"
      class="sidebar-overlay"
      @click="collapsed = true"
    />
    
    <router-view />
    
    
  </template>
  
  <script>
  import { h, markRaw } from 'vue'
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  import { running } from './api/running'

  const separator = {
    template: '<hr style="border-color: rgba(0, 0, 0, 0.1); margin: 20px;">'
  }
  
  const faIcon = (props) => {
    return {
      element: markRaw({
        render: () => h('div', [
          h(FontAwesomeIcon, { size: 'lg', ...props })
        ])
      })
    }
  }
  const runningmenu = [
  {
            header: '学生管理员',
            hiddenOnCollapse: true
          },
    {
      href: 'importStudents',
      title: '导入学生名单',
      icon: faIcon({ icon: 'fa-solid fa-download' }),
    },
    {
            href: '/scoresSummary',
            title: '成绩汇总',
            icon: faIcon({ icon: 'fa-solid fa-code' })
          },
          {
            href: '/exportData',
            title: '成绩导出',
            icon: faIcon({ icon: 'fa-solid fa-lock' })
          },
          {
            header: '评委',
            hiddenOnCollapse: true
          },
          {
            href: '/personalSummary',
            title: '个人学年总结',
            icon: faIcon({ icon: 'fa-solid fa-cogs' })
          },
          {
            href: '/volunteerService',
            title: '志愿服务',
            icon: faIcon({ icon: 'fa-solid fa-list-alt' })
          },
          {
            href: '/studentScores',
            title: '学生成绩',
            icon: faIcon({ icon: 'fa-solid fa-bell' })
          },
          {
            href: '/researchStatus',
            title: '科研情况',
            icon: faIcon({ icon: 'fa-solid fa-palette' })
          },
  
          {
            href: '/studentService',
            title: '学生骨干服务岗位',
            icon: faIcon({ icon: 'fa-solid fa-list-ul' })
          },
          {
            href: '/socialPractice',
            title: '社会实践',
            icon: faIcon({ icon: 'fa-solid fa-file-alt' })
          },
          {
            header: '学生',
            hiddenOnCollapse: true
          },
          {
            href: '/onlineFilling',
            title: '在线填报',
            icon: faIcon({ icon: 'fa-solid fa-palette' })
          },
          {
            href: '/logout',
            title: '退出',
            icon: faIcon({ icon: 'fa-solid fa-cog' })
          },
  ]
// const menuformanager = [
//   runningmenu[0],
//   runningmenu[1],
//   runningmenu[2],
//   runningmenu[3],
//   runningmenu[13]
// ]
// const menuforreviewer = [
//   runningmenu[4],
//   runningmenu[5],
//   runningmenu[6],
//   runningmenu[7],
//   runningmenu[8],
//   runningmenu[9],
//   runningmenu[10],
//   runningmenu[13]
// ]
// const menuforstudent = [
//   runningmenu[11],
//   runningmenu[12],
//   runningmenu[13]
// ]

  export default {
    
    data () {
      return {
        menu: [
        ],
      }
    },
    mounted () {
      this.onResize()
      window.addEventListener('resize', this.onResize)
    },
    created() {
    this.fetchMenuList();
  },
    methods: {
      fetchMenuList() {
      running()
        .then(response => {
          const menulist = response.data.map(i => runningmenu[i]);
          switch(response.data[0]){
            case 0 :
              menulist.push(runningmenu[3]);
              break;
            case 3 :
            menulist.shift();
            menulist.push(runningmenu[9]);
            menulist.push(runningmenu[10]);
              break;
            default:
              menulist.shift();
            menulist.unshift(runningmenu[11]);
            menulist.push(runningmenu[12]);

          };
          menulist.push(runningmenu[13]);
          this.menu = menulist;
        })
        .catch(error => {
          console.error(error);
        });
    },
      onToggleCollapse (collapsed) {
        console.log('onToggleCollapse')
      },
      onItemClick (event, item) {
        console.log('onItemClick')
      },
      onResize () {
        if (window.innerWidth <= 767) {
          this.isOnMobile = true
          this.collapsed = true
        } else {
          this.isOnMobile = false
          this.collapsed = false
        }
      }
    }
  }
  </script>
  
  <style lang="scss">
  @import url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600');
  
  body,
  html {
    margin: 0;
    padding: 0;
  }
  
  body {
    font-family: 'Source Sans Pro', sans-serif;
    font-size: 18px;
    background-color: #f2f4f7;
    color: #262626;
  }
  
  #demo {
    padding-left: 290px;
    transition: 0.3s ease;
  }
  #demo.collapsed {
    padding-left: 65px;
  }
  #demo.onmobile {
    padding-left: 65px;
  }
  
  .sidebar-overlay {
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    background-color: #000;
    opacity: 0.5;
    z-index: 900;
  }
  
  .demo {
    padding-top: -10px;
    padding-left: 20px;
  }
  
  .container {
    max-width: 900px;
  }
  </style>
  