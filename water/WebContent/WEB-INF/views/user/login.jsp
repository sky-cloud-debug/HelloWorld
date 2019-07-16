<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form id="loginForm">
  	<input type="text" name="model.username" placeholder="请输入用户名"/><br>
  	<input type="password" name="model.password" placeholder="请输入密码"/><br>
  	<input type="button" value="登录" id="loginBtn"/>
  </form>
  <%@include file="/WEB-INF/views/common/common_script.jspf" %>
  <script type="text/javascript">
		/*登录按钮绑定登录逻辑*/
		$("#loginBtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user/login",
				data:$("#loginForm").serialize(),
				type:"post",
				dataType:"text",
	 			success:function(data){
					if("success"==data){
						window.location.href="${pageContext.request.contextPath}/index.jsp";
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