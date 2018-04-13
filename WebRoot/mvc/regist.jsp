<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Shortcut Icon" href="../resource/imgs/book.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	 %>
	 已有账号:点击<a href="${pageContext.request.contextPath }/mvc/login.jsp">登录</a>
	 <br/>
	<form action="${pageContext.request.contextPath }/regist" method="post">
		姓名:<input type="text" name="username"><br/>
		密码:<input type="password" name="password"><br/>
		邮箱:<input type="text" name="email"><br/>
		年龄:<input type="text" name="age"><br/>
		生日:<input type="text" name="birthday"><br/>
		<input type="submit" value="注册">
	</form>
</body>
</html>