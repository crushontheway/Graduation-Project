<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
	<%@ include file="/page/head.jsp" %>
	<body style="background-color: #c2b5a2">
		<div align="center">
			<c:if test="${empty products}">
				<p>暂无商品</p>
			</c:if>
			<c:if test="${!empty products}">
				<table border="1">
				<tr>
					<th>图片</th>
					<th>品名</th>
					<th>价格</th>
					<th>库存</th>
					<th>种类</th>
					<th>推荐值</th>
					<th colspan="3">操作</th>
				</tr>
				<c:forEach items="${products}" var="p">
					<tr>
						<td><img src="/image/productSingle_small/${p_ids[p.productname]}.jpg">  </td>
						<td>${p.productname}</td>
						<td>${p.price}</td>
						<td>${p.stock}</td>
						<td>
							<c:if test="${p.c_id==1 }">鲜花</c:if>
							<c:if test="${p.c_id==2 }">绿植</c:if>
							<c:if test="${p.c_id==3 }">多肉</c:if>
							<c:if test="${p.c_id==4 }">种植工具</c:if>
							<c:if test="${p.c_id==5 }">肥料</c:if>
						</td>
							
						<td>
							<c:if test="${p.recommend==1 }">一般推荐</c:if>
							<c:if test="${p.recommend==2 }">强力推荐</c:if>
							<c:if test="${p.recommend==3 }">极力推荐</c:if>
						</td>
						<td><a href="updateProductPage/${p_ids[p.productname]}">修改</a></td>
						<td><a href="deleteProduct/${p_ids[p.productname]}">删除</a></td>
						<td><a href="addProductImagePage/${p_ids[p.productname]}">添加图片</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align:center">
		        <a href="?start=0">首  页</a>
		        <a href="?start=${page.start-page.count}">上一页</a>
		        <a href="?start=${page.start+page.count}">下一页</a>
		        <a href="?start=${page.last}">末  页</a>
   			 </div>
			</c:if>
		</div>
	</body>
	<%@ include file="/page/foot.jsp" %>
</html>