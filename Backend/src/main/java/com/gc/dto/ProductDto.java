package com.gc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

	private String name;
	private String description;
	private Long price;
	
	public ProductDto(String name, String description, Long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
}
