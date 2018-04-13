package com.ljy.web.datasource.dbcp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
	// 1.创建数据源
	private static DataSource dataSource;
	// 2.连接配置文件
	static {
		Properties properties = new Properties();
		try {
			// 获取配置信息,将内容保存到properties对象里面
			properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 得到连接池对象,将配置信息指定给连接池对象
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 3.获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// 4.释放连接
	public static void release(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
