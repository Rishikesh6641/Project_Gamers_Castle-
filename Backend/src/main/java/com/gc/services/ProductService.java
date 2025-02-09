package com.gc.services;

import java.util.List;

import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;

public interface ProductService {

	ApiResponse addProduct(ProductDto dto);
	ApiResponse deleteProduct(Long id);
	ApiResponse updateProduct(Long id,ProductDto dto);
	List<ProductDto> viewProduct();
}
