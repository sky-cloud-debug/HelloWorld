<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/common/common_css.jspf" %>
</head>
<body>
    <h1>区域列表</h1>
    <p><a href="${pageContext.request.contextPath}/region/addui">新增区域</a></p>
	<table border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>省</th>
				<th>城市</th>
				<th>村镇</th>
				<th>创建时间</th>
				<th>经度</th>
				<th>纬度</th>
				<th>高程</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="regionList">
		</tbody>
	</table>
	<p id="regionListTip">
		<a href="javascript:void(0);" onclick="loadDataByPage()">加载更多</a>
	</p>
<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
//ajax加载区域数据
var isMoreData=true;
function ajaxLoadRegionData(pageNo,pageSize){
	$.ajax({
		url:"${pageContext.request.contextPath}/region/listByPage",
		data:{"page.pageNo":pageNo,"page.pageSize":pageSize},
		dataType:"json",
		success:function(data){
			var regionArr=data.page.content;
			var regionListHtml="";
			if(regionArr.length==0){
				$("#regionListTip").html("没有更多了...");
				isMoreData=false;
				return;
			}
			for(var i=0;i<regionArr.length;i++){
				regionListHtml+='		<tr>'
				+'	<th>'+regionArr[i].id+'</th>'
				+'	<th>'+regionArr[i].province+'</th>'
				+'	<th>'+regionArr[i].city+'</th>'
				+'	<th>'+regionArr[i].town+'</th>'
				+'	<th>'+regionArr[i].createTime+'</th>'
				+'	<th>'+regionArr[i].latitude+'</th>'
				+'	<th>'+regionArr[i].longitude+'</th>'
				+'	<th>'+regionArr[i].altitude+'</th>'
				+'	<th><a href="${pageContext.request.contextPath}/region/editui?id='+regionArr[i].id+'">修改</a><a href="${pageContext.request.contextPath}/region/detail/all?regionId='+regionArr[i].id+'">查看采集数据</a></th>'
				+'</tr>';
			}
			$("#regionList").append(regionListHtml);
		},
		error:function(){
			alert("出错了");
		}
	});
}
var pageNo=1;
function loadDataByPage(){
	if(isMoreData){
		ajaxLoadRegionData(pageNo,10);
		pageNo++;
	}
}
$(function(){
	loadDataByPage();	
});
</script>
</body>
</html>