<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//如果参数有中文,需要单独设置
		request.setCharacterEncoding("utf-8");
	%>

	<%
		//通过java代码实现请求转发
		//request.getRequestDispatcher("/jsp/demo05.jsp?name=zhangsan&age=18").forward(request, response);
	%>
	<!-- 通过jsp实现请求转发 -->
	<jsp:forward page="/jsp/demo05.jsp">
		<jsp:param value="李四" name="name1" />
		<jsp:param value="32" name="age1" />
	</jsp:forward>
</body>
</html>