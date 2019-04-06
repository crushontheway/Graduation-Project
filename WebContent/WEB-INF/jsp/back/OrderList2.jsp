<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/page/head.jsp" %>
<body style="background-color: #c2b5a2">
	<table border="1" align="center">
		<tr>
			<th>昵称</th>
			<th>联系方式</th>
			<th colspan="2">住址</th>
		</tr>
		<tr>
			<td>${member.username}</td>
			<td>${member.tel }</td>
			<td colspan="2">${member.address}</td>
		</tr>
		<tr>
					<td colspan="2" width="169.5px">${shopInf.shopName}</td>
					<td colspan="2" width="169.5px">满${coupon.limitPrice}减${coupon.reducePrice}</td>
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
					<th>创建时间</th>
					<th>支付时间</th>
					<th>发货时间</th>
					<th>确认时间</th>
				</tr>
				<tr>
					<td>${orderlist.createDate}</td>
					<td>${orderlist.payDate}</td>
					<td>${orderlist.deliveryDate}</td>
					<td>${orderlist.comfirmDate}</td>
				</tr>
				<tr>
					<td colspan="2">总价为:${thisPrice}&nbsp;元</td>
					<td>
						<c:if test="${orderlist.orderstatus==1}">
							未付款
						</c:if>
						<c:if test="${orderlist.orderstatus==2}">
							未发货
						</c:if>
						<c:if test="${orderlist.orderstatus==3}">
							已发货
						</c:if>
						<c:if test="${orderlist.orderstatus==4}">
							已确认
						</c:if>
					</td>
					<td>
						<c:choose>
						   <c:when test="${orderlist.orderstatus==1 }">
						   		<a href="payOrderList2?id=${orderlist.id}">确定支付</a>
						   </c:when>
						   <c:when test="${orderlist.orderstatus==4 }">
								<p>订单结束</p>
						   </c:when>
						   <c:otherwise>
						   		<a href="confirmOrderList2?id=${orderlist.id}">确定收货</a>
						   </c:otherwise> 
						</c:choose>
					</td>
				</tr>	
	</table>
	<p align="center">备注:${orderlist.message}</p>
</body>
<%@ include file="/page/foot.jsp" %>
</html>