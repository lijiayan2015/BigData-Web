<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%-- JSTL的核心类库 prefix:使用jstl命令时的前缀,默认是c,也可以自定义--%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSTL标准标签库的使用</title>
</head>
<body>
	<%-- JSTL主要用来处理jsp中的逻辑:循环判断 
		JSTL 都是要作用于4大域对象
		使用的前提是先导入库 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	--%>
	
	<%
		int num = 4;
		out.println(num);
	 %>
	 <%--第一个参数是变量的名字,第二个参数是对应的值 --%>
	 <c:set var="num" value="${4}"></c:set>
	 <c:out value="${num }"></c:out>
	 <c:remove var="num"/>
	 <%--当不存在num这个变量时,用good来代替 --%>
	 <c:out value="${num }" default="good"></c:out>
	 
	 <%--判断 --%>
	 <c:if test="${true }">
	 	执行了
	 </c:if>
	 <c:set var="b" value="${2 }"></c:set>
	 <c:choose>
	 	<c:when test="${b==0 }">'a'</c:when>
	 	<c:when test="${b==2 }">'b'</c:when>
	 	<c:when test="${b==6 }">'g'</c:when>
	 </c:choose>
	 
	 
</body>
</html>