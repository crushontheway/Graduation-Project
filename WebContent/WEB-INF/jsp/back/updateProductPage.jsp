<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新商品</title>
</head>
<%@ include file="/page/head.jsp" %>
		<body style="background-color:#c2b5a2;">
			<h3 align="center">修改商品</h3>
			<form:form method="POST" action="${pageContext.request.contextPath }/updateProduct" modelAttribute="product">
				<input type="hidden" name="s_id" value="${s_id}">
				<input type="hidden" name="p_id" value="${p_id }">
				<table align="center">
					<tr>
						<td>商品名称</td>
						<td><form:input path="productname" placeholder="${p.productname} " /></td>
					</tr>	
						
					<tr>
						<td>商品价格</td>
						<td><form:input path="price"  placeholder="${p.price}" /> </td>
					</tr>
					
					<tr>
						<td>库存</td>
						<td><form:input path="stock"  placeholder="${p.stock}" /> </td>
					</tr>
					
					<tr>
						<td>商品类型</td>
						<td><form:select path="c_id" items="${categorys}" itemLabel="catename" itemValue="id"></form:select>   </td>
					</tr>
					
					<tr>
						<td>商品推荐值</td>
						<td> <form:select path="recommend">  
         					   <form:option value="0">选择推荐值</form:option>
					           <form:option value="1">一般推荐</form:option>
					           <form:option value="2">强力推荐</form:option>
					           <form:option value="3">极力推荐</form:option></form:select><br/></td>
					</tr>
					
					<tr>
						<td style="display: inline-block;vertical-align:top;">商品简介</td>
						<td><form:textarea cols="20" rows="5"   path="summary"  placeholder="${p.summary }" /></td>
					</tr>
							
					<tr>
						<td>
			    			<input type="reset"  value="清空"/>
			    		</td>
			    		<td>
			    			<input type="submit" value="更新"/>
			    		</td>
					</tr>				
			</table>
			</form:form>
		</body>
	<%@ include file="/page/foot.jsp" %>
</html>