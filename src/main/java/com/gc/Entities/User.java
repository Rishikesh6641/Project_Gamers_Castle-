package com.gc.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table()
@Getter
@Setter
@NoArgsConstructor

public class User extends BaseEntity{
	
	@Column(length = 50 ,name = "first_name")
	private String name;
	@Column(length = 50 ,name = "last_name")
	private String lastName;
	@Column(length = 10,name = "phone_no")
	private String phoneNo;
	@Column(nullable = false , length = 50)
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address-id")
	private Address address;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(length = 500)
	private String password;
}
