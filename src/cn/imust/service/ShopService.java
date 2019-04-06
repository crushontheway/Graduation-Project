package cn.imust.service;

import java.util.List;
import cn.imust.pojo.Shop;

public interface ShopService {
	List<Shop> list();
	void add(Shop shop);
	Boolean isExist(String username);
	Shop login(String username,String password);
	int update(Shop shop);
	int getShopidByUsername(String username);
	Shop getShopById(int s_id);
}
