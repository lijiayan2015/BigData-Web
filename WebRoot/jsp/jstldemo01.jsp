<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid red;
	width: 400px;
	cellspacing:0;
	cellpadding:0;
}

table td{
	border: 1px solid red;
	text-align: center;
}
</style>

</head>
<body>
	<%
		//数据源
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		List<String> list1 = new ArrayList<String>();
		Collections.addAll(list1, "str11", "str12", "str13", "str14", "str15");
		map.put("str1", list1);

		List<String> list2 = new ArrayList<String>();
		Collections.addAll(list2, "str21", "str22", "str23", "str24", "str25");
		map.put("str2", list2);

		List<String> list3 = new ArrayList<String>();
		Collections.addAll(list3, "str31", "str32", "str33", "str34", "str35");
		map.put("str3", list3);

		request.getSession().setAttribute("mapData", map);
	%>

	<table>
		<tr>
			<td>字段1</td>
			<td>字段2</td>
			<td>字段3</td>
			<td>字段4</td>
			<td>字段5</td>
		</tr>
		<c:forEach var="mapItem" items="${sessionScope.mapData}">
			<tr>
				<c:forEach items="${mapItem.value}" var="item">
					<td>${item}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>