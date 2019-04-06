package cn.imust.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Category;

public interface CategoryService {
	List<Category> list();
	String getCnameById(@Param("c_id") int c_id);
}
