<%@page import="java.util.Date"%><!-- 导java包 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	//这里定义的变量是全局变量
	int num=5;
	
	public void play(){
		System.out.println(num);
	}
	
	//这里不可以使用out  因为out是service方法内置的变量
 %>
	<%
		//这里定义的变量是局部变量
		//这里写java代码
		Date date = new Date();
		System.out.println(date.toString());//打印到控制台
		out.println(date.toString());
		
		//这里不能定义方法,因为现在已经在方法的内部
		//可以在这里调用方法
		
		play();
	 %>
	 <%=3+3 %><!-- out.println() -->
</body>
</html>