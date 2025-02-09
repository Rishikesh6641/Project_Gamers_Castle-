package com.gc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends BaseEntity{
	
	@Column(length = 50,name = "prod_name")
	private String name;
	@Column(length = 500)
	private String description;
	private Long price;
}
