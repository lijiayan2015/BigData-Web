package com.ljy.web.dbutilstest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.ljy.web.datasource.c3p0.C3P0Util;
import com.ljy.web.mvc.domain.User;

/**
 * <pre>
 * @Test 是测试的方法,可以被直接调用,但是必须在测试的环境下
 * 注意点:1.不能有参数
 * 2.不能有返回值
 * </pre>
 * @author lijiayan
 *
 */
public class TestDemo01 {
	
	@Test
	public void insert01(){
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "insert into t_user(username,password,email,age) values(?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, "dbutils-test");
			stat.setString(2, "dbutils-test-pwd");
			stat.setString(3, "dbutils-test@163.com");
			stat.setInt(4, 32);
			//因为sql.date的优先级比util.date的优先级低,所以需要进行转化
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3P0Util.release(conn,stat);
		}
		
	}
	
	/**
	 * 使用dbutils实现插入
	 * @throws Exception 
	 */
	@Test
	public void insert02() throws Exception{
		//使用的是无参数的QueryRunner方法,可以使用事务
		//1.创建干活的对象
		QueryRunner qRunner = new QueryRunner();
		//2.获取链接对象
		Connection conn = C3P0Util.getConnection();
		String sql = "insert into t_user(username,password,email,age) values(?,?,?,?)";
		//调用update方法实现插入
		int i = qRunner.update(conn, sql ,"test02","test02-pwd","test02@163.com",32);
		System.out.println(i);
		C3P0Util.release(conn);
	}
	
	/**
	 * 使用dbutils实现插入
	 * @throws Exception 
	 */
	@Test
	public void insert03() throws Exception{
		//使用的是有参数的QueryRunner方法,参数是数据源
		//没有conn对象,没法实现事务
		//1.创建干活的对象
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into t_user(username,password,email,age) values(?,?,?,?)";
		//调用update方法实现插入
		int i = qRunner.update(sql ,"test03","test03-pwd","test03@163.com",32);
		System.out.println(i);
	}
	
	/**
	 * 批量增加
	 * @throws Exception 
	 */
	@Test
	public void insert04() throws Exception{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into t_user(username,password,email,age) values(?,?,?,?)";
		int[] batch = qRunner.batch(sql, new Object[][]{{"batch01","batch02","batch03",10},{"batch11","batch12","batch13",11},{"batch21","batch22","batch23",20}});
		System.out.println(Arrays.toString(batch));
	}
	
	@Test
	public void query01() throws Exception{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from t_user";
		List<User> list = qRunner.query(sql, new ResultSetHandler<List<User>>(){
			/**
			 * 这是真正处理数据的方法,参数就是得到的结果集
			 * 这个方法是底层通过ResultSetHandler对象自动调用的
			 */
			@Override
			public List<User> handle(ResultSet rs) throws SQLException {
				List<User>list = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setUsername(rs.getString("username"));
					list.add(user);
				}
				return list;
			}
			
		});
		
		System.out.println(list);
	}
	
	/**
	 * 返回所有的数据集合
	 * @throws Exception
	 */
	@Test
	public void query02() throws Exception{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from t_user";
		List<User> list = qRunner.query(sql,new BeanListHandler<User>(User.class));
		System.out.println(list);
	}
	
	/**
	 * 返回一条记录
	 * @throws Exception
	 */
	@Test
	public void query03() throws Exception{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from t_user where id = ?";
		User user = qRunner.query(sql,new BeanHandler<User>(User.class),7);
		System.out.println(user);
	}
}
