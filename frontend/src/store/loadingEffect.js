import { ElLoading } from "element-plus";

const state = {

};

const getters = {

};

const mutations = {

};

const actions = {
  openFullScreen2: ( ) => {
    console.log('1111111111111111111111111');
    const loading = ElLoading.service({
      lock: true,
      text: 'Loading',
      background: 'rgba(0, 0, 0, 0.7)',
    })
    setTimeout(() => {
      loading.close()
    }, 2000)
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};
