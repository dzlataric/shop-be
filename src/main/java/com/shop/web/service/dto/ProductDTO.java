package com.shop.web.service.dto;

import java.util.Set;

import com.shop.web.entity.ProductDetails;

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
	private ProductDetails details;
	private Long categoryId;
	private Set<Long> reviewIds;
	
}
