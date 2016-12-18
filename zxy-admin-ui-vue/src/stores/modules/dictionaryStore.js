import * as types from '../mutation-types'
import dictServer from "../../api/dictService.js"
import { Message } from 'element-ui';

const state = {
  _categoryData: [],
  _itemData: [],
  _categoryCurrentRow: null,
  _itemUpdateFrom: null,
  _categoryForm: {},
  _itemForm: {},
  _categoryName: "无"
}

const getters = {
  //字典类别集合
  categoryDataSet: function(state){ return state._categoryData },
  //字典项集合
  itemDataSet: state => state._itemData,
  //类别表单
  categoryForm: state => state._categoryForm,
  //字典项表单
  itemForm: state => state._itemForm,
  //当前选中的类别行
  categoryCurrentRow : state => state._categoryCurrentRow,
  //当前选中的字典项行
  itemUpdateForm : state => state._itemUpdateFrom,
  //类别名称
  itemTableTitle: state => state._categoryName
}

const actions = {
  /**
   * 获得类别数据
   */
  getCategoryPage(context) {
    //从服务器获得数据，必须使用回调函数进行设置，因为Ajax调用方法是异步的
    dictServer.getCategoryPage(0, 100, function (body) {
      context.commit("DICT_GET_CATEGORY_LIST", body)
    });
  },
  /**
   * 选中类别行事件,第一个参数永远是自身
   */
  selectedCategoryRow(context, categoryInfo) {
    context.commit("DICT_SET_ITEM_TABLE_TITLE", categoryInfo.categoryName)
    context.commit("DICT_SELECTED_CATEGORY_ROW", categoryInfo)

    context.dispatch("getItemPage",categoryInfo)
  },
  /**
   * 选中字典项事件
   */
  selectedItemRow(context, itemInfo) {
    context.commit("DICT_SELECTED_ITEM_ROW", itemInfo)
  },
  /**
   * 新增类别
   */
  addCategory(context) {
    //var formData = JSON.stringify(context.getters.categoryForm);
    var formData = context.getters.categoryForm
    dictServer.addCategory(formData, function (body) {
      //成功回调函数
      context.commit("DICT_ADDED_CATEGORY", {isSuccess:true, requestBody:body})
    }, function (body) {
      //失败回调函数
      context.commit("DICT_ADDED_CATEGORY", {isSuccess:false, requestBody:body})
    });
  },
  updateCategory(context) {
     var formData = context.getters.categoryCurrentRow
     dictServer.updateCategory(formData,function (body) {
      //成功回调函数，commit只能接受两个参数，所以这里封装成对象传过去
      context.commit("DICT_UPDATED_CATEGORY", {isSuccess:true, requestBody:body})
    }, function (body) {
      //失败回调函数
      context.commit("DICT_UPDATED_CATEGORY",{isSuccess:false, requestBody:body})
    });
  },
  deleteCategory(context){
    return new Promise((resolve, reject) => {
      let uid = context.getters.categoryCurrentRow.uid
      dictServer.deleteCategory(uid,function (body) {
        context.commit("DICT_DELETED_CATEGORY", {isSuccess:true, requestBody:body})
        resolve()
      }, function (body) {
        //失败回调函数
        context.commit("DICT_DELETED_CATEGORY",{isSuccess:false, requestBody:body})
        reject()
      });
    })
  },
  /**
   * 获得字典项列表
   */
  getItemPage(context,categoryInfo){
    //从服务器获得数据，必须使用回调函数进行设置，因为Ajax调用方法是异步的
    dictServer.getItemPage(0, 100, categoryInfo, function (body) {
      context.commit("DICT_GET_ITEM_LIST", body)
    });
  },
  /**
   * 字典项操作
   */
  addItem(context) {
    var formData = context.getters.itemForm
    dictServer.addItem(formData, function (body) {
      //成功回调函数
      context.commit("DICT_ADDED_ITEM", {isSuccess:true, requestBody:body})
    }, function (body) {
      //失败回调函数
      context.commit("DICT_ADDED_ITEM", {isSuccess:false, requestBody:body})
    });
  },
  updateItem(context) {
    var formData = context.getters.itemUpdateForm
    dictServer.updateItem(formData,function (body) {
      //成功回调函数，commit只能接受两个参数，所以这里封装成对象传过去
      context.commit("DICT_UPDATED_ITEM", {isSuccess:true, requestBody:body})
    }, function (body) {
      //失败回调函数
      context.commit("DICT_UPDATED_ITEM",{isSuccess:false, requestBody:body})
    });
  },
  //删除字典项，使用Promise 异步操作后有返回值，返回后再绑定数据，如果不使用Promise，会先执行绑定数据的方法，在删除数据
  deleteItem(context){
    return new Promise((resolve, reject) => {
      let uid = context.getters.itemUpdateForm.uid
      dictServer.deleteItem(uid,function (body) {
        context.commit("DICT_DELETED_ITEM", {isSuccess:true, requestBody:body})
        resolve()
      }, function (body) {
        //失败回调函数
        context.commit("DICT_DELETED_ITEM",{isSuccess:false, requestBody:body})
        reject()
      });
    })
  }
}

const mutations = {
  //设置类别列表
  [types.DICT_GET_CATEGORY_LIST](state, requestBody) {
    state._categoryData = requestBody.data.content
  },
  //设置字典项列表
  [types.DICT_GET_ITEM_LIST](state, requestBody) {
    state._itemData = requestBody.data.content
  },
  //选择类别行
  [types.DICT_SELECTED_CATEGORY_ROW](state, categoryInfo) {
    state._categoryCurrentRow = categoryInfo
    state._itemForm.categoryCode = categoryInfo.categoryCode
  },
  //选择字典项行
  [types.DICT_SELECTED_ITEM_ROW](state, itemInfo) {
    //Object深拷贝,在取消修改后不会改变原始数据
    /*var temp = {}
    for (var i in itemInfo) {
        temp[i] = itemInfo[i]
    }
    state._itemUpdateForm = temp*/
    state._itemUpdateFrom = JSON.parse(JSON.stringify(itemInfo))
  },
  //设置字典项列表的标题
  [types.DICT_SET_ITEM_TABLE_TITLE](state,title){
    //
    state._categoryName = JSON.parse(JSON.stringify(title))
  },
  //新增类别后
  [types.DICT_ADDED_CATEGORY](state, resultObj) {
    if (resultObj.isSuccess) {
      resetCategoryForm(state)
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  },
  //修改类别后
  [types.DICT_UPDATED_CATEGORY](state, resultObj) {
    if (resultObj.isSuccess) {
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  },
  //删除类别后
  [types.DICT_DELETED_CATEGORY](state, resultObj) {
    if (resultObj.isSuccess) {
      state._categoryCurrentRow = null
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  },
  //新增字典项后
  [types.DICT_ADDED_ITEM](state, resultObj) {
    if (resultObj.isSuccess) {
      resetItemForm(state)
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  },
  //修改字典项后
  [types.DICT_UPDATED_ITEM](state, resultObj) {
    if (resultObj.isSuccess) {
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  },
  //删除字典项后
  [types.DICT_DELETED_ITEM](state, resultObj) {
    if (resultObj.isSuccess) {
      state._itemUpdateFrom = null
      Message.success(resultObj.requestBody.message);
    } else {
      Message.error(resultObj.requestBody.message);
    }
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}

//重置表单
function resetCategoryForm(state){
  state._categoryForm = {
      sort:"",
      categoryCode: "",
      categoryName: "",
      status:false,
      remark:""
    }
}

//重置表单
function resetItemForm(state){
  state._itemForm = {
      sort:"",
      categoryCode:state._itemForm.categoryCode,
      dictionaryCode: "",
      dictionaryName: "",
      status:false,
      remark:""
    }
}
