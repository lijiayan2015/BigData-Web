package com.ljy.web.resp_req;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
//显示验证码
@WebServlet("/resp04")
public class ResponseDemo04 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * 发送图片验证码
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("charset=utf-8");
		//告知客户端不缓存的方法:
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		resp.setDateHeader("expires", 0);
		ValidateCode code = new ValidateCode(100, 25, 4, 26);
		code.write(resp.getOutputStream());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
