var tooltip = {
  isShow: false,
  title: "",
  type: "success",
  setToAddedSuccessTooltip: function (body) {
    if (body == null || body == "" )
      body = "新增成功！!"
    this.isShow = true;
    this.title = body;
    this.type = "success";
  },
  /*setToSuccessTooltip : function(){
    this.isShow = true;
    this.title = "";
    this.type = "success";
  },*/
  setToAddedErrorTooltip: function (body) {
    if (body == null || body == "")
      body = "新增失败！!"
    this.isShow = true;
    this.title = body;
    this.type = "error";
  }
}

export default tooltip
