package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Boolean saveProduct(Product product) {
		Product p = productRepo.save(product);
		return p.getPid() != null;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public boolean deleteProduct(Integer pid) {
		if(productRepo.existsById(pid)) {
			productRepo.deleteById(pid);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		if(productRepo.existsById(product.getPid())) {
			productRepo.save(product);
			return true;
		}
		
		return false;
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepo.findById(id).orElse(null);
	}

}
