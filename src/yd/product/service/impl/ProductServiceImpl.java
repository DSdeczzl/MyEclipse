package yd.product.service.impl;

import java.util.List;

import yd.product.dao.ProductDao;
import yd.product.dao.impl.ProductDaoImpl;
import yd.product.pojo.Product;
import yd.product.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> queryListProduct(int startIndex, int pageSize) {
		return productDao.queryListProduct(startIndex, pageSize);
	}

	@Override
	public int queryProductsCount() {
		return productDao.queryProductsCount();
	}

	@Override
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public int delProduct(int id) {
		return productDao.delProduct(id);
	}


}
