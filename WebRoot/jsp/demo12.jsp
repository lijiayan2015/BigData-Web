<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>表单提交</title>
</head>
<body>

	<form action="/BigData-Web/jsp/demo13.jsp" method="post">
		姓名:<input type="text" name="user" /><br /> 密码:<input type="password"
			name="pwd"><br /> 性别:<input type="radio" name="sex"
			checked="checked" value="男">男 <input type="radio" name="sex"
			value="女" />女<br /> 爱好:<input type="checkbox" name="hobby"
			value="java">java <input type="checkbox" name="hobby"
			value="php">php <input type="checkbox" name="hobby"
			value="html">html<br /> 国籍:<select name="area">
			<option>中国</option>
			<option>美国</option>
			<option selected="selected">法国</option>
			<option>英国</option>
		</select><br /> 提交<input type="submit" value="提交"><br />
	</form>

</body>
</html>