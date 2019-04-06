<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加活动</title>
</head>
<%@ include file="/page/head.jsp" %>
		<body style="background-color:#c2b5a2;">
			<h3 align="center">添加活动</h3>
			<form:form method="POST" action="addCoupon" modelAttribute="coupon">
				<input type="hidden" name="s_id" value="${s_id}">
				<table align="center">
					<tr>
						<td>限制价格</td>
						<td><form:input path="limitPrice" placeholder="输入限制价格"/></td>
					</tr>	
						
					<tr>
						<td>减免价格</td>
						<td><form:input path="reducePrice"  placeholder="输入减免价格" /> </td>
					</tr>
							
					<tr>
						<td>
			    			<input type="reset"  value="清空"/>
			    		</td>
			    		<td>
			    			<input type="submit" value="添加"/>
			    		</td>
					</tr>				
			</table>
			</form:form>
		</body>
	<%@ include file="/page/foot.jsp" %>
</html>