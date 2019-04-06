package cn.imust.pojo;

import java.io.Serializable;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.imust.service.ShopService;
import cn.imust.service.impl.ShopServiceImpl;

public class RegisterFormBean implements Serializable {
	private String username;
	private String password;
	private String repeatpassword;
	private String shopName;
	private String tel;
	private String address;
	private String checkCode;
	
	public RegisterFormBean(String username, String password, String repeatpassword, String shopName, String tel,
			String address, String checkCode) {
		super();
		this.username = username;
		this.password = password;
		this.repeatpassword = repeatpassword;
		this.shopName = shopName;
		this.tel = tel;
		this.address = address;
		this.checkCode = checkCode;
	}
	
	
	public RegisterFormBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	private Map<String,String> errors = new HashMap<String,String>();
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
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
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	/*
	private String username;  用户名不能为空，并且要是3-8的字符 abcdABcd
	private String password;  密码不能为空，并且要是3-8的数字
	private String password2; 两次密码要一致
	private String shopName;  不超过20个字符，且不能为空
	private String tel;       不超过11个字符，且不能为空
	private String address;   不超过30个字符，且不能为空
	 * 
	 */
	public boolean validate(HttpServletRequest request){
		
		boolean isOk = true;
		
		if(this.username==null || this.username.trim().equals("") ){
			isOk = false;
			errors.put("username", "用户名不能为空！！");
		}else if(!this.username.matches("[a-zA-Z0-9]{6,10}")){
				isOk = false;
				errors.put("username", "用户名必须是6-10位的字母结合数字！！");
		}

		
		
		
		if(this.password==null || this.password.trim().equals("")){
			isOk = false;
			errors.put("password", "密码不能为空！！");
		}else if(this.password.matches("\\d{6,12}")){
				isOk = false;
				errors.put("password", "密码不能为纯数字");
		}else if(!this.password.matches("[a-zA-Z0-9]{6,12}")){
				isOk = false;
				errors.put("password", "密码必须是6-12位的字母与数字组合！！");
		}
		
		//private String password2; 两次密码要一致
		if(this.repeatpassword!=null){
			if(!this.repeatpassword.equals(this.password)){
				isOk = false;
				errors.put("repeatpassword", "两次密码不一致！！");
			}
		}
		
		if(this.shopName==null || this.shopName.trim().equals("") ){
			isOk = false;
			errors.put("shopName", "商户名不能为空！！");
		}else{
			if(!this.shopName.matches("[a-zA-Z\\u4E00-\\u9FA5]{2,20}")){
				isOk = false;
				errors.put("shopName", "商户名必须是2-10位的字母或汉字！！");
			}
		}
		
		if(this.address==null || this.address.trim().equals("") ){
			isOk = false;
			errors.put("address", "地址不能为空！！");
		}else{
			if(!this.address.matches("[0-9\\u4E00-\\u9FA5]{6,20}")){
				isOk = false;
				errors.put("address", "地址必须是6-15位的汉字和数字！！");
			}
		}
		
		if(this.tel==null || this.tel.trim().equals("") ){
			isOk = false;
			errors.put("tel", "联系方式不能为空！！");
		}else{
			if(!this.tel.matches("[0-9]{7,11}")){
				isOk = false;
				errors.put("tel", "联系方式必须是7-11位的数字！！");
			}
		}
		
		if(this.checkCode==null || this.checkCode.trim().equals("") ){
			isOk = false;
			errors.put("checkCode", "验证码不能为空！！");
		}else{
			if(!this.checkCode.equals(request.getSession().getAttribute("randCheckCode"))){
				isOk = false;
				errors.put("checkCode", "验证码错误，请重新输入！！！");
			}
		}
		return isOk;
	}
	
	
	
}
