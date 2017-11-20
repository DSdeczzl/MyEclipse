package yd.product.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Properties pro;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	/**
	 * 初始化
	 */
	static {
		pro = new Properties();
		try {
			// 获取jdbc.properties的值
			pro.load(JdbcUtil.class.getResourceAsStream("/jdbc.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			// 加载数据库驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立数据库连接
	 * 
	 * @return
	 */
	public static Connection connection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void closeAll(Connection connection, Statement statement,
			ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
