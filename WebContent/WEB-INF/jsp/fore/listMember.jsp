<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<%@ include file="/page/head.jsp" %>
	<br/><br/><hr/>
	<table>
		<tr>
			<th>用户名</th>
			<th>昵称</th>
			<th>密码</th>
			<th>电话</th>
			<th>地址</th>
		</tr>
	</table>
	<c:forEach var="member" items="${ms}">
		<tr>
			<th>${member.id}</th>
			<th>${member.username}</th>
			<th>${member.password}</th>
			<th>${member.tel}</th>
			<th>${member.address}</th>
		</tr>
	</c:forEach>
	<hr/><br/><br/>
	<%@ include file="/page/foot.jsp" %>
</body>
</html>