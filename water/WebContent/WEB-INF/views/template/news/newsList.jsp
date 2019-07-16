<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
							<tr>
								<td>标题</td>
								<td>创建时间</td>
								<td>作者</td>
								<td>来源</td>
								<td>图片</td>
								<td>所属分类</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${page.content}" var="item">
								<tr>
									<td>${item.title}</td>
									<td><fmt:formatDate value="${item.createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate></td>
									<td>${item.author}</td>
									<td>${item.source}</td>
									<td>
										<c:if test="${empty item.imgPath}">
											暂无图片
										</c:if>
										<c:if test="${!empty item.imgPath}">
											<img src="${pageContext.request.contextPath}/${item.imgPath}" width="50px" height="50px" />
										</c:if>
									</td>
									<td>${item.type==1?"平台资讯":"媒体报道"}</td>
									<td>
										<a href="javascript:void(0);" onclick="showNews(${item.id})">查看</a>
										<a href="${pageContext.request.contextPath}/news/editNews?newsId=${item.id}">修改</a>
										<a href="javascript:void(0);" onclick="deleteNews(${item.id},this)">删除</a>
									</td>
								</tr>
							</c:forEach>