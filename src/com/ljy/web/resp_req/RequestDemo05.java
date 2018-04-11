package com.ljy.web.resp_req;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * 重定向与请求转发 
 * 共同点 
 * 都可以实现两个页面的切换 
 * 不同点: 
 * 重定向: 
 * 1.客户端需要请求两次
 * 2.地址栏显示两个地址 
 * 3.两次操作都是客户端完成的
 * 4.可以访问外部地址
 * 5.可以访问外部地址工程下的servlet对象时,工程名是:req.getContextPath()+/req06
 * 6.不能通过req对象实现两个服务器进行传值,但是转发可以
 * 
 * 请求转发: 
 * 1.客户端只需要请求一次 
 * 2.地址栏先是一个地址 
 * 3.一次客户端,一次服务器端
 * 4.只能在一个应用内访问
 * </pre>
 * @author lijiayan
 *
 */
@WebServlet("/req05")
public class RequestDemo05 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		testDirect(req, resp);
		//testforword(req, resp);
	}

	// 实现重定向
	void testDirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 用户:张三       张三想跟req05借钱,req05没钱,并给以了一个电话号码,让他去找req06借钱
		 */
		@SuppressWarnings("unused")
		String url = req.getContextPath()+"/req06";
		resp.getWriter().append("<script>alert('大胸die,我手头紧,你去req06那去看看');</script>");
		//重定向,参数是进行跳转的网址---req06的访问地址
		//要写全路径,但是可以省略http://localhost:8080,后面的路径不能省
		//getContextPath-->获取的是资源在服务器上的路径
		resp.sendRedirect("http://www.baidu.com");
	}

	// 实现请求转发
	void testforword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("大胸die,我手头紧,你去req06那去看看");
		//forward实现的是req和resp对象的中间传递
		req.setAttribute("info", "req05跟我说了,他现在没钱,他是我大哥,你先拿着我的用");
		req.getRequestDispatcher("/req06").forward(req, resp);
		System.out.println("我是req05,恭喜你借钱成功");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
