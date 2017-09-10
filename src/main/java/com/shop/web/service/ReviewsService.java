package com.shop.web.service;

import org.springframework.security.access.prepost.PreAuthorize;

import com.shop.web.dto.ReviewDTO;

public interface ReviewsService {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	ReviewDTO insert(ReviewDTO reviewDTO);
	
}
