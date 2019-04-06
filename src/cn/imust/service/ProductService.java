package cn.imust.service;

import java.util.List;
import cn.imust.pojo.Product;

public interface ProductService {  
	void addProduct(Product product);
	List<Product> listShopProduct(int s_id);
	int updateProduct(Product product,int p_id);
	int deleteProduct(int id);
	int getProductId(String productname,int s_id);
	Product getProductById(int p_id);
	List<Product> getProductByCategory(int c_id);
	List<Product> getProductByS_id(int s_id);
	List<Product> getProductByKeyword(String keyWord);
	int getProductS_id(int id);
	void updateStock(int stock,int id);
	int checkCount(int s_id);
}
