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
			<div class="content fl"  >
				<div class="position">
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/system.jsp">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">城市情况</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h2 style="font-size: 25px" >城市情况表</h2>
						<table id="cityTable" style="margin-top: 45px ;margin-left:-30px">
							<tr>
							    <td>市</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${cityPage.content}" var="city">
								<tr id = "row_city">
									<td >${city.cityName}</td>
									<td>
									 <a href="javascript:;" onclick="ajaxDeleteCity(${city.id},this)"><i class="iconfont" style="font-size:25px;">&#xe63c;</i></a></td>
								</tr>
							</c:forEach>
						</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function ajaxDeleteCity(id,obj){
	     $.ajax({
         url:"${pageContext.request.contextPath}/region/deleteCity",
         type:"post",
         data:{cityId:id},
         dataType:"text",
         success:function(data){
 			if(data=="success"){
 				alert("操作成功");
 				$(obj).parents("tr").remove();
 			}
 		},
 		error:function(e){
 			alert("操作失败");
 		}
 	});
       }
	</script> 
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

    <%@include file="/WEB-INF/views/common/common_script.jspf" %>
</body>
</html>

	


