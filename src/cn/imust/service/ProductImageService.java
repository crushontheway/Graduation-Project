package cn.imust.service;

import cn.imust.pojo.ProductImage;

public interface ProductImageService {
	void add(ProductImage pi);
	ProductImage get(int id);
	void delete(int p_id);
}
