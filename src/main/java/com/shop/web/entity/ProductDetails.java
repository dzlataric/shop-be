package com.shop.web.entity;

import java.time.LocalDate;

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
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "productDetails", cascade = CascadeType.ALL)
	private Product product;  
	
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

	
}
