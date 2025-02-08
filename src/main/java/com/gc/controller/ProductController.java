package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.ProductDto;
import com.gc.service.ProductService;

@RestController
@RequestMapping("/gc/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(service.addProduct(productDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.deleteProduct(id));
	}
	
	@PatchMapping("/updateStock/{id}/{stock}")
	public ResponseEntity<?> updateStock(@PathVariable Long id, @PathVariable int stock){
		//int stock=Integer.parseInt(s);
		return ResponseEntity.ok(service.updateStock(id, stock));
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(service.viewProduct());
	}
}
