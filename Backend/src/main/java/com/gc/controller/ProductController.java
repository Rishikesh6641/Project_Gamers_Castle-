package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.ProductDto;
import com.gc.services.ProductService;

@RestController
@RequestMapping("/gc")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<?>addProduct(@RequestBody ProductDto dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(dto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducts(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
	}
	
	@GetMapping("/view")
	public ResponseEntity<?> viewProducts(){
		return ResponseEntity.ok(productService.viewProduct());
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, ProductDto dto){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, dto));
	}
}
