package com.ljy.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JDBCUtils {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			//获取配置文件方式1
			ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
			driverClass = bundle.getString("driverClass");
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
			
			//获取配置文件方式2
//			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
//			Properties properties = new Properties();
//			properties.load(in);
//			driverClass = properties.getProperty("driverClass");
//			url = properties.getProperty("url");
//			user = properties.getProperty("user");
//			password = properties.getProperty("password");
			//注册驱动
			Class.forName(driverClass);
		} catch (Exception e) {
			throw new ExceptionInInitializerError();
		}
	}
	
	public static Connection getConnection() throws Exception{
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void close(AutoCloseable...closeables){
		for(AutoCloseable closeable:closeables){
			if(closeable!=null){
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				closeable = null;
			}
		}
	}
}
