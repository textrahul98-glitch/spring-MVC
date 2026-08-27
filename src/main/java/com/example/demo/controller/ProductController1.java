package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController1 {

	@Autowired
	private ProductService productService;

	@GetMapping("/") //// http://localhost:8080/
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("productIndex");
		return mv;
	}

	@PostMapping("/product")
	public ModelAndView saveProduct(Product p) {
		ModelAndView mv = new ModelAndView();
		boolean status = productService.saveProduct(p);
		if (status) {
			mv.addObject("smsg", "Product saved");
		} else {
			mv.addObject("fmsg", "Product not save");
		}
		mv.setViewName("productIndex");
		return mv;
	}

	@GetMapping("/Allproduct")
	public ModelAndView GetAllProduct() {
		ModelAndView mv = new ModelAndView();
		List<Product> productList = productService.getAllProduct();
		mv.addObject("plist", productList);
		System.out.println(productList);
		mv.setViewName("productData");
		return mv;
	}

	@GetMapping("/delete/{id}") // http://localhost:8080/delete/5
	public ModelAndView deleteProduct(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		productService.deleteProduct(id);
		mv.addObject("smsg", "Product deleted successfully");
		mv.addObject("plist", productService.getAllProduct());
		mv.setViewName("productData");
		return mv;
	}

	@GetMapping("/edit/{id}") // http://localhost:8080/edit/5
	public ModelAndView editProduct(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Product product = productService.getProductById(id);
		mv.addObject("p", product);
		mv.setViewName("productIndex");
		return mv;
	}

	@PostMapping("/update")
	public String updateProduct(Product p) {
		productService.updateProduct(p);
		return "redirect:/Allproduct";
	}
	
}
