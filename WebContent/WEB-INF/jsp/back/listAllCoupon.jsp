<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动展示</title>
</head>
<%@ include file="/page/head.jsp" %>
<body style="background-color:#c2b5a2;">
	
	<c:if test="${!empty coupon}">
		<h1 align="center">商家活动</h1>
		<table align="center" border="1">
			<tr>
				<th>限定金额</th>
				<th>减免金额</th>
				<th>操作</th>
			</tr>
			<tr>
				<td>${coupon.limitPrice }</td>
				<td>${coupon.reducePrice}</td>
				<td><a href="deleteCoupon?id=${coupon.id}" style="text-decoration: none;">删除</a> </td>
			</tr>
		</table>
	</c:if>
	<c:if test="${empty coupon}">
		<h3 align="center">暂无活动</h3>
	</c:if>
	
	
	
</body>
<%@ include file="/page/foot.jsp" %>
</html>