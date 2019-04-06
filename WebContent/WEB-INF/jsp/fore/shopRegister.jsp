<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		padding: 8px;
	}
</style>
<script language="javascript">  
function myReload() {  
	document.getElementById("CreateCheckCode").src = document  
            .getElementById("CreateCheckCode").src  
            + "?nocache=" + new Date().getTime();
}  
</script>  
</head>
<body>

	<%@ include file="/page/head.jsp" %>
	<div style="background-color:#c2b5a2;">
		<br/><br/><hr/>
	<form:form method="POST" action="foreRegister" modelAttribute="registerFormBean">
	<h1 align="center">商户注册页面</h1>
	<table align="center">
		<tr>
			<td >用户名</td>
			<td><form:input path="username" placeholder="设置用户名" /></td>
			<td>${RegisterFormBean.errors.username}</td>
		</tr>		
		<tr>
			<td>登陆密码</td>
			<td><form:password path="password"  placeholder="设置你的登陆密码" /></td>
			<td> ${RegisterFormBean.errors.password}</td>
		</tr>
		
		<tr>
			<td>密码确认</td>
			<td><form:password path="repeatpassword"  placeholder="请再次输入你的密码" /> </td>
			<td>${RegisterFormBean.errors.repeatpassword}</td>
		</tr>
		
		<tr>
			<td>商店名称</td>
			<td><form:input path="shopName"  placeholder="输入你的商店名称" /> </td>
			<td>${RegisterFormBean.errors.shopName}</td>
		</tr>
		
		<tr>
			<td>联系方式</td>
			<td><form:input path="tel"  placeholder="输入你的联系方式" /> </td>
			<td>${RegisterFormBean.errors.tel}</td>
		</tr>
		
		<tr>
			<td>商店地址</td>
			<td><form:input path="address" placeholder="输入你的商店地址" /> </td>
			<td>${RegisterFormBean.errors.address}</td>
		</tr>
		
		<tr>
			<td>验证码</td>
			<td><form:input path="checkCode" placeholder="输入验证码" />   <img src="${pageContext.request.contextPath}/makeCheckCode.jpg" id="CreateCheckCode"  onclick="myReload()" style="display: inline-block;vertical-align:middle;"/> </td>
			<td>${RegisterFormBean.errors.checkCode}</td>
		</tr>
		
				
		<tr>
			<td>
    			<input type="reset"  value="清空"/>
    		</td>
    		<td/>
    		<td>
    			<input type="submit" value="注册"/>
    		</td>
		</tr>				
	</table>
</form:form>
	<hr/><br/><br/>
	</div>
	
	<%@ include file="/page/foot.jsp" %>

</body>
</html>
