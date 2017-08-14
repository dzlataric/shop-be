package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
