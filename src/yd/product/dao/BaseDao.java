package yd.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import yd.product.tools.JdbcUtil;

/**
 * 基础Dao类 用于实现数据库的增删改查功能
 * 
 * @author PC
 *
 */
public abstract class BaseDao {
	protected Connection connection = null;
	protected PreparedStatement statement = null;

	/**
	 * 关系型数据转换为对象型数据
	 * 
	 * @param resultSet
	 * @return
	 */
	public abstract Object tableToClass(ResultSet resultSet) throws Exception;

	/**
	 * 查询数据
	 * 
	 * @param sql
	 *            执行的sql语句
	 * @param params
	 *            sql中的参数
	 * @return 查询后的结果集
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql, Object... params)
			throws SQLException {
		// 获取数据库连接
		connection = JdbcUtil.connection();
		// statement用于执行sql语句
		statement = connection.prepareStatement(sql);
		// 设置参数的值
		for (int i = 0; i < params.length; i++) {
			statement.setObject(i + 1, params[i]);
		}
		// 执行sql语句
		return statement.executeQuery();
	}

	/**
	 * 增删改
	 * 
	 * @param sql
	 *            执行的sql语句
	 * @param params
	 *            sql中的参数
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, Object... params) {
		// 设置返回值变量
		int count = 0;
		try {
			// 获取数据库连接
			connection = JdbcUtil.connection();
			// preparedStatement用于执行sql语句
			statement = connection.prepareStatement(sql);
			// 设置参数的值
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			// 执行sql语句
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, statement, null);
		}
		// 执行sql语句
		return count;
	}
}
