package yd.product.pojo;

public class Product {
	private int id;// 产品id
	private String name;// 产品名
	private String brand;// 产品品牌
	private String description;// 产品描述
	private float price;// 产品价格

	public Product() {
		super();
	}

	public Product(int id, String name, String brand, String description,
			float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
