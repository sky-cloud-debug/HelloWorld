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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="#">区域管理</a><i class="fa fa-angle-right"></i><span class="athere">添加田地信息</span>
				</div>
				<div class="content-view">
				<h2 style="font-size: 25px">修改田地信息</h2>
					<form  style="margin-top: 45px"  method="post" id="areaAddForm" onsubmit="return false;">
					
						田地名字&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.areaName" value="${model.areaName}"style="width: 30%"/><br></br>
						灌水上限(%)&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.irrigationUpperLimit" value="${model.irrigationUpperLimit}"style="width: 30%"/><br></br>
						灌水下限(%)&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.irrigationLowerLimit" value="${model.irrigationLowerLimit}" style="width: 30%"/><br></br>
						田间持水率(%)&nbsp;<input type="text" name="model.averageWaterCapacity" value="${model.averageWaterCapacity} "style="width: 30%"/><br></br>
						生育初期土壤计划湿润层深度(cm)<input type="text" name="model.firstStageDepthOfWetting" value="${model.firstStageDepthOfWetting} "style="width: 30%"/><br></br>
						生育中期土壤计划湿润层深度(cm)<input type="text" name="model.secondStageDepthOfWetting"value="${model.secondStageDepthOfWetting}" style="width: 30%"/><br></br>
						生育后期土壤计划湿润层深度(cm)<input type="text" name="model.thirdStageDepthOfWetting" value="${model.thirdStageDepthOfWetting} "style="width: 30%"/><br></br>
						生育初期作物系数&nbsp;&nbsp;&nbsp;<input type="text" name="model.firstCropCoefficient"value="${model.firstCropCoefficient}" style="width: 30%"/><br></br>
						生育中期作物系数&nbsp;&nbsp;&nbsp;<input type="text" name="model.secondCropCoefficient"value="${model.secondCropCoefficient} "style="width: 30%"/><br></br>
						生育后期作物系数&nbsp;&nbsp;&nbsp;<input type="text" name="model.thirdCropCoefficient"value="${model.thirdCropCoefficient} "style="width: 30%"/><br></br>
						土壤类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.soilType" value="${model.soilType} "style="width: 30%"/><br></br>
						土壤干容重(g/cm3)&nbsp;<input type="text" name="model.soilDryBulkDensity" value="${model.soilDryBulkDensity}" style="width: 30%"/><br></br>
						出水口号码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="model.outletNumber" value="${model.outletNumber}"style="width: 30%"/><br></br>
						灌溉面积（亩）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="${model.irrigationArea} "name="model.irrigationArea"style="width: 30%"/><br></br>
                       <button onclick="areaAddFormSubmit()" class="btn"style=" margin-left: 0px ;margin-top: 20px">保存</button>
                       <button type="reset" class="btn" style=" margin-left:30 px ;margin-top: 20px">重置</button>
					</form>
				</div>
			</div>
		</div>
	</div>
    <script type="text/javascript">
function areaAddFormSubmit(){
	
	$.ajax({
		url:"${pageContext.request.contextPath}/area/updateArea2",
		type:"POST",
		data:$("#areaAddForm").serialize(),
		dataType:"text",
		
		success:function(data){
			if(data=="success"){
				alert("修改成功");
				window.location='${pageContext.request.contextPath}/region/detail/areaList';
			}
		},
		error:function(e){
			alert("操作失败");
		}
	});
}
</script>
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

</body>
</html>	
