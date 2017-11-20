package yd.product.dao;

import java.util.List;

import yd.product.pojo.Product;

public interface ProductDao {
	/**
	 * 查询产品
	 * 
	 * @param startIndex
	 *            开始页
	 * @param pageSize
	 *            页面个数
	 * @return
	 */
	public List<Product> queryListProduct(int startIndex, int pageSize);

	/**
	 * 查询产品总数
	 * 
	 * @return
	 */
	public int queryProductsCount();
	
	/**
	 * 产品添加
	 * 
	 * @return
	 */
	public int addProduct(Product product);
	/**
	 * 删除产品
	 * 
	 * @return
	 */
	public int delProduct(int id);
}
