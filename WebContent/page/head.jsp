<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    	function doShopLogout(){
    		window.location.href="${pageContext.request.contextPath}/shopLogout";
    	}
    	
    	function doLogout(){
    		window.location.href="${pageContext.request.contextPath}/memberLogout";
    	}
 </script>
 <style>
 	a{
 		 text-decoration: none;
 	}
 </style>
</head>
<body>
	<div style="background: url(/linglanflowershop/image/headback.jpg) no-repeat;background-size:100%; background-attachment:fixed;height: 220px;">
		<div style="font-family: Microsoft YaHei;font-size:12px;color:gray;">
			<img src="/linglanflowershop/image/email.png" style="display: inline-block;vertical-align: middle;"><span style="display: inline-block;vertical-align: middle;">&nbsp;站长信箱:15044703720@163.com&nbsp;&nbsp;&nbsp;</span>
			<img src="/linglanflowershop/image/phone.png" style="display: inline-block;vertical-align: middle;"><span style="display: inline-block;vertical-align: middle;">150-4470-3720</span>
		</div>
		<br/><br/>
		<p align="left" style="font-size: 50px;font-family: Microsoft YaHei;margin: 10px;color: white;">铃兰网上花店</p><br/>
		<br/>
		&nbsp;<c:if test="${member==null and shop==null}">
		   	<a href="memberRegisterPage">用户注册</a>
		   	<a href="memberLoginPage">用户登陆</a>
	  	</c:if>
	   
	    <c:if test="${member!=null}">
	   		欢迎您：${member.username }
	   		<a href="memberInformation">进入个人主页</a>
	   		<input type="button" value="退出登陆" onclick="doLogout()">
	    </c:if>
	   
	    <c:if test="${shop==null and member==null}">
	   		<a href="shopRegisterPage">我要开店</a>
	   		<a href="shopLoginPage">卖家登录</a>
	    </c:if>
	   
	    <c:if test="${shop!=null}">
	   		欢迎您：${shop.shopName }
	   		<a href="shopInformation">进入店铺</a>
	   		<input type="button" value="退出登陆" onclick="doShopLogout()">
	    </c:if>
	<br/>
	</div>
</body>
</html>