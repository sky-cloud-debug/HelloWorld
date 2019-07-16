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
    <h1>修改区域信息</h1>
    <form id="regionForm">
    	ID:<input type="text" name="model.id" value="${model.id}"/><br>
    	省：<input type="text" name="model.province" value="${model.province}"/><br>
    	城市：<input type="text" name="model.city" value="${model.city}"/><br>
    	村镇：<input type="text" name="model.town" value="${model.town}"/><br>
    	创建时间：<input type="text" name="model.createTime" value="${model.createTime}"/><br>
    	经度：<input type="text" name="model.latitude" value="${model.latitude}"/><br>
    	纬度：<input type="text" name="model.longitude" value="${model.longitude}"/><br>
    	高程：<input type="text" name="model.altitude" value="${model.altitude}"/><br>
    	<input type="button" value="提交" id="saveBtn"/>
    </form>
<%@include file="/WEB-INF/views/common/common_script.jspf" %>
<script type="text/javascript">
$(function(){
/*点击提交按钮ajax修改密码*/
$("#saveBtn").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/region/edit",
		data:$("#regionForm").serialize(),
		type:"post",
		dataType:"text",
			success:function(data){
			if("success"==data){
				window.location.href="list";
			}
			},
			error:function(response){
				alert("加载失败");
			//$("body").html(response.responseText);
			}					
	});
	});
});

</script>
</body>
</html>