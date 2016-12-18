import Vue from "vue"
import Vuex from "vuex"
import * as actions from "./actions"
import * as getters from "./getters"
import dict from "./modules/dictionaryStore"

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'
console.log("debug:" + debug);

export default new Vuex.Store({
  actions,
  getters,
  modules: {
    dict
  },
  //strict: debug,
  strict: false,  //不启用严格模式
})
