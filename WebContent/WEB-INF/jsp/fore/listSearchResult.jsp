<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
		<p align="center" style="font-size: 25px;">查&nbsp;&nbsp;询&nbsp;&nbsp;结&nbsp;&nbsp;果</p>
		<table>
			<tr>
				<c:if test="${empty searchResult}">
					<td><p align="center">对不起，无相关商品</p></td>
				</c:if>
				<c:if test="${!empty searchResult}">
					<c:forEach items="${searchResult}" var="product">
						<td><img src="/image/productSingle_middle/${product.id}.jpg"><br/>
						<p>品名:${product.productname}</p>
						<p>价格￥:${product.price}</p>
						<a href="getThisProduct/${product.id}">详情</a>&nbsp;&nbsp;
						 <c:if test="${member!=null}">
							<form action="addToCartFromDetail" method="get">
								<input type="hidden" name="p_id" value="${product.id}"/>
								<input type="hidden" name="itemnumber" value="1">
								<input type="submit" value="加入购物车">
							</form>
						 </c:if>
						</td>
					</c:forEach>
				</c:if>
			</tr>
		</table>
					
</body>
</html>