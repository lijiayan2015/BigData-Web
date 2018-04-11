<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>include</title>
</head>
<body>
	
	<h2>this page3</h2>
	<!-- 
		静态包含 
		在翻译的之后,直接将内容进行了合并,实际上只编译了一个.java文件
	-->
	<%@include file='demo02.jsp' %>
	<!-- 动态包含 
		从始至终都是两个文件,编译了两个文件
	-->	
	<jsp:include page="demo02.jsp"></jsp:include>
</body>
</html>