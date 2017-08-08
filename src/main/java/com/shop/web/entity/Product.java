package com.shop.web.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "COUNTRY_OF_ORIGIN", unique = false, nullable = false)
	private String countryOfOrigin;
	
	@Column(name = "MANUFACTURER", unique = false, nullable = false)
	private String manufacturer;
	
	@Column(name = "PRICE", unique = false, nullable = false)
	private Double price;
	
	@Column(name = "PRODUCTION_YEAR", unique = false, nullable = false)
	private Long productionYear;
	
	@Column(name = "EXPIRY_DATE", unique = false, nullable = true)
	private LocalDate expiryDate;
	
	@Column(name = "IMAGE", unique = false, nullable = true)
	private byte[] image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;
	
}
