<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="3;url=/linglanflowershop/index.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
	<%@ include file="/page/head.jsp" %>
	<div align="center" style="background-color:#c2b5a2;">
		<h3>恭喜：<span style="color: red">${RegisterFormBean.shopName}${memberRegisterFormBean.username}</span>注册成功 </h3><br/><br/>
		<p>本页面将在3秒钟之后跳转到首页，如果没有跳转，<a href="/linglanflowershop/index.jsp">点击此处</a></p>
	</div>
	<%@ include file="/page/foot.jsp" %>
</body>
</html>