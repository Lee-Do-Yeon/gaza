import { requestGuideRegisterList } from "../../common/api/commonAPI";

const state = {
    registerGuideList : []
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

        const list = response.data.result;
        
        console.log(list);
        console.log('리스트 읽어오기 성공');
        commit('setRegisterGuideList', list)
    } catch (error) {
        console.log(error);
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
