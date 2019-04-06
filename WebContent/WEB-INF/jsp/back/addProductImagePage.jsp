<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图片</title>
</head>
<%@ include file="/page/head.jsp"%>
<body style="background-color: #c2b5a2;">
	<h3 align="center">添加图片</h3>
	<div align="center">
		<form method="post" action="${pageContext.request.contextPath}/addProductImage" enctype="multipart/form-data">
			<table>
				<tr>
					<td>请选择本地图片 尺寸400X400 为佳</td>
				</tr>
				<tr>
					<td><input id="filepathSingle" type="file" accept="image/*"	 name="image" /></td>
				</tr>
				<tr>
					<td align="center">
						<input type="hidden" name="p_id" value="${p_id}" />
						<input type="submit" value="提交"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<%@ include file="/page/foot.jsp"%>
</html>