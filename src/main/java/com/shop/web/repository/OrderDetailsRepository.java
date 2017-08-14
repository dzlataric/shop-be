package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
