package com.shop.web.service;

import com.shop.web.entity.Review;

public interface ReviewService {

	void insert(Review review);
	
	void delete(Long id);
}
