<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
  <c:set  var="activeMenu" value="区域管理"></c:set>
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
		<script src="${pageContext.request.contextPath}/js/base.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
		<script src="${pageContext.request.contextPath}/dist/jquery-confirm.min.js"></script><!-- callback -->
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="javascript:void(0);">身份验证</a><i class="fa fa-angle-right"></i><span class="athere">系统管理员验证</span>
				</div>
				<div class="content-view">
				<h2 style="font-size: 25px">系统管理员登录</h2>
					<form  id="regionAddForm" style="margin-top: 45px" onsubmit="return false;">
						用户名&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.username" style="width: 30%"/><br></br>
						密&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="model.password" style="width: 30%"/><br></br>
						 <button  class="btn"style="margin-left:-5px  ; margin-top: 20px" onclick="regionAddFormSubmit()">确定</button>
                       <button type="reset" class="btn"style=" margin-left: 20px ;margin-top: 20px">重置</button>					
					</form>
					<script type="text/javascript">
function regionAddFormSubmit(){
	$.ajax({
		url:"${pageContext.request.contextPath}/water/login1",
		type:"POST",
		data:$("#regionAddForm").serialize(),
		dataType:"text",
		success:function(data){
			if(data!="fail"){
				alert("登录成功！");
				  if(data=="exportSoil"){window.location="${pageContext.request.contextPath}/ExportExportSoil?status=exportSoil";} 
				  if(data=="exportSoil2"){window.location="${pageContext.request.contextPath}/ExportExportSoil?status=exportSoil2";} 
				  if(data=="exportWeather"){window.location="${pageContext.request.contextPath}/ExportExportWeather?status=exportWeather";}
				  if(data=="exportWeather2"){window.location="${pageContext.request.contextPath}/ExportExportWeather?status=exportWeather2";}
				  if(data=="exportForecastWeather"){window.location="${pageContext.request.contextPath}/ExportExportForecastWeather?status=exportForecastWeather";}
				  if(data=="manualControl"){window.location="${pageContext.request.contextPath}/water/login?status=manualControl";}
				 //2017年4月17号新增的
				  if(data=="autoFertilizer"){window.location="${pageContext.request.contextPath}/water/login3?status=autoFertilizer";}
				 
				 
				  if(data=="autoControl"){window.location="${pageContext.request.contextPath}/water/login2?status=autoControl";}
				  if(data=="selectRegion"){window.location="${pageContext.request.contextPath}/region/login2?status=selectRegion";}
				  if(data=="selectCity"){window.location="${pageContext.request.contextPath}/region/login6?status=selectCity";}
				  if(data=="selectCounty"){window.location="${pageContext.request.contextPath}/region/login7?status=selectCounty";}
				  if(data=="selectPlot"){window.location="${pageContext.request.contextPath}/region/login8?status=selectPlot";}
				  if(data=="addRegion"){window.location="${pageContext.request.contextPath}/region/login3?status=addRegion";}
				  if(data=="addField"){window.location="${pageContext.request.contextPath}/area/login?status=addField";}
				  if(data=="addCity"){window.location="${pageContext.request.contextPath}/region/login1?status=addCity";}
				  if(data=="addPlot"){window.location="${pageContext.request.contextPath}/region/login5?status=addPlot";}
				  if(data=="addCounty"){window.location="${pageContext.request.contextPath}/region/login4?status=addCounty";}
				  if(data=="addCrop"){window.location="${pageContext.request.contextPath}/region/detail/login3?status=addCrop";}
				  if(data=="collectCrop"){window.location="${pageContext.request.contextPath}/region/detail/login?status=collectCrop";}
				  if(data=="newsList"){window.location="${pageContext.request.contextPath}/news/newsList?status=newsList";}
				  if(data=="addNews"){window.location="${pageContext.request.contextPath}/news/addNews?status=addNews";}
				  
			}
			else{
				alert("登录失败，请重试！"); 	}},
		error:function(e){
			alert("登录出现异常问题！");
		}
	});
}
</script>
				</div>
			</div>
		</div>

	</div>
    
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

</body>
</html>	

