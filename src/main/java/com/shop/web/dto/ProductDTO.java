package com.shop.web.dto;

import java.util.Date;

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
	private Double price;
	private String category;
	private Long categoryId;
	private Long detailsId;
	private String country;
	private String manufacturer;
	private Long productionYear;
	private String image;
	private Date expiryDate;
}
