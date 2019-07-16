<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

							<tr>
								<td>ID</td>
							    <td>田地名字</td>
								<td>根系层土壤平均田间持水率</td>
								<td>生育初期土壤计划湿润层深度</td>
								<td>生育中期土壤计划湿润层深度</td>
								<td>生育后期土壤计划湿润层深度</td>
								<td>生育初期作物系数</td>
								<td>生育中期作物系数</td>
								<td>生育后期作物系数</td>
								<td>田间持水量 </td>
								<td>土壤类型</td>
								<td>土壤干容重</td>
								<td>创建时间</td>
								<td>操作</td>
							</tr>
							
							<c:forEach items="${page.content}" var="area">
								<tr>
									<td>${area.id}</td>
									<td>${area.areaName}</td>
									<td>${area.averageWaterCapacity }</td>
									<td>${area.firstStageDepthOfWetting }</td>
									<td>${area.secondStageDepthOfWetting }</td>
									<td>${area.thirdStageDepthOfWetting }</td>
									<td>${area.firstCropCoefficient }</td>
									<td>${area.secondCropCoefficient }</td>
									<td>${area.thirdCropCoefficient }</td>
									<td>${area.waterholdingCapacity }</td>
									<td>${area.soilType }</td>
									<td>${area.soilDryBulkDensity}</td>
									<td><fmt:formatDate value="${area.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
									<td><a href="${pageContext.request.contextPath}/region/detail/cropList?areaId=${area.id}">作物采集数据</a></td>
								</tr>
							</c:forEach>
