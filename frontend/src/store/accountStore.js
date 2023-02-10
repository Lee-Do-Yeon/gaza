import {  requestLogin } from "../../common/api/commonAPI";
import router from '../router';

const state = {
  accessToken: null,
  refreshToken: null,
  isLogin: false,
  signRegister: false,
  userId: null,
};

const getters = {
  getToken: state => {
    return state.token;
  },
  getLogin: state => {
    return state.isLogin
  },
  getSignRegister: state => {
    return state.signRegister
  },
  getIsLogin: state => {
    return state.isLogin
  },
  getUserId: state => {
    return state.userId
  }
};

const mutations = {
  setToken: (state, data) => {
    console.log('token mutations');
    state.accessToken = data.accessToken
    state.refreshToken = data.refreshToken
  },
  getLogin: (state) => {
    console.log(state.accessToken);
    console.log(state.refreshToken);
    console.log(response);
  },
  logOutData: (state) => {
    state.accessToken = null,
    state.refreshToken = null,
    state.isLogin = false
    window.location.href = '/'
    // window.location.reload(true)
  },
  logOutDataWithoutRefresh: (state) => {
    state.token = null,
    state.isLogin = false
  },
  logInData: (state, data) => {
    console.log('로그인됨');
    state.isLogin = true
    state.userId = data
    console.log(state);
  },
  signRegister: (state) => {
    state.signRegister = true
  },
  signRegisterFalse: (state) => {
    state.signRegister = false
  }

}

const actions = {
  loginAction: async ({ commit }, loginData) => {
    console.log('store');
    try {
      console.log('trylogin');
      const response = await requestLogin(loginData);
      console.log(response.data);
      if (response.data.resultCode == 200) {
        alert('로그인 성공')
        commit("logInData", loginData.id)
        commit("setToken", response.data);
        router.push({name: "home"})
      } else {
        console.log(response.data.status);
        alert('로그인 실패')
      }
    } catch (error) {
      console.log(error.response);
      alert('잘못된 정보입니다.')
    }
  },
  signinAction: async ({ commit }, signinData) => {
    try {
      const response = await requestSignin(signinData);
      console.log(response);
      alert('회원가입이 완료되었습니다.')
    } catch (error) {
      alert('회원가입에 실패하였습니다.')
    }
  },

  confirmAction: async ({ commit,state }) => {
    if (state.token) {
      try {
        const response = await requestConfirm(`Bearer ${state.accessToken}`);
        commit("logInData")
      } catch (error) {
        console.log(error.response);
      }
    }
  },

};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};
