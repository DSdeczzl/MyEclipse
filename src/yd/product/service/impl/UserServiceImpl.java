package yd.product.service.impl;

import yd.product.dao.UserDao;
import yd.product.dao.impl.UserDaoImpl;
import yd.product.pojo.User;
import yd.product.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User getUser(String username,String password) {
		return userDao.getUser(username,password);
	}
	@Override
	public int UpdateUser(String filename,int id) {
		return userDao.UpdateUser(filename, id);
	}

}
