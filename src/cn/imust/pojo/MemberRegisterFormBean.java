package cn.imust.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MemberRegisterFormBean {
	private String id;
	private String password;
	private String repeatpassword;
	private String username;
	private String tel;
	private String address;
	private String checkCode;
	private Map<String,String> errors = new HashMap<String,String>();
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
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
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
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public MemberRegisterFormBean(String id, String password, String repeatpassword, String username, String tel,
			String address, String checkCode, Map<String, String> errors) {
		super();
		this.id = id;
		this.password = password;
		this.repeatpassword = repeatpassword;
		this.username = username;
		this.tel = tel;
		this.address = address;
		this.checkCode = checkCode;
		this.errors = errors;
	}
	
	public MemberRegisterFormBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
public boolean validate(HttpServletRequest request){
		
		boolean isOk = true;
		
		if(this.id==null || this.id.trim().equals("") ){
			isOk = false;
			errors.put("id", "用户名不能为空！！");
		}else if(!this.id.matches("[a-zA-Z0-9]{6,10}")){
				isOk = false;
				errors.put("id", "用户名必须是6-10位的字母结合数字！！");
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
		
		if(this.username==null || this.username.trim().equals("") ){
			isOk = false;
			errors.put("username", "昵称不能为空！！");
		}else{
			if(!this.username.matches("[a-zA-Z\\u4E00-\\u9FA5]{2,20}")){
				isOk = false;
				errors.put("username", "昵称必须是2-10位的字母或汉字！！");
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
