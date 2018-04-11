package com.ljy.web.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljy.web.mvc.domain.User;
import com.ljy.web.mvc.service.UserService;
import com.ljy.web.mvc.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		if(username!=null){
			byte[] bytes = username.getBytes("utf-8");
			username = new String(bytes,"utf-8");
		}
		String password = req.getParameter("password");
		UserService service = new UserServiceImpl();
		User user = service.findUser(username,password);
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(30*60);//30min
		if(user!=null){
			//登陆成功
			session.setAttribute("user", user);
			session.setAttribute("status", "success");
			//req.getRequestDispatcher("/mvc/main.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/mvc/main.jsp");
		}else{
			//登录失败
			session.setAttribute("user", null);
			session.setAttribute("status", "error");
			req.getRequestDispatcher("/mvc/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
