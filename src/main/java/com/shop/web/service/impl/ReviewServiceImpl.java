package com.shop.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Review;
import com.shop.web.repository.ReviewRepository;
import com.shop.web.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Inject
	private ReviewRepository reviewRepository;
	
	@Override
	public void insert(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void delete(Long id) {
		reviewRepository.delete(id);
	}

}
