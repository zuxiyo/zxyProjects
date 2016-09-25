<#include "../_layouts/layout.ftl">
<#include "../_layouts/components/CountriesDropDownList.ftl">
<@header title="行政区划管理">
	<link href="//cdn.bootcss.com/datatables/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
	
	<script src="//cdn.bootcss.com/zTree.v3/3.5.24/js/jquery.ztree.all.js"></script>
	<link href="//cdn.bootcss.com/zTree.v3/3.5.24/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet">
	
	<script src="/libs/dataTables/dataTablesUitl.js"></script>
</@header>
<@body>
<section class="content-header"> 
 <div>
     <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;首页&nbsp;&nbsp;</a><i class="active fa fa-angle-right"></i>&nbsp;行政区划设置
     <p class="pull-right">
	     <button type="button" class="fa fa-plus btn btn-primary" id="btnAdd"> 添加</button> 
	     <button type="button" class="fa fa-trash-o btn btn-danger" id="btnDelete"> 删除</button>
     </p>
</div>
</section>
<section class="content">
	<div class="box box-default">
		<div class="box-header">
			<form class="form-horizontal" role="form" id="queryForm">
				<div class="form-group">
					<label class="col-sm-1 control-label" for="query-countyCode">国别 </label>
					<div class="col-sm-2">		
						<@CountriesDropDownList id="query-countryCode" name="countryCode" dataSource=(countries)! class="form-control"/>
					</div>
					<label class="col-sm-1 control-label" for="query-areaCode">代码</label> 
				    <div class="col-sm-2">
						<input type="text" class="form-control" id="query-areaCode" name="areaCode" placeholder="请输入名称"/>
					</div>
				    <label class="col-sm-1 control-label" for="query-areaName">名称</label> 
				    <div class="col-sm-2">
						<input type="text" class="form-control" id="query-areaName" name="areaName" placeholder="请输入名称"/>
					</div>
				    <div class="col-sm-3">
					    <button type="button" class="btn btn-default" id="btnQuery">查 询</button>
					</div>
				</div>
			</form>
		</div>
		<div class="box-body">
	     	<table id="dataTable" class="table table-striped table-bordered table-hover table-condensed">
	     	 <thead>
				<tr >
				    <th  class="text-center" style="width:15px"><input type="checkbox" name="chkAll" id="chkAll"/></th>
				    <th  class="text-center" style="width:30px">序</th>
				    <th  class="text-center">区划代码</th>
				    <th  class="text-center">区划名称</th>
				  <!--   <th  class="text-center">全称</th>
				    <th  class="text-center">英文简称</th>
				    <th  class="text-center">经度</th>
				    <th  class="text-center">纬度</th> --> 
				    <th  class="text-center" style="width:30px">等级</th>
				    <th  class="text-center">邮编</th>
				    <th  class="text-center">电话区号</th>
				    <th  class="text-center" style="width:30px">状态</th>
				    <th  class="text-center">操作</th>
				</tr>
			  </thead>
	     	</table>
     	</div>
    </div>
    <div id="popupDialog"></div>
</section>
<script type="text/javascript">

var _dataTable;

$(document).ready(function() {
    $("#btnAdd").click( function () {
        $("#popupDialog").load('addView').dialog({
        	height: 570,
            width: 700,
            title: '新增行政区划',
            modal: true,
            position: {
                my: 'center',
                at: 'center'
            }
        });
    });
    
    var columns = [
             {
            	 'targets': 0,'searchable': false,'orderable': false,'className': 'dt-body-center',data : "areaCode",
                 'render': function (data, type, full, meta){
                     return '<input type="checkbox" name="chkItem" value="' + data + '">';
             	  }
             },
             { data: "sort",title:"序" },
             { data: "areaCode",title:"区划代码",width:"60px"},
             { data: "areaName",title:"区划名称",
            	 createdCell: function (cell, cellData, rowData, rowIndex, cellIndex) {
            		 var separator = "";
            		 if(rowData.areaLevel > 1){
	            		 for(var i = 1; i < rowData.areaLevel; i++){
	            			 if(i == 1)//一级行政区一般名称都不长，缩进小一点。
	            			   separator += "　";
	            			 else
	            			   separator += "　　";
	            		 }
	            		 separator += "├─";
            		 }
            		
            	 	var title = "全称：" + (rowData.fullName == null?    "--" : rowData.fullName) +"；&#10;";
            	 	title += "英文简称：" + (rowData.englishName == null? "--":rowData.englishName) +"；&#10;&#13;";
            	 	title += "经度：" + (rowData.lng == null?  "--" : rowData.lng) +"；\n\r";
            	 	title += "纬度：" + (rowData.lat ==  null? "--" : rowData.lat) +"；\n\r";
            	 	
            		var cellText = '<p data-toggle="tooltip" title="'+ title +'">' + separator + cellData + "</p>";
             	 	$(cell).html(cellText);
            	 } 
             },
             //{ data: "fullName",title:"全称" },
             //{ data: "englishName",title:"英文简称" },
             //{ data: "lng",title:"经度 " },
             //{ data: "lat",title:"纬度" },
             { data: "areaLevel",title:"等级" },
             { data: "postCode",title:"邮编" },
             { data: "phoneCode",title:"电话区号" },
             { data: "status",title:"状态" },
             { data: "areaCode",title:"操作",className:"dt-body-center",
            	 createdCell: function (cell, cellData, rowData, rowIndex, cellIndex) {
            		 var edit = "<a href='javascript:void(0);' onclick='_edit(\"" + rowData.areaCode + "\")'>编辑</a>&nbsp;&nbsp;";
                     var del  = "<a href='javascript:void(0);' onclick='_delete(\"" + rowData.areaCode + "\")'>删除</a>";
            	 	$(cell).html(edit + del);
            	 }
             }
         ];
    var idColumn = "areaCode";
    var order = [[1,"desc"]];
    var ajaxUrl = "getPageList";
    _dataTable = $('#dataTable').DataTable(zxy.admin.DataTables.createOption(ajaxUrl,idColumn,order,columns));
    
    $('#chkAll').on("click",(function(){   	
    	var rows = _dataTable.rows({ 'search': 'applied' }).nodes();
        $('input[type="checkbox"]', rows).prop('checked', this.checked);
    }));
     //激活提示框
    $("[data-toggle='tooltip']").tooltip();
    
    $('#btnQuery').on("click",(function(){   	
    	var _json = $('#queryForm').serialize();
    	var url = "getPageList?" + _json;
    	console.log(url);
    	_dataTable.ajax.url(url).load();
    }));   
});

function _edit(areaCode){
	var url = "editView?areaCode=" + areaCode;
	$("#popupDialog").load(url).dialog({
		height: 570,
        width: 700,
        title: '修改行政区划',
        modal: true,
        position: {
            my: 'center',
            at: 'center'
        }
    });
}
function _delete(areaCode){
	if(confirm("确定删除吗?")){
		var url = "delete?areaCode=" + areaCode;
		$.ajax({
		       type:"POST",
		       url:url,
		       success:function(result){
		    	   if(result.success)
			       		_dataTable.ajax.reload();
			    	 else
			    		 alert("error：" + result.message);
		       },  
		       error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); } 
		   });
	}
}

function reloadGrid(){
	_dataTable.ajax.reload();
}

</script>
</@body>