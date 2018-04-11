package com.ljy.web.resp_req;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req02")
public class RequestDemo02 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求消息行
		resp.setContentType("text/html;charset=utf-8");
		System.out.println(req.getMethod());
		System.out.println(req.getContextPath());//获取资源在服务器上的路径
		System.out.println(req.getRequestURI());//获取资源在服务器上的访问路径
		System.out.println(req.getRequestURL());//全路径
		System.out.println(req.getQueryString());//参数
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
