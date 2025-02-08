package com.gc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.Entities.Product;
import com.gc.Exception.ResourceNotFoundException;
import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;
import com.gc.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ProductRepository repo;
	
	@Override
	public ApiResponse addProduct(ProductDto productDto) {
		Product product= mapper.map(productDto, Product.class);
		repo.save(product);
		return new ApiResponse("Product Added Successfully "+product.getId());
	}

	@Override
	public ApiResponse deleteProduct(Long id) {
		if(!repo.existsById(id))
		{
			throw new ResourceNotFoundException("No Such product Found");
		}
		
		repo.deleteById(id);
		return new ApiResponse("Deleted Product Succesfully");
		
	}
	
	@Override
	public List<ProductDto> viewProduct() {
		
		List<Product> data=repo.findAll();
		List<ProductDto> dtoList=data.stream()
				.map(product -> mapper.map(product,ProductDto.class))
				.toList();
		return dtoList;
	}

	@Override
	public ApiResponse updateStock(Long id, int stock) {
		
//		Optional<Product> p=repo.findByProductName(product_name);
//		Product product = p.orElseThrow(()->new ResourceNotFoundException("No Such Product"));
//		product.setStock(product.getStock()+stock);
		Optional<Product> p= repo.findById(id);
		Product product=p.orElseThrow(()->new ResourceNotFoundException("No Such Product"));
		product.setStock(product.getStock()+stock);
		repo.save(product);
		return new ApiResponse("Stock Updated Succefully....");
	}
}
