<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
		<%@ include file="/page/head.jsp" %>
		<body>
			<div style="background-color: #c2b5a2">
			<h3 align="center" style="margin-top: 0px;">查看你的信息，若有需要，可以修改对应项</h3>
			<form:form action="updateMemberInformation" modelAttribute="member" method="POST">
				<table align="center">
					<tr>
						<td >用户名</td>
						<td><form:input path="id" placeholder="${member.id}" readonly="true" /></td>
					</tr>	
						
					<tr>
						<td>登陆密码</td>
						<td><form:input path="password"  placeholder="${member.password }" /></td>
					</tr>
					
					<tr>
						<td>个人昵称</td>
						<td><form:input path="username"  placeholder="${member.username }" /> </td>
					</tr>
					
					<tr>
						<td>联系方式</td>
						<td><form:input path="tel"  placeholder="${member.tel}" /> </td>
					</tr>
					
					<tr>
						<td>收货地址</td>
						<td><form:input path="address" placeholder="${member.address}"  /> </td>
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