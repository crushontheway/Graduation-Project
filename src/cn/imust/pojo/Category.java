package cn.imust.pojo;

public class Category {
	private int id;
	private String catename;

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Category(int id, String catename) {
		super();
		this.id = id;
		this.catename = catename;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
