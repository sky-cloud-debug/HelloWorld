
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/flexslider.css" rel="stylesheet" />

<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
		<![endif]-->
<!--[if IE 7]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css">
		<![endif]-->
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<!-- jQ -->
<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<!-- banner slider -->
<script src="${pageContext.request.contextPath}/js/base.js"></script>
<!-- callback -->
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jspf" %>

	<!-- main -->
	<div class="single-content">
		<div class="single clearfix">
			<div class="sidebar fl">
				<ul class="cage-name-nav">
					<li><a href="${pageContext.request.contextPath}/project.html"><i class="fa fa-desktop"></i>项目介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/system.jsp"><i class="fa fa-bar-chart-o"></i>大数据系统</a></li>
					<li><a href="${pageContext.request.contextPath}/news.html"><i class="fa fa-newspaper-o"></i>平台咨讯</a></li>
					<li><a href="${pageContext.request.contextPath}/aboutus.html"><i class="fa fa-bookmark"></i>关于我们</a></li>
				</ul>
			</div>
			<div class="content fl">
				<div class="content-view">
						<h1 class="title">${news.title}</h1>
						${news.content}
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

</body>
</html>
