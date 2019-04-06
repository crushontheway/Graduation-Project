<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${catename}</title>

<style>
	form{
		display: inline-block;
	}
</style>
</head>
<body>
	<h1 align="center">${shop.shopName }</h1>
	<table>
		<tr>
			<c:forEach items="${products}" var="product" end="3">
				<td><img src="/image/productSingle_middle/${product.id}.jpg"><br />
					<p>品名:${product.productname}</p>
					<p>价格￥:${product.price}</p>
					<a href="${pageContext.request.contextPath}/getThisProduct/${product.id}">详情</a>&nbsp;&nbsp; 
					<c:if test="${member!=null}">
						<form action="addToCartFromDetail" method="get">
							<input type="hidden" name="p_id" value="${product.id}"/>
							<input type="hidden" name="itemnumber" value="1">
							<input type="submit" value="加入购物车">
						</form>
					</c:if>
					</td>
			</c:forEach>
		</tr>
		<c:if test="${fn:length(products)>4}">
		<tr>
			<c:forEach items="${products}" var="product" begin="4">
				<td><img src="/image/productSingle_middle/${product.id}.jpg"><br />
					<p>品名:${product.productname}</p>
					<p>价格￥:${product.price}</p>
					 <a href="${pageContext.request.contextPath }/getThisProduct/${product.id}">详情</a>&nbsp;&nbsp;
					 <c:if test="${member!=null}">
						<form action="addToCartFromDetail" method="get">
							<input type="hidden" name="p_id" value="${product.id}"/>
							<input type="hidden" name="itemnumber" value="1">
							<input type="submit" value="加入购物车">
						</form>
					 </c:if>
				</td>
			</c:forEach>
		</tr>
		</c:if>
	</table>
</body>
</html>