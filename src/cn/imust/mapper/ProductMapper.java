package cn.imust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Product;

public interface ProductMapper {
	void addProduct(Product product);
	List<Product> listShopProduct(int s_id);
	int updateProduct(@Param("p") Product product,@Param("p_id") int p_id);
	int deleteProduct(int id);
	int getProductId(@Param("productname")String productname,@Param("s_id")int s_id);
	Product getProductById(int p_id);
	List<Product> getProductByCategory(int c_id);
	List<Product> getProductByS_id(int s_id);
	List<Product> getProductByKeyword(@Param("keyWord") String keyWord);
	int getProductS_id(@Param("id") int id);
	void updateStock(@Param("stock")int stock,@Param("id")int id);
	int checkCount(@Param("s_id")int s_id);
}
