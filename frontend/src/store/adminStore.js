import { requestGuideRegisterList } from "../common/api/accountAPI";

const state = {
    registerGuideList
};

const getters = {
  getRegisterGuideList: state => {
    return state.registerGuideList
  }
};

const mutations = {
  setRegisterGuideList: (state, list) => {
    state.registerGuideList = list
  }
}

const actions = {
  getRegisterGuideListAction: async ({ commit }) => {
    try {
        const response = await requestGuideRegisterList();
        console.log('리스트 읽어오기 성공');
        commit('setRegisterGuideList')
    } catch (error) {
        console.log(error.reponse);
    }
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};
