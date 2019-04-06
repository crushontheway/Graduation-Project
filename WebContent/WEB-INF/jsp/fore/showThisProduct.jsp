<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body style="background-color:#c2b5a2;">
	<h1 align="center">${shop.shopName}</h1>
	<div style="height: 450px;">
		<div style="float: left">
			<img alt="商品图片" src="/image/productSingle/${product.id}.jpg">
		</div>
		
		<div style="float: left;margin-left: 50px">
			<p style="font-size: 20px;margin: 0px">${product.productname}<p>
			<p style="font-size: 20px;">价格:<span style="font-size: 30px;color: red;">￥ ${product.price}</span> </p>
			<p style="font-size: 20px;">库存量:${product.stock}</p>
			<p style="font-size: 20px;">简介:<br/><span style="font-size: 15px;color: grey;">${product.summary}</span><p>
			<c:if test="${member!=null}"> 
				<form action="${pageContext.request.contextPath }/addToCartFromDetail" method="get">
					<input type="hidden" name="p_id" value="${product.id}"/>
					请输入购买数量:<input type="text" name="itemnumber"><br/>
					<input type="submit" value="加入购物车">
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>