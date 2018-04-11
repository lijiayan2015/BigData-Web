package com.ljy.web.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.ljy.web.session.entity.Book;

@WebServlet("/remove")
public class RemoveCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain;charset=utf-8");
		
		String id = req.getParameter("id");
		String carid = req.getParameter("carid");
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<Book>list = (List<Book>) session.getAttribute("bookscar");
		PrintWriter writer = resp.getWriter();
		JsonObject obj = new JsonObject();
		if(list!=null){
			ListIterator<Book> it = list.listIterator();
			while(it.hasNext()){
				Book book = it.next();
				try {
					if (book.getId() == Integer.valueOf(id) && book.getCarid() == Long.valueOf(carid)) {
						it.remove();
						obj.addProperty("result", 1);
						writer.append(obj.toString()).close();
						return;
					} 
				} catch (Exception e) {
				}
			}
		}
		
		obj.addProperty("result", -1);
		writer.append(obj.toString()).close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
