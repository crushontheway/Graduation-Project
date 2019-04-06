<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateCart(input,id,oldvalue){
		var itemnumber = input.value;
		var b = window.confirm("请确认改为：" + itemnumber);
		if(b){
			window.location.href="UpdateCart1?id="+id + "&itemnumber=" + itemnumber;
		}else{
			input.value=oldvalue;  //发现用户取消的话，把input输入值改为原始值
		}
	}
</script>
</head>
<body style="background-color: #c2b5a2">
	<c:if test="${!empty s_id_shop}">
		<h1 align="center">购物车页面</h1>
		<table align="center" border="1">
			<c:forEach items="${s_id_shop}" var="sitem" >
				<tr>
					<td colspan="3">${sitem.value.shopName}</td>
					<td colspan="2">满${s_id_coupon[sitem.key].limitPrice}减${s_id_coupon[sitem.key].reducePrice}</td>
				</tr>
				<tr>
					<th>图片</th>
					<th>品名</th>
					<th>单价</th>
					<th>数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${shop_items[sitem.key]}" var="item">
					<tr>
						<td>&nbsp;&nbsp;<img src="/image/productSingle_small/${item.product.id}.jpg"></td>
						<td>${item.product.productname}</td>
						<td>${item.product.price }</td>
						<td><input type="text" name="itemnumber" value="${item.itemnumber}" style="width: 30px" onchange="updateCart(this,${item.id },${item.itemnumber})"></td>
						<td>&nbsp;&nbsp;<a href="deleteItem1/${item.id}" style="text-decoration:none;">删除</a> </td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2"><a href="addOrderPage1?s_id=${sitem.key}" style="text-decoration: none;">提交</a></td>
					<td colspan="3">总价为:${sumPrice_si_id[sitem.key]}&nbsp;元</td>
				</tr>	
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${empty s_id_shop}">
		<p align="center">暂无数据</p>
	</c:if>	
</body>
</html>