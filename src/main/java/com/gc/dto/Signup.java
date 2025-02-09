package com.gc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gc.Entities.Address;
import com.gc.Entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Signup {
	
	 @JsonProperty(access = Access.READ_ONLY) 
	    private Long id;

	    @NotBlank(message = "First Name is required")
	    private String name; 

	    private String lastName; 

	    @NotBlank(message = "Phone number is required")
	    private String phoneNo; 

	    @Email(message = "Invalid Email Address")
	    private String email;

	    private Address address; 
	    @JsonProperty(access = Access.WRITE_ONLY) 
	    private String password;

	    private Role role; 

	    public Signup(String name, String lastName, String phoneNo, String email, String password, Role role, Address address) {
	        this.name = name;
	        this.lastName = lastName;
	        this.phoneNo = phoneNo;
	        this.email = email;
	        this.password = password;
	        this.role = role;
	        this.address = address;
	    }

}
