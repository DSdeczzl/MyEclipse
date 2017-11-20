package yd.product.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yd.product.pojo.User;
import yd.product.service.UserService;
import yd.product.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/UserServlet" }, name = "UserServlet")
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		user = userService.getUser(username, password);
		if (user == null) {
			request.getRequestDispatcher("/pages/login.jsp").forward(request,
					response);
		} else {
			session.setAttribute("user", user);
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
