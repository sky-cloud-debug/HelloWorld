<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	.news{text-align:center;}
	.news .info{margin:0 auto;}
	.news .content{margin:0 auto;}
</style>
<div class="news">
		<h1 class="title">${news.title}</h1>
		<div class="content">${news.content}</div>
</div>