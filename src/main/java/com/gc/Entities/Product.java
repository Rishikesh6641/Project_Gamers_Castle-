package com.gc.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor

public class Product extends BaseEntity{
	
	@Column(name = "product_name")
	private String productName;
	@Column(length = 500)
	private String description;
	@Column(nullable = false)
	private Double price;
	@Column
	private int stock;
	@Column(nullable = false)
	private String image;
	@Column(length = 100)
	private String brand;
}
