package com.ljy.web.session;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ljy.web.session.entity.Book;

@WebServlet("/showcar")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain;charset=utf-8");
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) session.getAttribute("bookscar");
		JsonArray array = new JsonArray();
		if(list!=null){
			for(Book book:list){
				JsonObject obj = new JsonObject();
				obj.addProperty("id", book.getId());
				obj.addProperty("author", book.getAuthor());
				obj.addProperty("des", book.getDes());
				obj.addProperty("info", book.getInfo());
				obj.addProperty("bookname", book.getBookname());
				obj.addProperty("carid", book.getCarid());
				array.add(obj);
			}
		}
		resp.getWriter().append(array.toString()).close();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
