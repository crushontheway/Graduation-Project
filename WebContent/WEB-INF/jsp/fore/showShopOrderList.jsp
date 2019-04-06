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
<body style="background-color:#c2b5a2;">
	<c:forEach items="${members}" var="member">
		<table border="1" align="center">
			<tr>
				<th>昵称</th>
				<th>联系方式</th>
				<th colspan="2">住址</th>
			</tr>
			
			<tr>
				<td>${member.value.username}</td>
				<td>${member.value.tel }</td>
				<td colspan="2">${member.value.address}</td>
			</tr>
		</table>
		
		
			<table border="1" align="center">
				<tr>
					<th>图片</th>
					<th>品名</th>
					<th>单价</th>
					<th>数量</th>
				</tr>
				<c:forEach items="${order_items[member.key]}" var="item">
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
					<td>${orderLists[member.key].createDate}</td>
					<td>${orderLists[member.key].payDate}</td>
					<td>${orderLists[member.key].deliveryDate}</td>
					<td>${orderLists[member.key].comfirmDate}</td>
				</tr>
				<tr>
					<td colspan="2">总价为:${orderPrice[member.key]}&nbsp;元</td>
					<td>
						<c:if test="${orderLists[member.key].orderstatus==1}">
							未付款
						</c:if>
						<c:if test="${orderLists[member.key].orderstatus==2}">
							已付款
						</c:if>
						<c:if test="${orderLists[member.key].orderstatus==3}">
							已发货
						</c:if>
						<c:if test="${orderLists[member.key].orderstatus==4}">
							已确认
						</c:if>
					</td>
					<td>
						<c:choose>
						   <c:when test="${orderLists[member.key].orderstatus==2 }">
						   		<a href="deliveryOrder?id=${orderLists[member.key].id}">确定发货</a>
						   </c:when>
						   <c:when test="${orderLists[member.key].orderstatus==1 }">
						   		<p>等待付款</p>
						   </c:when>
						   <c:when test="${orderLists[member.key].orderstatus==3 }">
						   		<p>等待收货</p>
						   </c:when>
						   <c:otherwise>
						   		<p>订单结束</p>
						   </c:otherwise> 
						</c:choose>
					</td>
				</tr>	
			</table>
			<p align="center">备注:${orderLists[member.key].message}</p>
		</c:forEach>
</body>
<%@ include file="/page/foot.jsp" %>
</html>