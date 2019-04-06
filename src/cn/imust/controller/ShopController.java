package cn.imust.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.imust.mapper.ShopMapper;
import cn.imust.pojo.Member;
import cn.imust.pojo.RankShop;
import cn.imust.pojo.RegisterFormBean;
import cn.imust.pojo.Shop;
import cn.imust.service.OrderItemService;
import cn.imust.service.ShopService;

@Controller
@RequestMapping("")
public class ShopController {
	@Autowired
	ShopService shopService;
	@Autowired
	OrderItemService orderItemService;
	
	
	@RequestMapping(value = "foreRegister", method = RequestMethod.POST)
	public String addShop(RegisterFormBean registerFormBean, HttpServletRequest request) {
		if (registerFormBean.validate(request) == false) {
			request.setAttribute("RegisterFormBean", registerFormBean);
			return "fore/shopRegister";
		}
		if(shopService.isExist(registerFormBean.getUsername()))
		{
			registerFormBean.getErrors().put("username", "用户名已经存在");
			request.setAttribute("RegisterFormBean", registerFormBean);
			return "fore/shopRegister";
		}else {	
			Shop shop = new Shop(registerFormBean.getShopName(), registerFormBean.getUsername(), registerFormBean.getPassword(), registerFormBean.getTel(), registerFormBean.getAddress());
			request.setAttribute("RegisterFormBean", registerFormBean);
			shopService.add(shop);
			return "/fore/registerSuccess";
		}
	}
	
	@RequestMapping(value="forelogin",method=RequestMethod.POST)
	public String shopLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Shop shop = shopService.login(username, password);
		if(shop!=null) {
			request.getSession().setAttribute("shop", shop);
			request.setAttribute("message", "恭喜！"+shop.getShopName()+"登录成功！！");
			return "/fore/message";
		}else{
			request.setAttribute("message", "登录失败！！账号或密码错误！！");
			return "/fore/message";
		}
		
	}
	
	@RequestMapping("shopLogout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("shop");
		request.setAttribute("message", "下线成功！");
		return "/fore/message";
	}
	
	@RequestMapping("shopInformation")
	public String memberInformation() {
		return "back/shopInformation";
	}
	
	@RequestMapping("showShopInformation")
	public String showMemberInformation(Map<String,Object> map,HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		map.put("shop", shop);
		return "/back/showShopInformation";
	}
	
	@RequestMapping("updateShopInformation")
	public String updateMemberInformation(Shop shop,HttpServletRequest request) {
		int isUpdate = shopService.update(shop);
		if(isUpdate !=0) {
			request.setAttribute("message", "修改成功！！！");
		}
		return "/fore/message"; 
	}
	
	@RequestMapping("rankShop")
	public String rankShop(HttpServletRequest request) {
		List<RankShop> rankShop = orderItemService.rankShop();
		List<Shop> rankShops = new LinkedList<>(); 
		for(RankShop rs :rankShop) {
			rankShops.add(shopService.getShopById(rs.getS_id()));
		}
		request.setAttribute("rankShops", rankShops);
		return "fore/shopRank";
	}
}
