package cn.imust.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.OrderListMapper;
import cn.imust.pojo.OrderList;
import cn.imust.service.OrderListService;

@Service
public class OrderListServiceImpl implements OrderListService {
	
	@Autowired
	OrderListMapper orderListMapper;
	
	@Override
	public void addOrderList(OrderList orderList) {
		// TODO Auto-generated method stub
		orderListMapper.addOrderList(orderList);
	}

	@Override
	public OrderList getOrderListById(String id) {
		// TODO Auto-generated method stub
		return orderListMapper.getOrderListById(id);
	}

	@Override
	public OrderList getOrderListByM_id(String m_id) {
		// TODO Auto-generated method stub
		return orderListMapper.getOrderListByM_id(m_id);
	}

	@Override
	public void deleteOrderList(String id) {
		// TODO Auto-generated method stub
		orderListMapper.deleteOrderList(id);
	}

	@Override
	public void updateListStatus(int status, String id) {
		// TODO Auto-generated method stub
		orderListMapper.updateListStatus(status, id);
	}

	@Override
	public void updateListPayDate(Timestamp payDate, String id) {
		// TODO Auto-generated method stub
		orderListMapper.updateListPayDate(payDate, id);
	}

	@Override
	public void updateListDeliveryDate(Timestamp deliveryDate, String id) {
		// TODO Auto-generated method stub
		orderListMapper.updateListDeliveryDate(deliveryDate, id);
	}

	@Override
	public void updateListComfirmDate(Timestamp comfirmDate, String id) {
		// TODO Auto-generated method stub
		orderListMapper.updateListComfirmDate(comfirmDate, id);
	}

	@Override
	public List<OrderList> getHistoryOrderListByM_id(String m_id) {
		// TODO Auto-generated method stub
		return orderListMapper.getHistoryOrderListByM_id(m_id);
	}
	
	
	
	
}
