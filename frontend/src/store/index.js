import { createStore } from "vuex";
import accountStore from "./accountStore";
import createPersistedState from "vuex-persistedstate";

export default createStore({
  modules: {
    accountStore,
  },
  plugins: [
    createPersistedState({
      paths: ["accountStore",],
    })
  ]
});