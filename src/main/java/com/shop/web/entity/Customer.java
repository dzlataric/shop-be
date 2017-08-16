package com.shop.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Getter
@Wither
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TYPE", unique = false, nullable = true)
	private String type;

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
