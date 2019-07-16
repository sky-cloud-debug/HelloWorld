<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
<c:set  var="activeMenu" value="监控预警"></c:set>
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
		<title>农田水肥一体化智慧化大数据系统平台</title>
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" /> 
		<link href="css/style.css" rel="stylesheet" />
		<link href="css/font-awesome.min.css" rel="stylesheet"  />
		<link href="css/flexslider.css" rel="stylesheet"/>
		<!--[if lt IE 9]>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="css/ie7.css">
		<![endif]-->
		<style type="text/css">
			input[type='button']{cursor:pointer;}
		</style>
		<script src="js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="js/base.js"></script><!-- callback -->
	</head>
	<body>
	<div class="login-content">
		<div class="login clearfix">
        	<span class="fl">欢迎进入：农田灌溉大数据智慧化系统平台</span>
			<c:if test="${empty sessionScope.user}">
				<div class="input-group fr">
					<!-- <form action="" method="post" id="loginForm">
						<input type="text" name="model.username" placeholder="用户名" value="用户名" onfocus="if(value=='用户名') {value=''}" onblur="if (value=='') {value='用户名'}"/>
						<input type="password" name="model.password" placeholder="密码"/>
						<input type="button" value="登录" id="loginBtn"/>
					</form> -->
				</div>
			</c:if>
			<c:if test="${!empty sessionScope.user}">
				欢迎你：${sessionScope.user.user.username}
				<a href="${pageContext.request.contextPath}/user/logout">退出</a>
			</c:if>
		</div>
	</div>
	<!-- header -->
	<div class="header-content">
		<div class="header clearfix">
			<div class="fl logo">
				<img src="images/logo1.png" class="fl" />
				<a href="${pageContext.request.contextPath}/index.jsp">农田水肥一体化智慧化大数据系统平台<span>滨州沾化区智慧化高效节水项目</span></a>
            </div>
			<ul class="fl menu">
				<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/project.html">项目介绍</a></li>
				<li><a href="${pageContext.request.contextPath}/system.html">大数据系统</a></li>
				<li><a href="${pageContext.request.contextPath}/news.html">平台资讯</a></li>
				<li><a href="${pageContext.request.contextPath}/aboutus.html">关于我们</a></li>
			</ul>
		</div>
	</div>


		<!-- main -->
    <div class="single-content">
		<div class="single clearfix">
			<div class="sidebar fl">
				<h2 class="title">大数据系统</h2>
<%@include file="/WEB-INF/views/common/menu.jspf" %>
                <ul class="cage-name-nav">
					<li><a href="${pageContext.request.contextPath}/project.html"><i class="fa fa-desktop"></i>项目介绍</a></li>
                    <li><a href="${pageContext.request.contextPath}/system.html"><i class="fa fa-bar-chart-o"></i>大数据系统</a></li>
                    <li><a href="${pageContext.request.contextPath}/news.html"><i class="fa fa-newspaper-o"></i>平台咨讯</a></li>
                    <li><a href="${pageContext.request.contextPath}/aboutus.html"><i class="fa fa-bookmark"></i>关于我们</a></li>
				</ul>
			</div>
			<div class="content fl">
				<div class="position">
					<a href="index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/monitor.jsp">监控预警</a><i class="fa fa-angle-right"></i><span class="athere">干旱预警</span>
				</div>
				<div class="content-view">
                	<h1 class="title">干旱预警</h1>
                    <img src="images/3.jpg" />
				</div>
			</div>
		</div>
	</div>
    
	<div class="footer">
        <div class="footer-t">
            <div class="footer-content">
                <ul class="web col-4 clearfix">
                    <li class="fl">政府机构网站<i class="fa fa-angle-down"></i></li>
                    <li class="fl">科研院所网站<i class="fa fa-angle-down"></i></li>
                    <li class="fl">常用农业网站<i class="fa fa-angle-down"></i></li>
                    <li class="fl contacttip">山东农业大学水利土木工程学院<i class="fa fa-angle-down"></i></li>
                </ul>
            </div>
        </div>
		<div class="footer-content">
			<ul class="web-list col-4 clearfix">
				<li class="fl">
					<a href="http://www.most.gov.cn">+科技部</a>
					<a href="http://www.moa.gov.cn/">+农业部</a>
					<a href="http://www.sdstc.gov.cn/">+山东省科技厅</a>
					<a href="http://www.dysti.gov.cn/">+东营市科技局</a>
					<a href="http://www.bzst.gov.cn/">+滨州市科技局</a>
				</li>
				<li class="fl">
					<a href="http://www.sdau.edu.cn">+山东农业大学</a>
					<a href="http://www.cas.cn/">+中国科学院</a>
					<a href="http://www.caas.net.cn/">+中国农业科学院</a>
					<a href="http://www.sdas.org/">+山东省科学院</a>
				</li>
				<li class="fl">
					<a href="http://www.agri.gov.cn/">+中国农业信息网</a>
					<a href="http://www.3w3n.com/">+农产品价格信息网</a>
					<a href="http://www.chinaseed.net/">+中国种子信息网</a>
					<a href="http://www.china-fertinfo.com.cn/">+中国化肥信息网</a>
				</li>
				<li class="fl contacttype">
					<p><i class="fa fa-map-marker"></i>地址：山东农业大学岱宗大街61号</p>
					<p><i class="fa fa-phone"></i>电话：0538-8249612  </p>
					<p><i class="fa fa-fax"></i>传真: 0538-8249612</p>
					<p><i class="fa fa-envelope"></i>E-mail：liufsh@sdau.edu.cn</p>
				</li>
			</ul>
		</div>
    </div>
	<div class="copy">
		<div class="footer-content">
			<p>Copyright © 2016 山东农业大学水利土木工程学院 All Right Reserved 鲁ICP备08014187</p>
	   </div>
	</div>
</body>
</html>	


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
			$("body").html(e.responseText);
		}
	});
}
$(function(){
	new GuangPage().init("${soilPage.totalItems}",{$dom:$("#soilPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"soil");
	}});
});
function riqi(content){
	if(content==null)
		return "无";
	else
		return content.substring(0,10);
};
 		$("#ii").click(function(){
 			var areaId=$('#area_id').val();
 				$.ajax({
 					url:"${pageContext.request.contextPath}/forecast/forecast",
 					data:{'areaId':areaId},
 					type:"post",
 					dataType:"json",
 		 			success:function(data){
 		 				if(data.msg1=="目前已达灌溉下限值，请灌溉")
 		 					{alert(data.msg1); }else{
 		 				alert(data.msg1); 
 		 				$("#forecastTable").html("");
 		 				$("#forecastTable").append("<tr><td>日期</td><td>ET0预测（mm）</td><td>KC预测</td><td>耗水量预测（mm）</td><td>土壤含水率预测（占土壤体积%）</td></tr>");
 		 				if (data.forecast_list!=null) {
 							$.each(data.forecast_list, function(i, item) {
 								/* $("#forecastTable").append("<td>"+data.forecast_list.date.year+"年"+data.forecast_list.date.month+"月"+data.forecast_list.date.date+"日</td>"); */
 								
 								$("#forecastTable").append("<tr><td>"+riqi(item.date)+"</td>"
 								+"<td>"+item.eT0pre+"</td>"
 								+"<td>"+item.kCpre+"</td>"
 								+"<td>"+item.ipre+"</td>"
 								+"<td>"+item.soilHumipre<data.lower?'--':item.soilHumipre+"</td></tr>");
 							});
 		 				}
 		 			}},
 		 			error:function(response){
 		 				alert("网络不太稳定！请尝试重新刷新界面");
 		 			}					
 				});
 			});
</script>
</body>
</html>