package cn.imust.mapper;

import cn.imust.pojo.ProductImage;

public interface ProductImageMapper {
	void add(ProductImage pi);
	ProductImage get(int id);
	void delete(int p_id);
}
