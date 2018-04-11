<%@page import="com.ljy.web.jsp.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EL表达式</title>
</head>
<body>
	<%-- 
	EL表达式是一种规范,但是不是一种语言
	可以通过它简化jsp代码
	 --%>
	 
	<%
		request.setCharacterEncoding("utf-8");
		Person p = new Person();
		p.setName("张三");
		p.setAge(31);
		
		Dog d = new Dog();
		d.setName("金毛");
		p.setDog(d);
		//请求转发
		request.setAttribute("person", p);
		request.getRequestDispatcher("/jsp/demo10.jsp").forward(request, response);
		
	 %>
</body>
</html>