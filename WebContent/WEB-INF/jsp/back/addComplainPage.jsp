<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交投诉</title>
</head>
<%@ include file="/page/head.jsp" %>
		<body style="background-color:#c2b5a2;">
			<h4 align="center">提交投诉</h4>
		<div align="center">
		<form  action="addComplain" method="post" >
			<input type="hidden" name="m_id" value="${m_id}">
			<input type="hidden" name="commitDate" value="${timestamp}">
			<textarea  rows="10" cols="80" name="content" value="在此输入您的不满，我们将尽快回复。" ></textarea>
			<input type="reset"  value="清空"/>
			<input type="submit"  value="提交"/>
		</form>
		</div>
		
		</body>
<%@ include file="/page/foot.jsp" %>
</html>