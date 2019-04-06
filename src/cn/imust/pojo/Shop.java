package cn.imust.pojo;

public class Shop {
	private int id;
	private String shopName;
	private String username;
	private String password;
	private String tel;
	private String address;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Shop(int id, String shopName, String username, String password, String tel, String address) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.address = address;
	}
	
	public Shop( String shopName, String username, String password, String tel, String address) {
		super();
		this.shopName = shopName;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.address = address;
	}
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}	
