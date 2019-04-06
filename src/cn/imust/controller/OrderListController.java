package cn.imust.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.imust.pojo.Coupon;
import cn.imust.pojo.Member;
import cn.imust.pojo.OrderItem;
import cn.imust.pojo.OrderList;
import cn.imust.pojo.Shop;
import cn.imust.service.CouponService;
import cn.imust.service.MemberService;
import cn.imust.service.OrderItemService;
import cn.imust.service.OrderListService;
import cn.imust.service.ProductService;
import cn.imust.service.ShopService;

@Controller
public class OrderListController {
	@Autowired
	OrderListService orderListService;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ShopService shopService;
	@Autowired
	CouponService couponService;
	@Autowired
	ProductService productService;
	@Autowired 
	MemberService memberService;
	
	@RequestMapping("addOrderPage1")
	public String addOrderPage1(HttpServletRequest request) {
		int s_id =  Integer.parseInt(request.getParameter("s_id"));
		Map<Integer,List<OrderItem>> sitems = (Map<Integer, List<OrderItem>>) request.getSession().getAttribute("shop_items");
		Map<Integer,Double> sumPrices =  (Map<Integer, Double>) request.getSession().getAttribute("sumPrice_si_id");
		double thisPrice = sumPrices.get(s_id);
		request.setAttribute("s_id", s_id);
		request.getSession().setAttribute("items", sitems.get(s_id));
		request.setAttribute("thisPrice",thisPrice);
		return "back/addOrderPage1";
	}
	
	@RequestMapping("addOrderPage2")
	public String addOrderPage2(HttpServletRequest request) {
		int s_id =  Integer.parseInt(request.getParameter("s_id"));
		Map<Integer,List<OrderItem>> sitems = (Map<Integer, List<OrderItem>>) request.getSession().getAttribute("shop_items");
		Map<Integer,Double> sumPrices =  (Map<Integer, Double>) request.getSession().getAttribute("sumPrice_si_id");
		double thisPrice = sumPrices.get(s_id);
		request.setAttribute("s_id", s_id);
		request.getSession().setAttribute("items", sitems.get(s_id));
		request.setAttribute("thisPrice",thisPrice);
		return "back/addOrderPage2";
	}
	
	@RequestMapping("OrderList1")
	public String addOrderList1(HttpServletRequest request) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		Member member = (Member) request.getSession().getAttribute("member");
		String message = request.getParameter("message");
		String m_id = member.getId();
		Timestamp createDate = new Timestamp(System.currentTimeMillis());
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + 1024;
		int orderstatus = 1;
		OrderList ol = new OrderList();
		ol.setId(id);
		ol.setM_id(m_id);
		ol.setMessage(message);
		ol.setCreateDate(createDate);
		ol.setOrderstatus(orderstatus);
		orderListService.addOrderList(ol);
		List<OrderItem> items = (List<OrderItem>) request.getSession().getAttribute("items");
		for(OrderItem item:items) {
			item.setO_id(id);
			orderItemService.setItemO_id(item.getO_id(), item.getId());
		}
		Map<Integer,Double> sumPrices =  (Map<Integer, Double>) request.getSession().getAttribute("sumPrice_si_id");
		double thisPrice = sumPrices.get(s_id);
		request.getSession().setAttribute("thisPrice",thisPrice);
		request.getSession().setAttribute("shopInf", shopService.getShopById(s_id)); 
		request.getSession().setAttribute("coupon", couponService.getCouponByS_id(s_id));
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList1";
	}
	
	@RequestMapping("OrderList2")
	public String addOrderList2(HttpServletRequest request) {
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		Member member = (Member) request.getSession().getAttribute("member");
		String message = request.getParameter("message");
		String m_id = member.getId();
		Timestamp createDate = new Timestamp(System.currentTimeMillis());
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + 1024;
		int orderstatus = 1;
		OrderList ol = new OrderList();
		ol.setId(id);
		ol.setM_id(m_id);
		ol.setMessage(message);
		ol.setCreateDate(createDate);
		ol.setOrderstatus(orderstatus);
		orderListService.addOrderList(ol);
		List<OrderItem> items = (List<OrderItem>) request.getSession().getAttribute("items");
		for(OrderItem item:items) {
			item.setO_id(id);
			orderItemService.setItemO_id(item.getO_id(), item.getId());
		}
		Map<Integer,Double> sumPrices =  (Map<Integer, Double>) request.getSession().getAttribute("sumPrice_si_id");
		double thisPrice = sumPrices.get(s_id);
		request.getSession().setAttribute("thisPrice",thisPrice);
		request.getSession().setAttribute("shopInf", shopService.getShopById(s_id)); 
		request.getSession().setAttribute("coupon", couponService.getCouponByS_id(s_id));
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList2";
	}
	
	@RequestMapping("payOrderList1")
	public String payOrderList1(HttpServletRequest request) {
		String id = request.getParameter("id");
		orderListService.updateListStatus(2,id);
		Timestamp payDate = new Timestamp(System.currentTimeMillis());
		orderListService.updateListPayDate(payDate,id);
		OrderList ol = orderListService.getOrderListById(id);
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList1";
	}
	
	@RequestMapping("payOrderList2")
	public String payOrderList2(HttpServletRequest request) {
		String id = request.getParameter("id");
		orderListService.updateListStatus(2,id);
		Timestamp payDate = new Timestamp(System.currentTimeMillis());
		orderListService.updateListPayDate(payDate,id);
		OrderList ol = orderListService.getOrderListById(id);
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList2";
	}
	
	@RequestMapping("showUserOrderList")
	public String showUserOrderList(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		List<OrderItem> itemsByM_id = orderItemService.getItemsByM_id(member.getId());
		List<OrderItem> newItemsByM_id = new ArrayList<>();
		for(int i=0;i<itemsByM_id.size();i++) {
			if(itemsByM_id.get(i).getO_id()!=null&&orderListService.getOrderListById(itemsByM_id.get(i).getO_id()).getOrderstatus()!=4)
				newItemsByM_id.add(itemsByM_id.get(i));
		}
		for(OrderItem item:newItemsByM_id) {
			item.setProduct(productService.getProductById(item.getP_id()));
		}
		if(newItemsByM_id.isEmpty()) {
			request.setAttribute("message","暂无订单数据" );
			return "fore/message";
		}
		
		request.getSession().setAttribute("coupon", couponService.getCouponByS_id(newItemsByM_id.get(0).getS_id()));
		request.getSession().setAttribute("shopInf", shopService.getShopById(newItemsByM_id.get(0).getS_id())); 
		request.getSession().setAttribute("items",newItemsByM_id);
		request.getSession().setAttribute("orderlist", orderListService.getOrderListByM_id(member.getId()));
		return "back/OrderList2";
	}
	
	@RequestMapping("showUserHistoryOrderList")
	public String showUserHistoryOrderList(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		List<OrderItem> itemsByM_id = orderItemService.getItemsByM_id(member.getId());
		List<OrderItem> newItemsByM_id = new ArrayList<>();
		for(int i=0;i<itemsByM_id.size();i++) {
			if(itemsByM_id.get(i).getO_id()!=null&&orderListService.getOrderListById(itemsByM_id.get(i).getO_id()).getOrderstatus()==4)
				newItemsByM_id.add(itemsByM_id.get(i));
		}
		if(newItemsByM_id.isEmpty()) {
			request.setAttribute("message","暂无订单数据" );
			return "fore/message";
		}
		
		Map<String,List<OrderItem>> o_id_items = new HashMap<>();
		List<String> o_ids = new LinkedList<String>();
		for(OrderItem oi:newItemsByM_id) {
			if(!o_ids.contains(oi.getId())) {
				o_ids.add(oi.getO_id());
			}
		}
		
		for(String o_id:o_ids) {
			List<OrderItem> thisO_id_items = orderItemService.getItemsByO_id(o_id);
			for(OrderItem item:thisO_id_items) {
				item.setProduct(productService.getProductById(item.getP_id()));
			}
			o_id_items.put(o_id,thisO_id_items);
			System.out.println(o_id+"the list size is "+thisO_id_items.size());
		}
		System.out.println(o_id_items.size());
		
		Map<String,OrderList> m_orderlist = new HashMap<>();
		List<OrderList> m_orderLists = orderListService.getHistoryOrderListByM_id(member.getId());
		
		for(OrderList ol:m_orderLists) {
			m_orderlist.put(ol.getId(), ol);
		}
		
		request.getSession().setAttribute("o_id_items",o_id_items);
		request.getSession().setAttribute("coupon", couponService.getCouponByS_id(newItemsByM_id.get(0).getS_id()));
		request.getSession().setAttribute("shopInf", shopService.getShopById(newItemsByM_id.get(0).getS_id())); 
		request.getSession().setAttribute("items",newItemsByM_id);
		request.getSession().setAttribute("m_orderlist",m_orderlist);
		return "back/OrderHistoryList";
	}
	
	@RequestMapping("confirmOrderList1")
	public String confirmOrderList1(HttpServletRequest request) {
		String id = request.getParameter("id");
		orderListService.updateListStatus(4,id);
		Timestamp comfirmDate = new Timestamp(System.currentTimeMillis());
		orderListService.updateListComfirmDate(comfirmDate, id);
		OrderList ol = orderListService.getOrderListById(id);
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList1";
	}
	
	@RequestMapping("confirmOrderList2")
	public String confirmOrderList2(HttpServletRequest request) {
		String id = request.getParameter("id");
		orderListService.updateListStatus(4,id);
		Timestamp comfirmDate = new Timestamp(System.currentTimeMillis());
		orderListService.updateListComfirmDate(comfirmDate, id);
		OrderList ol = orderListService.getOrderListById(id);
		request.getSession().setAttribute("orderlist",ol);
		return "back/OrderList2";
	}
	
	@RequestMapping("showShopOrderList")
	public String showShopOrderList(HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		List<OrderItem> itemsByS_id = orderItemService.getItemsByS_id(shop.getId());
		List<String> o_ids = new ArrayList<>();
		Map<String,List<OrderItem>> order_items = new HashMap(); 
		Map<String,Member> members = new HashMap();
		Map<String,OrderList> orderLists = new HashMap();
		Map<String,Double> orderPrice = new HashMap();
		for(OrderItem item:itemsByS_id) {
			if(item.getO_id() !=null) {
				o_ids.add(item.getO_id());
			}
		}
		
		if(o_ids.isEmpty()) {
			request.setAttribute("message", "暂无订单信息");
			return "fore/message";
		}else {
			for(String o_id:o_ids) {
				List<OrderItem> orderItems = orderItemService.getItemsByO_id(o_id);
				double sumPrice = 0;
				for(OrderItem item:orderItems) {
					item.setProduct(productService.getProductById(item.getP_id()));
					sumPrice = item.getProduct().getPrice()*item.getItemnumber() + sumPrice;
				}
				Coupon coupon = couponService.getCouponByS_id(shop.getId());
				if(coupon != null) {
					if(sumPrice>coupon.getLimitPrice()) {
						sumPrice = sumPrice - coupon.getReducePrice();
					}
				}
				orderPrice.put(orderItems.get(0).getM_id(), sumPrice);
				members.put(orderItems.get(0).getM_id(), memberService.getMemberByid(orderItems.get(0).getM_id()));
				order_items.put(orderItems.get(0).getM_id(),orderItems);
				orderLists.put(orderItems.get(0).getM_id(),orderListService.getOrderListById(orderItems.get(0).getO_id()));
			}
		}
		request.getSession().setAttribute("orderPrice", orderPrice);
		request.getSession().setAttribute("orderLists", orderLists);
		request.getSession().setAttribute("members", members);
		request.getSession().setAttribute("order_items", order_items);
		return "fore/showShopOrderList";
	}
	
	@RequestMapping("deliveryOrder")
	public String deliveryOrder(HttpServletRequest request) {
		String id = request.getParameter("id");
		orderListService.updateListStatus(3, id);
		Timestamp deliveryDate = new Timestamp(System.currentTimeMillis());
		orderListService.updateListDeliveryDate(deliveryDate, id);
		OrderList ol = orderListService.getOrderListById(id);
		Map<String,OrderList> orderLists = (Map<String, OrderList>) request.getSession().getAttribute("orderLists");
		orderLists.put(ol.getM_id(), ol);
		request.getSession().setAttribute("orderLists", orderLists);
		return "fore/showShopOrderList";
	}
}
