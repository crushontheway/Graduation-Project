<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/page/head.jsp" %>
	<body style="background-color:#c2b5a2;">
			<table	align="center" border="1">
				<tr>
					<th>昵称</th>
					<th>地址</th>
					<th>联系方式</th>
				</tr>
				<tr>
					<th>李明</th>
					<th>阿尔丁大街内蒙古科技大学</th>
					<th>15043961234</th>
				</tr>
			</table>
			<table align="center" border="1">
				<tr>
					<td colspan="3">花语花店</td>
					<td colspan="2">满100减20</td>
				</tr>
				<tr>
					<th>图片</th>
					<th>品名</th>
					<th>单价</th>
					<th>数量</th>
				</tr>
					<tr>
						<td>&nbsp;&nbsp;<img src="/image/productSingle_small/14.jpg"></td>
						<td>蓝莲姬</td>
						<td>15</td>
						<td>5</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;<img src="/image/productSingle_small/12.jpg"></td>
						<td>芦荟</td>
						<td>15</td>
						<td>1</td>
					</tr>
				<tr>
					<td colspan="2">总价为:90元</td>
					<td colspan="1">已发货</td>
					<td><a href="#">确认收货</a> </td>
				</tr>	
		</table>
		<p align="center">备注信息：请在明天中午2点到5点之间送达<p>
	</body>
	<%@ include file="/page/foot.jsp" %>
</html>