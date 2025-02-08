package com.gc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProductDto {
	//@JsonProperty(access=Access.READ_ONLY)
    private String productName;
	private String description;
	private Double price;
	private int stock;
	private String image;
	private String brand;
	public ProductDto(String productName,String description,Double price,int stock, String image,String brand) {
		this.productName=productName;
		this.description=description;
		this.price=price;
		this.stock=stock;
		this.image=image;
		this.brand=brand;
	}
}
