package cn.imust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.OrderItem;
import cn.imust.pojo.RankShop;

public interface OrderItemMapper {
	void addItem(OrderItem orderItem);
	void deleteItem(int id);
	void updateItem(@Param("itemnumber")int itemnumber,@Param("id")int id);
	int getItemsP_id(int id);
	List<OrderItem> getItemsByM_id(@Param("m_id") String m_id);
	List<OrderItem> getItemsByO_id(@Param("o_id") String o_id);
	OrderItem getItemById(@Param("id") int id);
	OrderItem getItemByP_id(@Param("p_id") int p_id);
	List<OrderItem> getItemsByS_id(@Param("s_id") int s_id);
	List<Integer> getItemS_id();
	List<RankShop> rankShop();
	void setItemO_id(@Param("o_id")String o_id,@Param("id") int id);
	
}
