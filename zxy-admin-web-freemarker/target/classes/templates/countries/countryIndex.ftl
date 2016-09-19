<#include "../_layouts/layout.ftl">
<@header title="国家或地区设置">
	<link href="//cdn.bootcss.com/datatables/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
		
	<script src="/libs/dataTables/dataTablesUitl.js"></script>
</@header>
<@body>
<section class="content-header"> 
 <div>
    <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;首页&nbsp;&nbsp;</a><i class="active fa fa-angle-right"></i>&nbsp;国家或地区设置
    <p class="pull-right">
	     <button type="button" class="fa fa-plus btn btn-primary" id="btnAdd"> 添加</button> 
	     <button type="button" class="fa fa-trash-o btn btn-danger" id="btnDelete"> 删除</button>
     </p>
</div>
</section>
<section class="content">
	<div class="box box-default">	
		<div class="box-body">
	     	<table id="dataTable" class="cell-border">
	     	  <thead>
				<tr >
				    <th  class="text-center" style="width:15px"><input type="checkbox" name="chkAll" id="chkAll"/></th>
				    <th  class="text-center">序</th>
				    <th  class="text-center">编码</th>
				    <th  class="text-center">名称</th>
				    <th  class="text-center">全称</th>
				    <th  class="text-center">英文简称</th>
				    <th  class="text-center">域名</th>
				    <th  class="text-center">电话代码</th>
				    <th  class="text-center">状态</th>
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
            height: 370,
            width: 600,
            title: '新增国家或地区',
            modal: true,
            position: {
                my: 'center',
                at: 'center'
            }
        });
    });
    
    var columns = [
             {
            	 'targets': 0,'searchable': false,'orderable': false,'className': 'dt-body-center',data : "countryCode",
                 'render': function (data, type, full, meta){
                     return '<input type="checkbox" name="chkItem" value="' + data + '">';
             	  }
             },
             { data: "sort",title:"序" },
             { data: "countryCode",title:"编码" },
             { data: "countryName",title:"名称" },
             { data: "fullName",title:"全称" },
             { data: "englishName",title:"英文简称" },
             { data: "domainName",title:"域名" },
             { data: "phoneCode",title:"电话代码" },
             { data: "status",title:"状态" },
             { data: "countryCode",title:"操作",className:"dt-body-center",
            	 createdCell: function (cell, cellData, rowData, rowIndex, cellIndex) {
            		 var edit = "<a href='javascript:void(0);' onclick='_edit(\"" + rowData.countryCode + "\")'>编辑</a>&nbsp;&nbsp;";
                     var del  = "<a href='javascript:void(0);' onclick='_delete(\"" + rowData.countryCode + "\")'>删除</a>";
            	 	$(cell).html(edit + del);
            	 }
             }
         ];
    var idColumn = "countryCode";
    var order = [[1,"desc"]];
    var ajaxUrl = "getPageList";
    _dataTable = $('#dataTable').DataTable(zxy.admin.DataTables.createOption(ajaxUrl,idColumn,order,columns));
    
    $('#chkAll').on("click",(function(){   	
    	var rows = _dataTable.rows({ 'search': 'applied' }).nodes();
        $('input[type="checkbox"]', rows).prop('checked', this.checked);
    }));
});

function _edit(countryCode){
	var url = "editView?countryCode=" + countryCode;
	$("#popupDialog").load(url).dialog({
        height: 370,
        width: 600,
        title: '修改国家或地区',
        modal: true,
        position: {
            my: 'center',
            at: 'center'
        }
    });
}
function _delete(countryCode){
	if(confirm("确定删除吗?")){
		var url = "delete?countryCode=" + countryCode;
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