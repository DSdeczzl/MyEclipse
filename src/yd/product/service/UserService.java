package yd.product.service;

import yd.product.pojo.User;

public interface UserService {
	/**
	 * 获取用户
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public User getUser(String username,String password);
	
	/**
	 * 更新用户
	 * 
	 * @param filename
	 *            文件名
	 * @return
	 */
	public int UpdateUser(String filename,int id);
}
