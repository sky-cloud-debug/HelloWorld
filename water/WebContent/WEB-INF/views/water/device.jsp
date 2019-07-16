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
		<style>
			td{text-align:center;}
		
   #water-box{border:1px solid green;margin:50px auto;padding:20px;width:500px;}
   #water-box p{}
   #water-box p .i_text{padding:8px 10px;}
   #water-box p select{width:160px;}
   #water-box p .i_btn{padding:6px 18px;}
 	.btn{background:#81a44a;border-radius:2px;box-shadow:1px 1px 3px #ccc;padding:6px 10px;font-size:14px;font-family:"微软雅黑";color:#fff;}
 	.btn:hover{cursor:pointer;background:darkgreen;color:#fff;}
</style>
		
<%@include file="/WEB-INF/views/common/common_css.jspf" %>
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/system.jsp">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">管网状态</span>
				</div>
				<div class="content-view">
				    <button onclick="window.location.reload();" class="btn"style=" margin-left: 17px">刷新</button>
					<table  style="margin-top: 20px">
						<tr>
							<td>设备</td>
							<td>状态</td>
							<td>流速</td>
							<td>水量</td>
						</tr>
						<tr>
							<td>出水口1</td>
							<td>${waterStatus.water1=="1.00"?'开':'关'}</td>
							<td>${waterData1.waterSpeed}</td>
							<td>${waterData1.waterFlow}</td>
						</tr>
						<tr>
							<td>出水口2</td>
							<td>${waterStatus.water2=="1.00"?'开':'关'}</td>
							<td>${waterData2.waterSpeed}</td>
							<td>${waterData2.waterFlow}</td>
						</tr>
						<tr>
							<td>出水口3</td>
							<td>${waterStatus.water3=="1.00"?'开':'关'}</td>
							<td>${waterData3.waterSpeed}</td>
							<td>${waterData3.waterFlow}</td>
						</tr>
						<tr>
							<td>出水口4</td>
							<td>${waterStatus.water4=="1.00"?'开':'关'}</td>
							<td>${waterData4.waterSpeed}</td>
							<td>${waterData4.waterFlow}</td>
						</tr>
						<tr>
							<td>总控</td>
                            <td>${waterStatus.water5=="1.00"?'开':'关'}</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr>
							<td>施肥器</td>
                            <td>${waterStatus.water6=="1.00"?'开':'关'}</td>
							<td>-</td>
							<td>-</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
    
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
</script>
</body>
</html>