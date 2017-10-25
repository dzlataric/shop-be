package com.shop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO {

	private Long id;
	private String name;
	private Long stock;
	private Double price;
	private String category;
	private String country;
	private String manufacturer;
	private Long productionYear;
	private String expiryDate;
	private String image;

}
