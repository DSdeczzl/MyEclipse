package yd.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yd.product.dao.BaseDao;
import yd.product.dao.ProductDao;
import yd.product.pojo.Product;
import yd.product.tools.JdbcUtil;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public List<Product> queryListProduct(int startIndex, int pageSize) {
		List<Product> listProducts = new ArrayList<Product>();
		String sql = "SELECT * FROM `product` LIMIT ?,?";
		ResultSet resultSet = null;
		try {
			resultSet = this.executeQuery(sql, startIndex, pageSize);
			while (resultSet.next()) {
				listProducts.add(tableToClass(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, statement, resultSet);
		}
		return listProducts;
	}

	@Override
	public int queryProductsCount() {
		int count = 0;
		String sql = "SELECT COUNT(0) FROM `product`";
		ResultSet resultSet = null;
		try {
			resultSet = this.executeQuery(sql);
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(connection, statement, resultSet);
		}
		return count;
	}

	@Override
	public Product tableToClass(ResultSet resultSet) throws Exception {
		Product product = new Product();
		product.setDescription(resultSet.getString("description"));
		product.setId(resultSet.getInt("id"));
		product.setName(resultSet.getString("name"));
		product.setPrice(resultSet.getFloat("price"));
		product.setBrand(resultSet.getString("brand"));
		return product;
	}

	@Override
	public int addProduct(Product product) {
		String sql = "INSERT INTO `product` (NAME,price,brand,description) VALUES (?,?,?,?)";
		return this.executeUpdate(sql, product.getName(), product.getPrice(),
				product.getBrand(), product.getDescription());
	}

	@Override
	public int delProduct(int id) {
		String sql = "DELETE FROM `product` WHERE id=?";
		return this.executeUpdate(sql, id);
	}
}
