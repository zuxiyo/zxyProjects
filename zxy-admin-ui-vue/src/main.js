/* 更新modules
npm update vue --save
npm update vuex --save
npm update vue-router --save
npm update vue-resource --save
npm update element-ui --save*/

import Vue from "vue";
import store from './stores'
import ElementUI from "element-ui";
import route from "./routes";
import Layout from "./components/_layouts/Layout";
//import "element-ui/lib/theme-default/index.css";


Vue.use(ElementUI);

const app = new Vue({
  el: "#mainApp",
  router: route,
  store:store,
  render: h => h(Layout)
});
