package cn.imust.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.imust.pojo.Coupon;
import cn.imust.pojo.Shop;
import cn.imust.service.CouponService;

@Controller
public class CouponController {
	@Autowired
	CouponService couponService;
	
	@RequestMapping("addCouponPage")
	public String addCouponPage(HttpServletRequest request,Map<String,Object> map) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		int s_id = shop.getId();
		map.put("coupon", new Coupon());
		request.setAttribute("s_id",s_id);
		return "back/addCouponPage";
	}
	
	@RequestMapping("addCoupon")
	public String addCoupon(HttpServletRequest request,Coupon coupon) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		int s_id = shop.getId();
		if(couponService.getCouponByS_id(s_id) !=null) {
			request.setAttribute("message","对不起，一家店铺只能举办一个活动！！！");
			return "fore/message";
		}
		couponService.add(coupon);
		return "redirect:listAllCoupon";
	}
	
	@RequestMapping("listAllCoupon")
	public String listAllCoupon(HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		int s_id = shop.getId();
		Coupon coupon = couponService.getCouponByS_id(s_id);
		request.setAttribute("coupon", coupon);
		return "back/listAllCoupon";
	}
	
	@RequestMapping("deleteCoupon")
	public String deleteCoupon(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		couponService.deleteCouponById(id);
		return "redirect:listAllCoupon";
	}
}
