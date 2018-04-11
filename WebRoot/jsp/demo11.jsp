<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String>phones = new ArrayList<String>();
		phones.add("iphone");
		phones.add("huawei");
		
		Map<String,String>map = new HashMap<String,String>();
		map.put("yi", "张三");//注意这里的key如果是01 ,则用EL表达式取值的会报错
		map.put("er", "李四");
		
		//先将他们存入域对象
		pageContext.setAttribute("list", phones);
		pageContext.setAttribute("map", map);
	 %>
	 
	 <%--使用EL表达式取值 --%>
	 ${list}
	 ${list[0]}
	 ${map}
	 ${map.yi}
	 
</body>
</html>