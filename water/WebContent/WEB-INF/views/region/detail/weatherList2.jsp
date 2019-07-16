<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
<c:set  var="activeMenu" value="数据采集"></c:set>
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/system.jsp">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">气象数据采集</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">	
						<h2 style="font-size: 25px">气象数据采集</h2><a href="${pageContext.request.contextPath}/ExportExportWeather?status=exportWeather2"  style="font-size: 40px;margin-left: 650px"class="iconfont" >&#xe63f;</a>
						<table id="weatherTable" style="margin-top: 45px">
							<tr>
								
								<td style="margin-top: 30px">空气温度（℃）</td>
								<td style="margin-top: 30px">空气湿度（%）</td>
								<td style="margin-top: 30px">CO2浓度（ppm）</td>
								<!-- <td style="margin-top: 30px">风向</td> -->
								<td style="margin-top: 30px">风速（公里/时）</td>
								
								<td style="margin-top: 30px">降雨量（mm）</td>
								
								<td style="margin-top: 30px">光照（lux）</td>
								<td style="margin-top: 30px">创建时间</td>
							</tr>
							<c:forEach items="${weatherPage2.content}" var="weather">
								<tr>
									
									<td>${weather.airTemp}</td>
									<td>${weather.airHumi}</td>
									<td>${weather.co2}</td>
									<%-- <td>${weather.windDir}</td> --%>
									<td>${weather.windSpeed}</td>
									
									<td>${weather.rainHour*0.2}</td>
									
									<td>${weather.sunData}</td>
									<td><fmt:formatDate value="${weather.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
								</tr>
							</c:forEach>
						</table>
						<div id="weatherPage" style="margin-left: -100px;margin-top: 70px;display:block;"></div>
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
		url:"${pageContext.request.contextPath}/region/detail/"+type+"List2ByPage",
		type:"post",
		data:{pageNo:pageNo,pageSize:pageSize,plotId:getCookie("Ids")},
		dataType:"text",
		success:function(data){
			$("#"+type+"Table").html(data);
		},error:function(e){
			
			
			alert("数据加载失败！");
			//$("body").html(e.responseText);
		}
	});
}
//读取cookie
function getCookie(name) 
{ 
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); 
    if(arr=document.cookie.match(reg)) 
	return unescape(arr[2]); 
    else
	return null; 
} 
$(function(){
	
	new GuangPage().init("${weatherPage2.totalItems}",{$dom:$("#weatherPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"weather");
	}});
});
</script>
</body>
</html>