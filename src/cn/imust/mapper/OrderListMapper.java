package cn.imust.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.OrderList;

public interface OrderListMapper {
	void addOrderList(OrderList orderList);
	OrderList getOrderListById(String id);
	OrderList getOrderListByM_id(String m_id);
	void deleteOrderList(String id);
	void updateListStatus(@Param("status")int status,@Param("id")String id);
	void updateListPayDate(@Param("payDate")Timestamp payDate,@Param("id")String id);
	void updateListDeliveryDate(@Param("deliveryDate")Timestamp deliveryDate,@Param("id")String id);
	void updateListComfirmDate(@Param("comfirmDate")Timestamp comfirmDate,@Param("id")String id);
	List<OrderList> getHistoryOrderListByM_id(String m_id);
}
