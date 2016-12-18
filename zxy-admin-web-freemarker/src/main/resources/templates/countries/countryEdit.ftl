<div class="container-fluid"> 
<form class="form-horizontal" role="form" id="countryForm">
   <div class="form-group">
      <label for="countryCode" class="col-sm-2 control-label">代码</label>
      <div class="col-sm-4">
         <input type="hidden" value="${model.countryCode}" id="countryCode" name="countryCode"/> 
         <p class="form-control-static">${model.countryCode}</p>
      </div>      
      <label for="sort" class="col-sm-2 control-label">排序号</label>
      <div class="col-sm-4">
         <input type="text" class="form-control" id="sort" name="sort" placeholder="请输入排序号" value="${model.sort}">
      </div>
   </div> 
   <div class="form-group">
      <label for="countryName" class="col-sm-2 control-label">简称</label>
      <div class="col-sm-4">
         <input type="text" class="form-control" id="countryName" name="countryName" placeholder="请输入国家或地区的简称" value="${model.countryName}">
      </div>      
      <label for="englishName" class="col-sm-2 control-label">英文简称</label>
      <div class="col-sm-4">
         <input type="text" class="form-control" id="englishName" name="englishName" placeholder="请输入国家或地区的英文简称" value="${model.englishName}">
      </div>
   </div>
   <div class="form-group">
      <label for="fullName" class="col-sm-2 control-label">全称</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="fullName" name="fullName" placeholder="请输入国家或地区的全称" value="${model.fullName}">
      </div>
   </div>
   <div class="form-group">
      <label for="phoneCode" class="col-sm-2 control-label">电话代码</label>
      <div class="col-sm-4">
         <input type="text" class="form-control" id="phoneCode" name="phoneCode" value="${model.phoneCode}">
      </div>
      <label for="domainName" class="col-sm-2 control-label">域名缩写</label>
      <div class="col-sm-4">
         <input type="text" class="form-control" id="domainName" name="domainName" value="${model.domainName}">
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <label>
               <input type="checkbox" id="status" name="status" <#if (model.status == true)> checked </#if> />  禁用
            </label>
         </div>
      </div>
   </div>
   <hr class="divider"/>
   <div class="form-group">
	   <div class="col-sm-offset-3 col-sm-4">
		 <a class="btn btn-primary btn-sm" href="javascript:void(0)" id="btnUpdate"><i class="fa fa-save"></i> 更新</a>
       </div>
       <div class="col-sm-5"> 
		 <a class="btn btn-default btn-sm" href="javascript:closeDialog();"><i class="fa fa-close"></i> 关 闭</a>
       </div>
   </div>
</form>
</div>
<script type="text/javascript"> 
$(function () {
    $("#btnUpdate").click( function () {
    	var _json = $('#countryForm').serialize();
        var request = $.ajax({  
            url: "update",  
            type: "POST",  
            async: false,  
            data: _json,
            cache: false,  
            success: function (result, textStatus) {  
            	if(result.success){
                    alert(result.message);
                    reloadGrid();
                    closeDialog();
                }else
		    		alert("error：" + result.message);                       
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); }  
        });
    });
 });
 
 function closeDialog(){
	 $('#popupDialog').dialog('close')
 }
</script>