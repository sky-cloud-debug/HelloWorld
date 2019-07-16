<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
			<%@include file="/WEB-INF/views/common/common_css.jspf"%>    
		<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css">
		<![endif]-->
	</head>
	<body>
	<!--fast-login-->
		<%@include file="/WEB-INF/views/common/header.jspf" %>
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
				<div class="tab-slider">
					<a id="part1" class="active">平台动态</a>
					<a id="part2">媒体报道</a>
				</div>
				<div class="tab-content">
					<div class="part1">
						<ul class="con-list type1">
						</ul>
						<div id="newsPage1" style="margin-top:10px;"></div>
					</div>
					<div class="part2">
						<ul class="con-list type2">
						</ul>
						<div id="newsPage2" style="margin-top:10px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jspf"%>    
	<%@include file="/WEB-INF/views/common/common_script.jspf"%>    
	<script type="text/javascript">
		$(function(){
			initNewsList(1,1,10);
			initNewsList(2,1,10);
		});
		    //ajax加载数据初始化新闻列表
		    var flag=0;
     		function initNewsList(type,pageNo,pageSize){
     		 	$.ajax({
     		 		url:"${pageContext.request.contextPath}/news/ajaxListByPageAndType",
     		 		data:{type:type,"page.pageNo":pageNo,"page.pageSize":pageSize},
     		 		type:"post",
     		 		dataType:"json",
     		 		success:function(data){
     		 		 var html="";
     		 		 var arr=data.content;
					for(var i=0;i<arr.length;i++){
     		 		 html+='<li class="clearfix">'+
							'<div class="time fl">'+
							'		<b>'+getDay(arr[i].createTime)+'</b>'+
							'		<i>'+getYear(arr[i].createTime)+'.'+getMonth(arr[i].createTime)+'</i>'+
							'	</div>'+
							'	<a href="${pageContext.request.contextPath}/news/detail?newsId='+arr[i].id+'">'+arr[i].title+'</a>'+
							'</li>';
					} 
     		 		$(".type"+type).html(html);
     		 		if(flag<=2){
	    		 		 new GuangPage().init(data.totalItems,{$dom:$("#newsPage"+type),callback:function(pageNo,pageSize){
								initNewsList(type,pageNo+1,10);
				     	}});
			     	}
			     	flag++;
     		 		}
     		 	});
     		}
     		function getYear(date){
     			return date.slice(0,4);
     		}
     		function getMonth(date){
     			return date.slice(5,7);
     		}
     		function getDay(date){
     			return date.slice(8,10);
     		}
	</script>
</body>
</html>		