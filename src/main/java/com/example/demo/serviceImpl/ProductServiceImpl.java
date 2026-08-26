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

}
