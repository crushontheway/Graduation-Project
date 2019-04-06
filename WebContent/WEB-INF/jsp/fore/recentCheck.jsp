<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="10">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#c2b5a2;">
		<h2 align="center">最近浏览记录</h2>
		<p>${nophistory}</p>		
		<table>
			<c:forEach items="${phistory}" var="p">
				<tr>
					<td rowspan="2"><img src="/image/productSingle_small/${p.id}.jpg"></td>
					<td><p>品名:${p.productname}</p><td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/getThisProduct/${p.id}" target="getProductByType">详情</a></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>