package yd.product.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import yd.product.service.UserService;
import yd.product.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/FileServlet" }, name = "FileServlet")
public class FileServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
			File tempPathFile = new File(request.getSession()
					.getServletContext().getRealPath("/temp"));
			if (!tempPathFile.exists()) {
				tempPathFile.mkdirs();
			}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 10);
			factory.setRepository(tempPathFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> listFileItem = upload
						.parseRequest(request);
				for (FileItem fileItem : listFileItem) {
					if (fileItem.isFormField()) {
					} else {
						String fileName = fileItem.getName();
						if (fileName != null
								&& !"file".equals(fileName)) {
							String suffix = fileName.substring(fileName
									.lastIndexOf(".") + 1);
							List<String> fileType = Arrays.asList(
									"jpg", "gif", "png");
							if (!fileType.contains(suffix)) {
								out.print("<script type=\"text/javascript\">");
								out.print("alert(\"添加失败，文件类型只能是jpg,png,gif\");");
								out.print("window.location.href=\""
										+ request.getContextPath()
										+ "/pages/touxiang.jsp\";");
								out.print("</script>");
								return;
							} else {
								File uploadFilePath = new File(request
										.getSession()
										.getServletContext()
										.getRealPath("/files"));
								if (!uploadFilePath.exists()) {
									uploadFilePath.mkdirs();
								}
								fileName = new Date().getTime()
										+ new Random().nextInt(10000)
										+ "." + suffix;
								userService.UpdateUser(fileName, Integer.parseInt(request.getParameter("id")) );
								fileItem.write(new File(uploadFilePath,
										fileName));
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		request.getRequestDispatcher("/pages/login.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}

}
