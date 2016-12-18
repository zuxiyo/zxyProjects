<#--
id 				      : 本控件的ID号。
selected		      : 希望选中项的值。
class		     	  : CSS类。
countryDropDownListId : 国别选中控件的ID号
fullPositionCode	  : 行政区划的完整位置（省-市-县-镇）。
fullPositionName	  : 完整的位置Name信息控件ID好。
-->
<#macro AreasSelectDialog id  countryDropDownListId selected="" class="form-control" fullPositionCode="positionCode" fullPositionName="positionName">

  <input type="hidden" id="${id}" name="${id}">
  <input type="hidden" id="${fullPositionCode}" name="${fullPositionCode}">
  <input type="hidden" id="${fullPositionName}" name="${fullPositionName}">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdown1">
	  <span id="dropdownText">---请选择行政区划---</span>
	  <span class="caret"></span>
  </button>
  <div id="popupAreasDialog" style="display:none">
    <div class="alert alert-info" style="height:25px;padding: 2px;">当前选择：<span id="fullTips"></span></div>
    <div class="container-fluid"> 
	    <div class="row">
		  <div class="col-md-1"><span class="label label-info">省</span></div>
		  <div class="col-md-11">
		      <ul class="list-inline" id="province" data-toggle="prefecture" data-level="1"> 	   	   
   			   </ul>
   		  </div>
		</div>
		<div class="row">
		  <div class="col-md-1"><span class="label label-info">市</span></div>
		  <div class="col-md-11">
		      <ul class="list-inline" id="prefecture" data-toggle="county" data-level="2"> 	 	   	   
   			  </ul>
   		  </div>
		</div>
		<div class="row">
		  <div class="col-md-1"><span class="label label-info">县</span></div>
		  <div class="col-md-11">
		      <ul class="list-inline" id="county" data-toggle="township" data-level="3"> 	   	   
   			  </ul>
   		  </div>
		</div>
		<div class="row">
		  <div class="col-md-1"><span class="label label-info">镇</span></div>
		  <div class="col-md-11">
		      <ul class="list-inline" id="township" data-level="4"> 	   	   
   			  </ul>
   		  </div>
		</div>
	</div>
  </div>
 <style type="text/css">
	.list-inline > li:hover{
	    background:#fff;
	    color: #d9534f;
	    cursor:hand;
	}
	.list-inline > li{
    	padding-top:0.2em;
    	padding-bottom:0.2em;
    }
    .list-inline > li.active{
 		color: #fff;
  		text-decoration: none;
	    outline: 0;
	    border-radius: .25em;
	    background-color: #337ab7;
	}
</style>
 <script type="text/javascript">
		
 		function  initializeAreasDialog(){
						
			var countryCode = $("#${countryDropDownListId}").val();
			if(countryCode != ""){
				setAreas("/areas/getProvinceAreasByCountyCode", {"countryCode" : countryCode}, $("#province"));
			}else{
				clearTips();
				clearAllContent();
			}			
 		}
 		
 		
		$(function() {
			
			initializeAreasDialog();
			
			$(".list-inline").on("mouseover", "li", liMouseOver);
			$(".list-inline").on("click", "li", liClick);
			
			$("#${countryDropDownListId}").on("change",initializeAreasDialog);

			$("#dropdown1").click(function() {
				
				var countryCode = $("#${countryDropDownListId}").val();
				if(countryCode == ""){
					alert("请先选择国别！");
					return false;
				};
				
				$("#popupAreasDialog").dialog({
					height : 610,
					width : 700,
					title : '选择行政区划',
					modal : true,
					overlay : {
						opacity : 0.5,
						background : "black"
					},
					position : {
						my : 'center',
						at : 'center'
					},
					close : function(event, ui) {
						$(this).dialog("destroy");
					},
					buttons : {
						" 确 定 " : function() {

							$(this).dialog("close");
						},
						" 关 闭 " : function() {
							$(this).dialog("close");
						}
					}
				});
			});
		})

		function liMouseOver() {
			var parentCode = $(this).data("code");
			var nextUlElement = getNextToggleUlElementByLi(this);
			setAreas("/areas/getAreasByParentCode", {"parentCode" : parentCode}, nextUlElement);
		}

		function getNextToggleUlElementByLi(liElement) {
			var toggle = $(liElement).parent().data("toggle");
			return $("#" + toggle);
		}
		
		function getNextToggleUlElementByUl(ulElement) {
			var toggle = $(ulElement).data("toggle");
			return $("#" + toggle);
		}

		function liClick() {
			if ($(this).hasClass('active')) {
				$(this).removeClass('active');
				$(this).parent().on("mouseover", "li", liMouseOver);
				clearContent(this);

				//取消选中后，提示信息重构建
				resetTips();
			} else {
				//如果已有选中的元素，则不让做点击选中操作，必须先取消原先选中项，
				var exists = false;
				$(this).parent().children().each(
						function(index, domEle) {
							if ($(domEle).hasClass('active')) {
								//console.log("2-liClick" + index + ":" + $(domEle).data("code") + $(this).text());
								exists = true;
								return;
							}
						});
				if (exists == false) { //选中
					$(this).parent().off("mouseover")
					$(this).addClass("active");

					//元素取消选中后再重新点击选中后，需要重新绑定数据，不然该元素的下一级数据会为空。
					var nextUlElement = getNextToggleUlElementByLi(this);
					//console.log(nextElement.text());
					if (nextUlElement.text() == "")  
						liMouseOver.apply(this);// 回调函数作为普通函数调用时使用apply传递this指针，liMouseOver为回调函数。

					setTips($(this).data("code"),$(this).text());

				} else {
					//$(this).popover({title: 'Twitter Bootstrap Popover', content: "为我的网站创建一个提示框如此简单！"}).fadeOut(3000); 
				}
			}
		}

		function setAreas(url, dataJson, showUlCtrl) {
			$.ajax({
				url : url,
				type : "GET",
				async : false,
				data : dataJson,
				cache : false,
				success : function(r, textStatus) {
					var areaNames = "";
					var level = "-1";
					$.each(r, function(i, value) {
						areaNames += '<li data-code="' + value.areaCode + '">' + value.areaName + '</li>';
						
						if(level == "-1")  //获得本次级别数据
							level = value.areaLevel;
					})
					showUlCtrl.empty();
					
					var i = 1;
					while(showUlCtrl.length > 0 && showUlCtrl.data("level") != level){
						showUlCtrl = getNextToggleUlElementByUl(showUlCtrl);
						//console.log(i);
						if (i++ == 100) //防止进入死循环
							break;
					}
					
					showUlCtrl.empty();
					showUlCtrl.append(areaNames);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("error：" + XMLHttpRequest.readyState);
				}
			});
		}

		function clearContent(currentLiCtrl) {
			var nextUlElement = getNextToggleUlElementByLi(currentLiCtrl);
			while (nextUlElement.length > 0) {
				$(nextUlElement).empty();
				nextUlElement = $("#" + $(nextUlElement).data("toggle"));
			}
		}
		function clearAllContent() {
			var nextUlElement = getNextToggleUlElementByUl($("#province"));
			while (nextUlElement.length > 0) {
				$(nextUlElement).empty();
				nextUlElement = $("#" + $(nextUlElement).data("toggle"));
			}
		}
		
		function clearTips(){
			$("#fullTips").empty();
			$("#${id}").empty();
			$("#${fullPositionCode}").empty();
			$("#${fullPositionName}").empty();
			$("#dropdownText").text("---请选择行政区划---");
		}
		
		function setTips(code,text){
			if ($("#fullTips").text() != ""){
				$("#fullTips").append("→");
				$("#${fullPositionCode}").val( $("#${fullPositionCode}").val() + "→");
				$("#${fullPositionName}").val( $("#${fullPositionName}").val() + "→");
				
			}
			$("#fullTips").append(text);
			$("#${fullPositionCode}").val( $("#${fullPositionCode}").val() + code);
			$("#${fullPositionName}").val( $("#${fullPositionName}").val() + text);
			
			$("#${id}").val(code);
			
			//显示完整的选择项
			$("#dropdownText").text($("#${fullPositionName}").text());
		}

		function resetTips() {
			var toggleUlElement = $("#province");
			clearTips();
			var i = 0;
			while (toggleUlElement.length > 0) {

				$(toggleUlElement).children().each(function(index, domEle) {
					if ($(domEle).hasClass('active')) {
						setTips($(this).data("code"),$(this).text());
						return false; //跳出each循环
					}
				});

				if (i++ == 100) //防止进入死循环
					break;

				toggleUlElement = $("#" + $(toggleUlElement).data("toggle"));
			}
		}
	</script>
</#macro>