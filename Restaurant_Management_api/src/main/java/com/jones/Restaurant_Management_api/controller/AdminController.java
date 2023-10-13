package com.jones.Restaurant_Management_api.controller;

import com.jones.Restaurant_Management_api.model.User;
import com.jones.Restaurant_Management_api.service.Food;
import com.jones.Restaurant_Management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    Food food;

    @Autowired
    UserService userService;

    @PostMapping("foodItem")
    public String createFoodItem(@RequestParam String email, @RequestBody com.jones.Restaurant_Management_api.model.Food foodItem){
        return food.createFoodItem(email, foodItem);
    }


    @DeleteMapping("foodItem/{email}/{foodId}")
    public String deleteFoodItem(@PathVariable String email, @PathVariable Long foodId){
        return food.deleteFoodItem(email,foodId);
    }

    @GetMapping("users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
