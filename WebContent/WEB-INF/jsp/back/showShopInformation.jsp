<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商店信息</title>
</head>
		<%@ include file="/page/head.jsp" %>
		<body>
			<div style="background-color: #c2b5a2">
			<h3 align="center">查看你商店的信息，若有需要，可以修改对应项</h3>
			<form:form action="updateShopInformation" modelAttribute="shop" method="POST">
				<table align="center">
					<tr>
						<td >用户名</td>
						<td><form:input path="username" placeholder="${shop.username}" readonly="true" /></td>
					</tr>	
						
					<tr>
						<td>登陆密码</td>
						<td><form:input path="password"  placeholder="${shop.password }" /></td>
					</tr>
					
					<tr>
						<td>商户名称</td>
						<td><form:input path="shopName"  placeholder="${shop.shopName }" /> </td>
					</tr>
					
					<tr>
						<td>联系方式</td>
						<td><form:input path="tel"  placeholder="${shop.tel}" /> </td>
					</tr>
					
					<tr>
						<td>商店地址</td>
						<td><form:input path="address" placeholder="${shop.address}"  /> </td>
					</tr>
							
					<tr>
						<td>
			    			<input type="reset"  value="清空"/>
			    		</td>
			    		<td>
			    			<input type="submit" value="修改"/>
			    		</td>
					</tr>				
			</table>
		</form:form>
		</div>
		
		</body>
		<%@ include file="/page/foot.jsp" %>
</html>