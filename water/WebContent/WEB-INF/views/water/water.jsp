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
	<style>
	  	.btn{background:#81a44a;border-radius:2px;box-shadow:1px 1px 3px #ccc;padding:6px 10px;font-size:18px;font-family:"微软雅黑";color:#fff;}
	  	.btn:hover{cursor:pointer;background:darkgreen;color:#fff;}
	  </style>
<style>
   #water-box{border:1px solid green;margin:50px auto;padding:20px;width:500px;}
   #water-box p{}
   #water-box p .i_text{padding:8px 10px;}
   #water-box p select{width:200px;}
   #water-box p .i_btn{padding:6px 18px;}
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

href="${pageContext.request.contextPath}/system.jsp">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">气象数据下载</span>
				</div>
				<div class="content-view">
					
	  <h1 style="font-size: 25px">灌水信息</h1>
	  <form  style="margin-top: 45px ;margin-left: 100px" action="${pageContext.request.contextPath}/water/confirm" method="post">
	   <c:forEach items="${waterList}" var="water" >
	     <p>${water.outletNumber }号出水口，灌溉面积：${water.irrigationArea }亩，灌水量：${water.waterNum } m3&nbsp;<input style="width: 40%" id = "irri" placeholder="请输入灌溉量" ><span>mm</span></p>
	  </c:forEach>
	  <p><!-- <input type="submit" value="确定" class="i_btn"/> --> <button class="i_btn btn" id="ii"  style=" margin-top:20px;width: 100px ;height: 40px;">系统管理员登录</button></p>
	  </form>
  </div>
 
						<div id="soilPage" style="margin-left: -100px;margin-top: 70px"></div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/common/footer.jspf" %>
	
    <script type="text/javascript">
  $('#irri').val("");
  </script>
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
	new GuangPage().init("${soilPage.totalItems}",{$dom:$("#soilPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"soil");
	}});
});
</script>
</body>
</html>