package cn.imust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.ComplainMapper;
import cn.imust.pojo.Complain;
import cn.imust.service.ComplainService;

@Service
public class ComplainServiceImpl implements ComplainService {
	@Autowired
	ComplainMapper complainMapper;
	
	@Override
	public void addComplain(Complain complain) {
		// TODO Auto-generated method stub
		complainMapper.addComplain(complain);
	}

}
