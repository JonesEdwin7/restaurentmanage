package com.jones.Restaurant_Management_api.controller;

import com.jones.Restaurant_Management_api.service.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    Food food;

    @GetMapping("visitor/foods/")
    public List<com.jones.Restaurant_Management_api.model.Food> getAllFoodItem()
    {
        return food.getAllFoodItems();
    }
}
