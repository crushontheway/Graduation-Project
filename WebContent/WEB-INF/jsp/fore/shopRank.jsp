<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body style="background-color:#c2b5a2;">
	<p>商&nbsp;&nbsp;家&nbsp;&nbsp;评&nbsp;&nbsp;级</p>
	<c:forEach items="${rankShops}" var="shop">
		<a href="showProductByShop?id=${shop.id}" target="getProductByType" style="font-size: 20px ;text-decoration: none;">${shop.shopName}</a>
		<br/><br/><br/>
	</c:forEach>
</body>


</html>