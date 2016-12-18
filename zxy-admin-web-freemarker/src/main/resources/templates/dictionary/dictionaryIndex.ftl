<#include "../_layouts/layout.ftl">
<@header title="数据字典">
	<link href="//cdn.bootcss.com/datatables/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src="/libs/dataTables/dataTablesUitl.js"></script>
</@header>
<@body>
<section class="content-header"> 
 <div>
     <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;首页&nbsp;&nbsp;</a><i class="active fa fa-angle-right"></i>&nbsp;数据字典
</div>
</section>
<section class="content">
	<div class="box box-default">
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-5">
              <div class="box-header with-border">
	          	<h3 class="box-title">类别</h3>
	          	<p class="pull-right">
			       <button type="button" class="fa fa-plus btn btn-primary" id="btnAdd"> 添加</button> 
			    </p>
	          </div>
	          <table id="dictCategoryGrid" class="cell-border"></table>
            </div>
            <div class="col-md-7">
              <div class="box-header with-border">
	          	<h3 class="box-title"><lable id="dictItemsTitle"></lable>字典项</h3>
	          	<p class="pull-right">
			       <button type="button" class="fa fa-plus btn btn-primary" id="btnItemAdd"> 添加</button> 
			    </p>
	          </div>
	          <table id="dictItemGrid" class="cell-border"></table>
            </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
      </div>
     </div>
     <div id="popupDialog"></div>
     <div id="popupDialogForItem"></div>
</section>
<script>
  
	var dictCategoryGrid, dictItemGrid;
	$(function() {

		var columns = [ 
		                {"data" : "sort", "title" : "序","className":"dt-body-center","width":"15px"}, 
		                {"data" : "categoryCode","title" : "编码"},
		                {"data" : "categoryName","title" : "名称"}, 
		                {"data" : "status","title" : "状态"}, 
		                {"data" : "remark","title" : "备注","visible" : false},
		                {"data": "uid",title:"操作",className:"dt-body-center","width":"47px",
			            	 createdCell: function (cell, cellData, rowData, rowIndex, cellIndex) {
			            		 var edit = "<a href='javascript:void(0);' onclick='_categoryEdit(\"" + rowData.uid + "\")'>编辑</a>&nbsp;&nbsp;";
			                     var del  = "<a href='javascript:void(0);' onclick='_categoryDelete(\"" + rowData.uid + "\")'>删除</a>";
			            	 	$(cell).html(edit + del);
			            	 }
			             }
		              ];
		var idColumn = "uid";
		var order = [ [ 1, "desc" ] ];
		var ajaxUrl = "getCategoryPage";
		dictCategoryGrid = $('#dictCategoryGrid').DataTable(zxy.admin.DataTables.createOption(ajaxUrl, idColumn, order,columns));

		$('#dictCategoryGrid tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				dictCategoryGrid.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');

				var obj = dictCategoryGrid.row(this).data();
				bindDictItemGrid(obj);
			}
		});

		$('#button').click(function() {
			dictCategoryGrid.row('.selected').remove().draw(false);
		});
		//---------------------------------------------------------
		columns = [ 
		            {"data" : "sort","title" : "序","className":"dt-body-center","width":"15px"}, 
		            {"data" : "dictionaryCode","title" : "编码"},
		            {"data" : "dictionaryName","title" : "名称","width":"30px"}, 
		            {"data" : "status","title" : "状态","width":"30px"}, 
		            {"data" : "remark","title" : "备注"},
		            {"data": "uid",title:"操作","className":"dt-body-center","width":"47px",
		            	 createdCell: function (cell, cellData, rowData, rowIndex, cellIndex) {
		            		 var edit = "<a href='javascript:void(0);' onclick='_itemEdit(\"" + rowData.uid + "\")'>编辑</a>&nbsp;&nbsp;";
		                     var del  = "<a href='javascript:void(0);' onclick='_itemDelete(\"" + rowData.uid + "\")'>删除</a>";
		            	 	$(cell).html(edit + del);
		            	 }
		             }
		          ];
		idColumn = "uid";
		order = [ [ 1, "desc" ] ];
		ajaxUrl = "getItemPage?categoryCode=OrgLevel";//+ $("#dictItemsTitle").data("code"),
		dictItemGrid = $('#dictItemGrid').DataTable(zxy.admin.DataTables.createOption(ajaxUrl, idColumn, order,columns));

		//必须绑定到window等不变的元素上，不然在对话框中调不到这些方法
		window.reloadCategoryGrid = function() {
			var categoryPageUrl = "getCategoryPage";
			dictCategoryGrid.ajax.url(categoryPageUrl).load();
		}

		window.reloadItemGrid = function() {
			var itemPageUrl = "getItemPage?categoryCode=" + $("#dictItemsTitle").data("code");
			dictItemGrid.ajax.url(itemPageUrl).load();
		}
		
		//---------------------------------------------------------
		$("#btnAdd").click(function() {
			$("#popupDialog").load('addCategoryView').dialog({
				height : 390,
				width : 500,
				title : '新增数据字典类别',
				modal : true,
				position : {
					my : 'center',
					at : 'center'
				}
			});
		});
	
//--------------------------------------------------------------
		$("#btnItemAdd").click(function() {
			$("#popupDialogForItem").load('addItemView').dialog({
				height : 440,
				width : 750,
				title : '新增' + $("#dictItemsTitle").text() + '字典项',
				modal : true,
				position : {
					my : 'center',
					at : 'center'
				}
			});
		});
	});
	
	function bindDictItemGrid(dictTypeInfo) {
		//console.log( dictCategoryGrid.row( this ).data() )
		//保存编码和名称,在子窗口中使用
		$("#dictItemsTitle").text("【" + dictTypeInfo.categoryName + "】");
		$("#dictItemsTitle").data("code", dictTypeInfo.categoryCode);
		var itemPageUrl = "getItemPage?categoryCode="
				+ dictTypeInfo.categoryCode;
		dictItemGrid.ajax.url(itemPageUrl).load();
	}
	
	function _categoryEdit(uid){
		var url = "editCategoryView?uid=" + uid;
		$("#popupDialog").load(url).dialog({
			height: 390,
	        width: 500,
	        title: '修改数据字典类别',
	        modal: true,
	        position: {
	            my: 'center',
	            at: 'center'
	        }
	    });
	}
	
	function _categoryDelete(uid){
		if(confirm("确定删除吗?")){
			var url = "deleteCategory?uid=" + uid;
			$.ajax({
			       type:"POST",
			       url:url,
			       success:function(result){
			    	   if(result.success)
			    		   dictCategoryGrid.ajax.reload();
				    	 else
				    		 alert("error：" + result.message);
			       },  
			       error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); } 
			   });
		}
	}

	function _itemEdit(uid){
		var url = "editItemView?uid=" + uid;
		$("#popupDialogForItem").load(url).dialog({
			height: 440,
	        width: 750,
	        title: '修改'  + $("#dictItemsTitle").text() + '字典项',
	        modal: true,
	        position: {
	            my: 'center',
	            at: 'center'
	        }
	    });
	}
	function _itemDelete(uid){
		if(confirm("确定删除吗?")){
			var url = "deleteItem?uid=" + uid;
			$.ajax({
			       type:"POST",
			       url:url,
			       success:function(result){
			    	   if(result.success)
			    		   dictItemGrid.ajax.reload();
				    	 else
				    		 alert("error：" + result.message);
			       },  
			       error: function (XMLHttpRequest, textStatus, errorThrown) { alert("error：" + XMLHttpRequest.readyState); } 
			   });
		}
	}
</script>
</@body>