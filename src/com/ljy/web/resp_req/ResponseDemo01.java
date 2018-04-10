package com.ljy.web.resp_req;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resp01")
public class ResponseDemo01 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		//方式1:这种方式仅仅设置服务器端
		resp.setCharacterEncoding("utf-8");
		//方式2:这种方式是设置客户端解析数据时用utf-8格式解析
		resp.setContentType("text/html;charset=utf-8");
		//方式3:这是通过head的方式设置,是方式2的另一种写法而已
		//resp.setHeader("content-type", "text/html;charset=utf-8");
		String content = "<html><head><title>服务器端返回<title></head><body>"
				+ "<h1>标题<h1>"
				+"<pre>你好,这是我的邮箱:lijiayan_mail@163.com</pre>"
				+ "</body></html>";
		content = "我操怎么会不行了";
		PrintWriter writer = resp.getWriter();
		writer.write(content);
		writer.flush();
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
