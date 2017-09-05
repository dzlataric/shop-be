package com.shop.web.dto;

import java.time.LocalDate;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private Long id;
	private LocalDate date;
	private Long customerId;
	private Map<Long, Integer> productIdsWithAmmount;
	
}
