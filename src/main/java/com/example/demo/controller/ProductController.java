package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @PostMapping("/addproduct")
	 public Product addProduct(@RequestBody Product product) 
	 {
		return  productService.saveProduct(product);
	 }
	 
	 @PostMapping("/addlistproduct")
	 public List<Product> addProducts(@RequestBody List<Product> prdt){
		 return productService.listProduct(prdt);
		 
	 }
	 
	 @GetMapping("/products")
	 public List<Product> findAllProduct(){
		return productService.getProducts();
	 }
	
	 @GetMapping("/productById/{id}")
	 public Optional<Product> findProductById(@PathVariable Long id) {
		 return productService.getproduct(id);
		 
	 }
	 
	 @GetMapping("/productByName/{name}")
	 public Product findProductByName(@PathVariable  String name) {
		 return productService.getProductByName(name);
	 }
	 
	 @DeleteMapping("/Delproduct/{id}")
	 public String deleteProduct(@PathVariable Long id) {
		return productService.delProduct(id);
		
	 }
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) throws Exception 
	 {
		
		return  productService.updateProduct(product);
	 }
	 
	
	 
	 

}
