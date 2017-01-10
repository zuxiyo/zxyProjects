import { Server } from "./config/serverUrl.js"
import Http from "./config/http.js";

/**
 * 国家或地区服务操作接口
 */
class CountryServer {


  /**
   * 获取一页数据
   * @param {any} currentPag   当前页码
   * @param {any} pageSize    一页的大小
   * @returns 请求页的数据
   *
   * @memberOf CountryServer
   */
  getPage(currentPage, pageSize) {
    var options = {
      params: { pageIndex: currentPage, pageSize: pageSize }
    }

    var p = new Promise((resolve, reject) => {
      Http.get(Server.Country_Page_Url, options)
        .then(function (body) {
          resolve(body)
        })
        .catch(function (body) {
          reject(body)
        })
    })
    return p
  }
    /**
     * 获取一项数据
     */
  get(id) {
    var options = { params: { id: id } }

    var p = new Promise((resolve, reject) => {
      Http.get(Server.Country_Get_Url, options)
        .then(function (body) {
          resolve(body)
        })
        .catch(function (body) {
          reject(body)
        })
    })
    return p
  }

  /**
   * 新增数据
   */
  create(formData) {
    var p = new Promise((resolve, reject) => {
      Http.save(Server.Country_Create_Url, formData)
        .then(function (body) {
          resolve(body)
        })
        .catch(function (body) {
          reject(body)
        })
    })
    return p
  }

  /**
   * 更新数据
   */
  update(formData) {
     var p = new Promise((resolve, reject) => {
      Http.save(Server.Country_Update_Url, formData)
        .then(function (body) {
          resolve(body)
        })
        .catch(function (body) {
          reject(body)
        })
    })
    return p
  }

  /**
   * 删除数据
   */
  delete(id) {
    var options = { params: { id: id } }

    var p = new Promise((resolve, reject) => {
      Http.delete(Server.Country_Delete_Url, options)
        .then(function (body) {
          resolve(body)
        })
        .catch(function (body) {
          reject(body)
        })
    })
    return p
  }
}

export default new CountryServer()
