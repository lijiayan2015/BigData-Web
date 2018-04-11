package com.ljy.web.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie01")
public class CookieDemo01 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = req.getCookies();
		PrintWriter writer = resp.getWriter();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("time")){
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					writer.write("<p>您上次访问的时间是:"+format.format(new Date(Long.valueOf(cookie.getValue())))+"</p>");
					writer.write(req.getContextPath());
					writer.flush();
					writer.close();
				}
			}
		}else{
			writer.write("欢迎您,您是第一次访问哦");
			writer.flush();
			writer.close();
		}
		
		Cookie cookie = new Cookie("time", new Date().getTime()+"");
		//最大的存活时间
		//num = 0; 立即清除
		// num=一个数   这个数就是cookie的存活时间
		// num=无穷大  永远不过期
		cookie.setMaxAge(Integer.MAX_VALUE);
		cookie.setPath(req.getContextPath()+"/cookie01");
		resp.addCookie(cookie);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
