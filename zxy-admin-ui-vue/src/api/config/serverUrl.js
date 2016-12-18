///Web API 服务地址
const _SERVER_ROOT_URL =  "http://localhost:8090/";

var ServerUrlConfig = {
  //字典类别操作
  Dict_Category_List_Url:   _SERVER_ROOT_URL + "dict/category/list",
  Dict_Category_get_Url:    _SERVER_ROOT_URL + "dict/category/get{/uid}",
  Dict_Category_create_Url: _SERVER_ROOT_URL + "dict/category/create",
  Dict_Category_Update_Url: _SERVER_ROOT_URL + "dict/category/update",
  Dict_Category_Delete_Url: _SERVER_ROOT_URL + "dict/category/delete{/uid}",

  //字典项操作
  Dict_Item_List_Url:   _SERVER_ROOT_URL + "dict/item/list",
  Dict_Item_get_Url:    _SERVER_ROOT_URL + "dict/item/get{/uid}}",
  Dict_Item_create_Url: _SERVER_ROOT_URL + "dict/item/create",
  Dict_Item_Update_Url: _SERVER_ROOT_URL + "dict/item/update",
  Dict_Item_Delete_Url: _SERVER_ROOT_URL + "dict/item/delete{/uid}",
}

export { ServerUrlConfig as Server };
