package com.ljy.web.mvc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ljy.web.mvc.dao.UserDao;
import com.ljy.web.mvc.domain.User;
import com.ljy.web.util.JDBCUtils;

/**
 * 访问数据库
 * 
 * @author lijiayan
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public int regiest(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		int i = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into t_user(username,password,email,age,birthday) values(?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getEmail());
			stat.setInt(4, user.getAge());
			//因为sql.date的优先级比util.date的优先级低,所以需要进行转化
			stat.setDate(5, new Date(user.getBirthday().getTime()));
			i = stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,stat);
		}
		return i;
	}

	@Override
	public User findUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stat = null;
		User user = null;
		ResultSet set = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_user where username=? and password=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			set = stat.executeQuery();
			if(set.next()){
				user = new User();
				user.setId(set.getInt("id"));
				user.setAge(set.getInt("age"));
				user.setBirthday(set.getDate("birthday"));
				user.setEmail(set.getString("email"));
				user.setUsername(username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,stat,set);
		}
		return user;
	}

}
