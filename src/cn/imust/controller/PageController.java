package cn.imust.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.imust.pojo.MemberRegisterFormBean;
import cn.imust.pojo.RegisterFormBean;
import cn.imust.pojo.Shop;

@Controller
@RequestMapping("")
public class PageController {
	@RequestMapping("shopRegisterPage")
    public String shopRegisterPage(Map<String,Object> map) {
		map.put("registerFormBean",new RegisterFormBean());
		return "fore/shopRegister";
    }
	
	@RequestMapping("shopLoginPage")
	public String shopLoginPage(){
		return "fore/shopLogin";
	}
	
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    
    @RequestMapping("memberRegisterPage")
    public String memberRegisterPage(Map<String,Object> map) {
    	 map.put("memberRegisterFormBean", new MemberRegisterFormBean());
    	 return "fore/memberRegister";
    }
    
    @RequestMapping("memberLoginPage")
    public String memberLoginPage() {
    	return "fore/memberLogin";
    }

    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
    
    @RequestMapping("showOrderList")
    public String showOrderList(){
        return "fore/showOrderList";
    }
}
