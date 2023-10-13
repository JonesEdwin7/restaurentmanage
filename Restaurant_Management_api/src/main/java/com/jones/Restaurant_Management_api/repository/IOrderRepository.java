package com.jones.Restaurant_Management_api.repository;

import com.jones.Restaurant_Management_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
