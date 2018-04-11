<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Shortcut Icon" href="../resource/imgs/book.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页面</title>
</head>
<body>
	
	<c:if test="${empty sessionScope.user}">
		<a href="${pageContext.request.contextPath}/mvc/login.jsp">登录</a>
		<a href="${pageContext.request.contextPath}/mvc/regist.jsp">注册</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.user }">
		欢迎<span style="color: red;">${sessionScope.user.username}</span>登录 &nbsp; &nbsp; &nbsp; &nbsp;
		<a href='${pageContext.request.contextPath }/logout'>退出登录</a>
	</c:if>
</body>
</html>