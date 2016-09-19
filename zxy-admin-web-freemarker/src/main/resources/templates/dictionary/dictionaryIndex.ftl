<#include "../_layouts/layout.ftl">
<@header title="数据字典">
	<link href="//cdn.bootcss.com/datatables/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
	
	<script src="//cdn.bootcss.com/zTree.v3/3.5.24/js/jquery.ztree.all.js"></script>
	<link href="//cdn.bootcss.com/zTree.v3/3.5.24/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet">
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
            <div class="col-md-4">
              <div class="box-header with-border">
	          	<h3 class="box-title">类别</h3>
	          	<p class="pull-right">
			       <button type="button" class="fa fa-plus btn btn-primary" id="btnAdd"> 添加</button> 
			    </p>
	          </div>
	          <table id="dictCategoryGrid" class="table table-striped table-bordered table-hover datatable" cellspacing="0" width="100%"></table>
            </div>
            <div class="col-md-8">
              <div class="box-header with-border">
	          	<h3 class="box-title"><lable id="dictItemsTitle"></lable>字典项</h3>
	          	<p class="pull-right">
			       <button type="button" class="fa fa-plus btn btn-primary" id="btnItemAdd"> 添加</button> 
			    </p>
	          </div>
	          <table id="dictItemGrid" cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover"></table>
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
  $(function () {
	 
	var dictCategoryGrid = 
	$('#dictCategoryGrid').DataTable({
       "processing": true,
       "serverSide": true,
       "searching": false,
       "lengthMenu": [15, 30, 50, 100],
       "pageLength": 15,
       "ajax": "getCategoryPage",
       "ordering": false,
       "order": [[ 1, "desc" ]],
       "language": {"url": "../libs/dataTables/cn.json"},
       "rowId": "uid",
       "columns": [
                   { "data": "sort","title":"序" },
                   { "data": "categoryCode","title":"编码" },
                   { "data": "categoryName","title":"名称" },
                   { "data": "status","title":"状态" },
                   { "data": "remark","title":"备注","visible":false }
               ]
    });
    
    $('#dictCategoryGrid tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	dictCategoryGrid.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            
            var obj = dictCategoryGrid.row( this ).data();
            bindDictItemGrid(obj);
        }
    } );
    
    $('#button').click( function () {
    	dictCategoryGrid.row('.selected').remove().draw( false );
    } );
   //---------------------------------------------------------
   var dictItemGrid = 
	  $('#dictItemGrid').DataTable({
       "processing": true,
       "autoWidth":  true,
       "serverSide": true,
       "searching": false,
       "lengthMenu": [15, 30, 50, 100],
       "pageLength": 15,
       "ajax":  "getItemPage?categoryCode=OrgLevel",//+ $("#dictItemsTitle").data("code"),
       "ordering": false,
       "order": [[ 1, "desc" ]],
       "language": {"url": "../libs/dataTables/cn.json"},
       "rowId": "uid",
       "columns": [
                   { "data": "sort","title":"序" },
                   { "data": "dictionaryCode","title":"编码" },
                   { "data": "dictionaryName","title":"名称" },
                   { "data": "status","title":"状态" },
                   { "data": "remark","title":"备注" }
               ]
    });

   //必须绑定到window等不变的元素上，不然在对话框中调不到这些方法
   window.reloadCategoryGrid = function(){
	   var categoryPageUrl = "getCategoryPage";
	   dictCategoryGrid.ajax.url(categoryPageUrl).load();
   }
 
   window.reloadItemGrid = function (){
	   var itemPageUrl = "getItemPage?categoryCode=" +  $("#dictItemsTitle").data("code");
	   dictItemGrid.ajax.url(itemPageUrl).load();	 
   }
   
   function bindDictItemGrid(dictTypeInfo){
	   //console.log( dictCategoryGrid.row( this ).data() )
	   //保存编码和名称,在子窗口中使用
	   $("#dictItemsTitle").text("【" + dictTypeInfo.categoryName + "】");
	   $("#dictItemsTitle").data("code",dictTypeInfo.categoryCode);
	   var itemPageUrl = "getItemPage?categoryCode=" + dictTypeInfo.categoryCode;
	   dictItemGrid.ajax.url(itemPageUrl).load();	   
   }
    
   //---------------------------------------------------------
    $("#btnAdd").click( function () {
        $("#popupDialog").load('addCategoryView').dialog({
            height: 390,
            width: 500,
            title: '新增数据字典类别',
            modal: true,
            position: {
                my: 'center',
                at: 'center'
            }
        });
    });
    
    $("#btnItemAdd").click( function () {
        $("#popupDialogForItem").load('addItemView').dialog({
            height: 440,
            width: 750,
            title: '新增' + $("#dictItemsTitle").text() +'字典项',
            modal: true,
            position: {
                my: 'center',
                at: 'center'
            }
        });
    });
  });
 </script>
</@body>