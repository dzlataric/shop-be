package com.shop.web.service.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Long id;
	private String name;
	private Long stock;
	private String countryOfOrigin;
	private String manufacturer;
	private Double price;
	private Long productionYear;
	private LocalDate expiryDate;
	private Long categoryId;
	private Set<Long> reviewIds;
	
}
