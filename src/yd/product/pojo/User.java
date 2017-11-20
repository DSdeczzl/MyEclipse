package yd.product.pojo;

public class User {
	private int id;// 用户ID
	private String userName;// 用户名
	private String password;// 用户密码
	private String filename;// 文件名

	public User() {
		super();
	}

	public User(int id, String userName, String password, String filename) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
