package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	
	public Boolean saveProduct(Product product);
	public List<Product> getAllProduct();
	
	public boolean deleteProduct(Integer pid);
	public boolean updateProduct(Product product);
	public Product getProductById(Integer id);

}
