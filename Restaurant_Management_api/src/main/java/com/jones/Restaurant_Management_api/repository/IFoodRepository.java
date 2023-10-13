package com.jones.Restaurant_Management_api.repository;

import com.jones.Restaurant_Management_api.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepository extends JpaRepository<Food, Long> {
}
