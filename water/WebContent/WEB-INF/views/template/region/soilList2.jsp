<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<tr>
   
	<td>土壤温度（℃）</td>
	<td>土壤湿度（%）</td>
	<td>酸碱度</td>
	<td>电导率（mS/cm）</td>
	<td>创建时间</td>
</tr>
<c:forEach items="${page.content}" var="soil">
	<tr>
		
		<td>${soil.soilTemp}</td>
		<td>${(soil.soilHumi+soil.soilHumi2+soil.soilHumi3)/3.0}</td>
		<td>${soil.ph}</td>
		<td>${soil.elect}</td>
	    <td><fmt:formatDate value="${soil.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
	</tr>
</c:forEach>
