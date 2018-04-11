package com.ljy.web.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ljy.web.session.entity.Book;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain;charset=utf-8");
		JsonArray array = new JsonArray();
		List<Book> list = BookListService.getBooks();
		if (list != null) {
			for (Book book : list) {
				JsonObject obj = new JsonObject();
				obj.addProperty("id", book.getId());
				obj.addProperty("bookname", book.getBookname());
				obj.addProperty("author", book.getAuthor());
				obj.addProperty("des", book.getDes());
				obj.addProperty("info", book.getInfo());
				array.add(obj);
			}
		}
		
		PrintWriter writer = resp.getWriter();
		writer.write(array.toString());
		writer.flush();
		writer.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
