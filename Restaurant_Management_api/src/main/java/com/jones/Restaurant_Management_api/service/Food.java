package com.jones.Restaurant_Management_api.service;

import com.jones.Restaurant_Management_api.model.User;
import com.jones.Restaurant_Management_api.repository.IFoodRepository;
import com.jones.Restaurant_Management_api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jones.Restaurant_Management_api.model.enums.UserRole.*;

@Service
public class Food {

    @Autowired
    IFoodRepository iFoodRepository;

    @Autowired
    IUserRepository iUserRepository;

    // Create Food Item
    public String createFoodItem(String email, com.jones.Restaurant_Management_api.model.Food foodItem) {
        User existingUser = iUserRepository.findFirstByEmail(email);
try {
    if (existingUser.getRole().equals(ADMIN_ROLE)) {
        iFoodRepository.save(foodItem);
        return "Food Item Created";
    } else {
        return "Only Admin can create food!";
    }
}
catch (Exception e){
    System.out.println("exception");
}
  return "food itemcreated";  }

    // Delete Food Item By Food I'D
    public String deleteFoodItem(String email, Long foodId) {
        User existingUser = iUserRepository.findFirstByEmail(email);

        if(existingUser.getRole().equals(ADMIN_ROLE)){
            iFoodRepository.deleteById(foodId);
            return "Food Item deleted";
        }
        else {
            return "Only Admin can delete food!";
        }
    }

    // Get all Food
    public List<com.jones.Restaurant_Management_api.model.Food> getAllFoodItems() {
        return iFoodRepository.findAll();
    }
}
