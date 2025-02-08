package com.gc.Entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor

public class Order extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_Id;
	@Column
	private LocalDateTime OrderDate;
	@Column(nullable = false )
	private Double total_Amount;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToMany
	//@JoinColumn(name = "order_details_id")
	private List<OrderDetails> order_Details;
}