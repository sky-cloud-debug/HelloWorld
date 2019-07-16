<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf"%>
<c:set var="activeMenu" value="数据采集"></c:set>
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
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/favicon.ico" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/flexslider.css"
	rel="stylesheet" />
<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
		<![endif]-->
<!--[if IE 7]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css">
		<![endif]-->
<%@include file="/WEB-INF/views/common/common_css.jspf"%>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<!-- jQ -->
<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<!-- banner slider -->
<script src="${pageContext.request.contextPath}/js/base.js"></script>
<!-- callback -->
<style>
	td{vertical-align: middle;}
	.img-show{position:fixed;left:0;top:0;width:100%;height:100%;z-index:99;display:none;}
	.img-mask{width:100%;height:100%;background:#000;opacity:0.7;filter:alpha(opacity=70);}
	.img-list{position:absolute;}
	.img-list .img-item{background:#fff;padding:10px;}
	.img-list .img-item img{max-width:100%;max-height:100%;}
	.img-show .i-ear{position:absolute;font-size:60px;color:#fff;font-weight:bold;text-decoration:none;}
	.img-show .i-left{left:50px;}
	.img-show .i-right{right:50px;}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jspf"%>

	<!-- main -->
	<div class="single-content">
		<div class="single clearfix">
			<div class="sidebar fl">
				<%@include file="/WEB-INF/views/common/menu.jspf"%>
			</div>
			<div class="content fl">
				<div class="position">
					<a href="${pageContext.request.contextPath}/index.jsp">首页</a><i
						class="fa fa-angle-right"></i><a href="#">数据采集</a><i
						class="fa fa-angle-right"></i><span class="athere">作物数据采集信息</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h2 style="font-size: 25px">新闻列表</h2>
						<p><a href="javascript:void(0);" onclick="viewImg();" style="line-height:40px;float:right;">查看图片</a></p>
						<table id="newsTable" style="margin-top: 45px">
							<tr>
								<td>标题</td>
								<td>创建时间</td>
								<td>作者</td>
								<td>来源</td>
								<td>图片</td>
								<td>所属分类</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${page.content}" var="item" varStatus="status">
								<tr>
									<td>${item.title}</td>
									<td><fmt:formatDate value="${item.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
									<td>${item.author}</td>
									<td>${item.source}</td>
									<td>
										<c:if test="${empty item.imgPath}">
											暂无图片
										</c:if>
										<c:if test="${!empty item.imgPath}">
											<img src="${pageContext.request.contextPath}/${item.imgPath}" width="50px" height="50px"/>
										</c:if>
									</td>
									<td>${item.type==1?"平台资讯":"媒体报道"}</td>
									<td>
										<a href="javascript:void(0);" onclick="showNews(${item.id})">查看</a>
										<a href="${pageContext.request.contextPath}/news/editNews?newsId=${item.id}">修改</a>
										<a href="javascript:void(0);" onclick="deleteNews(${item.id},this)">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<div id="newsPage"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jspf"%>
	<style>
		#newsContainer{position:fixed;left:0;top:0;width:100%;height:100%;z-index:99;display:none;}
		#newsContainer .news-mask{width:100%;height:100%;background:#000;opacity:0.7;filter:alpha(opacity=70);}
		#newsContainer .news-content{position:absolute;width:600px;height:550px;top:30px;left:350px;background:#fff;overflow:auto;}
	</style>
	<div id="newsContainer">
		<div class="news-mask"></div>
		<div class="news-content"></div>
	</div>	
     <div class="img-show">
		<div class="img-mask"></div>
		<a class="i-ear i-left" href="javascript:void(0);">&lt;</a>
		<ul class="img-list">
		</ul>
		<a class="i-ear i-right" href="javascript:void(0);">&gt;</a>
	</div>
	<%@include file="/WEB-INF/views/common/common_script.jspf"%>
	<script type="text/javascript">
function loadData(pageNo,pageSize){
	$.ajax({
		url:"${pageContext.request.contextPath}/news/ajaxNewsList",
		type:"post",
		data:{"page.pageNo":pageNo,"page.pageSize":pageSize},
		dataType:"text",
		success:function(data){
			$("#newsTable").html(data);
			initImgList();
		},
		error:function(e){
			alert("数据加载失败！");
		}
	});
};

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
	$("#newsTable").find("img").each(function(){
		html+='<li class="img-item">'+
	   			'<img src="'+$(this).attr("src")+'"/>'+
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
function showNews(id){
	$.ajax({
		url:"${pageContext.request.contextPath}/news/show?newsId="+id,
		type:"post",
		dataType:"text",
		success:function(data){
			$("#newsContainer").show();
			$("#newsContainer .news-content").html(data);
		},
		error:function(e){
			alert("数据加载失败！");
		}
	});
}

function deleteNews(id,obj){
	if(confirm("确认删除该新闻吗？")){
		$.ajax({
			url:"${pageContext.request.contextPath}/news/delete?news.id="+id,
			type:"post",
			dataType:"text",
			success:function(data){
				alert("删除成功！");
				$(obj).parents("tr").fadeOut();
			},
			error:function(e){
				alert("删除失败！");
			}
		});
	}
}
var curIndex=0;
$(function(){
	new GuangPage().init("${page.totalItems}",{$dom:$("#newsPage"),callback:function(pageNo,pageSize){
		loadData(pageNo+1,pageSize);
	}});
    	//dom元素
    	var winWidth=$(window).width();
	    var winHeight=$(window).height();
		$(".img-show").width(winWidth).height(winHeight);
		
		initImgList();


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
			if(curIndex+1>itemSize){
				//$(".i-right").hide();
				curIndex=0;
			}
			$(".img-show .img-list .img-item").eq(curIndex).show().siblings().hide();
			changeItemPosition(curIndex);
		});
		$(".img-show .img-mask").click(function(){
			$(".img-show").hide();
		});
		$("#newsContainer .news-mask").click(function(){
			$("#newsContainer").hide();
		});
    });
</script>
</body>
</html>