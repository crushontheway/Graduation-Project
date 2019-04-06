<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/page/head.jsp"%>
<body style="background-color:#c2b5a2;">
		<h1 align="center">订单提交</h1>
			<table align="center" border="1">
				<tr>
					<th>昵称</th>
					<th>联系方式</th>
					<th>住址</th>
				<tr>
				<tr>
					<td>${member.username}</td>
					<td>${member.tel }</td>
					<td>${member.address}</td>
				</tr>
			</table>
			<table align="center" border="1">
				<tr>
					<td colspan="2" width="169.5px">${s_id_shop[s_id].shopName}</td>
					<td colspan="2" width="169.5px">满${s_id_coupon[s_id].limitPrice}减${s_id_coupon[s_id].reducePrice}</td>
				</tr>
				<tr>
					<th>图片</th>
					<th>品名</th>
					<th>单价</th>
					<th>数量</th>
				</tr>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>&nbsp;&nbsp;<img src="/image/productSingle_small/${item.product.id}.jpg"></td>
						<td>${item.product.productname}</td>
						<td>${item.product.price}</td>
						<td>${item.itemnumber}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">总价为:${thisPrice}&nbsp;元</td>
				</tr>	
		</table>
		<div align="center">
			<form action="OrderList2">
				<input type="hidden" name="s_id" value="${s_id}">
				<textarea rows="10" cols="30" name="message">在此输入备注</textarea>
				<input type="submit" value="确定提交" >
			</form><a href="showCart2">取消订单</a>
		</div>	
</body>
<%@ include file="/page/foot.jsp" %>
</html>