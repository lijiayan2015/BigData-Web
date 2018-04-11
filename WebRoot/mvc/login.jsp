<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Shortcut Icon" href="../resource/imgs/book.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user}">
		<jsp:forward page="/mvc/main.jsp"></jsp:forward>
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<form action="${pageContext.request.contextPath}/login" method="post">
			姓名:<input type="text" name="username">
			<c:if test="${not empty sessionScope.status}">
				<c:if test="${sessionScope.status eq 'error'}">
					<span style="color: red">用户名或密码错误</span>
				</c:if>
			</c:if>
			<br /> 密码:<input type="password" name="password"><br /> <input
				type="submit" value="登录">
		</form>
	</c:if>

</body>
</html>