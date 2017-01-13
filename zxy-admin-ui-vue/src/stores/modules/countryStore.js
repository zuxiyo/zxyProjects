import * as types from '../mutation-types'
import countryServer from "../../api/countryService.js"
import PAGEABLE from "../../utils/pageArgs"
import { Message } from 'element-ui';

export default {
/**
 * 定义模块,可以使用同名的方法和函数
 */
  state:{
    _formData: {},
    _countryDataSet: [],
    _currentPage:PAGEABLE.CURRENT_PAGE,
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
    ["country/getPage"](context,pageParams) {
      context.commit("SET_PAGE_SIZE", pageParams.pageSize)
      context.commit("SET_CURRENT_PAGE", pageParams.currentPage)

      let promise = countryServer.getPage(context.state._currentPage,  context.state._pageSize)

      promise.then(function (responseBody) {
        context.commit("COUNTRY_PAGE", responseBody)
      })

      promise.catch(function (responseBody) {
        context.commit("ERROR", responseBody)
      })

      return promise;
    },
    /**
     * 获得一项信息
     */
    get(context) {

    },
    ["country/getFormData"](context){
      return Promise.resolve(context.state._formData)
    },
    /**
     * 设置表单数据
     */
    ["country/setFormData"](context,formData){
       context.commit("SET_FORM_DATA", formData)
    },
    /**
     * 新增数据
     */
    ["country/create"](context,formData) {
      let promise = countryServer.create(formData)

      promise.then(function(responseBody){
         context.commit("COUNTRY_CREATED", responseBody)
      })

      promise.catch(function (responseBody) {
        context.commit("ERROR", responseBody)
      })

      return promise;
    },
    /**
     * 更新数据
     */
    ["country/update"](context,formData) {
      let promise = countryServer.update(formData)

      promise.then(function (responseBody) {
        context.commit("COUNTRY_UPDATED", responseBody)
      })

      promise.catch(function (responseBody) {
        context.commit("ERROR", responseBody)
      })

      return promise;
    },
    /**
     * 删除数据
     */
    ["country/delete"](context,code) {
      let promise = countryServer.delete(code)

      promise.then(function (responseBody) {
        context.commit("COUNTRY_DELETED", responseBody)
      })

      promise.catch(function (responseBody) {
        context.commit("ERROR", responseBody)
      })

      return promise;
    },
  },

mutations: {
    [types.COUNTRY_PAGE](state, responseBody) {
      state._countryDataSet = responseBody.data.content
      state._total = responseBody.data.totalElements
    },

    [types.COUNTRY_GET](state, responseBody) {

    },

    [types.COUNTRY_CREATED](state, responseBody) {
      Message.success(responseBody.message);
    },

    [types.COUNTRY_UPDATED](state, responseBody) {
      Message.success(responseBody.message);
    },

    [types.COUNTRY_DELETED](state, responseBody) {
      Message.success(responseBody.message);
    },

    [types.ERROR](state, responseBody) {
      Message.error(responseBody.message);
    },

    [types.SET_PAGE_SIZE](state, pageSize) {
      state._pageSize = pageSize
    },

    [types.SET_CURRENT_PAGE](state, currentPage) {
      state._currentPage = currentPage
    },

    [types.SET_FORM_DATA](state, selectedRow) {
      state._formData = selectedRow
    },
  }
}
