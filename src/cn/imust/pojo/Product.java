package cn.imust.pojo;

public class Product {
	private int id;
	private String productname;
	private String summary;
	private double price;
	private int stock;
	private int s_id;
	private int c_id;
	private int recommend;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	
	
	public Product(int id, String productname, String summary, double price, int stock, int s_id, int c_id,
			int recommend) {
		super();
		this.id = id;
		this.productname = productname;
		this.summary = summary;
		this.price = price;
		this.stock = stock;
		this.s_id = s_id;
		this.c_id = c_id;
		this.recommend = recommend;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
