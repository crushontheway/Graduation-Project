package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.ProductImageMapper;
import cn.imust.pojo.ProductImage;
import cn.imust.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	@Autowired
	ProductImageMapper productImageMapper;
	
	
	@Override
	public void add(ProductImage pi) {
		// TODO Auto-generated method stub
		productImageMapper.add(pi);
	}

	@Override
	public ProductImage get(int id) {
		// TODO Auto-generated method stub
		return productImageMapper.get(id);
	}

	@Override
	public void delete(int p_id) {
		productImageMapper.delete(p_id);
		
	}
	
	
	
}
