package com.shop.web.service.impl;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shop.web.entity.Product;
import com.shop.web.entity.Review;
import com.shop.web.repository.ProductRepository;
import com.shop.web.repository.ReviewRepository;
import com.shop.web.service.ReviewsService;
import com.shop.web.service.dto.ReviewDTO;

@Service
public class ReviewsServiceImpl implements ReviewsService {

	@Inject
	private ReviewRepository reviewsRepository;
	@Inject
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public ReviewDTO insert(ReviewDTO reviewDTO) {
		
		Product product = productRepository.findOne(reviewDTO.getProductId());
		if(product == null) {
			throw new EntityNotFoundException("Product not found!");
		}
		
		Review review = new Review().withProduct(product).withComment(reviewDTO.getComment()).withRating(reviewDTO.getRating());
		
		Review saved = reviewsRepository.save(review);
		
		return new ReviewDTO(saved.getId(), saved.getComment(), saved.getRating(), saved.getProduct().getId());
	}

}
