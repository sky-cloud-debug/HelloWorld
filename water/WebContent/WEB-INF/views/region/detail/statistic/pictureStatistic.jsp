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
 			#img-box .img-item{float:left;width:30%;margin:1%;}
 			#img-box .img-item img{max-height:300px;border:1px solid #ccc;}
 			#img-box .img-item img:hover{box-shadow:0 0 10px #000;}
 			
 				.img-show{position:fixed;left:0;top:0;width:100%;height:100%;z-index:99;display:none;}
	.img-mask{width:100%;height:100%;background:#000;opacity:0.7;filter:alpha(opacity=70);}
	.img-list{position:absolute;}
	.img-list .img-item{background:#fff;padding:10px;}
	.img-list .img-item img{max-width:100%;max-height:100%;}
	.img-show .i-ear{position:absolute;font-size:60px;color:#fff;font-weight:bold;text-decoration:none;}
	.img-show .i-left{left:50px;}
	.img-show .i-right{right:50px;}
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
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i class="fa fa-angle-right"></i><a href="#">数据采集</a><i class="fa fa-angle-right"></i><span class="athere">田地图像展示</span>
				</div>
				<div class="content-view">
				    <p>   
				    <span class="c_title" style="margin-left: -20px">站点：</span>
					<select id="charType"style="padding-left: 5px;width:100px;"onchange="changeChartType(this)">
						<option value="zh0002" style="padding-left: 12px" >沾化1号</option>
						<option value="test001" style="padding-left: 12px">沾化2号</option>
					</select>
					<span class="c_title" >起始日期：</span>
					<input type="text" class="date-input" style="width:100px;" placeholder="" id="startTime"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
					<span class="c_title">结束日期：</span>
					<input type="text"  class="date-input"style="width:100px;"  placeholder="" id="endTime"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
					<button onclick="getPictureSubmit()" style="margin-top:20px;float:right;" class="btn" >查询</button>
					</p>
					<div id="list" style='min-height: 100px'>
					</div>
					<a id="showViewBtn" style="display:none;" href="javascript:void(0);" onclick="viewImg()">查看图片</a>
					<div id="img-box">
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>
     <div class="img-show">
		<div class="img-mask"></div>
		<a class="i-ear i-left" href="javascript:void(0);">&lt;</a>
		<ul class="img-list">
		</ul>
		<a class="i-ear i-right" href="javascript:void(0);">&gt;</a>
	</div>
<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
function getPictureSubmit()
{
var plotId=$("#charType").val();
var startTime=$("#startTime").val();
var endTime=$("#endTime").val();
var tempstartdate1=startTime.split("-");
startTime=tempstartdate1[0]+tempstartdate1[1]+tempstartdate1[2];

var tempenddate1=endTime.split("-");
endTime=tempenddate1[0]+tempenddate1[1]+tempenddate1[2];   
if(startTime>endTime){alert("请检查区间是否正确！");}
else{
$.ajax(
		{
			url:"${pageContext.request.contextPath}/picture/getPicture",
			type:"post",
		    data:{"beginDate":startTime,"endDate":endTime,"plotId":plotId},
		    dataType:"json",
		success:function(data){
			if(data!=null){
				$("#showViewBtn").show();
				var html="";
			for(var i=0;i<data.length;i++){
				html+="<a href='"+data[i]+"' target='_blank' class='img-item'><img src='"+data[i]+"'/></a>";
			
			}}else
				{var html="";html+="<p>此区间没有图片可以展示。</p>";
				
				}
			$("#img-box").html(html);
		},
		error:function(e){
			alert("图片加载失败！");
		}
	});
}
}

//改变图片和耳朵位置
function changeItemPosition(index){
	var $itemDoms=$(".img-show .img-list .img-item");
	var winWidth=$(window).width();
    var winHeight=$(window).height();
	var itemWidth=$itemDoms.eq(index).find("img").width();
	var itemHeight=$itemDoms.eq(index).find("img").height();
	var left=winWidth/2-itemWidth/2-20;
	var top=winHeight/2-itemHeight/2-20-10;
	$(".img-show .img-list").css({"left":left,"top":top});
	$(".img-show .i-ear").css({"top":top+itemHeight/2});
};

//初始化图片列表
function initImgList(){
	var html="";
	$("#img-box").find("img").each(function(){
		html+='<li class="img-item">'+
	   			'<img src="'+$(this).attr("src")+'" width="600px" height="480px"/>'+
				'</li>';
	});
	$(".img-show .img-list").html(html);
	//$(".i-ear").show();
	var size=$(".img-show .img-list .img-item").size();
	if(size==0){
		return;
	}
	if(size==1){
		//$(".i-ear").hide();
	}
	$(".img-show .img-list .img-item").eq(0).show().siblings().hide();
	setTimeout(function(){
		changeItemPosition(0);
	},1);
};
function viewImg(){
	initImgList();
    $(".img-show").show();
};
$(function(){
    	//dom元素
    	var winWidth=$(window).width();
	    var winHeight=$(window).height();
		$(".img-show").width(winWidth).height(winHeight);
		
		initImgList();

		var curIndex=0;
		$(".img-show .i-left").click(function(){
			//$(".i-ear").show();
			var itemSize=$(".img-show .img-list .img-item").size();
			curIndex=curIndex-1;
			if(curIndex-1<0){
				//$(".i-left").hide();
				curIndex=itemSize-1;
			}
			$(".img-show .img-list .img-item").eq(curIndex).show().siblings().hide();
			changeItemPosition(curIndex);
		});
		$(".img-show .i-right").click(function(){
			//$(".i-ear").show();
			var itemSize=$(".img-show .img-list .img-item").size();
			curIndex=curIndex+1;
			if(curIndex>itemSize-1){
				//$(".i-right").hide();
				curIndex=0;
				//curIndex=0;
			}
			$(".img-show .img-list .img-item").eq(curIndex).show().siblings().hide();
			changeItemPosition(curIndex);
		});
		$(".img-show .img-mask").click(function(){
			$(".img-show").hide();
		});
    });


</script>
</body>
</html>