package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
