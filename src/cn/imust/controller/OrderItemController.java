package cn.imust.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.imust.pojo.Coupon;
import cn.imust.pojo.Member;
import cn.imust.pojo.OrderItem;
import cn.imust.pojo.Product;
import cn.imust.pojo.Shop;
import cn.imust.service.CouponService;
import cn.imust.service.OrderItemService;
import cn.imust.service.ProductService;
import cn.imust.service.ShopService;

@Controller
public class OrderItemController {
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ProductService productService;
	@Autowired
	ShopService shopService;
	@Autowired
	CouponService couponService;
	
//	@RequestMapping("addToCart")
//	public String addToCart(HttpServletRequest request) {
//		int p_id = Integer.parseInt(request.getParameter("p_id"));
//		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
////		itemnumber = Integer.parseInt(sitemnumber);
//		Member member = (Member) request.getSession().getAttribute("member");
//		OrderItem orderItem =  orderItemService.getItemByP_id(p_id);
//		if(orderItem !=null) {
//			orderItemService.updateItem(orderItem.getItemnumber()+itemnumber, orderItem.getId());
//			return "redirect:showCart";
//		}
//		
//		int s_id = productService.getProductS_id(p_id);
//		OrderItem o = new OrderItem();
//		o.setItemnumber(itemnumber);
//		o.setM_id(member.getId());
//		o.setP_id(p_id);
//		o.setS_id(s_id);
//		orderItemService.addItem(orderItem); bn
//		return "redirect:showCart";
//	}
	
	@RequestMapping("addToCartFromDetail")
	public String addToCartFromDetail(HttpServletRequest request) {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
		Product p = productService.getProductById(p_id);
		int stock = p.getStock();
		if(itemnumber>p.getStock()) {
			request.setAttribute("message","对不起，货物不足！！");
			return "fore/message2";
		}else if(itemnumber<0) {
			request.setAttribute("message","对不起，请输入大于0的整数！");
			return "fore/message2";
		}
		else {
			stock = stock - itemnumber;
			productService.updateStock(stock, p_id);
		}
		Member member = (Member) request.getSession().getAttribute("member");
		OrderItem orderItem =  orderItemService.getItemByP_id(p_id);
		if(orderItem !=null&&orderItem.getM_id()==member.getId()) {
			orderItemService.updateItem(orderItem.getItemnumber()+itemnumber, orderItem.getId());
			return "redirect:showCart1";
		}
		
		int s_id = productService.getProductS_id(p_id);
		OrderItem o = new OrderItem();
		o.setItemnumber(itemnumber);
		o.setM_id(member.getId());
		o.setP_id(p_id);
		o.setS_id(s_id);
		orderItemService.addItem(o);
		return "redirect:showCart1";
	}
	
	@RequestMapping("showCart1")
	public String showCart1(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		List<Integer> s_ids = orderItemService.getItemS_id();
		Map<Integer,List<OrderItem>> shop_items = new HashMap();
		Map<Integer,Shop> s_id_shop = new HashMap();
		Map<Integer,Double> sumPrice_si_id = new HashMap();
		Map<Integer,Coupon> s_id_coupon = new HashMap();
		for(int s_id:s_ids) {
			List<OrderItem> old_items = orderItemService.getItemsByS_id(s_id);
			List<OrderItem> items = new ArrayList<>();
			for(int i=0;i<old_items.size();i++) {
				if(old_items.get(i).getM_id().equals(member.getId()))
					items.add(old_items.get(i));
			}
			double sumPrice = 0;
			for(OrderItem o : items) {
				o.setProduct(productService.getProductById(o.getP_id()));
				sumPrice = o.getProduct().getPrice()*o.getItemnumber() + sumPrice;
			}
			Coupon coupon = couponService.getCouponByS_id(s_id);
			if(coupon != null) {
				if(sumPrice>coupon.getLimitPrice()) {
					sumPrice = sumPrice - coupon.getReducePrice();
				}
				s_id_coupon.put(s_id, coupon);
			}
			sumPrice_si_id.put(s_id, sumPrice);
			s_id_shop.put(s_id, shopService.getShopById(s_id));
			shop_items.put(s_id, items);
		}
		request.getSession().setAttribute("s_id_coupon", s_id_coupon);
		request.getSession().setAttribute("sumPrice_si_id", sumPrice_si_id);
		request.getSession().setAttribute("s_id_shop", s_id_shop);
		request.getSession().setAttribute("shop_items",shop_items);
		return "back/showCart1";
	}
	
	@RequestMapping("showCart2")
	public String showCart2(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		List<Integer> s_ids = orderItemService.getItemS_id();
		Map<Integer,List<OrderItem>> shop_items = new HashMap();
		Map<Integer,Shop> s_id_shop = new HashMap();
		Map<Integer,Double> sumPrice_si_id = new HashMap();
		Map<Integer,Coupon> s_id_coupon = new HashMap();
		for(int s_id:s_ids) {
			List<OrderItem> old_items = orderItemService.getItemsByS_id(s_id);
			List<OrderItem> items = new ArrayList<>();
			for(int i=0;i<old_items.size();i++) {
				if(old_items.get(i).getM_id().equals(member.getId()))
					items.add(old_items.get(i));
			}
			double sumPrice = 0;
			for(OrderItem o : items) {
				o.setProduct(productService.getProductById(o.getP_id()));
				sumPrice = o.getProduct().getPrice()*o.getItemnumber() + sumPrice;
			}
			Coupon coupon = couponService.getCouponByS_id(s_id);
			if(coupon != null) {
				if(sumPrice>coupon.getLimitPrice()) {
					sumPrice = sumPrice - coupon.getReducePrice();
				}
				s_id_coupon.put(s_id, coupon);
			}
			sumPrice_si_id.put(s_id, sumPrice);
			s_id_shop.put(s_id, shopService.getShopById(s_id));
			shop_items.put(s_id, items);
		}
		request.getSession().setAttribute("s_id_coupon", s_id_coupon);
		request.getSession().setAttribute("sumPrice_si_id", sumPrice_si_id);
		request.getSession().setAttribute("s_id_shop", s_id_shop);
		request.getSession().setAttribute("shop_items",shop_items);
		return "back/showCart2";
	}
	
	@RequestMapping("deleteItem1/{id}")
	public String deleteItem1(@PathVariable("id")Integer id) {
		//获取欲删除订单项
		OrderItem o = orderItemService.getItemById(id);
		//获取该订单项对应的商品的ID
		Product p =  productService.getProductById(o.getP_id());
		//恢复商品的库存量
		int stock = p.getStock()+o.getItemnumber();
		//数据库中更新商品
		productService.updateStock(stock,o.getP_id());
		//数据库中删除该订单项
		orderItemService.deleteItem(id);
		
		return "redirect:/showCart1";
	}
	
	@RequestMapping("deleteItem2/{id}")
	public String deleteItem2(@PathVariable("id")Integer id) {
		OrderItem o = orderItemService.getItemById(id);
		Product p =  productService.getProductById(o.getP_id());
		int stock = p.getStock()+o.getItemnumber();
		productService.updateStock(stock,o.getP_id());
		orderItemService.deleteItem(id);
		return "redirect:/showCart2";
	}
	
	@RequestMapping("UpdateCart1")
	public String UpdateCart1(HttpServletRequest request) {
		int id  = Integer.parseInt(request.getParameter("id"));
		int itemnumber  = Integer.parseInt(request.getParameter("itemnumber"));
		orderItemService.updateItem(itemnumber, id);
		OrderItem thisitem = orderItemService.getItemById(id);
		int s_id = thisitem.getS_id();
		List<OrderItem> items = orderItemService.getItemsByS_id(s_id);
		double sumPrice = 0;
		for(OrderItem o : items) {
			o.setProduct(productService.getProductById(o.getP_id()));
			sumPrice = o.getProduct().getPrice()*o.getItemnumber() + sumPrice;
		}
		Map<Integer,Double> sumPrice_si_id =  (Map<Integer,Double>) request.getSession().getAttribute("sumPrice_si_id");
		sumPrice_si_id.put(s_id,sumPrice);
		request.getSession().setAttribute("sumPrice_si_id", sumPrice_si_id);
		return "redirect:/showCart1";
	}
	
	@RequestMapping("UpdateCart2")
	public String UpdateCart2(HttpServletRequest request) {
		int id  = Integer.parseInt(request.getParameter("id"));
		int itemnumber  = Integer.parseInt(request.getParameter("itemnumber"));
		orderItemService.updateItem(itemnumber, id);
		OrderItem thisitem = orderItemService.getItemById(id);
		int s_id = thisitem.getS_id();
		List<OrderItem> items = orderItemService.getItemsByS_id(s_id);
		double sumPrice = 0;
		for(OrderItem o : items) {
			o.setProduct(productService.getProductById(o.getP_id()));
			sumPrice = o.getProduct().getPrice()*o.getItemnumber() + sumPrice;
		}
		
		Map<Integer,Double> sumPrice_si_id =  (Map<Integer,Double>) request.getSession().getAttribute("sumPrice_si_id");
		sumPrice_si_id.put(s_id,sumPrice);
		request.getSession().setAttribute("sumPrice_si_id", sumPrice_si_id);
		return "redirect:/showCart2";
	}
}
