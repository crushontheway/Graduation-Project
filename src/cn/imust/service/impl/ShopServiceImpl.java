package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.ShopMapper;
import cn.imust.pojo.Shop;
import cn.imust.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	ShopMapper shopMapper;
	
	public List<Shop> list(){
		return shopMapper.list();
	}
	
	public void add(Shop shop) {
		shopMapper.add(shop);
	}
	
	public Boolean isExist(String username) {
		// TODO Auto-generated method stub
		int isExist = shopMapper.isExist(username);
		if(isExist!=0)
			return true;
		return false;
	}

	@Override
	public Shop login(String username, String password) {
		// TODO Auto-generated method stub
		return shopMapper.login(username, password);
	}

	@Override
	public int update(Shop shop) {
		return shopMapper.update(shop);
	}

	@Override
	public int getShopidByUsername(String username) {
		// TODO Auto-generated method stub
		return shopMapper.getShopidByUsername(username);
	}

	@Override
	public Shop getShopById(int s_id) {
		// TODO Auto-generated method stub
		return shopMapper.getShopById(s_id);
	}
	
	
}
