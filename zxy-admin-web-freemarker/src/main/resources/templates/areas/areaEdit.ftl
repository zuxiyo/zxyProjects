<#include "../_layouts/components/AreaLevelDropDownList.ftl">
<#include "../_layouts/components/CountriesDropDownList.ftl">
<#include "../_layouts/components/AreasSelectDialog.ftl">

<div class="container-fluid"> 
	<form class="form-horizontal" role="form" id="areaForm">
	   <div class="form-group"> 
	        <label class="col-sm-2 control-label" for="countyCode">国别</label>
	        <div class="col-sm-10">
	       	    <@CountriesDropDownList id="countryCode" dataSource=(countries)! selected="${(model.countryCode)!defaultCountryCode}" class="form-control"/>
	        </div> 
	    </div>
	   
	   <div class="form-group">
	        <label for="parentCode" class="col-sm-2 control-label">上级区划</label>
	        <div class="col-sm-10">
	        	<@AreasSelectDialog id="parentCode"  countryDropDownListId="countryCode" selected="${(model.parentCode)!}"
	        	 fullPositionCode="positionCode" fullPositionName="positionName"/>
	        </div>	        
	    </div>
	 	<div class="form-group"> 
	        <label for="areaCode" class="col-sm-2 control-label">区划代码</label>
	        <div class="col-sm-4"> 
	        	<input type="text" class="form-control" id="areaCode"  name="areaCode" placeholder="请输入区划代码" value="${(model.areaCode)!}">
	        </div>
	        <label for="areaName" class="col-sm-2 control-label">区划名称</label>
	        <div class="col-sm-4">
	        	<input type="text" class="form-control" id="areaName" name="areaName" placeholder="请输入排序号" value="${(model.areaName)!}">
	        </div>
	    </div> 
	    <div class="form-group">
	    	<label for="shortName" class="col-sm-2 control-label">区划简称</label>
		    <div class="col-sm-4">
		        <input type="text" class="form-control" id="shortName" name="shortName" placeholder="请输入区划简称" value="${(model.shortName)!}">
	        </div>
	    	<label for="sort" class="col-sm-2 control-label">排序号</label>
		    <div class="col-sm-4">
		        <input type="text" class="form-control" id="sort" name="sort" placeholder="请输入排序号" value="${(model.sort)!}">
	        </div>
	    </div>
	    <div class="form-group"> 
	        <label class="col-sm-2 control-label" for="fullName">区划全称</label>
	        <div class="col-sm-4">
	        	<input type="text" class="form-control" id="fullName"  name="fullName" value="${(model.fullName)!}"> 
	        </div>
	        <label for="areaLevel" class="col-sm-2 control-label">行政级别</label>
	        <div class="col-sm-4">
	        	<@AreaLevelDropDownList id="areaLevel" selected="${(model.areaLevel)!}"/>
	        </div>
	    </div>
	    <div class="form-group"> 
	        <label class="col-sm-2 control-label" for="englishName">英文名称</label>
	        <div class="col-sm-10">
	       	    <input type="text" class="form-control" id="englishName" name="englishName"  value="${(model.englishName)!}"/>
	        </div> 
	    </div>
	    <div class="form-group"> 
	        <label for="postCode" class="col-sm-2 control-label">邮政编码</label>
	        <div class="col-sm-4">
	        	<input type="text" class="form-control" id="postCode" name="postCode" value="${(model.postCode)!}"/>
	        </div>
	        <label for="phoneCode" class="col-sm-2 control-label">电话区号</label>
	        <div class="col-sm-4"> 
	        	<input type="text" class="form-control" id="phoneCode" name="phoneCode" value="${(model.phoneCode)!}"/>
	        </div>        
	    </div>
	    <div class="form-group">
	        <label for="lng" class="col-sm-2 control-label">经度</label>
	        <div class="col-sm-4">
	        	<input type="text" class="form-control" id="lng" name="lng" value="${(model.lng)!}"/>
	        </div>
	        <label for="lat" class="col-sm-2 control-label">纬度</label>
	        <div class="col-sm-4">
	        	<input type="text" class="form-control" id="lat" name="lat" value="${(model.lat)!}"/>
	        </div>
	    </div> 
	    <div class="form-group">
	      <div class="col-sm-offset-2 col-sm-10">
	         <div class="checkbox">
	            <label>
	               <#if model??>
	               	  <input type="checkbox" id="status" name="status" <#if model.status == true > checked </#if> />禁用
	               <#else>
	                  <input type="checkbox" id="status" name="status" />禁用
	               </#if>
	               
	            </label>
	         </div>
	      </div>
	   </div>   
	    <hr class="divider"/>
	    <div class="form-group"> 
	    	<div class="col-sm-2 col-sm-offset-4"> 
	        	<a class="btn btn-primary btn-sm" href="javascript:void(0)" id="btnUpdate"><i class="fa fa-save"></i> 保存</a>
	        </div>
	        <div class="col-sm-6">
	        	<a class="btn btn-default btn-sm" href="javascript:closeDialog();"><i class="fa fa-close"></i> 关 闭</a>
	        </div>
	    </div>
	</form>
</div>
<script type="text/javascript"> 
function getActionUrl(){
	if("${(model.areaName)!}".length == 0)
		return "add";
	else
		return "update";
}

$(function () {
    $("#btnUpdate").click( function () {
    	var _json = $('#areaForm').serialize();
        var request = $.ajax({  
            url: getActionUrl(),  
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