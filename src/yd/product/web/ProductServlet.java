package yd.product.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yd.product.pojo.Product;
import yd.product.service.ProductService;
import yd.product.service.impl.ProductServiceImpl;
import yd.product.tools.PageUtil;

@WebServlet(urlPatterns = { "/ProductServlet" }, name = "ProductServlet")
public class ProductServlet extends HttpServlet {
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if (opr.equals("product")) {
			String startIndexStr = request.getParameter("startIndex");
			String pageSizeStr = request.getParameter("pageSize");
			int startIndex = (!"".equals(startIndexStr) && startIndexStr != null) ? Integer
					.parseInt(startIndexStr) : 1;
			int pageSize = (!"".equals(pageSizeStr) && pageSizeStr != null) ? Integer
					.parseInt(pageSizeStr) : 2;
			int totalCount = productService.queryProductsCount();
			PageUtil pageUtil = new PageUtil();
			pageUtil.setPageSize(pageSize);
			pageUtil.setTotalCount(totalCount);
			pageUtil.setStartIndex(startIndex);
			pageUtil.setTotalPage(pageUtil.getTotalPage());
			pageUtil.setUrl("/ProductServlet?opr=product");
			List<Product> listProduct = productService.queryListProduct(
					(startIndex - 1) * pageSize, pageSize);
			request.setAttribute("pageUtil", pageUtil);
			request.setAttribute("listProduct", listProduct);
			request.getRequestDispatcher("/pages/product.jsp").forward(request,
					response);
		}
		if (opr.equals("add")) {
			Product product = new Product();
			product.setBrand(request.getParameter("brand"));
			product.setDescription(request.getParameter("description"));
			product.setName(request.getParameter("name"));
			float price = Float.parseFloat(request.getParameter("price"));
			product.setPrice(price);
			productService.addProduct(product);
			request.getRequestDispatcher("/pages/product.jsp").forward(request,
					response);
		}
		if (opr.equals("del")) {
			productService.delProduct(Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("/pages/product.jsp").forward(request,
					response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}
}
