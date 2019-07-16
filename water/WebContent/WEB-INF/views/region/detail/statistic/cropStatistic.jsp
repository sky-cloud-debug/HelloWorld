<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/analysis.html">挖掘分析</a><i class="fa fa-angle-right"></i><span class="athere">苗情分析</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h2>田地</h2>
						<table id="areaTable">
							<tr>
								<td>ID</td>
							    <td>田地名字</td>
								<td>根系层土壤平均田间持水率</td>
								<td>生育初期土壤计划湿润层深度</td>
								<td>生育中期土壤计划湿润层深度</td>
								<td>生育后期土壤计划湿润层深度</td>
								<td>生育初期作物系数</td>
								<td>生育中期作物系数</td>
								<td>生育后期作物系数</td>
								<td>田间持水量 </td>
								<td>土壤类型</td>
								<td>土壤干容重</td>
								<td>创建时间</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${areaPage.content}" var="area">
								<tr>
									<td>${area.id}</td>
									<td>${area.areaName}</td>
									<td>${area.averageWaterCapacity }</td>
									<td>${area.firstStageDepthOfWetting }</td>
									<td>${area.secondStageDepthOfWetting }</td>
									<td>${area.thirdStageDepthOfWetting }</td>
									<td>${area.firstCropCoefficient }</td>
									<td>${area.secondCropCoefficient }</td>
									<td>${area.thirdCropCoefficient }</td>
									<td>${area.waterholdingCapacity }</td>
									<td>${area.soilType }</td>
									<td>${area.soilDryBulkDensity}</td>
									<td>${area.createTime }</td>
									<td><a href="${pageContext.request.contextPath}/region/detail/cropList?areaId=${area.id}">作物采集数据</a></td>
								</tr>
							</c:forEach>
						</table>
						<div id="areaPage"></div>
					</div>
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
			//$("body").html(e.responseText);
		}
	});
}
$(function(){
	new GuangPage().init("${areaPage.totalItems}",{$dom:$("#areaPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"area");
	}});
});
</script>
</body>
</html>