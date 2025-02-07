package com.gc.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrderDetails")
@Getter
@Setter
@NoArgsConstructor

public class OrderDetails extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orders;
	@OneToOne
	@JoinColumn(name = "id")
	private Product product_Id;
	@Column
	private int qty;
	@Column(nullable = false)
	private Double price;
}
