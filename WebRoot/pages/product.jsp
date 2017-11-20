<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<c:if test="${listProduct==null }">
	<jsp:forward page="/ProductServlet?opr=product" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>用户名</td>
			<td>${user.userName }</td>
			
		</tr>
		<tr>
			<td>用户头像</td>
			<c:if test="${user.filename==null }"><td><a href="${ctx}/pages/touxiang.jsp">上传头像</a></td></c:if> 
			<c:if test="${user.filename!=null }"><td><img src="${ctx}/files/${user.filename}" width="60px"
					height="60px" /> </td></c:if> 
		</tr>
	</table>
	<table>
		<tr>
			<td width="20%">产品名称</td>
			<td width="20%">产品价格</td>
			<td width="20%">产品品牌</td>
			<td width="20%">产品描述</td>
			<td width="20%">操作</td>
		</tr>
		<c:forEach items="${listProduct}" var="product">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.brand}</td>
				<td>${product.description}</td>
				<td><a href="${ctx}/ProductServlet?opr=del&id=${product.id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="${ctx}/pages/productAdd.jsp">添加商品</a></td>
		</tr>
	</table>
	<div>
		<a href="">当前页数:[${pageUtil.startIndex }/${pageUtil.totalPage }]</a>
		<c:if test="${pageUtil.startIndex>1 }">
			<a href="${ctx}${pageUtil.url }&startIndex=1">首页</a>
			<a
				href="${ctx}${pageUtil.url }&startIndex=${pageUtil.startIndex - 1}">上一页</a>
		</c:if>
		<c:if test="${pageUtil.startIndex<pageUtil.totalPage }">
			<a
				href="${ctx}${pageUtil.url }&startIndex=${pageUtil.startIndex + 1}">下一页</a>
			<a href="${ctx}${pageUtil.url }&startIndex=${pageUtil.totalPage }">末页</a>
		</c:if>
	</div>
</body>
</html>