<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx }/ProductServlet">
		<table>
			<tr>
				<td>产品名称</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>产品价格</td>
				<td><input type="text" name="price" value="" /></td>
			</tr>
			<tr>
				<td>产品品牌</td>
				<td><input type="text" name="brand" value="" /></td>
			</tr>
			<tr>
				<td>产品描述</td>
				<td><input type="text" name="description" value="" /></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="添加" /></td>
				<td><input type="hidden" name="opr" value="add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>