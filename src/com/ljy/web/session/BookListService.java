package com.ljy.web.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ljy.web.session.entity.Book;
import com.ljy.web.util.JDBCUtils;

public class BookListService {

	public static List<Book> getBooks() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet set = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_book";
			stat = conn.prepareStatement(sql);
			set = stat.executeQuery();
			List<Book> books = new ArrayList<>();
			while (set.next()) {
				Book book = new Book();
				book.setId(set.getInt("id"));
				book.setBookname(set.getString("bookname"));
				book.setDes(set.getString("des"));
				book.setInfo(set.getString("info"));
				book.setAuthor(set.getString("author"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn,stat,set);
		}
		return null;
	}
	
	
	public static Book getBookById(int id) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet set = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_book where id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			set = stat.executeQuery();
			if(set.next()){
				Book book = new Book();
				book.setId(set.getInt("id"));
				book.setAuthor(set.getString("author"));
				book.setBookname(set.getString("bookname"));
				book.setDes(set.getString("des"));
				book.setInfo(set.getString("info"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn,stat,set);
		}
		return null;
	}

}
