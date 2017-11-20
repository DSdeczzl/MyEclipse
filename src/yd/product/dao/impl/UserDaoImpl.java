package yd.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import yd.product.dao.BaseDao;
import yd.product.dao.UserDao;
import yd.product.pojo.User;
import yd.product.tools.JdbcUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getUser(String username,String password) {
		User user = null;
		String sql = "SELECT * FROM `user` WHERE username = ? and password =? ";
		ResultSet resultSet = null;
		try {
			resultSet = this.executeQuery(sql, username,password);
			if (resultSet.next()) {
				user = this.tableToClass(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, statement, resultSet);
		}
		return user;
	}

	@Override
	public User tableToClass(ResultSet resultSet) throws Exception {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setUserName(resultSet.getString("userName"));
		user.setPassword(resultSet.getString("password"));
		user.setFilename(resultSet.getString("filename"));
		return user;
	}

	@Override
	public int UpdateUser(String filename,int id) {
		String sql = "UPDATE `user` SET filename=? WHERE id=?";
		return this.executeUpdate(sql, filename, id);
	}

}
