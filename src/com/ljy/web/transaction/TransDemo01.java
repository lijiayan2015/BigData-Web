package com.ljy.web.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ljy.web.util.JDBCUtils;

/**
 * 事务:是逻辑上的一组操作,默认一个sql语句对应一个事务
 * 
 * 一个事务中操作的特点:要么全成功,要么全失败
 * 
 * @author lijiayan
 *
 */
public class TransDemo01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtils.getConnection();
			//开启手动事务之前设置隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			//手动开启事务  ---将默认的自动提交关闭,就相当于开启了手动提交
			conn.setAutoCommit(false);
			// 借钱
			String sql = "update t_account set money=money-1000 where name=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, "zhangsan");
			stat.executeUpdate();
			//int num = 3/0;
			// 借钱
			sql = "update t_account set money=money+1000 where name=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, "lisi");
			stat.executeUpdate();
			//提交事务  将借钱和收钱放在一个事务中
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//当发生异常的时候,让事务回滚,当前事务回退到开启事务之前,当前事务的所有操作失效
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JDBCUtils.close(conn,stat);
		}
	}
}
