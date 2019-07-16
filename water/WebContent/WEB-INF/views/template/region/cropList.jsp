<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

							<tr>
								<td>冠层温度</td>
								<td>生理生化指标</td>
								<td>品质</td>
								
								<td>创建时间</td>
							</tr>
							<c:forEach items="${page.content}" var="crop">
								<tr>
									<td>${crop.canopyTemperature}</td>
									<td>${crop.physiologicalAndBiochemicalIndexes}</td>
									<td>${crop.quality}</td>
									
									<td><fmt:formatDate value="${crop.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
								</tr>
							</c:forEach>
