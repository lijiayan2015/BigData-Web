package com.ljy.web.datasource.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//1.创建池子(数据源)---创建了数据源之后,系统会自动添加连接
	private static ComboPooledDataSource dataSource =  new ComboPooledDataSource();
	//向池子中添加连接---系统会自动读取c3p0-config.xml文件:a.文件的名字要固定-c3p0-config.xml    b.文件的位置也是固定的--src下面
	//2.获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//3.释放连接
	public static void release(AutoCloseable ...closeables) {
		for(AutoCloseable closeable:closeables){
			if(closeable!=null){
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
}
