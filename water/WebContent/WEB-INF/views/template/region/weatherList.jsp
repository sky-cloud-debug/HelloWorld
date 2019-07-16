<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<tr>
		<td>空气温度（℃）</td>
		<td>空气湿度（%）</td>
		<td>CO2浓度（ppm）</td>
		<td>风向</td>
		<td>风速（m/s）</td>
		<td>降雨量（mm）</td>
		<td>光照（klx）</td>
		<td>创建时间</td>
	</tr>
	<c:forEach items="${page.content}" var="weather">
		<tr>
			<td>${weather.airTemp}</td>
			<td>${weather.airHumi}</td>
			<td>${weather.co2}</td>
			<td>${weather.windDir}</td>
			<td>${weather.windSpeed}</td>
			<td>${weather.rainHour*0.2}</td>
			<td>${weather.sunData}</td>
		  <td><fmt:formatDate value="${weather.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
		</tr>
	</c:forEach>
