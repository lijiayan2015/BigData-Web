<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>九大内置对象之4大域对象</title>
</head>
<body>
	<!-- 重定向和请求转发是得到的是空的:原因是pageContext作用范围是当前servlet -->
	<%=pageContext.getAttribute("like")%>
	<!-- 重定向是空的:原因是重定向是两个request -->
	<%= request.getAttribute("like") %>
	<%=session.getAttribute("like")%>
	<%=application.getAttribute("like")%>
	
	<%--起作用的范围也是当前的4大域对象
		域对象的范围从小到大是:
		pageContext<request<session<application
		findAttribute起作用的时候是从pageContext开始匹配,有值就输出,没有就一直往下寻找,直到最后都是null
	 --%>
	<%=pageContext.findAttribute("like") %>
</body>
</html>