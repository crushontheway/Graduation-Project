package cn.imust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Category;

public interface CategoryMapper {
	List<Category> list();
	String getCnameById(@Param("c_id") int c_id);
}
