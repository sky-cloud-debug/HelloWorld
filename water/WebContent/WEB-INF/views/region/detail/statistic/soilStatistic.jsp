<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf" %>
<c:set  var="activeMenu" value="挖掘分析"></c:set>

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
		<style>
			.c_title{font-size:16px;font-weight:600;}
			select{width:120px;}
			.btn{background:#81a44a;border-radius:2px;box-shadow:1px 1px 3px #ccc;padding:6px 10px;font-size:14px;font-family:"微软雅黑";color:#fff;}
 	.btn:hover{cursor:pointer;background:darkgreen;color:#fff;}
		</style>
<%@include file="/WEB-INF/views/common/common_css.jspf" %>
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="${pageContext.request.contextPath}/system.jsp">数据挖掘</a><i class="fa fa-angle-right"></i><span class="athere">土壤数据分析</span>
				</div>
				<div class="content-view">
				    <p>   
				    <span class="c_title" style="margin-left: -20px">图形：&nbsp;&nbsp;&nbsp;</span>
					<select id="charType"style="padding-left: 5px;width:100px;"onchange="changeChartType(this)">
						<option value="column" style="padding-left: 12px" >柱形图</option>
						<option value="line" style="padding-left: 12px">折线图</option>
         				<option value="spline" style="padding-left: 12px">曲线图</option>
						<option value="area" style="padding-left: 12px">面积图</option>
						<option value="areaspline" style="padding-left: 12px">曲线面积图</option>
						<option value="bar" style="padding-left: 12px">条形图</option>
						<option value="scatter" style="padding-left: 12px">散点图</option>
						<option value="waterfall" style="padding-left: 12px">瀑布图 </option>
					</select>
					<span class="c_title" >&nbsp;单位：&nbsp;&nbsp;&nbsp;</span>
					<select id="charTime"style="width:100px;">
					     <option value="true"  style="padding-left: 5px;">天</option>
					     <option value="false"  style="padding-left: 5px;">小时</option>
					</select>
					<br/>
					<span class="c_title" >起始日期：</span>
					<input type="text" class="date-input" style="width:100px;" placeholder="" id="startTime"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
					<span class="c_title">结束日期：</span>
					<input type="text"  class="date-input"style="width:100px;"  placeholder="" id="endTime"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
					<button onclick="changeChartType(this)" style="margin-top:20px;float:right;" class="btn" >查询</button>
					</p>
					<div id="highcharts_container"  style="margin-top: 30px">
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>

<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
function initChart(charType,timeType,startTime,endTime){
	
	$.ajax({
		url:"${pageContext.request.contextPath}/region/detail/soilStatisticData",
		data:{plotIdName:getCookie("plotName"),isDay:timeType,startTimeStr:startTime,endTimeStr:endTime},
		type:"post",
		dataType:"json",
		success:function(json){
			initCharts(json);
		},error:function(e){
		alert("数据加载失败");
		}
	});
	
	function getDate(str){
		var arr=str.split('T');
		return arr[0]+"日  "+arr[1].substring(0,2)+"时";		
	}
	
	function initCharts(json){
		var tempArr=[];
		var humiArr=[];
		var dateArr=[];
		for(var i=0;i<json.length;i++){
			tempArr.push(parseFloat(json[i].soilTemp));
			humiArr.push(parseFloat(json[i].soilHumi));
			dateArr.push(getDate(json[i].createTime));
		}
		$("#highcharts_container").highcharts({ //图表展示容器，与div的id保持一致
			chart: {
				type:charType      //图表类型
			},
			title: {
				text:"土壤数据统计图表"      //图表标题
			},
			xAxis: {
				categories:dateArr  //x轴名字
			},
			yAxis: {
				title: {
					text:"数值"             //y轴名字
				}
			},
			series:[{"name":"土壤温度",data:humiArr,tooltip: {
                valueSuffix: ' °C'
            }},{"name":"土壤湿度",data:tempArr,tooltip: {
                valueSuffix: ' %'
            }}],//统计项的数据
			credits:{
				enabled:true,
				text:"农田水肥一体化智慧化大数据系统平台",
				href:"${pageContext.request.contextPath}"
			},
			exporting:{
				enabled:true
			}
		});
	}
	}

function changeChartType(obj){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	if(!startTime||!startTime.match(/[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}/)){
		alert("请选择起始日期！");
	}
	if(!endTime||!endTime.match(/[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}/)){
		alert("请选择结束日期！");
	}
	
	if(startTime>endTime){alert("请检查区间是否正确！");}else{
	initChart($("#charType").val(),$("#charTime").val(),startTime,endTime);
};}
$(function(){


	new GuangPage().init("${areaPage.totalItems}",{$dom:$("#areaPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize,"area");
	}});
	
	/*
			data:{regionId:1},
		type:"post",
		xName:"createTime",
		nameMap:{'createTime':'土壤温度', 'soilHumi':'土壤湿度'},
		chartContainer:"#highcharts_container",
		chartParams:{
			chartTitle:"土壤数据统计图表",
			yName:"数值"
		}

	*/
});
</script>
</body>
</html>