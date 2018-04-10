package com.ljy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		String attribute = (String) context.getAttribute("key");
		PrintWriter writer = resp.getWriter();
		if(attribute==null){
			writer.write("请先运行:<a href='http://localhost:8080/BigData-Web/demo04'>点击运行</a>");
		}else{
			writer.write("获取的全局变量:"+attribute);
		}
		writer.flush();
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
