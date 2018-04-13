
/**
 * <pre>
 * 	文件上传注意点:
 * 	1.请求方法必须是post
 * 	2.表单的enctype属性必须是multipart/form-data
 * 	3.表单中提供的<input type="file"类型的上传输入域
 * </pre>
 * 
 * <pre>
 * 	form 表单的encty属性:
 * 	该属性的作用是用来告知服务器,请求正文的mime类型
 * 	相当于请求消息头,相当于content-type
 * 	encty=application/x-www-form-urlencoded
 * 	相当于content-Type=application/x-www-form-urlencoded(默认值)
 * 	服务器端:String value = request.getParameter(String name);
 * 	只能读取请求正文是application/x-www-form-urlencoded	类型的数据
 * 
 * 	enctype=multipart/form-data
 * 	相当于content-Type=multipart/form-data
 * </pre>
 * 
 * <pre>
 * 	利用第三方组件上传
 * 	apache 的:commons-fileupload组件
 * 			  依赖commons-io组件
 * </pre>
 * 
 * <pre>
 * 服务器可能存在的安全问题:
 * 用户上传一个危险的jsp文件,如下:
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Runtime.getRuntime().exec("notepad");//万一是其他命令会很危险
	 %>
</body>
</html>
 * 然后用户假如知道上传的文件所在的位置在下面
 * files/
 * 则用户直接访问BigData-Web/files/a.jsp----就会存在安全问题
 * 
 * 
 * 解决方案:1.把上传的文件放到用户访问不到的地方(放到web-info目录下)
 * 		  2.限制文件类型(不能完全保证)
 * 			a:限制文件的拓展名
 * 			b:文件mime类型(text/html)
 * 重名文件会覆盖的问题:
 * 		文件名不同方案解决
 * 		FileItem 的item.getContentType()可以获得文件的mime
 * 
 * 避免一个文件夹中的文件过多:
 * 方案1:按照日期分目录存储
 * 方案2:按照文件名的hashCode随机存储.
 * 
 * </pre>
 * 
 * @author lijiayan
 *
 */
package com.ljy.web.fileupload;
