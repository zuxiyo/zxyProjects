import Vue from "vue";
import VueRouter from "vue-router";
import orgs from './maps/orgsMap.js'
import permits from './maps/permitsMap.js'
import sys from './maps/settingsMap.js'

Vue.use(VueRouter)

const RoutesMap = [
  {
    path: '/',
    components: {
      //命名视图
      layoutView: function (resolve) {
        require(['../components/_layouts/Layout.vue'], resolve)
      }
    }
  },
  ...orgs,
  ...permits,
  ...sys
]

// 创建一个路由器实例
const router = new VueRouter({
  routes: RoutesMap
});
//console.log(RoutesMap)

/*
Vue.config.debug = true;*/
router.beforeEach((to, from, next) => {
  //console.log(router);
  //console.info("to:" + to.path + ",from:" + from.path + ",next:" + next.name);
  next();
});

export default router
