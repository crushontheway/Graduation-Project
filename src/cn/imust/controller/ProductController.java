package cn.imust.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.imust.mapper.ProductMapper;
import cn.imust.pojo.Category;
import cn.imust.pojo.Product;
import cn.imust.pojo.Shop;
import cn.imust.service.CategoryService;
import cn.imust.service.ProductImageService;
import cn.imust.service.ProductService;
import cn.imust.service.ShopService;
import cn.imust.utils.Page;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ShopService shopService;
	@Autowired
	ProductImageService productImageService ;
	
	@RequestMapping("addProductPage")
	public String addProductPage(Map<String,Object> map,HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		List<Category> categorys = categoryService.list();
		int s_id = shopService.getShopidByUsername(shop.getUsername());
		map.put("s_id", s_id);
		map.put("categorys", categorys);
		map.put("product",new Product());
		return "back/addProductPage";
	}
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String addProduct(Product product,HttpServletRequest request) {
		if(product.getRecommend()==3) {
			if(productService.checkCount(product.getS_id())>=3)
				request.setAttribute("message", "对不起，每家商店仅能设置3个极力推荐的商品!");
			return "fore/message";
		}
		productService.addProduct(product);
		request.setAttribute("message", "商品添加成功!!");
		return "fore/message";
	}
	
	@RequestMapping("listProduct")
	public String listProduct(Page page,HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		int s_id = shopService.getShopidByUsername(shop.getUsername());
		PageHelper.offsetPage(page.getStart(),5);
		List<Product> products =  productService.listShopProduct(s_id);
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(Product p:products) {
			int p_id = productService.getProductId(p.getProductname(), s_id);
			map.put(p.getProductname(),p_id );
		}
		int total = (int) new PageInfo<>(products).getTotal();
		page.caculateLast(total);
		request.setAttribute("p_ids", map);
        request.setAttribute("products",products);
		return "back/listProductPage";
	}
	
	@RequestMapping("deleteProduct/{p_id}")
	public String deleteProduct(@PathVariable("p_id")Integer p_id,HttpServletRequest request) {
		productImageService.delete(p_id);
		productService.deleteProduct(p_id);
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		request.getSession().setAttribute("shop", shop);
		return "redirect:/listProduct";
	}
	
	@RequestMapping("updateProductPage/{p_id}")
	public String updateProductPage(@PathVariable("p_id")int p_id,Map<String,Object> map,HttpServletRequest request) {
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		List<Category> categorys = categoryService.list();
		int s_id = shopService.getShopidByUsername(shop.getUsername());
		Product p = productService.getProductById(p_id);
		map.put("p_id",p_id);
		map.put("product",p);
		map.put("s_id", s_id);
		map.put("categorys", categorys);
		return "back/updateProductPage";
	}
	
	@RequestMapping(value="updateProduct",method=RequestMethod.POST)
	public String updateProduct(Product product,HttpServletRequest request) {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		productService.updateProduct(product,p_id);
		return "redirect:/listProduct";
	}
	
	@RequestMapping("getProductByType")
	public String getProductByType(HttpServletRequest request) {
		List<Product> flowers = productService.getProductByCategory(1);
		List<Product> greenplants = productService.getProductByCategory(2);
		List<Product> succulents = productService.getProductByCategory(3);
		List<Product> tools = productService.getProductByCategory(4);
		List<Product> fertilizers = productService.getProductByCategory(5);
		request.setAttribute("flowers",flowers);
		request.setAttribute("greenplants",greenplants);
		request.setAttribute("succulents",succulents);
		request.setAttribute("tools",tools);
		request.setAttribute("fertilizers",fertilizers);
		return "fore/listProductsByType";
	}
	
	@RequestMapping("searchProduct")
	public String searchProduct(HttpServletRequest request){
		String keyWord = request.getParameter("keyWord");
		if(keyWord=="") {
			request.setAttribute("message", "关键字不允许为空！！");
			return "fore/message2";
		}
		List<Product> searchResult = productService.getProductByKeyword(keyWord);
		request.setAttribute("searchResult", searchResult);
		return "fore/listSearchResult";
	}
	
	@RequestMapping("getThisProduct/{p_id}")
	public String getThisProduct(@PathVariable("p_id")int p_id,HttpServletRequest request,HttpServletResponse response){
		Product p = productService.getProductById(p_id);
		request.setAttribute("product", p);
		Shop s = shopService.getShopById(p.getS_id());
		request.setAttribute("shop", s);
		String firstHistory = makeHistory(request,p_id+"");
		response.addHeader("Set-Cookie", "firshtHistory="+firstHistory+";");
		request.getSession().setAttribute("firstHistory", firstHistory);
		return "fore/showThisProduct";
	}
	
private String makeHistory(HttpServletRequest request, String id) {
		String firstHistory = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("firshtHistory")){
				firstHistory = cookies[i].getValue();
			}
		}
		
		if(firstHistory==null){
			return id;
		}
		
		List l = Arrays.asList(firstHistory.split("\\_")); 
		LinkedList<String> list = new LinkedList();
		list.addAll(l);
		
		if(list.contains(id)){
			list.remove(id);
			list.addFirst(id);
		}else{
			if(list.size()>=5){
				list.removeLast();
				list.addFirst(id);
			}else{
				list.addFirst(id);
			}
		}
		
		StringBuffer sb = new StringBuffer();  
		for(String lid: list){
			sb.append(lid + "_");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	@RequestMapping("getRecentCheck")
	public String getRecentCheck(HttpServletRequest request,HttpServletResponse response) {
			String secondHistory = (String) request.getSession().getAttribute("firstHistory");
			String productHistory = null;
			
			if(secondHistory != null) {
				response.setHeader("Set-Cookie", "secondHistory="+secondHistory+";");	
				Cookie cookies[] = request.getCookies();
				for(int i=0;cookies!=null&&i<cookies.length;i++){
					if(cookies[i].getName().equals("secondHistory")){
						productHistory = cookies[i].getValue();
					}
				}
				
				if(productHistory != null && !productHistory.equals("")) {
					String ids[] = productHistory.split("\\_");
					List<Product> phistory = new LinkedList<>();
					for(String id:ids) {
						 Product p = productService.getProductById(Integer.parseInt(id));
						 phistory.add(p);
					}
					request.setAttribute("phistory", phistory);
				}else {
					request.setAttribute("nophistory", "暂无数据");
				}
			}else {
				request.setAttribute("nophistory", "暂无数据");
			}
		return "fore/recentCheck";
	}
	
	@RequestMapping("listAllTypeItems/{c_id}")
	public String listAllTypeItems(@PathVariable("c_id") Integer c_id,HttpServletRequest request) {
		List<Product> products = productService.getProductByCategory(c_id);
		String catename = categoryService.getCnameById(c_id);
		request.setAttribute("products",products);
		request.setAttribute("catename", catename);
		return "fore/listAllTypeItemsPage";
	}
	
	@RequestMapping("showProductByShop")
	public String showProductByShop(HttpServletRequest request) {
		int s_id = Integer.parseInt(request.getParameter("id"));
		Shop shop = shopService.getShopById(s_id);
		List<Product> products = productService.getProductByS_id(s_id);
		request.setAttribute("shop", shop);
		request.setAttribute("products", products);
		return "fore/listProductByShop";
	}
}
