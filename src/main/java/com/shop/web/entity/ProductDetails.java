package com.shop.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails implements Serializable {

	private static final long serialVersionUID = -549253874446351271L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "COUNTRY_OF_ORIGIN", unique = false, nullable = false)
	private String countryOfOrigin;

	@Column(name = "MANUFACTURER", unique = false, nullable = false)
	private String manufacturer;

	@Column(name = "PRODUCTION_YEAR", unique = false, nullable = false)
	private Long productionYear;

	@Column(name = "EXPIRY_DATE", unique = false, nullable = true)
	private Date expiryDate;

	@Column(name = "IMAGE", unique = false, nullable = true)
	private String imageUrl;

	@OneToOne(mappedBy = "productDetails")
	private Product product;
	
}
