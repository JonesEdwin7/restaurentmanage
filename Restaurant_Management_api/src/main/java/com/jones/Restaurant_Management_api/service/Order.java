package com.jones.Restaurant_Management_api.service;

import com.jones.Restaurant_Management_api.model.Food;
import com.jones.Restaurant_Management_api.model.User;
import com.jones.Restaurant_Management_api.model.enums.OrderStatus;
import com.jones.Restaurant_Management_api.model.enums.UserRole;
import com.jones.Restaurant_Management_api.repository.IFoodRepository;
import com.jones.Restaurant_Management_api.repository.IOrderRepository;
import com.jones.Restaurant_Management_api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order {

    @Autowired
    IFoodRepository iFoodRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IOrderRepository orderRepository; //



    public String addOrder(com.jones.Restaurant_Management_api.model.Order order, String email) {
        User user = userRepository.findFirstByEmail(email);

        if(!user.getRole().equals(UserRole.USER_ROLE)){
            return "Sorry only users can able to Order food!";
        }

        // Find the food item by its ID
        Food foodItem = iFoodRepository.findById(order.getFood().getFoodId()).orElse(null);
        if (foodItem == null) {
            return "Sorry the food item you're looking isn't available. Please choose other food item.";
        }
        // Set the user and food item in the order
        order.setUser(user);
        order.setFood(foodItem);
        order.setOrderStatus(OrderStatus.CREATED);

        // Save the order in the database
        orderRepository.save(order);
        return "Order Placed Successfully";
    }


}
