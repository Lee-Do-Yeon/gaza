import { createStore } from "vuex";
import accountStore from "./accountStore";
import menuStore from "./menuStore";
import platformInfoStore from "./platformInfoStore";
import loadingEffect from "./loadingEffect";
import createPersistedState from "vuex-persistedstate";

export default createStore({
  modules: {
    accountStore,
    menuStore,
    platformInfoStore,
    loadingEffect,
  },
  plugins: [
    createPersistedState({
      paths: ["accountStore",],
    })
  ]
});