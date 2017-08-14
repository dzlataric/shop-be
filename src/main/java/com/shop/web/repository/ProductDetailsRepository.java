package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
