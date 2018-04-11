<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSTF 循环</title>
</head>
<body>
	<%--第一个参数初始化变量  第二个开始值  第三个结束值  第四个自变量
		注意:包括开始和结束
	 --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i}
	</c:forEach>
	<%--增强for循环 --%>
	<%
	//存
		List<String>list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("c++");
		request.setAttribute("list", list);
	 %>
	 
	 <%--第一个参数是当前的集合  第二个参数代表一个临时变量 --%>
	 <c:forEach items="${list}" var="item">
	 	${item}
	 </c:forEach>
</body>
</html>