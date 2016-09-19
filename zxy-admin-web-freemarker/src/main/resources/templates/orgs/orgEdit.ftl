<div class="container-fluid"> 
<form class="form-horizontal" role="form"> 
 	<div class="form-group">
        <label for="parentOrg" class="col-sm-2 control-label">上级机构</label>
        <div class="col-sm-4">
        	<select class="form-control" id="parentOrg"></select>
        </div>
        <label for="orgType" class="col-sm-2 control-label">机构类型</label>
        <div class="col-sm-4">
        	<select class="form-control" id="orgType"></select>
        </div>
    </div>  
 	<div class="form-group"> 
        <label for="orgCode" class="col-sm-2 control-label">机构代码</label>
        <div class="col-sm-4"> 
        	<input type="text" class="form-control" id="orgCode" placeholder="请输入机构代码">
        </div>
        <label for="sort" class="col-sm-2 control-label">排序号</label>
        <div class="col-sm-4">
        	<input type="text" class="form-control" id="sort" name="sort" placeholder="请输入排序号">
        </div>
    </div> 
    <div class="form-group"> 
        <label class="col-sm-2 control-label" for="orgName">机构简称</label>
        <div class="col-sm-10">
        	<input type="text" class="form-control" id="orgName" placeholder="请输入机构简称"> 
        </div>
    </div> 
    <div class="form-group"> 
        <label class="col-sm-2 control-label" for="fullName">完整名称</label>
        <div class="col-sm-10">
        	<input type="text" class="form-control" id="fullName" placeholder="请输入机构完整名称"> 
        </div>
    </div>
    <div class="form-group"> 
        <label class="col-sm-2 control-label" for="englishName">英文名称</label>
        <div class="col-sm-10">
       	    <input type="text" class="form-control" id="englishName" placeholder="请输入机构英文名称">
        </div> 
    </div>
    <div class="form-group"> 
        <label class="col-sm-2 control-label" for="address">地址</label>
        <div class="col-sm-10">
       	    <input type="text" class="form-control" id="address" placeholder="请输入机构地址">
        </div> 
    </div>
    <div class="form-group">
        <label for="countryName" class="col-sm-2 control-label">国家/地区</label>
        <div class="col-sm-4">
        	<select class="form-control" id="countryName"></select>
        </div>
        <label for="regionName" class="col-sm-2 control-label">省/地区</label>
        <div class="col-sm-4">
        	<select class="form-control" id="regionName"></select>
        </div>
    </div>
    <div class="form-group">
        <label for="cityName" class="col-sm-2 control-label">所在城市</label>
        <div class="col-sm-4">
        	<select class="form-control" id="cityName"></select>
        </div>
        <label for="postCode" class="col-sm-2 control-label">邮政编码</label>
        <div class="col-sm-4">
        	<input type="text" class="form-control" id="postCode">
        </div>
    </div>
    <div class="form-group"> 
        <label for="tel" class="col-sm-2 control-label">电话</label>
        <div class="col-sm-4"> 
        	<input type="text" class="form-control" id="tel">
        </div>
        <label for="fax" class="col-sm-2 control-label">传真</label>
        <div class="col-sm-4">
        	<input type="text" class="form-control" id="fax">
        </div>
    </div>
    <hr class="divider"/>
    <div class="form-group"> 
    	<div class="col-sm-2 col-sm-offset-4"> 
        	<a class="btn btn-primary btn-sm" href="#"><i class="fa fa-save"></i> 保存</a>
        </div>
        <div class="col-sm-6">
        	<a class="btn btn-default btn-sm" href="javascript: $('#popupDialog').dialog('close')"><i class="fa fa-close"></i> 关 闭</a>
        </div>
    </div>
</form>
</div>
