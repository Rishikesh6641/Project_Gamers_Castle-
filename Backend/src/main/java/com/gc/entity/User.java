package com.gc.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends BaseEntity {
	
	@Column(length = 50,name="first_name")
	private String firstName;
	@Column(length = 50,name="last_name")
	private String lastName;
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Role role;
	private String contact;
	@OneToMany(mappedBy = "cust_id",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order> orders =new ArrayList<>();
	@Column(unique = true,length = 100)
	private String email;
	@Column(length = 500, nullable = false)
	private String password;
	private LocalDate dob;
}
