<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	a{
		text-decoration: none;
	}
	form{
		display: inline-block;
	}
</style>
</head>
		<body style="background-color:#c2b5a2;">
			<div align="center">
				<form action="searchProduct">
						<input type="text" name="keyWord" value="输入产品关键字">
						<input type="submit" value="点击搜索"> 
				</form>
			</div>
				
			<table>
					<tr>
						<td style="font-size: 25px;" colspan="4" align="center"><a href="listAllTypeItems/1" style="text-decoration: none;color: black;">鲜&nbsp;&nbsp;花&nbsp;&nbsp;类</a></td>
					</tr>
					<tr>
							<c:forEach items="${flowers}" var="flower" end="3" >
								<td><img src="/image/productSingle_middle/${flower.id}.jpg"><br/>
									<p>品名:${flower.productname}</p>
									<p>价格￥:${flower.price}</p>
									<a href="getThisProduct/${flower.id}">详情</a>&nbsp;&nbsp;
									<c:if test="${member!=null}">
										<form action="addToCartFromDetail" method="get">
											<input type="hidden" name="p_id" value="${flower.id}"/>
											<input type="hidden" name="itemnumber" value="1">
											<input type="submit" value="加入购物车">
										</form>
									</c:if>
								</td>
							</c:forEach>
					</tr>
					<tr>
						<td style="font-size: 25px;" colspan="4" align="center"><a href="listAllTypeItems/2" style="text-decoration: none;color: black;">绿&nbsp;&nbsp;植&nbsp;&nbsp;类</a></td>
					</tr>
					<tr>
							<c:forEach items="${greenplants}" var="greenplant" end="3" >
								<td><img src="/image/productSingle_middle/${greenplant.id}.jpg"><br/>
									<p>品名:${greenplant.productname}</p>
									<p>价格￥:${greenplant.price}</p>
									<a href="getThisProduct/${greenplant.id}">详情</a>&nbsp;&nbsp;
									<c:if test="${member!=null}">
										<form action="addToCartFromDetail" method="get">
											<input type="hidden" name="p_id" value="${greenplant.id}"/>
											<input type="hidden" name="itemnumber" value="1">
											<input type="submit" value="加入购物车">
										</form>
									</c:if>
								</td>
							</c:forEach>
					</tr>
					<tr>
						<td style="font-size: 25px;" colspan="4" align="center"><a href="listAllTypeItems/3" style="text-decoration: none;color: black;">多&nbsp;&nbsp;肉&nbsp;&nbsp;类</a></td>
					</tr>
					<tr>
							<c:forEach items="${succulents}" var="succulent" end="3" >
								<td><img src="/image/productSingle_middle/${succulent.id}.jpg"><br/>
									<p>品名:${succulent.productname}</p>
									<p>价格￥:${succulent.price}</p>
									<a href="getThisProduct/${succulent.id}">详情</a>&nbsp;&nbsp;
									<c:if test="${member!=null}">
										<form action="addToCartFromDetail" method="get">
											<input type="hidden" name="p_id" value="${succulent.id}"/>
											<input type="hidden" name="itemnumber" value="1">
											<input type="submit" value="加入购物车">
										</form>
									</c:if>
								</td>
							</c:forEach>
					</tr>
					<tr>
						<td style="font-size: 25px;" colspan="4" align="center"><a href="listAllTypeItems/4" style="text-decoration: none;color: black;">工&nbsp;&nbsp;具&nbsp;&nbsp;类</a></td>
					</tr>
					<tr>
							<c:forEach items="${tools}" var="tool" end="3" >
								<td><img src="/image/productSingle_middle/${tool.id}.jpg"><br/>
									<p>品名:${tool.productname}</p>
									<p>价格￥:${tool.price}</p>
									<a href="getThisProduct/${tool.id}">详情</a>&nbsp;&nbsp;
									<c:if test="${member!=null}">
										<form action="addToCartFromDetail" method="get">
											<input type="hidden" name="p_id" value="${tool.id}"/>
											<input type="hidden" name="itemnumber" value="1">
											<input type="submit" value="加入购物车">
										</form>
									</c:if>
								</td>
							</c:forEach>
					</tr>
					<tr>
						<td style="font-size: 25px;" colspan="4" align="center"><a href="listAllTypeItems/5" style="text-decoration: none;color: black;">肥&nbsp;&nbsp;料&nbsp;&nbsp;类</a></td>
					</tr>
					<tr>
							<c:forEach items="${fertilizers}" var="fertilizer" end="3" >
								<td style="margin:3px"><img src="/image/productSingle_middle/${fertilizer.id}.jpg"><br/>
									<p>品名:${fertilizer.productname}</p>
									<p>价格￥:${fertilizer.price}</p>
									<a href="getThisProduct/${fertilizer.id}">详情</a>&nbsp;&nbsp;
									<c:if test="${member!=null}">
										<form action="addToCartFromDetail" method="get">
											<input type="hidden" name="p_id" value="${fertilizer.id}"/>
											<input type="hidden" name="itemnumber" value="1">
											<input type="submit" value="加入购物车">
										</form>
									</c:if>
								</td>
							</c:forEach>
					</tr>
			</table>	
		</body>
</html>
