package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
//	private Long id;

	public Product saveProduct(Product product) { // post
		return productRepository.save(product);
	}

	public List<Product> listProduct(List<Product> products) { // post
		return productRepository.saveAll(products);

	}

	// get
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getproduct(Long id2) { // get
		return productRepository.findById(id2);

	}

	public Product getProductByName(String name) { // get
		return productRepository.findByName(name);
	}

	public String delProduct(Long id) { // delete
		productRepository.deleteById(id);
		return "product deleted"  + id;

	}

	public Product updateProduct(Product prod) throws Exception {
		if(prod.getId()!=null) {
			return productRepository.save(prod);
			
		}
		throw new Exception("please enter id to update");
	
		
		
		
	}

	
	//public Optional<Product> getProductById(Long id) {
		//productRepository.getById(id);
		// TODO Auto-generated method stub
		//return null;}
	

}
