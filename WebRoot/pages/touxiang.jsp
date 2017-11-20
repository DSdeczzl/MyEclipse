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
	<form action="${ctx}/FileServlet?id=${user.id}"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>商品图片</td>
				<td><input name="file" type="file" /></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="点击上传" /></td>
			</tr>
		</table>
	</form>
</body>
</html>