package cn.imust.pojo;

public class Member {
	private String id;
	private String password;
	private String username;
	private String tel;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Member(String id, String password, String username, String tel, String address) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.tel = tel;
		this.address = address;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
