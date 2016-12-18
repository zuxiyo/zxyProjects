<#include "../_layouts/layout.ftl">
<@header title="组织管理">
	<link  href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>	
	<script src="/libs/dataTables/dataTablesUitl.js"></script>
	<script src="//cdn.bootcss.com/zTree.v3/3.5.24/js/jquery.ztree.all.js"></script>
	<link href="//cdn.bootcss.com/zTree.v3/3.5.24/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet">
</@header>
<@body>
<section class="content-header"> 
 <div>
     <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;首页&nbsp;&nbsp;</a><i class="active fa fa-angle-right"></i>&nbsp;组织管理
     <p class="pull-right">
	     <button type="button" class="fa fa-plus btn btn-primary" id="btnAdd"> 添加</button> 
	     <button type="button" class="fa fa-trash-o btn btn-danger" id="btnDelete"> 删除</button>
     </p>
</div>
</section>
<section class="content"> 
	<div class="box">
	   <div class="box-header">  
	     <form class="form-horizontal" role="form"> 
		    <div class="form-group"> 
		        <label class="col-sm-1 control-label" for="ddlName" >选择单位 </label> 
		        <div class="col-sm-2">
		        	<select id="ddlName" class="form-control">
                       <option>禁止选择</option>
                       <option>禁止选择</option>
                    </select>
		        </div>
		        <label class="col-sm-1 control-label" for="inputfile">名称</label>
		        <div class="col-sm-2"> 
		        	<input type="text" class="form-control" id="inputfile" placeholder="请输入名称">
		        </div>
		   		<div class="col-sm-3"> 
		    		<button type="submit" class="btn btn-default"> 查 询 </button>
		    	</div>
		    </div>
		</form>
	 </div>
     <div class="box-body">
     	<table id="example1" class="table table-bordered table-striped">
	         <thead>
	         <tr>
	           <th>Rendering engine</th>
	           <th>Browser</th>
	           <th>Platform(s)</th>
	           <th>Engine version</th>
	           <th>CSS grade</th>
	         </tr>
	         </thead>
	         <tbody>
	         <tr>
	           <td>Trident</td>
	           <td>Internet
	             Explorer 4.0
	           </td>
	           <td>Win 95+</td>
	           <td> 4</td>
	           <td>X</td>
	         </tr>
	         <tr>
	           <td>Trident</td>
	           <td>Internet
	             Explorer 5.0
	           </td>
	           <td>Win 95+</td>
	           <td>5</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Trident</td>
	           <td>Internet
	             Explorer 5.5
	           </td>
	           <td>Win 95+</td>
	           <td>5.5</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Trident</td>
	           <td>Internet
	             Explorer 6
	           </td>
	           <td>Win 98+</td>
	           <td>6</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Trident</td>
	           <td>Internet Explorer 7</td>
	           <td>Win XP SP2+</td>
	           <td>7</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Trident</td>
	           <td>AOL browser (AOL desktop)</td>
	           <td>Win XP</td>
	           <td>6</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Firefox 1.0</td>
	           <td>Win 98+ / OSX.2+</td>
	           <td>1.7</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Firefox 1.5</td>
	           <td>Win 98+ / OSX.2+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Firefox 2.0</td>
	           <td>Win 98+ / OSX.2+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Firefox 3.0</td>
	           <td>Win 2k+ / OSX.3+</td>
	           <td>1.9</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Camino 1.0</td>
	           <td>OSX.2+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Camino 1.5</td>
	           <td>OSX.3+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Netscape 7.2</td>
	           <td>Win 95+ / Mac OS 8.6-9.2</td>
	           <td>1.7</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Netscape Browser 8</td>
	           <td>Win 98SE+</td>
	           <td>1.7</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Netscape Navigator 9</td>
	           <td>Win 98+ / OSX.2+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.0</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.1</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.1</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.2</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.2</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.3</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.3</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.4</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.4</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.5</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.5</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.6</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>1.6</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.7</td>
	           <td>Win 98+ / OSX.1+</td>
	           <td>1.7</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Mozilla 1.8</td>
	           <td>Win 98+ / OSX.1+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Seamonkey 1.1</td>
	           <td>Win 98+ / OSX.2+</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Gecko</td>
	           <td>Epiphany 2.20</td>
	           <td>Gnome</td>
	           <td>1.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>Safari 1.2</td>
	           <td>OSX.3</td>
	           <td>125.5</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>Safari 1.3</td>
	           <td>OSX.3</td>
	           <td>312.8</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>Safari 2.0</td>
	           <td>OSX.4+</td>
	           <td>419.3</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>Safari 3.0</td>
	           <td>OSX.4+</td>
	           <td>522.1</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>OmniWeb 5.5</td>
	           <td>OSX.4+</td>
	           <td>420</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>iPod Touch / iPhone</td>
	           <td>iPod</td>
	           <td>420.1</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Webkit</td>
	           <td>S60</td>
	           <td>S60</td>
	           <td>413</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 7.0</td>
	           <td>Win 95+ / OSX.1+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 7.5</td>
	           <td>Win 95+ / OSX.2+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 8.0</td>
	           <td>Win 95+ / OSX.2+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 8.5</td>
	           <td>Win 95+ / OSX.2+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 9.0</td>
	           <td>Win 95+ / OSX.3+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 9.2</td>
	           <td>Win 88+ / OSX.3+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera 9.5</td>
	           <td>Win 88+ / OSX.3+</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Opera for Wii</td>
	           <td>Wii</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Nokia N800</td>
	           <td>N800</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Presto</td>
	           <td>Nintendo DS browser</td>
	           <td>Nintendo DS</td>
	           <td>8.5</td>
	           <td>C/A<sup>1</sup></td>
	         </tr>
	         <tr>
	           <td>KHTML</td>
	           <td>Konqureror 3.1</td>
	           <td>KDE 3.1</td>
	           <td>3.1</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>KHTML</td>
	           <td>Konqureror 3.3</td>
	           <td>KDE 3.3</td>
	           <td>3.3</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>KHTML</td>
	           <td>Konqureror 3.5</td>
	           <td>KDE 3.5</td>
	           <td>3.5</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Tasman</td>
	           <td>Internet Explorer 4.5</td>
	           <td>Mac OS 8-9</td>
	           <td>-</td>
	           <td>X</td>
	         </tr>
	         <tr>
	           <td>Tasman</td>
	           <td>Internet Explorer 5.1</td>
	           <td>Mac OS 7.6-9</td>
	           <td>1</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Tasman</td>
	           <td>Internet Explorer 5.2</td>
	           <td>Mac OS 8-X</td>
	           <td>1</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>NetFront 3.1</td>
	           <td>Embedded devices</td>
	           <td>-</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>NetFront 3.4</td>
	           <td>Embedded devices</td>
	           <td>-</td>
	           <td>A</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>Dillo 0.8</td>
	           <td>Embedded devices</td>
	           <td>-</td>
	           <td>X</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>Links</td>
	           <td>Text only</td>
	           <td>-</td>
	           <td>X</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>Lynx</td>
	           <td>Text only</td>
	           <td>-</td>
	           <td>X</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>IE Mobile</td>
	           <td>Windows Mobile 6</td>
	           <td>-</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Misc</td>
	           <td>PSP browser</td>
	           <td>PSP</td>
	           <td>-</td>
	           <td>C</td>
	         </tr>
	         <tr>
	           <td>Other browsers</td>
	           <td>All others</td>
	           <td>-</td>
	           <td>-</td>
	           <td>U</td>
	         </tr>
	         </tbody>
	         <tfoot>
	         <tr>
	           <th>Rendering engine</th>
	           <th>Browser</th>
	           <th>Platform(s)</th>
	           <th>Engine version</th>
	           <th>CSS grade</th>
	         </tr>
	         </tfoot>
	       </table>
     </div>
   </div>
   <div id="popupDialog"></div>
</section>
<script>
  $(function () {
    $("#example1").DataTable();
    $("#btnAdd").click( function () {
    	zxy.admin.DataTables.loadDialog("addView","popupDialog","组织机构新增",800,620);
    });
  });
 </script>
</@body>