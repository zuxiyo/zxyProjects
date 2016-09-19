<div class="container-fluid"> 
<form class="form-horizontal" role="form" id="addForm">
   <div class="form-group">
      <label for="sort" class="col-sm-2 control-label">排序号</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="sort" name="sort" placeholder="请输入排序号">
      </div>
   </div>
   <div class="form-group">
      <label for="categoryCode" class="col-sm-2 control-label">编码</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="categoryCode" name="categoryCode" placeholder="请输入种类编号/代码">
      </div>
   </div>
   <div class="form-group">
      <label for="categoryName" class="col-sm-2 control-label">名称</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="请输入种类名称">
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <label>
               <input type="checkbox" id="status" name="status">  禁用
            </label>
         </div>
      </div>
   </div>
   <div class="form-group">
      <label for="remark" class="col-sm-2 control-label">备注</label>
      <div class="col-sm-10">
         <textarea class="form-control" rows="2" id="remark" name="remark"></textarea>
      </div>
   </div>
   <hr class="divider"/>
    <div class="form-group">
		<div class="col-sm-offset-2 col-sm-5">
			<a class="btn btn-primary btn-sm" href="javascript:void(0)" id="btnSave"><i class="fa fa-save"></i> 保存</a>
        </div>
        <div class="col-sm-5"> 
			<a class="btn btn-default btn-sm" href="javascript: $('#popupDialog').dialog('close')"><i class="fa fa-close"></i> 关 闭</a>
        </div>
    </div>
</form>
</div>
<script type="text/javascript">
 
$(function () {
    $("#btnSave").click( function () {
    	var _json = $('#addForm').serialize();
        var request = $.ajax({  
            url: "saveCategory",  
            type: "POST",  
            async: false,  
            data: _json,
            cache: false,  
            success: function (r, textStatus) {  
                alert(r);  
                $('#addForm').trigger("reset");
                reloadCategoryGrid();
            },  
            error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); }  
        });
    });
 });
</script>