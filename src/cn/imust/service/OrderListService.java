package cn.imust.service;

import java.sql.Timestamp;
import java.util.List;

import cn.imust.pojo.OrderList;

public interface OrderListService {
	void addOrderList(OrderList orderList);
	OrderList getOrderListById(String id);
	OrderList getOrderListByM_id(String m_id);
	void deleteOrderList(String id);
	void updateListStatus(int status,String id);
	void updateListPayDate(Timestamp payDate,String id);
	void updateListDeliveryDate(Timestamp deliveryDate,String id);
	void updateListComfirmDate(Timestamp comfirmDate,String id);
	List<OrderList> getHistoryOrderListByM_id(String m_id);
}
