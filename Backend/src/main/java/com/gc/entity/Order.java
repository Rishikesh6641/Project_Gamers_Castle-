package com.gc.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Order extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "cust_id")
	private User cust_id;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "prod_id")
	private Product prod_id;
	
	private LocalDate order_Date;
	private LocalDateTime order_tm;
	@Column(length = 30)
	private Status stauts;
}
