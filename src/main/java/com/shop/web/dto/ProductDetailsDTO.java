package com.shop.web.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO {

	private Long id;
	private String country;
	private String manufacturer;
	private Long productionYear;
	private Date expiryDate;
	private byte[] image;
	
}
