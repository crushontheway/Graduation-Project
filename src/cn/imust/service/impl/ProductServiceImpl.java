package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.ProductMapper;
import cn.imust.pojo.Product;
import cn.imust.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.addProduct(product);
	}

	@Override
	public List<Product> listShopProduct(int s_id){
		// TODO Auto-generated method stub
		return productMapper.listShopProduct(s_id);
	}

	@Override
	public int updateProduct(Product product,int p_id) {
		// TODO Auto-generated method stub
		return productMapper.updateProduct(product,p_id);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productMapper.deleteProduct(id);
	}

	@Override
	public int getProductId(String productname, int s_id) {
		// TODO Auto-generated method stub
		return productMapper.getProductId(productname, s_id);
	}

	@Override
	public Product getProductById(int p_id) {
		// TODO Auto-generated method stub
		return productMapper.getProductById(p_id);
	}

	@Override
	public List<Product> getProductByCategory(int c_id) {
		// TODO Auto-generated method stub
		return productMapper.getProductByCategory(c_id);
	}

	@Override
	public List<Product> getProductByS_id(int s_id) {
		// TODO Auto-generated method stub
		return productMapper.getProductByS_id(s_id);
	}

	@Override
	public List<Product> getProductByKeyword(String keyWord) {
		return productMapper.getProductByKeyword(keyWord);
	}

	@Override
	public int getProductS_id(int id) {
		// TODO Auto-generated method stub
		return productMapper.getProductS_id(id);
	}


	@Override
	public void updateStock(int stock, int id) {
		productMapper.updateStock(stock, id);
		
	}

	@Override
	public int checkCount(int s_id) {
		// TODO Auto-generated method stub
		return productMapper.checkCount(s_id);
	}
	
	
}
