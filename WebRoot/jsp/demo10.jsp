<%@page import="com.ljy.web.jsp.Dog"%>
<%@page import="com.ljy.web.jsp.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EL表达式</title>
</head>
<body>
	<%
		//通过java将值取出
		Person p = (Person) request.getAttribute("person");
		out.println(p.getName());
		Dog d = p.getDog();
		out.println(d.getName());
	%>
	<%--
		通过EL表达式取值
		构成:${域对象的key}  ${域对象内江支队的key.属性名.属性名}
		注意点:1.类中必须有get set 方法,
		2.点后面的属性的名字必须跟类成员变量的名字一致
		3.如果在测试期间,对模型发生了改变,一定要重新发布
		4.通过EL表达式只能操作4个域对象范围的值
	 --%>
	<pre>
	 Person的对象:${person}
	 Person的姓名:${person.name}
	 dog的姓名:${person.dog.name}
	 </pre>
</body>
</html>