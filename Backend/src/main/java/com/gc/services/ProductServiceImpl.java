package com.gc.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;
import com.gc.entity.Product;
import com.gc.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse addProduct(ProductDto dto) {
		Product product=mapper.map(dto,Product.class);
		productRepository.save(product);
		return new ApiResponse("Added Product successfully "+product.getId());
	}

	@Override
	public ApiResponse deleteProduct(Long id) {
		if(productRepository.existsById(id))
		{
			productRepository.deleteById(id);
			return new ApiResponse("Deleted product succefully...");
		}
		return new ApiResponse("Not able to delete the product");
	}

	@Override
	public ApiResponse updateProduct(Long id, ProductDto dto) {
		Product product=mapper.map(dto,Product.class);
		if(productRepository.existsById(id)) {
			product.setId(id);
			product.setCreated_on(LocalDate.now());
			productRepository.save(product);
			return new ApiResponse("updated product succefully...");
		}
		return new ApiResponse("cannot update the product");
	}

	@Override
	public List<ProductDto> viewProduct() {
		return productRepository
				.findAll()
				.stream()
				.map(product -> mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

}
