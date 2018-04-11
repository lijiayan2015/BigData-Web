<%@page import="com.ljy.web.jsp.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person p = new Person();
		p.setName("张三");
		p.setAge(21);
		out.println(p.getName());
	%>
	<%-- id代表对象的名字
		这里底层是利用反射方式创建对象
	  --%>
	<jsp:useBean id="person1" class="com.ljy.web.jsp.Person"></jsp:useBean>
	<%--
		property:属性的名字
		name:属性对应的对象的名字
		value:属性对应的值
	 --%>
	<jsp:setProperty property="name" name="person1" value="李四"/>
	<%--直接打印到web页面上 --%>
	<jsp:getProperty property="name" name="person1"/>
</body>
</html>