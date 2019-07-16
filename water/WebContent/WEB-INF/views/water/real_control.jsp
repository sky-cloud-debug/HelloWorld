<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
<c:set  var="activeMenu" value="决策服务"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="关健词" />
		<meta name="description" content="描述" />
		<meta name="robots" content="all" />
		<meta name="author" content="biaofan.com.cn" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>水肥一体化节水灌溉智慧化大数据平台</title>
		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico" /> 
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"  />
		<link href="${pageContext.request.contextPath}/css/flexslider.css" rel="stylesheet"/>
		<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css">
		<![endif]-->
<%@include file="/WEB-INF/views/common/common_css.jspf" %>
		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="${pageContext.request.contextPath}/js/base.js"></script><!-- callback -->
	<style>
   #water-box{border:1px solid green;margin:50px auto;padding:20px;width:500px;}
   #water-box p{}
   #water-box p .i_text{padding:8px 10px;}
   #water-box p select{width:160px;}
   #water-box p .i_btn{padding:6px 18px;}
 	.btn{background:#81a44a;border-radius:2px;box-shadow:1px 1px 3px #ccc;padding:6px 10px;font-size:14px;font-family:"微软雅黑";color:#fff;}
 	.btn:hover{cursor:pointer;background:darkgreen;color:#fff;}
</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/header.jspf" %>

	<!-- main -->
    <div class="single-content">
		<div class="single clearfix">
			<div class="sidebar fl">
<%@include file="/WEB-INF/views/common/menu.jspf" %>
			</div>
			<div class="content fl">
				<div class="position">
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a 

href="#">决策服务</a><i class="fa fa-angle-right"></i><span class="athere">基于实测气象数据预测灌溉量</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h1 style="font-size: 25px">基于实测气象数据预测灌溉量</h1>
	   <p id="area" style="margin-top: 45px ; margin-left: -10px">田地号：
	  <select class="i_text" id="area_id" style="width: 100px ;height: 40px;">
	  	 <option value="0">田地1号</option>
	  	 <option value="1">田地2号</option>
	  	 <option value="2">田地3号</option>
	  	 <option value="3">田地4号</option>
	  </select>
	 <button class="i_btn btn" id="ii" style=" margin-left:10px;">确定预测</button>
	  </p>
	   <table id="forecastTable" style="margin-top: 20px">
	   <thead><tr><td>日期</td><td>ET0预测（mm）</td><td>KC预测</td><td>耗水量预测（mm）</td><td>土壤含水率预测（占土壤体积%）</td></tr></thead>
	  
						</table> 
						<div id="soilPage" style="margin-left: -100px;margin-top: 70px"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
     <script type="text/javascript">
     		/* $("#ii").click(function(){
     			

     			var areaId=$('#area_id').val();
     				$.ajax({
     					url:"${pageContext.request.contextPath}/forecast/real_forecast",
     					data:{'areaId':areaId},
     					type:"post",
     					dataType:"json",
     		 			success:function(data){
     		 				alert(data.msg);
     		 			},
     		 			error:function(response){
     		 				alert(1);
     		 			}					
     				});
     			}
  		); */
  		
  		
  		function riqi(content){
  			if(content==null)
  				return "无";
  			else
  				return content.substring(0,10);
  		};
  		function neirong(t){
  			var content=t+'';
  			if(content==null)
  				return "无";
  			else
  				return content.substring(0,10);
  		};
  		 		$("#ii").click(function(){
  		 			var areaId=$('#area_id').val();
  		 			var tab="";
  		 			$("#forecastTable").append("<tbody>");
  		 				$.ajax({
  		 					url:"${pageContext.request.contextPath}/forecast/real_forecast",
  		 					data:{'areaId':areaId},
  		 					type:"post",
  		 					dataType:"json",
  		 					cache: false,
  		 					error:function(response){
  		 		 				//$("body").html(response.responseText);
  		 		 				alert("网络不太稳定！");
  		 					},	
  		 		 			success:function(data){
  		 		 				if(data.msg=="目前已达灌溉下限值，请灌溉")
  		 		 					{alert(data.msg1); }
  		 		 				else{
  		 		 				alert(data.msg); 
  		 		 				 $("#forecastTable").html("");
  		 		 				$("#forecastTable").append("<thead><tr><td>日期</td><td>ET0预测（mm）</td><td>KC预测</td><td>耗水量预测（mm）</td><td>土壤含水率预测（占土壤体积%）</td></tr></thead>"); 
  		 		 				
  		 		 				if (data.foreShow!=null) {
  		 		 					/*var item=data.forecast_list[0];
  		 		 					 $("#forecastTable2").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>"); 
  		 		 					$("#forecastTable2").append("<tr><td>"+"2015-10-23"+"</td><td>"+"2015-10-23"+"</td><td>"+"2015-10-23"+"</td><td>"+"2015-10-23"+"</td><td>"+"2015-10-23"+"</td></tr>");
  		 		 					$("#forecastTable2").append("<tr><td>"+riqi(item.date)+"</td><td>"+neirong(item.eT0pre)+"</td><td>"+neirong(item.kCpre)+"</td><td>"+neirong(item.ipre)+"</td><td>"+neirong(item.soilHumipre<data.lower?'--':item.soilHumipre)+"</td></tr>"); */
  		 							 $.each(data.foreShow, function(i, item) { 
  		 								
  		 								
  		 								$("#forecastTable").append("<tr style='background-color: white'><td>"+riqi(item.date)+"</td><td>"+neirong(item.eT0pre)+"</td><td>"+neirong(item.kCpre)+"</td><td>"+neirong(item.ipre)+"</td><td>"+neirong(item.soilHumipre)+"</td></tr>");
  		 							});  
  		 		 				}
  		 		 				}}
  		 		 						
  		 				});
  		 				
  		 				$("#forecastTable").append("</tbody>");
  		 			});
  		
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>


<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
function loadData(pageNo,pageSize,type){
	$.ajax({
		url:"${pageContext.request.contextPath}/region/detail/"+type+"ListByPage",
		type:"post",
		data:{pageNo:pageNo,pageSize:pageSize,regionId:"${regionId}"},
		dataType:"text",
		success:function(data){
			$("#"+type+"Table").html(data);
		},error:function(e){
			alert("数据加载失败！");
			$("body").html(e.responseText);
		}
	});
}
$(function(){
	new GuangPage().init("${soilPage.totalItems}",{$dom:$("#soilPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"soil");
	}});
});
</script>
</body>
</html>