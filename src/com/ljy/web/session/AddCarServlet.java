package com.ljy.web.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.ljy.web.session.entity.Book;

@WebServlet("/addcar")
public class AddCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id");
		//获取session
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) session.getAttribute("bookscar");
		if(list==null){
			list = new ArrayList<Book>();
		}
		Book book = BookListService.getBookById(Integer.valueOf(id));
		book.setCarid(new Date().getTime());
		
		list.add(book);
		session.setAttribute("bookscar", list);
		JsonObject obj = new JsonObject();
		obj.addProperty("result", 1);
		resp.getWriter().append(obj.toString()).flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
