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
		<title>农田水肥一体化智慧化大数据系统平台</title>
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" /> 
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"  />
		<link href="${pageContext.request.contextPath}/css/flexslider.css" rel="stylesheet"/>
		<!--[if lt IE 9]>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="css/ie7.css">
		<![endif]-->
		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="${pageContext.request.contextPath}/js/base.js"></script><!-- callback -->
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/header.jspf" %>

	<!-- main -->
    <div class="system">
        <div class="sys-main">
            <div class="sys">
            		<%@ include file="/WEB-INF/views/common/menu.jspf" %>

                <div class="box clearfix">
                	<img src="${pageContext.request.contextPath}/images/sys-pic.jpg" class="fl"/>
                    <p>分为人工采集和自动采集，其中自动采集通过科学组配气象、土壤、作物长势等各类传感器，组成地空一体传感器簇，构建作物生长过程环境信息智慧化感知系统，实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。人工采集作为大数据采集的重要手段、自动采集的有效补充，其采集指标包括项目及采样点基本信 息、作物播种、施肥、喷药、全生育期苗情信息等。项目区管理人员及科研人员分权限登录查看及录入信息，人工采集信息通过山东农业大学大数据平台传输到大数据数据服务器，为后续数据分析、监控预警、决策服务提供全天候、立体化数据支撑。</p>
                </div>
            </div>
        
        	<div class="history widget">
            	<div class="top clearfix">
					<h3 class="module-tip">历史数据</h3>
					<div class="select-group">
						<form method="post" action="${pageContext.request.contextPath}/region/show">
						<span>区域</span>
							<select id="city" name="regionId" style="width:150px;">
								<c:forEach items="${page.content}" var="item">
									<option value="${item.id}">${item  .city}、${item.town}</option>	
								</c:forEach>
							</select>
						</form>
					</div>
                </div>
                <ul class="his-main col-3 clearfix">
                	<li class="fl">
                    	<h3>土壤水分历史数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s1.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see sub_btn" href="javascript:void(0);">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>气象历史数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s2.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see" href="javascript:void(0);">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>农作物历史数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s3.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see" href="javascript:void(0);">查看数据</a>
                    </li>
                </ul>
            </div>
            <div class="history widget">
            	<div class="top clearfix">
					<h3 class="module-tip">自动采集</h3>
					<div class="select-group">
						 <form method="post" action="${pageContext.request.contextPath}/region/detail/show" id="regionForm">
							<select id="city" name="regionId" style="width:150px;">
								<c:forEach items="${page.content}" var="item">
									<option value="${item.id}">${item.city}、${item.town}</option>	
								</c:forEach>
							</select>
							<input type="hidden" name="type"/>
						</form>
					</div>
                </div>
                <ul class="his-main col-3 clearfix">
                	<li class="fl">
                    	<h3>土壤水分数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s4.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see  sub_btn" href="javascript:void(0);" class="sub_ton">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>气象数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s5.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see sub_btn" href="javascript:void(0);" class="sub_btn">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>管网控制系统数据</h3>
                        <img src="${pageContext.request.contextPath}/images/s6.jpg" />
                        <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                        <a class="see sub_btn" href="javascript:void(0);" class="sub_btn">查看数据</a>
                    </li>
                </ul>
            </div>
            <div class="history widget">
            	<div class="top clearfix">
                    <h3 class="module-tip">人工采集</h3>
					<div class="select-group">
						<span>选择采集点</span>
						<select id="city" name="city">
							<option>区域</option>
							<option value="区域1">区域1</option>
						</select>
						<select id="area" name="area">
							<option>采集点</option>
							<option value="采集点1">采集点1</option>
						</select>
						<input type="submit" value="确定"/>
					</div>
                </div>
                <div class="his-main-c clearfix">
                	<div class="his-l fl">
                    	<img src="${pageContext.request.contextPath}/images/s7.jpg" class="fl"/>
                        <div class="his-con">
                        	<h3>作物数据采集</h3>
                            <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                            <a class="see" href="javascript:void(0);">查看数据</a>
                        </div>
                    </div>
                    <div class="his-l his-r fl">
                    	<img src="${pageContext.request.contextPath}/images/s8.jpg" class="fl"/>
                        <div class="his-con">
                        	<h3>作物数据显示</h3>
                            <p>实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。</p>
                            <a class="see" href="javascript:void(0);">查看数据</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

	<script type="text/javascript">
	  $(function(){
	   $(".sub_btn").click(function(){
			$("#regionForm").submit();								   
	   });
	  });
	</script>
</body>
</html>		