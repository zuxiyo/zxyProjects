import * as types from '../mutation-types'
import countryServer from "../../api/countryService.js"
import PAGEABLE from "../../utils/pageArgs"
import { Message } from 'element-ui';

export default {
/**
 * 定义模块,可以使用同名的方法和函数
 */
  state:{
    _countryDataSet: [],
    _currentPage:PAGEABLE.PAGE_INDEX,
    _total:0,
    _pageSize:PAGEABLE.PAGE_SIZE,
    _pageSizes:PAGEABLE.PAGE_SIZES
  },

  getters:{
    ["country/countryDataSet"]: state => state._countryDataSet,
    ["country/currentPage"]: state => state._currentPage,
    ["country/total"]: state => state._total,
    ["country/pageSize"]: state => state._pageSize,
    ["country/pageSizes"]: state => state._pageSizes,
  },

  actions:{
    /**
     * 获得一页数
     */
    ["country/getPage"](context) {
      countryServer.getPage(context.state._currentPage, context.state._pageSize)
        .then(function (body) {
          context.commit("COUNTRY_PAGE", body)
        })
        .catch(function (body) {
          context.commit("ERROR", body)
        })
    },
    /**
     * 获得一项信息
     */
    get(context) {

    },
    /**
     * 新增数据
     */
    create(context) {

    },
    /**
     * 更新数据
     */
    update(context) {

    },
    /**
     * 删除数据
     */
    delete(context) {

    }
  },

mutations: {
    [types.COUNTRY_PAGE](state, responseBody) {
      state._countryDataSet = responseBody.data.content
      state._total = responseBody.data.totalElements
    },

    [types.COUNTRY_GET](state, responseBody) {

    },

    [types.COUNTRY_CREATED](state, responseBody) {

    },

    [types.COUNTRY_UPDATED](state, responseBody) {

    },

    [types.COUNTRY_DELETED](state, responseBody) {

    },

    [types.ERROR](state, responseBody) {
      Message.error(responseBody.message);
    }
  }
}

//export default {
 // Country
//}
