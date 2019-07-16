<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common_taglib.jspf"%>
<c:set var="activeMenu" value="数据采集"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<link
	href="${pageContext.request.contextPath}/wangEditor/dist/css/wangEditor.min.css"
	rel="stylesheet" />
<!--[if lt IE 9]>
			<script 

src="${pageContext.request.contextPath}/js/respond.min.js"></script>
		<![endif]-->
<!--[if IE 7]>
			<link rel="stylesheet" 

href="${pageContext.request.contextPath}/css/font-awesome-ie7.min.css" />
			<link rel="stylesheet" 

href="${pageContext.request.contextPath}/css/ie7.css">
		<![endif]-->
<%@include file="/WEB-INF/views/common/common_css.jspf"%>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<!-- jQ -->
<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<!-- banner slider -->
<script src="${pageContext.request.contextPath}/js/base.js"></script>
<!-- callback -->
<style>
td {
	vertical-align: middle;
}

.img-show {
	position: fixed;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	z- index: 99;
	display: none;
}

.img-mask {
	width: 100%;
	height: 100%;
	background: #000;
	opacity: 0.7;
	filter: alpha (   opacity =   70 );
}

.img-list {
	position: absolute;
}

.img-list .img-item {
	background: #fff;
	padding: 10px;
}

.img-list .img-item img {
	max-width: 100%;
	max-height: 100%;
}

.img-show .i-ear {
	position: absolute;
	font-size: 60px;
	color: #fff;
	font-weight: bold;
	text- decoration: none;
}

.img-show .i-left {
	left: 50px;
}

.img-show .i-right {
	right: 50px;
}
.btn{
	background:green;
	color:#fff;
	cursor:pointer;
	font-size:14px;
}
.btn:hover{
  background:darkgreen;
}
.content-view .box h2{
  font-size:18px;
  line-hei
}
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
						class="fa fa-angle-right"></i><a href="#">新闻管理</a><i
						class="fa fa-angle-right"></i><span class="athere">发布新闻</span>
				</div>
				<div class="content-view">
					<div class="box clearfix">
						<h2>发布新闻</h2>
						<div class="news-item">
							<p>标题</p>
							<p>
								<input id="newsTitle" type="text" name="news.title" value="${news.title}"/>
							</p>
						</div>
						<div class="news-item">
							<p>作者</p>
							<p>
								<input id="newsAuthor" type="text" name="news.author" value="${news.author}"/>
							</p>
						</div>
						<div class="news-item">
							<p>来源</p>
							<p>
								<input id="newsSource" type="text" name="news.source" value="${news.source}"/>
							</p>
						</div>
						<div class="news-item">
							<p>封面图片</p>
							<p>
							    <button id="uploadImgBtn">上传图片</button>
								<input id="newsImgPath" type="hidden" value="${news.imgPath}"/>
								<c:if test="${!empty news.imgPath}">
									<img id="img" src="${pageContext.request.contextPath}/${news.imgPath}"/>
								</c:if>
							</p>
						</div>
						<div class="news-item">
							<p>所属分类</p>
							<select id="newsType">
								<option value="1" ${news.type==1?"selected":""}>平台资讯</option>
								<option value="2" ${news.type==2?"selected":""}>媒体报道</option>
							</select>
						</div>
						<div class="news-item">
							<p>内容</p>
							<script id="container" type="text/plain">${news.content}</script>
						</div>
						<div class="news-item">
							<p>
								<button class="btn" onclick="ajaxSaveNews()">发布</button>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="uploadImgForm" method="post" action="${pageContext.request.contextPath}/news/uploadImg" enctype="multipart/form-data">
		 <input type="file" name="img" id="uploadImgInput"/> 
	</form>
	<%@ include file="/WEB-INF/views/common/footer.jspf"%>
	<%@include file="/WEB-INF/views/common/common_script.jspf"%>
	<!-- 配置文件 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript">
	
		var ue = UE.getEditor('container');    
		function ajaxSaveNews() {
			var data = {
			    "news.id":"${newsId}",
				"news.title" : $("#newsTitle").val(),
				"news.content" : ue.getContent(),
				"news.author" : $("#newsAuthor").val(),
				"news.source" : $("#newsSource").val(),
				"news.imgPath" : $("#newsImgPath").val(),
				"news.type":$("#newsType").val()
			};
			var url="${pageContext.request.contextPath}/news/save";
			if("${newsId}"){
				url="${pageContext.request.contextPath}/news/update";
			}
			$.post(url, data,
					function(data) {
						if("success"==data){
							alert("发布成功！");
							window.location.href="${pageContext.request.contextPath}/news/newsList";
						}
					});
		}
		$("#uploadImgBtn").click(function(){
			$("#uploadImgInput").click();
		});
		$("#uploadImgInput").change(function(){
		
			$("#uploadImgForm").ajaxSubmit({
				success:function(data){
					$("#img").attr("src","${pageContext.request.contextPath}"+data);
					$("#newsImgPath").val(data);
				}
			});
		});
	</script>
</body>
</html>