package com.gc.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor

public class Address extends BaseEntity{
	@Column(length=100)
	private String address_line1;
	@Column(length=100)
	private String address_line3;
	@Column(length=50)
	private String city;
	@Column(length=100)
	private String State;
	@Column(length=100)
	private Long pincode;
}
