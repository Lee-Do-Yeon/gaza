import { createStore } from "vuex";
import accountStore from "./accountStore";
import menuStore from "./menuStore";
import platformInfoStore from "./platformInfoStore";
import loadingEffect from "./loadingEffect";
import createPersistedState from "vuex-persistedstate";
import adminStore from "./adminStore";

export default createStore({
  modules: {
    accountStore,
    menuStore,
    platformInfoStore,
    loadingEffect,
    adminStore
  },
  plugins: [
    createPersistedState({
      paths: ["accountStore",],
    })
  ]
});