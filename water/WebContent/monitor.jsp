<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
<c:set  var="activeMenu" value="监控预警"></c:set>
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
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" /> 
		<link href="css/style.css" rel="stylesheet" />
		<link href="css/font-awesome.min.css" rel="stylesheet"  />
		<link href="css/flexslider.css" rel="stylesheet"/>
		<!--[if lt IE 9]>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="css/ie7.css">
		<![endif]-->
		<style type="text/css">
			input[type='button']{cursor:pointer;}
		</style>
		<script src="js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="js/base.js"></script><!-- callback -->
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/monitor.jsp">监控预警</a><i class="fa fa-angle-right"></i><span class="athere">干热风预警</span>
				</div>
				<div class="content-view">
                	<h1 class="title">干热风预警</h1>
                    <p>根据《中华人民共和国气象行业标准（QX/T 82-2007）：小麦干热风灾害等级》制定的发生干热风气象指标为：14时气温高于30℃，田间相对湿度低于30%，风力≧3米/秒时，即为轻型干热风过程；14时气温高于35℃，田间相对湿度低于25%，风力≧3米/秒时，即为重型干热风过程。 以及干热风年型等级指标为： 根据干热风指标判定干热风日，用干热风天气过程中出现的干热风日等级天数组合确定过程等级，用过程等级组合确定年型的轻重。
                    </p>
				</div>
			</div>
		</div>
	</div>
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
function riqi(content){
	if(content==null)
		return "无";
	else
		return content.substring(0,10);
};
 		$("#ii").click(function(){
 			var areaId=$('#area_id').val();
 				$.ajax({
 					url:"${pageContext.request.contextPath}/forecast/forecast",
 					data:{'areaId':areaId},
 					type:"post",
 					dataType:"json",
 		 			success:function(data){
 		 				if(data.msg1=="目前已达灌溉下限值，请灌溉")
 		 					{alert(data.msg1); }else{
 		 				alert(data.msg1); 
 		 				$("#forecastTable").html("");
 		 				$("#forecastTable").append("<tr><td>日期</td><td>ET0预测（mm）</td><td>KC预测</td><td>耗水量预测（mm）</td><td>土壤含水率预测（占土壤体积%）</td></tr>");
 		 				if (data.forecast_list!=null) {
 							$.each(data.forecast_list, function(i, item) {
 								/* $("#forecastTable").append("<td>"+data.forecast_list.date.year+"年"+data.forecast_list.date.month+"月"+data.forecast_list.date.date+"日</td>"); */
 								
 								$("#forecastTable").append("<tr><td>"+riqi(item.date)+"</td>"
 								+"<td>"+item.eT0pre+"</td>"
 								+"<td>"+item.kCpre+"</td>"
 								+"<td>"+item.ipre+"</td>"
 								+"<td>"+item.soilHumipre<data.lower?'--':item.soilHumipre+"</td></tr>");
 							});
 		 				}
 		 			}},
 		 			error:function(response){
 		 				alert("网络不太稳定！请尝试重新刷新界面");
 		 			}					
 				});
 			});
 </script>
</body>
</html>