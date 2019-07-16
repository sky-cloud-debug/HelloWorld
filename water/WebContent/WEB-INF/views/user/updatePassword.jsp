<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form id="updatePasswordForm">
  	<input type="password" name="prevPassword" placeholder="请输入原密码"/><br>
  	<input type="password" name="newPassword" placeholder="请输入新密码"/><br>
  	<input type="password" name="confirmPassword" placeholder="再次输入新密码"/><br>
  	<input type="button" value="修改" id="confirmBtn"/>
  </form>
  
  <%@include file="/WEB-INF/views/common/common_script.jspf" %>
  <script type="text/javascript">
		/*点击提交按钮ajax修改密码*/
		$("#confirmBtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user/updatePassword",
				data:$("#updatePasswordForm").serialize(),
				type:"post",
				dataType:"text",
	 			success:function(data){
					alert(data);
					if("success"==data){
						window.location.href="${pageContext.request.contextPath}/user/logout";
					}
	 			},
	 			error:function(response){
					$("body").html(response.responseText);
	 			}					
			});
  		});
  	</script>
</body>
</html>