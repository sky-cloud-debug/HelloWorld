<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>灌溉控制</title>
<style>
   #water-box{border:1px solid green;margin:50px auto;padding:20px;width:500px;}
   #water-box p{}
   #water-box p .i_text{padding:8px 10px;}
   #water-box p select{width:160px;}
   #water-box p .i_btn{padding:6px 18px;}
</style>

		<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script><!-- jQ -->
		<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script><!-- banner slider -->
		<script src="${pageContext.request.contextPath}/js/base.js"></script><!-- callback -->
</head>
<body>
   <div id="water-box">
	  <h1 style="font-size: 25px">灌水信息</h1>
	  <form  style="margin-top: 45px ;margin-left: 0px"  method="post">
	   <c:forEach items="${waterList}" var="water" >
	     <p>${water.outletNumber }号出水口，灌溉面积：${water.irrigationArea }亩，灌水量：${water.waterNum } m3&nbsp;</p>
	  </c:forEach></form>
	  <form id="autoWaterForm" method="post" onsubmit="return false;">
<p>	1号出水口：实际灌水量：  <input style="width: 40%"  placeholder="请输入灌溉量" name="waterNum1"

><span>m3</span></p>
<p>	2号出水口：实际灌水量：  <input style="width: 40%"  placeholder="请输入灌溉量" name="waterNum2"

><span>m3</span></p>
<p>	3号出水口：实际灌水量：  <input style="width: 40%"  placeholder="请输入灌溉量" name="waterNum3"

><span>m3</span></p>
<p>	4号出水口：实际灌水量：  <input style="width: 40%"  placeholder="请输入灌溉量" name="waterNum4"

><span>m3</span></p>

	  <p> <button onclick="autoWaterSubmit()"class="i_btn btn" id="ii"  style=" margin-top:20px;width: 100px ;height: 40px;">确定</button></p>
	  </form>
	  
  </div>
  	<script type="text/javascript">
	function autoWaterSubmit(){
		$.ajax({
			url:"${pageContext.request.contextPath}/water/wat",
			type:"POST",
			data:$("#autoWaterForm").serialize(),
			dataType:"text",
			success:function(data){
				if(data=="success"){
					alert("发送指令成功");
					window.location="${pageContext.request.contextPath}/record/waterRecord?regionId=1";
				}
				else{
					alert("发送指令失败");
				}
			},
			error:function(e){
				alert("对不起，不能显示灌溉需水量信息，可能原因是您新增或原来的田地信息不全，不能进行灌水量计算！请填写完整田地的信息。");
			}
		});
	}
  </script>
</body>
</html>