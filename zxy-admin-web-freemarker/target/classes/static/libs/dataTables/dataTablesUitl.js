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

//获得指定表格的选择行数据
zxy.admin.DataTables.getSelectedIds = function(_dataTable){
	
	var rows = _dataTable.rows().nodes();
	var checkboxes = $('input[type="checkbox"]', rows);
	
	var ids = [];
	for(var i = 0; i < checkboxes.length; i++){
		if(checkboxes[i].checked){
			ids.push($(checkboxes[i]).val());
		}
	}
	return ids;
}

//打开一个对话框
zxy.admin.DataTables.loadDialog = function(url,containerId,title,width,height){
	$("#" + containerId).load(url).dialog({    
        "width": width,
        "height": height,
        "title": title,
        "modal": true,
        "position": {
            "my": 'center',
            "at": 'center'
        }
    });
}
//删除一条记录
zxy.admin.DataTables.deleteOne = function(url,callback) {
	if (confirm("确定删除吗?")) {
		$.ajax({
			"type" : "POST",
			"url" : url,
			success : function(result) {
				if (result.success)
					callback();
				else
					alert("error：" + result.message);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("error：" + XMLHttpRequest.readyState);
			}
		});
	}
}
//删除一页记录
zxy.admin.DataTables.deletePageAll = function(url,callback){
	var ids = zxy.admin.DataTables.getSelectedIds(_dataTable);
	if(ids == null || ids.length == 0)
		alert("请选择要删除的记录！");
	else{
		url = url + ids;
		//console.log(url);
		this.deleteOne(url,callback);
	}
}