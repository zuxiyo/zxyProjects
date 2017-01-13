import  {Server} from "./config/serverUrl.js"
import  Http from "./config/http-callback.js";

/**
 * 数据字典服务端方法
 */
class DictService {

    /**
     * 获得字典类别数据
     */
    getCategoryPage(currentPage,pageSize,callback) {
        var options = {
          params: { currentPage: currentPage, pageSize:pageSize }
        }
        Http.get(Server.Dict_Category_Page_Url,options,callback)
    }

    /**
     * 获得字典项数据
     */
    getItemPage(currentPage,pageSize,categoryInfo,callback) {
        var options = {
          params: { currentPage: currentPage, pageSize:pageSize,categoryCode:categoryInfo.categoryCode}
        }
        Http.get(Server.Dict_Item_Page_Url,options,callback)
    }

    /**
     * 新增类别数据
     */
    addCategory(formData, successCallback, errorCallback){
      Http.save(Server.Dict_Category_Create_Url,formData, successCallback, errorCallback)
    }
    /**
     * 修改类别数据
     */
    updateCategory(formData, successCallback, errorCallback){
      Http.update(Server.Dict_Category_Update_Url,formData, successCallback, errorCallback)
    }
    /**
     * 删除类别数据
     */
    deleteCategory(uId, successCallback, errorCallback){
      var options = {
          params: {  uid : uId }
        }
      Http.delete(Server.Dict_Category_Delete_Url,options, successCallback, errorCallback)
    }

    /**
     * 新增字典项数据
     */
    addItem(formData, successCallback, errorCallback){
      Http.save(Server.Dict_Item_Create_Url,formData, successCallback, errorCallback)
    }
    /**
     * 修改字典项数据
     */
    updateItem(formData, successCallback, errorCallback){
      Http.update(Server.Dict_Item_Update_Url,formData, successCallback, errorCallback)
    }
    /**
     * 删除字典项数据
     */
    deleteItem(uId, successCallback, errorCallback){
      var options = {
          params: {  uid : uId }
        }
      Http.delete(Server.Dict_Item_Delete_Url,options,successCallback, errorCallback)
    }
}

export default new DictService()
