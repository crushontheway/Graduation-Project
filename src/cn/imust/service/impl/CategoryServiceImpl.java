package cn.imust.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.CategoryMapper;
import cn.imust.pojo.Category;
import cn.imust.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list(){
		return categoryMapper.list();
	}
	
	public String getCnameById(int c_id) {
		return categoryMapper.getCnameById(c_id);
	}
}
