package com.gc.service;

import java.util.List;

import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;

public interface ProductService {
	
	 ApiResponse addProduct(ProductDto product);
	 ApiResponse deleteProduct(Long id);
	 ApiResponse updateStock(Long Id,int stock);
	 List<ProductDto> viewProduct();
}
