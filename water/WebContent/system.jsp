<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		<!--[if lt IE 9]>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="css/ie7.css">
		<![endif]-->
		<script src="js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="js/base.js"></script><!-- callback -->
		<script src="js/jquery.cookie.js"></script>
	</head>
	
	
	<body>
	<div class="login-content">
		<div class="login clearfix">
        	<span class="fl">欢迎进入：水肥一体化节水灌溉智慧化大数据平台</span>
			<div class="input-group fr">
				<!-- <form action="/" method="post">
					<input type="text" name="username" placeholder="用户名" value="用户名" onfocus="if(value=='用户名') {value=''}" onblur="if (value=='') {value='用户名'}"/>
					<input type="password" name="password" placeholder="密码"/>
					<input type="submit" name="submit" value="登录"/>
				</form> -->
			</div>
		</div>
	</div>
	<!-- header -->
	<div class="header-content">
		<div class="header clearfix">
			<div class="fl logo">
				<img src="images/logo1.png" class="fl" />
				<a href="index.jsp">水肥一体化节水灌溉智慧化大数据平台<span>滨州沾化区智慧化高效节水项目</span></a>
            </div>
			<ul class="fl menu">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="project.html">项目介绍</a></li> 
				<li><a href="system.jsp">大数据系统</a></li>
				<li><a href="news.html">平台资讯</a></li>
				<li><a href="aboutus.html">关于我们</a></li>
			</ul>
		</div>
	</div>
	<!-- main -->
    <div class="system">
        <div class="sys-main">
            <div class="sys">
                <h3 class="module-tip">智慧化大数据系统</h3><!-- monitor.jsp  water/login-->
                <ul class="sys-list col-5 clearfix">
                	<li class="fl"><a href="javascript:void(0);" ><span class="icon icon1"></span>数据采集</a></li>
                	<li class="fl"><a href="javascript:void(0);"><span class="icon icon2"></span>数据挖掘</a></li>
                	<li class="fl"><a href="javascript:void(0);"><span class="icon icon3"></span>监控预警</a></li>
                	<li class="fl"><a href="javascript:void(0);"><span class="icon icon4"></span>决策服务</a></li>
                	<li class="fl"><a href="assess.html"><span class="icon icon5"></span>效益评估</a></li>
                </ul>
                <div class="box clearfix">
                	<img src="images/sys-pic.jpg" class="fl"/>
                    <p>分为人工采集和自动采集，其中自动采集通过科学组配气象、土壤、作物长势等各类传感器，组成地空一体传感器簇，构建作物生长过程环境信息智慧化感知系统，实时采集传输各类数据，为后续数据分析，构建农业大数据分析技术系统提供数据支持。人工采集作为大数据采集的重要手段、自动采集的有效补充，其采集指标包括项目及采样点基本信 息、作物播种、施肥、喷药、全生育期苗情信息等。项目区管理人员及科研人员分权限登录查看及录入信息，人工采集信息通过山东农业大学大数据平台传输到大数据数据服务器，为后续数据分析、监控预警、决策服务提供全天候、立体化数据支撑。</p>
                </div>
            </div>
            
            <input type="hidden" id="tableSeparate"/>
            <input type="hidden" id="tablePlot"/>
            
            
        	<div class="history widget">
            	<div class="top clearfix">
					<h3 class="module-tip">历史数据</h3>
					<div class="select-group">
						<span>区域</span>
						<select id="city1" name="city" onchange="selectCity(this)">
						<option>请选择</option>
						</select>
						<select id="region1" name="region" onchange="selectRegion(this)">
							<option>请选择</option>
						</select>
						<select id="county1" name="county" onchange="selectCounty(this)">
						<option>请选择</option>
						</select>
						<select id="plot1" name="plot" onchange="selectPlot(this)">
						<option>请选择</option>
						</select>
					</div>
                </div>
                <ul class="his-main col-3 clearfix">
                	<li class="fl">
                    	<h3>土壤水分历史数据</h3>
                        <img src="images/s1.jpg" /><!-- region/detail/soilDownload --><!-- region/detail/weartherDownload -->
                        <p>实时采集并传输土壤温湿度数据至大数据平台系统，为后续历史数据分析，构建农业大数据模型提供数据支持。</p>
                       <!--  <a class="see" href="region/detail/soilList?regionId=1">查看数据</a> -->
                        <a class="see" href="javascript:void(0);" onclick="soilSubmit('1')">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>气象历史数据</h3>
                        <img src="images/s2.jpg" />
                        <p style="font-size: 12px">实时采集农田小气候数据，包括日最高温度、最低温度、相对湿度、日照时数、风速、风向等气象数据，为作物需水量模型构建提供数据支持。</p>
                        <!-- <a class="see" href="region/detail/weatherList?regionId=1">查看数据</a> -->
                         <a class="see" href="javascript:void(0);" onclick="weatherSubmit('1')">查看数据</a> 
                    </li>
                	<li class="fl">
                    	<h3>农作物历史数据</h3>
                        <img src="images/s3.jpg" />
                        <p>通过采集作物不同生育期的叶面积数据、冠层温度数据等为构建作物生长模型提供数据支持</p>
                        <!-- <a class="see" href="region/detail/login?status=collectCrop">查看数据</a> -->
                         <a class="see" href="region/detail/login?status=collectCrop">查看数据</a> 
                    </li>
                </ul>
            </div>
            <div class="history widget">
            	<div class="top clearfix">
					<h3 class="module-tip">自动采集</h3>
					<div class="select-group">
						<span>区域</span>
						<select id="city" name="city" onchange="selectCity(this)">
							<option>请选择</option>
						</select>
						<select id="region" name="region" onchange="selectRegion(this)">
							<option>请选择</option>
						</select>
						<select id="county" name="county" onchange="selectCounty(this)">
						<option>请选择</option>
						</select>
						<select id="plot" name="plot" onchange="selectPlot(this)">
						<option>请选择</option>
						</select>
					</div>
                </div>
                <ul class="his-main col-3 clearfix">
                	<li class="fl">
                    	<h3>土壤水分数据</h3>
                        <img src="images/s4.jpg" />
                        <p></p>
                        <a class="see" href="javascript:void(0);" onclick ="soilSubmit('')">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>气象数据</h3>
                        <img src="images/s5.jpg" />
                         <p></p>
                        <a class="see" href="javascript:void(0);" onclick="weatherSubmit('')">查看数据</a>
                    </li>
                	<li class="fl">
                    	<h3>管网控制系统数据</h3>
                        <img src="images/s6.jpg" />
                         <p></p>
                        <a class="see" href="water/device">查看数据</a>
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
							<option value="1">沾化区</option>
						</select>
						<!-- <select id="area" name="area">
							<option>采集点</option>
							<option value="采集点1">采集点1</option>
						</select> -->
						<input type="submit" value="确定"/>
					</div>
                </div>
                <div class="his-main-c clearfix">
                	<div class="his-l fl">
                	<h3>作物数据采集</h3>
                    	<img src="images/s7.jpg" class="fl"/>
                        <div class="his-con">
                        	
                            <a class="see" href="javascript:void(0);" onclick = "selectCropData()">查看数据</a>
                        </div>
                    </div>
                    <div class="his-l his-r fl">
                    <h3>作物数据显示</h3>
                    	<img src="images/s8.jpg" class="fl"/>
                        <div class="his-con">
                        	
                        	 <p></p>
                        	 <p></p>
                            <a class="see" href="javascript:void(0);" onclick = "selectCropPicture()">查看数据</a>
                        </div>
                    </div>
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
					<p><i class="fa fa-fax"></i>传真：0538-8249612  </p>
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
	
	
	
	<script type="text/javascript">
	function selectCropData(){
		
		if(getCookie("byd")){
			delCookie("byd");
			setCookie("byd","1");
			
			}else{
			setCookie("byd","1");
				
			}
		window.location="${pageContext.request.contextPath}/region/detail/login?status=collectCrop";			
	}
	function selectCropPicture(){
		//
		if(getCookie("byd")){
			delCookie("byd");
			setCookie("byd","1");
			
			}else{
			setCookie("byd","1");
				
			}
		window.location="${pageContext.request.contextPath}/picture/requestPicture";	
	}
	$(function(){
		    $("#city").empty();
			$("#city").append("<option>请选择</option>");
			$("#region").empty();
			$("#region").append("<option>请选择</option>");
			$("#county").empty();
			$("#county").append("<option>请选择</option>");
			$("#plot").empty();
			$("#plot").append("<option>请选择</option>");
		    $("#city1").empty();
			$("#city1").append("<option>请选择</option>");
			$("#region1").empty();
			$("#region1").append("<option>请选择</option>");
			$("#county1").empty();
			$("#county1").append("<option>请选择</option>");
			$("#plot1").empty();
			$("#plot1").append("<option>请选择</option>");
			
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
	 					$("#county").empty();
	 					$("#county").append("<option>请选择</option>");
	 					$("#plot").empty();
	 					$("#plot").append("<option>请选择</option>");
							for(i=0;i<data.cities.length;i++){
							$("#city").append("<option value='"+data.cities[i].cityName+"'>"+data.cities[i].cityName+"</option>");
							$("#city1").append("<option value='"+data.cities[i].cityName+"'>"+data.cities[i].cityName+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
		if(getCookie("Ids")){
			delCookie("Ids");
			}
		
		if(getCookie("byd")){
			delCookie("byd");
			}
		
		if(getCookie("plotName")){
			delCookie("plotName");
			}
		
		
	});
	
	
	
	function selectCity(obj){
		var str;
		if(obj.id.substring(obj.id.length-1,obj.id.length)=="1"){
			 str="1";
		}
		else{
			 str="";
		}
		
	 					$("#region"+str).empty();
	 					$("#region"+str).append("<option>请选择</option>");
	 					$("#county"+str).empty();
	 					$("#county"+str).append("<option>请选择</option>");
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
		var cityName = obj.value;
		 $.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectRegion",
			type:"post",
			data:{cityName:cityName},
			dataType:"json",
			success:function(data){
	 				if (data.regions!=null) {
	 					$("#region"+str).empty();
	 					$("#region"+str).append("<option>请选择</option>");
	 					$("#county"+str).empty();
	 					$("#county"+str).append("<option>请选择</option>");
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
							for(i=0;i<data.regions.length;i++){
							$("#region"+str).append("<option value='"+data.regions[i].id+"'>"+data.regions[i].regionName+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
	function selectRegion(obj){
		var str;
		if(obj.id.substring(obj.id.length-1,obj.id.length)=="1"){
			 str="1";
		}
		else{
			 str="";
		}
		var regionId = obj.value;
	 					$("#county"+str).empty();
	 					$("#county"+str).append("<option>请选择</option>");
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
		 $.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectCounty",
			type:"post",
			data:{regionId:regionId},
			dataType:"json",
			success:function(data){
	 				if (data.countys!=null) {
	 					$("#county"+str).empty();
	 					$("#county"+str).append("<option>请选择</option>");
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
							for(i=0;i<data.countys.length;i++){
							$("#county"+str).append("<option value='"+data.countys[i].id+"'>"+data.countys[i].countyName+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
	function selectCounty(obj){
		var str;
		if(obj.id.substring(obj.id.length-1,obj.id.length)=="1"){
			 str="1";
		}
		else{
			 str="";
		}
		
		var countyName = obj.value;
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
		 $.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectPlot",
			type:"post",
			data:{countyId:countyName},
			dataType:"json",
			success:function(data){
	 				if (data.plots!=null) {
	 					$("#plot"+str).empty();
	 					$("#plot"+str).append("<option>请选择</option>");
							for(i=0;i<data.plots.length;i++){
							$("#plot"+str).append("<option value='"+data.plots[i].id+"'>"+data.plots[i].plotName+"</option>");
	 				}
			}},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
	
	function selectPlot(obj){
		$.ajax({
			url:"${pageContext.request.contextPath}/region/selectRegion/selectOnePlot",
			type:"post",
			data:{plotId:obj.value},
			dataType:"json",
			success:function(data){
	 				if (data.plots!=null) {
					 var ID=data.plots[0].plotId;
					 var Name=data.plots[0].plotName;
		var node = document.getElementById("tableSeparate");
		var nodeName = document.getElementById("tablePlot");
		node.value = ID;
		nodeName.value = Name;
	 				}
			},error:function(e){
				alert("数据加载失败！");
			}
		}); 
	}
	
	
	
	
	
	
	
	function soilSubmit(str){
		var tableSe = document.getElementById("tableSeparate").value;
		var value = document.getElementById("plot"+str).value;
		var textvalue = document.getElementById("tablePlot").value;
		if(textvalue=="沾化1号"){textvalue=1;}
		else{textvalue=2;}
		if(value=="请选择"){
			alert("请选择有效的区域！");
			return false;
		}else{
			if(getCookie("Ids")){
			delCookie("Ids");
			setCookie("Ids",value);
			
			}else{
			setCookie("Ids",value);
				
			}
			if(tableSe!=''){
				if(getCookie("byd")){
					delCookie("byd");
					setCookie("byd",tableSe);
					
					}else{
					setCookie("byd",tableSe);
						
					}
				
				window.location="${pageContext.request.contextPath}/region/detail/soilList2?plotId="+tableSe;	
			}
			else{
				if(getCookie("byd")){
					delCookie("byd");
					setCookie("byd",tableSe);
					
					}else{
					setCookie("byd",tableSe);
						
					}
				if(getCookie("plotName")){
					delCookie("plotName");
					setCookie("plotName",textvalue);
					}else{
					setCookie("plotName",textvalue);
						
					}
				window.location="${pageContext.request.contextPath}/region/detail/soilList?plotIdName="+textvalue;			
			}
			
		}
		
	}
	
	function weatherSubmit(str){
		var value = document.getElementById("plot"+str).value;
		var tableSe = document.getElementById("tableSeparate").value;
		if(value=="请选择"){
			alert("请选择有效的区域！");
			return false;
		}else{
			if(getCookie("Ids")){
			delCookie("Ids");
			setCookie("Ids",value);
			
			}else{
			setCookie("Ids",value);
				
			}
			if(!tableSe==''){
				if(getCookie("byd")){
					delCookie("byd");
					setCookie("byd",tableSe);
					
					}else{
					setCookie("byd",tableSe);
						
					}
				window.location="${pageContext.request.contextPath}/region/detail/weatherList2?plotId="+tableSe;	
			}
			else{
				if(getCookie("byd")){
					delCookie("byd");
					setCookie("byd",tableSe);
					
					}else{
					setCookie("byd",tableSe);
						
					}
				window.location="${pageContext.request.contextPath}/region/detail/weatherList";			
			}
			
		}
		
	}
	
	//读取cookie
	function getCookie(name) 
	{ 
		var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); 
	    if(arr=document.cookie.match(reg)) 
		return unescape(arr[2]); 
        else
		return null; 
	} 
	//删除cookie
	function delCookie(name) 
	{ 
		var exp = new Date(); 
	    exp.setTime(exp.getTime() - 1);
	    var cval=getCookie(name); 
	    if(cval!=null) 
	    	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
	    	} 
	//写cookies 
	function setCookie(name,value) 
	{ 
		var Days = 1; 
		var exp = new Date(); 
		exp.setTime(exp.getTime() + Days*24*60*60*1000);
		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	}
	
	
	

</script>
</body>
</html>