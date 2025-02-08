package com.gc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.Entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByProductName(String product_name); 

}
