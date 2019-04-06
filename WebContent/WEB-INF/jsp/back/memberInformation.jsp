<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	a{
		font-family: Microsoft YaHei;
		text-decoration: none;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>
</head>	
		<%@ include file="/page/head.jsp" %>
		<body style="background-color:#c2b5a2;">
			<hr/>
			<div align="center" style="width: 100%;height: 350px">
				<a href="showMemberInformation" style="font-size: 20px">查看/修改个人信息</a><br/><br/><br/>
				<a href="showCart2" style="font-size: 20px">查看购物车</a><br/><br/><br/>
				<a href="showUserOrderList" style="font-size: 20px">查看订单</a><br/><br/><br/>
				<a href="showUserHistoryOrderList" style="font-size: 20px">查看历史订单</a><br/><br/><br/>
				<a href="addComplainPage" style="font-size: 20px">投诉店家</a>
			</div>
			<hr/>
		</body>
		<%@ include file="/page/foot.jsp" %>
</html>