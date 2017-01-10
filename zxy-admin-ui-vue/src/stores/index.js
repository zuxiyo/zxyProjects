import Vue from "vue"
import Vuex from "vuex"
import * as actions from "./actions"
import * as getters from "./getters"
import dict from "./modules/dictionaryStore"
import country from "./modules/countryStore"

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'
console.log("debug:" + debug);

export default new Vuex.Store({
  namespaced: true,
  actions,
  getters,
  modules: {
    dict:{ namespaced: true, ...dict},
    country:{ namespaced: true, ...country},
    account: {
      namespaced: true,
      getters: {
        isAdmin () { console.log("isAdmin") } // -> getters['account/isAdmin']
      },
      actions: {
        login () { console.log("login") }
      }
    }
  },
  //strict: debug,
  strict: false,  //不启用严格模式
})
