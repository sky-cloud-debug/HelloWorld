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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/system.jsp">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">土壤墒情采集信息</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h2 style="font-size: 25px">土壤墒情采集信息</h2><a href="${pageContext.request.contextPath}/ExportExportSoil?status=exportSoil2"  style="font-size: 40px;margin-left: 650px"class="iconfont" >&#xe63f;</a>
						
						<table id="soilTable" style="margin-top: 45px">
							<tr>
								
								<td style="margin-top: 30px">土壤温度（℃）</td>
								<td style="margin-top: 30px">土壤湿度（%）</td>
								<td style="margin-top: 30px">酸碱度</td>
								<td style="margin-top: 30px">电导率（mS/cm）</td>
								<td style="margin-top: 30px">创建时间</td>
							</tr>
							<c:forEach items="${soilPage2.content}" var="soil">
								<tr>
									
									
									
									<td>${soil.soilTemp}</td>
									<td>${(soil.soilHumi+soil.soilHumi2+soil.soilHumi3)/3.0}</td>

									<td>${soil.ph}</td>
									<td>${soil.elect}</td>
									
									<td><fmt:formatDate value="${soil.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
								</tr>
    								
							</c:forEach>
						</table>
						<div id="soilPage" style="margin-left: -100px;margin-top: 70px;display:block;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>
	
	<%@include file="/WEB-INF/views/common/common_script.jspf" %>
	<script type="text/javascript">
	function selectCity(obj){
		//alert(obj.value);
		var cityName = obj.value;
		 $.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectRegion",
			type:"post",
			data:{cityName:cityName},
			dataType:"json",
			success:function(data){
	 				if (data.regions!=null) {
							for(i=0;i<data.regions.length;i++){
							$("#region").append("<option value='"+data.regions[i].id+"'>"+data.regions[i].regionName+"区"+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
	function countySubmit(){
		var value = document.getElementById("county").value;
		if(value==1){
			
			window.location="${pageContext.request.contextPath}/region/detail/soilList?regionId=1";			
		}
		else{
			
			
			//alert("有问题！");
		}
	}
	
	function submit(){
		
		 $.ajax({
			url:"http://sa.tcloudit.com:8003/ToCustomerService.svc/GetDeviceTypeData",
			type:"post",
			data:{privatekey:'fAqZzgBpz+FwBKCYBqVVMA==',username:'zzdz',pass:'123456',devicetype:'31',starttime:'2017-08-16 10:01',endtime:'2017-08-16 13:01'},
			dataType:"json",
			success:function(data){
	 				if (data=null) {
	 					
	 				alert(data);
			}},error:function(e){
				alert("数据加载失败！");
			}
		});  
		
	}
	
	
	function selectRegion(obj){
		var regionId = obj.value;
		 $.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectCounty",
			type:"post",
			data:{regionId:regionId},
			dataType:"json",
			success:function(data){
	 				if (data.countys!=null) {
							for(i=0;i<data.countys.length;i++){
							$("#county").append("<option value='"+data.countys[i].id+"'>"+data.countys[i].countyName+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
function loadData(pageNo,pageSize,type){
	var value =1;
	$.ajax({
		url:"${pageContext.request.contextPath}/region/detail/"+type+"List2ByPage",
		type:"post",
		data:{pageNo:pageNo,pageSize:pageSize,plotId:value},
		dataType:"text",
		success:function(data){
			$("#"+type+"Table").html(data);
		},error:function(e){
			alert("数据加载失败！");
		//	$("body").html(e.responseText);
		}
	});
}
$(function(){
	new GuangPage().init("${soilPage2.totalItems}",{$dom:$("#soilPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"soil");
	}});	
});
</script>
</body>
</html>	