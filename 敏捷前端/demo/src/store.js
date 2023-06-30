// store.js

import { reactive } from 'vue';
import { createStore } from 'vuex';
import { running } from './api/running';

const state = reactive({
  routerData: null
});

const actions = {
  fetchRouterData({ commit }) {
    running()
      .then(response => {
        console.log(response.data);
        const menulist = response.data.map(i => runningroute[i]);
        menulist.push(runningroute[10]);
        commit('updateRouterData', menulist);
        console.log("路由更新", menulist);
      })
      .catch(error => {
        console.error(error);
      });
  }
};

const mutations = {
  updateRouterData(state, data) {
    state.routerData = data;
  }
};

export default createStore({
  state,
  actions,
  mutations
});
