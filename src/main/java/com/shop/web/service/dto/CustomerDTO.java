package com.shop.web.service.dto;

import com.shop.web.util.CustomerType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private CustomerType type;
	private String address;
	private String city;
	private String country;
	private String gender;
}
