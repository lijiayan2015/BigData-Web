package com.ljy.web.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//退出登录
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//清除登录信息
		//req.getSession().setAttribute("user", null);
		//req.getSession().setAttribute("status", null);
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("status");
		resp.sendRedirect(req.getContextPath()+"/mvc/main.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
