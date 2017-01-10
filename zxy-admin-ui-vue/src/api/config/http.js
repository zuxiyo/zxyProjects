//与WebAPI 的交互，可以使用任何拥有AJAX功能
import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

const http = {
  get: function (url, params) {
    var p = new Promise(function(resolve, reject){
      Vue.http.get(url, params).then((response) => {
        resolve(response.body);
      }, (response) => {
        reject(response.body);
      });
    });
    return p;
  },

  update: function (url, formData, successCallback, errorCallback) {
    return new Promise((resolve, reject) => {
      Vue.http.options.emulateJSON = true
      Vue.http.put(url, formData).then((response) => {
        resolve(response.body);
      }, (response) => {
        reject(response.body);
      });
    });
  },

  save: function (url, formData, successCallback, errorCallback) {
    //如果Web服务器无法处理编码为application/json的请求，可以启用emulateJSON选项。启用该选项后
    //请求会以application/x-www-form-urlencoded作为MIME type，就像普通的HTML表单一样。
    return new Promise((resolve, reject) => {
      Vue.http.options.emulateJSON = true
      Vue.http.post(url, formData).then((response) => {
        resolve(response.body);
      }, (response) => {
        reject(response.body);
      });
    });
  },

  delete: function (url, params, successCallback, errorCallback) {
    return new Promise((resolve, reject) => {
      Vue.http.delete(url, params).then((response) => {
        resolve(response.body);
      }, (response) => {
        reject(response.body);
      });
    });
  }
}

export default http;

/*
get: {method: 'GET'},
save: {method: 'POST'},
query: {method: 'GET'},
update: {method: 'PUT'},
remove: {method: 'DELETE'},
delete: {method: 'DELETE'}*/
