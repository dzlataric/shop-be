package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
