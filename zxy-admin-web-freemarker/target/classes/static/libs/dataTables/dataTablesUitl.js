/**
 * dataTables表格操作
 */

namespace.Register("zxy.admin.DataTables");
zxy.admin.DataTables.createOption = function(ajaxUrl,idName,orderIdJson,columns){
	var option = {
			dom: 'rt<"bottom"ilp>',
			processing: true,
	        //启用服务器端分页  
	        serverSide: true,
	        //禁用原生搜索  
	        searching: false,
	        ordering: false,
	        //分页
	        lengthMenu: [10, 25, 50, 100],
	        pageLength: 10, 
	        //lengthChange: false,//禁用改变每页显示多少条数据的控件
	        	
	        ajax:ajaxUrl,
	        language: {"url": "../libs/dataTables/cn.json"},
	        //为奇偶行加上样式，兼容不支持CSS伪类的场合  
            stripeClasses : [ "odd", "even" ],
            //取消默认排序查询,否则复选框一列会出现小箭头  
            order: orderIdJson, 
            rowId: idName,
            columns:columns
	};
	return option;
};

