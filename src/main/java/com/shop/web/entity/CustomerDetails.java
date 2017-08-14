package com.shop.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customerDetails", cascade = CascadeType.ALL)
	private Customer customer;  
	
	@Column(name = "FIRST_NAME", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = false)
	private String lastName;
	
	@Column(name = "ADDRESS", unique = false, nullable = true)
	private String address;
	
	@Column(name = "CITY", unique = false, nullable = true)
	private String city;
	
	@Column(name = "COUNTRY", unique = false, nullable = true)
	private String country;
	
	@Column(name = "GENDER", unique = false, nullable = true)
	private String gender;
	
}
