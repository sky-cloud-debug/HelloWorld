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
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" /> 
		<link href="css/style.css" rel="stylesheet" />
		<link href="css/font-awesome.min.css" rel="stylesheet"  />
		<link href="css/flexslider.css" rel="stylesheet"/>
		
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico"/>
        <link rel="bookmark" href="${pageContext.request.contextPath}/favicon.ico"/>
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
			<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="${pageContext.request.contextPath}/js/base.js"></script><!-- callback -->
	</head>
	<body>
	<%@ include file="/WEB-INF/views/common/header.jspf" %>

	<!-- banner -->
	<div class="banner-content">
		<div class="banner">
			<div id="slider" class="flexslider">
				<ul class="slides">
				    <li style="background:url(images/banner1.jpg) center center no-repeat ;"></li>
					<li style="background:url(images/banner1.jpg) center center no-repeat ;"></li>
                    <li style="background:url(images/banner1.jpg) center center no-repeat ;"></li>
                    <li style="background:url(images/banner1.jpg) center center no-repeat ;"></li>
                    <li style="background:url(images/banner1.jpg) center center no-repeat ;"></li>
				</ul>
			</div>
		</div>
	</div>
    <div class="shujv">
    	<div class="data-content">
			<h3 class="module-tip">智慧化大数据系统</h3>
			<div class="slider-content">
				<div class="data-info">
					<ul class="slider-public col-5 clearfix">
						<li class="fl">
							<a href="${pageContext.request.contextPath}/system.jsp">
								<div class="desc">
									<h3 class="title"><span class="icon icon1"></span>数据采集</h3>
									<img src="images/p1.jpg" />
									<p>实时采集传输各类数据，为后续数据分析、监控预警、决策服务提供全天候、立体化数据支撑。</p>
								</div>
							</a>
						</li>
						<li class="fl"><!--   monitor.jsp water/device-->
							<a href="${pageContext.request.contextPath}/analysis.html">
								<div class="desc">
									<h3 class="title"><span class="icon icon2"></span>数据挖掘</h3>
									<img src="images/p2.jpg" />
									<p>挖掘分析相关历史数据和实时数据及时指导农业生产并为监控预警和管理决策提供可靠依据。</p>
								</div>
							</a>
						</li>
						<li class="fl">
							<a href="${pageContext.request.contextPath}/system.jsp">
								<div class="desc">
									<h3 class="title"><span class="icon icon3"></span>监控预警</h3>
									<img src="images/p3.jpg" />
									<p>根据作物适宜生长阈值实施预警，为提前预防和科学处置农业生产中的病虫灾害提供警示信息。</p>
								</div>
							</a>
						</li>
						<li class="fl">
							<a href="${pageContext.request.contextPath}/system.jsp">
								<div class="desc">
									<h3 class="title"><span class="icon icon4"></span>决策服务</h3>
									<img src="images/p4.jpg" />
									<p>通过立体化发布，为政府、企业、农户生产管理和决策提供科学依据为推进渤海粮仓科技示范工程健康发展服务。</p>
								</div>
							</a>
						</li>
						<li class="fl">
							<a href="${pageContext.request.contextPath}/assess.html">
								<div class="desc">
									<h3 class="title"><span class="icon icon5"></span>效益评估</h3>
									<img src="images/p5.jpg" />
									<p>对项目进行全面系统的回顾和总结得出经验教训，提出改进建议，反馈决策者。</p>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
    </div>
	
	<!-- main -->
	<div class="main-content">
		<div class="main clearfix">
			<div class="left fl">
					<h2 class="title" id="platform">平台动态 <a class="more" href="${pageContext.request.contextPath}/news/more">更多新闻</a></h2>
					<div class="type1">
					</div>
			</div>
			<div class="middle fl">
				<h2 class="title" id="report" >媒体报道<a class="more" href="${pageContext.request.contextPath}/news/more">更多新闻</a></h2>
				 <div class="type2">
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

	<script type="text/javascript">
	        var flag=false;
     		$("#loginBtn").click(function(){
     			if(!flag){
     				var username=$("#loginForm").find("input[type='text']").val().trim();
     				var password=$("#loginForm").find("input[type='password']").val().trim();
     				if(username==""){
     					alert("用户名不能为空！");
     					return;
     				}
     				if(password==""){
     					alert("密码不能为空！");
     					return;
     				}
     				$.ajax({
     					url:"${pageContext.request.contextPath}/user/login",
     					data:$("#loginForm").serialize(),
     					type:"post",
     					dataType:"text",
     		 			success:function(data){
     						flag=true;
     						if("success"==data){
     							window.location.reload();
     						}
     		 			},
     		 			error:function(response){
     		 				alert("用户名或密码错误！");
     		 			}					
     				});
     			}
  		});

		
     		$(function(){
     			initNewsList(1);	
     			initNewsList(2);	
     		});
     		//ajax加载数据初始化新闻列表
     		function initNewsList(type){
     		 	$.ajax({
     		 		url:"${pageContext.request.contextPath}/news/ajaxListByPageAndType",
     		 		data:{type:type},
     		 		type:"post",
     		 		dataType:"json",
     		 		success:function(data){
     		 		 var html="";
     		 		 html+='<img src="${pageContext.request.contextPath}/'+data.content[0].imgPath+'" class="fl" />';
     		 		 html+='<ul class="normal-list" id="report_list">';
					 var arr=data.content;
					 var length=arr.length<5?arr.length:5;
					for(var i=0;i<length;i++){
						html+='<li><a href="${pageContext.request.contextPath}/news/detail?newsId='+arr[i].id+'">'+getEllipseText(arr[i].title,11)+'<span class="fr">'+arr[i].createTime.slice(0,10)+'</span></a></li>';
					} 
					 html+='</ul>';
     		 		$(".type"+type).html(html);
     		 		}
     		 	});
     		}
     	function getEllipseText(text,length){
     		if(text.length>length){
     			return text.slice(0,length)+"...";
     		}else{
     			return text;
     		}
     	}
     	
     	
   
     	
	</script>
</body>
</html>		




