package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.OrderItemMapper;
import cn.imust.pojo.OrderItem;
import cn.imust.pojo.RankShop;
import cn.imust.service.OrderItemService;


@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	OrderItemMapper orderItemMapper;
	
	
	@Override
	public void addItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItemMapper.addItem(orderItem);
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		orderItemMapper.deleteItem(id);
	}

	@Override
	public void updateItem(int itemnumber, int id) {
		// TODO Auto-generated method stub
		orderItemMapper.updateItem(itemnumber, id);
	}

	@Override
	public int getItemsP_id(int id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemsP_id(id);
	}

	@Override
	public List<OrderItem> getItemsByM_id(String m_id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemsByM_id(m_id);
	}

	@Override
	public OrderItem getItemById(int id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemById(id);
	}

	@Override
	public OrderItem getItemByP_id(int p_id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemByP_id(p_id);
	}

	@Override
	public List<OrderItem> getItemsByS_id(int s_id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemsByS_id(s_id);
	}

	@Override
	public List<Integer> getItemS_id() {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemS_id();
	}

	@Override
	public List<RankShop> rankShop() {
		// TODO Auto-generated method stub
		return orderItemMapper.rankShop();
	}

	@Override
	public void setItemO_id(String o_id, int id) {
		orderItemMapper.setItemO_id(o_id, id);
	}

	@Override
	public List<OrderItem> getItemsByO_id(String o_id) {
		// TODO Auto-generated method stub
		return orderItemMapper.getItemsByO_id(o_id);
	}
	
	
}
