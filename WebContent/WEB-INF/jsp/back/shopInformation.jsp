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
<title>商店主页</title>
</head>	
		<%@ include file="/page/head.jsp" %>
		<body style="background-color:#c2b5a2;">
			<hr/>
			<div align="center" style="width: 100%;height: 400px">
				<a href="showShopInformation" style="font-size: 20px">查看/修改商店信息</a><br/><br/><br/>
				<a href="addProductPage" style="font-size: 20px">添加货物</a><br/><br/><br/>
				<a href="listProduct" style="font-size: 20px">查看货物</a><br/><br/><br/>
				<a href="addCouponPage" style="font-size: 20px">添加活动</a><br/><br/><br/>
				<a href="listAllCoupon" style="font-size: 20px">查看活动</a><br/><br/><br/>
				<a href="showShopOrderList" style="font-size: 20px">查看订单</a>
			</div>
			<hr/>
		</body>
		<%@ include file="/page/foot.jsp" %>
</html>