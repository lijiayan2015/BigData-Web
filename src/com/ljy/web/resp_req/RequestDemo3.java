package com.ljy.web.resp_req;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * get方式下中文乱码处理
 * @author lijiayan
 *
 */
@WebServlet("/req03")
public class RequestDemo3 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//使用再编码再解码的方式解决问题
		String name = req.getParameter("user");
		byte[] bytes = name.getBytes("ISO8859-1");
		name = new String(bytes,"utf-8");
		PrintWriter writer = resp.getWriter();
		writer.write(name);
		writer.flush();
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
