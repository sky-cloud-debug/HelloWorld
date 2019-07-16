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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="#">区域管理</a><i class="fa fa-angle-right"></i><span class="athere">添加乡镇信息</span>
				</div>
				<div class="content-view">
				<h2 style="font-size: 25px">添加乡镇信息</h2>
					<form  id="countyAddForm" style="margin-top: 45px " onsubmit="return false;">
						市&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;<select id="city" name="city" onchange="selectCity(this)"style="width: 30%">
							<option>请选择</option>
						</select><br></br>
						区域名&nbsp;&nbsp;&nbsp;&nbsp;<select id="region" name="model.region.id" style="width: 30%">
							<option>请选择</option>
						</select><br></br>
						<input type = "hidden" id="regionId" />
						乡镇名&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.countyName" style="width: 30%"/><br></br>
						
						<br></br>
						 <button  class="btn"style="margin-left:-5px  ; margin-top: 20px" onclick="countyAddFormSubmit()">保存</button>
                       <button type="reset" class="btn"style=" margin-left: 20px ;margin-top: 20px">重置</button>					
					</form>
					<script type="text/javascript">
					
					$(function(){
					    $("#city").empty();
						$("#city").append("<option>请选择</option>");
						$("#region").empty();
						$("#region").append("<option>请选择</option>");
					$.ajax({
						url:"${pageContext.request.contextPath}/region/selectRegion/select17",
						type:"get",
						dataType:"json",
						success:function(data){
				 				if (data.cities!=null) {
				 					$("#city").empty();
				 					$("#city").append("<option>请选择</option>");
				 					$("#region").empty();
				 					$("#region").append("<option>请选择</option>");
										for(i=0;i<data.cities.length;i++){
										$("#city").append("<option value='"+data.cities[i].cityName+"'>"+data.cities[i].cityName+"</option>");
				 				}
						}},error:function(e){
							alert("数据加载失败！");
						}
					}); 	
				});
				
					
					
						function selectCity(obj) {
							var str;
							if (obj.id.substring(obj.id.length - 1,
									obj.id.length) == "1") {
								str = "1";
							} else {
								str = "";
							}

							$("#region" + str).empty();
							$("#region" + str).append("<option>请选择</option>");
							var cityName = obj.value;
							$
									.ajax({
										url : "${pageContext.request.contextPath}/region/selectRegion/selectRegion",
										type : "post",
										data : {
											cityName : cityName
										},
										dataType : "json",
										success : function(data) {
											if (data.regions != null) {
												$("#region" + str).empty();
												$("#region" + str).append(
														"<option>请选择</option>");
												for (i = 0; i < data.regions.length; i++) {
													$("#region" + str)
															.append(
																	"<option value='"+data.regions[i].id+"'>"
																			+ data.regions[i].regionName
																			+ "</option>");
												}
											}
										},
										error : function(e) {
											alert("数据加载失败！");
										}
									});
						}

						function countyAddFormSubmit() {
									$.ajax({
										url : "${pageContext.request.contextPath}/region/selectRegion/countyAdd",
										type : "POST",
										data : $("#countyAddForm").serialize(),
										dataType : "text",
										success : function(data) {
											if (data == "success") {
												alert("保存成功");
												//window.location='${pageContext.request.contextPath}/region/login2';
											}
										},
										error : function(e) {
											alert("保存失败");
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

