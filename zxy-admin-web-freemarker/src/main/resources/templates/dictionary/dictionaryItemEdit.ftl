<div class="container-fluid"> 
<form class="form-horizontal" role="form" id="addItemForm">
   <input type="hidden" id="categoryCode" name="categoryCode"/>
   <div class="form-group">
      <label for="parentCode" class="col-sm-2 control-label">所属上级</label>
      <div class="col-sm-10">
         <select id="parentCode" name="parentCode" class="form-control"></select>
      </div>
   </div>
   <div class="form-group">
      <label for="sort" class="col-sm-2 control-label">排序号</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="sort" name="sort" placeholder="请输入排序号">
      </div>
   </div>
   <div class="form-group">
      <label for="dictionaryCode" class="col-sm-2 control-label">字典项代码</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="dictionaryCode" name="dictionaryCode"  placeholder="请输入字典项代码">
      </div>
   </div>
   <div class="form-group">
      <label for="dictionaryName" class="col-sm-2 control-label">字典项名称</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="dictionaryName" name="dictionaryName" placeholder="请输入字典项名称">
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">备注</label>
      <div class="col-sm-10">
         <textarea class="form-control" rows="2" id="remark" name="remark"></textarea>
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <label>
               <input type="checkbox" id="status" name="status">禁用
            </label>
         </div>
      </div>
   </div>
   <hr class="divider"/>
    <div class="form-group">
    	<div class="col-sm-offset-3 col-sm-4">
        	<a class="btn btn-primary btn-sm" href="javascript:void(0)" id="btnItemSave"><i class="fa fa-save"></i> 保存</a>
        </div>
        <div class="col-sm-5"> 
        	<a class="btn btn-default btn-sm" href="javascript:$('#popupDialogForItem').dialog('close')"><i class="fa fa-close"></i> 关 闭</a>
        </div>
    </div>
</form>
</div>
<script type="text/javascript">
$(function () {
	var categoryCode = $("#dictItemsTitle").data("code");
	$("#categoryCode").val(categoryCode);
	bindParentSelect(categoryCode);
	
	$("#btnItemSave").click( function () {
    	var _json = $('#addItemForm').serialize();
        var request = $.ajax({  
            url: "saveItem",  
            type: "POST",  
            async: false,  
            data: _json,
            cache: false,  
            success: function (r, textStatus) {  
                alert(r);  
                $('#addItemForm').trigger("reset");
                reloadItemGrid();
                bindParentSelect(categoryCode);
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); }  
        });
    });
	
	function bindParentSelect(categoryCode){
		$.ajax({  
            url: "getItemData", 
            data:{"categoryCode":categoryCode},
            type: "GET", 
            dataType: "json",
            cache: false,  
            success: function (r, textStatus) {  
            	$("#parentCode").empty();//清空下拉框             	 
            	$("#parentCode").append("<option value=''>------请选择------</option>");
            	
            	if(r.length <= 0)
            		return;
            	
            	var topData = getTopObject(r);
            	$.each(topData,function(index,jsonItem){
            		$("#parentCode").append('<option value='+jsonItem.dictionaryCode+' >├─'+jsonItem.dictionaryName+'</option>');
            		ChildNodeBind(r, jsonItem.parentCode,1);
            	});
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); } 
		});
	};
	
	function getTopObject(data){
		
		var targetData = [];  
		$.each(data,function(index,jsonItem){
			//console.log("getTopObject:" + jsonItem )
			if(jsonItem.parentCode == "" || jsonItem.parentCode == "0"){
				targetData.push(jsonItem);
			}
		});
		return targetData;
	}
	
	function ChildNodeBind(data,parentCode,separatorCount){
		
		//防止死循环,大于5层时退回
        if (separatorCount == 5)
            return;
		
        var targetData = [];  
		$.each(data,function(index,jsonItem){
			//console.log("ChildNodeBind:" + jsonItem )
			if(jsonItem.parentCode != "" && jsonItem.parentCode != "0"  && jsonItem.parentCode == parentCode ){
				targetData.push(jsonItem);
			}
		});
		
		if(targetData.length > 0){
			
			var separator = "";
	        for (var i = 0; i < separatorCount; i++)
	            separator += "　";

	        separator += "├─";

	        $.each(targetData,function(index,jsonItem){
	        	$("#parentCode").append('<option value='+jsonItem.dictionaryCode+'>' + separator +jsonItem.dictionaryName+'</option>');
        		ChildNodeBind(data, jsonItem.parentCode,separatorCount + 1);
	        });	
		}
	}
 });
</script>