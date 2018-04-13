package com.ljy.web.datasource.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet set = null;
		try {
			conn = DBCPUtil.getConnection();
			stat = conn.prepareStatement("select * from t_user");
			set = stat.executeQuery();
			while(set.next()){
				System.out.println(set.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtil.release(conn,stat,set);
		}
	}
}
