package com.orderinventory.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.orderinventory.entities.Product;
import com.orderinventory.repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServices implements ProductServiceInterface{
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	public Product addProduct(Product product) {
		return repo.saveAndFlush(product);
	}
	
	public Product updateProduct(Product product) {
		Product prod = repo.findById(product.getProductId()).orElse(null);
		prod.setProductName(product.getProductName());
		prod.setBrand(product.getBrand());
		prod.setColour(product.getColour());
		prod.setUnitPrice(product.getUnitPrice());
		prod.setSize(product.getSize());
		prod.setRating(product.getRating());
		return repo.save(prod);
	}
	
	public String deleteProductById(int id) {
		Product product = repo.findById(id).orElse(null);
		if (product==null) {
			return "Record is not deleted";
		}
		repo.deleteById(id);
		return "deleted";
	}
	
	public List<Product> getProductsByName(String productName){
		return repo.findByProductName(productName);
	}
	
	public List<Product> getProductsByUnitPriceRange(BigDecimal min, BigDecimal max){
		return repo.findByUnitPriceBetween(min, max);
		
	}
	
	public List<Product> getSortedProductsByField(Sort sort){
		return repo.findAll(sort);
	}
	
	public List<Product> getProductsByBrand(String brand){
		return repo.findByBrand(brand);
	}
}
