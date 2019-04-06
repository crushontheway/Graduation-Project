package cn.imust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Shop;

public interface ShopMapper {
	List<Shop> list();
	void add(Shop shop);
	int isExist(String username);
	Shop login(@Param("username") String username,@Param("password")String password);
	int update(Shop shop);
	int getShopidByUsername(String username);
	Shop getShopById(@Param("s_id") int s_id);
}
