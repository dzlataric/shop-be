package com.shop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.web.entity.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {

}
