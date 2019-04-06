<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<%@ include file="/page/head.jsp" %>

		<div align="center" style="background-color:#c2b5a2;width: 100%;height: 300px">
		<br/><br/><br/><br/>
			<form action="memberforelogin" method="post">
				<table>
					<tr>
						<td>用户名</td>
						<td><input type="text" name="id"/></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td><input type="reset" value="重置"></td>
						<td><input type="submit" value="登录"></td>
					</tr>
				</table>
			</form>
		</div>
		
		<%@ include file="/page/foot.jsp" %>
</body>
</html>