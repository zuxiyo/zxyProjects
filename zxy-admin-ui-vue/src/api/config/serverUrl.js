///Web API 服务地址
const _SERVER_ROOT_URL =  "http://localhost:8090/";

var ServerUrlConfig = {
  //字典类别操作
  Dict_Category_Page_Url:   _SERVER_ROOT_URL + "dict/category/get",
  Dict_Category_Get_Url:    _SERVER_ROOT_URL + "dict/category/get{/uid}",
  Dict_Category_Create_Url: _SERVER_ROOT_URL + "dict/category/create",
  Dict_Category_Update_Url: _SERVER_ROOT_URL + "dict/category/update",
  Dict_Category_Delete_Url: _SERVER_ROOT_URL + "dict/category/delete{/uid}",

  //字典项操作
  Dict_Item_Page_Url:   _SERVER_ROOT_URL + "dict/item/get",
  Dict_Item_Get_Url:    _SERVER_ROOT_URL + "dict/item/get{/uid}}",
  Dict_Item_Create_Url: _SERVER_ROOT_URL + "dict/item/create",
  Dict_Item_Update_Url: _SERVER_ROOT_URL + "dict/item/update",
  Dict_Item_Delete_Url: _SERVER_ROOT_URL + "dict/item/delete{/uid}",

  //国家或地区操作
  Country_Page_Url:   _SERVER_ROOT_URL + "countries/get",
  Country_Get_Url:    _SERVER_ROOT_URL + "countries/get{/uid}}",
  Country_Create_Url: _SERVER_ROOT_URL + "countries/create",
  Country_Update_Url: _SERVER_ROOT_URL + "countries/update",
  Country_Delete_Url: _SERVER_ROOT_URL + "countries/delete{/uid}",
}

export { ServerUrlConfig as Server };
