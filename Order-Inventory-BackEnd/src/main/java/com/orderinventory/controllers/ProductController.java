package com.orderinventory.controllers;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.orderinventory.entities.Product;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.ProductServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductServices prod;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = prod.getAllProducts();
		if (products.isEmpty()) {
			throw new NotFoundException("No products found");
		}
		return ResponseEntity.ok(products);
	}

	@PostMapping
     public ResponseEntity<String> addProduct(@RequestBody Product product) {
		Product check = prod.addProduct(product);
		if (check != null) {
			return new ResponseEntity<String>(" Record Created Successfully",HttpStatus.CREATED) ;
		}
		throw new InvaliddataException("Failed to add product");
	}

	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		Product check = prod.updateProduct(product);
		if (check != null) {
			return new ResponseEntity<String>( "Record Updated Successfully",HttpStatus.OK);
		}
		
		throw new InvaliddataException( " Invalid data founded to update ");
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
	    String result = prod.deleteProductById(id);

	    if (!result.equals("deleted")) {
	        throw new NotFoundException("Product with ID " + id + " not found");
	    }

	    return ResponseEntity.ok("Product deleted successfully");
	}


	@GetMapping("/{productname}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable("productname") String productName) {
		List<Product> products = prod.getProductsByName(productName);

		if (products.isEmpty()) {
			throw new InvaliddataException(" productName not found with the name: " + productName);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/unitprice")
	public ResponseEntity<List<Product>> getProductsByUnitPriceRange(@RequestParam("min") BigDecimal min,
			@RequestParam("max") BigDecimal max) {
		List<Product> products = prod.getProductsByUnitPriceRange(min, max);

		if (products.isEmpty()) {
			throw new NotFoundException(" product Price Not found within the specified unit price range");
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/sort")
	public ResponseEntity<List<Product>> getSortedProductsByField(@RequestParam("field") String field) {
		Sort sort = Sort.by(field);
		List<Product> sortedProducts = prod.getSortedProductsByField(sort);

		if (sortedProducts.isEmpty()) {
			throw new NotFoundException("No products found for sorting field: " + field);
		}
		return ResponseEntity.ok(sortedProducts);
	}
	
	@GetMapping("/brand")
	public ResponseEntity<List<Product>> getProductsByBrand(@RequestParam("brand") String brand){
		List<Product> brands=prod.getProductsByBrand(brand);
		if(brands.isEmpty()) {
			throw new NotFoundException("No products found for brand:"+brand);
		}
		return ResponseEntity.ok(brands);
	}

}
