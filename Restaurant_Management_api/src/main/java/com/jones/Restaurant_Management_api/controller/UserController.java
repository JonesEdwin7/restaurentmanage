package com.jones.Restaurant_Management_api.controller;

import com.jones.Restaurant_Management_api.model.User;
import com.jones.Restaurant_Management_api.model.dto.AuthenticationInput;
import com.jones.Restaurant_Management_api.model.dto.OrderRequest;
import com.jones.Restaurant_Management_api.model.dto.SignInInput;
import com.jones.Restaurant_Management_api.service.Food;
import com.jones.Restaurant_Management_api.service.Order;
import com.jones.Restaurant_Management_api.service.UserService;
import com.jones.Restaurant_Management_api.service.Usertoken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Food food;

    @Autowired
    Order order;

    @Autowired
    Usertoken usertoken;

    @PostMapping("user/signUp")
    public String userSignUp(@RequestBody User user){
        return userService.userSignUp(user);
    }


    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInput sign){
        return userService.userSignIn(sign);
    }

    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody AuthenticationInput authenticationInput) {
        return userService.userSignOut(authenticationInput);
    }

    @PostMapping("user/order")
    public String addOrder(@RequestBody OrderRequest orderRequest){
        if(usertoken.authenticate(orderRequest.getAuthenticationInput())) {
            return order.addOrder(orderRequest.getOrder(),orderRequest.getAuthenticationInput().getEmail());
        }
        else {
            return "You've to sign to order the food!";
        }
    }

    @GetMapping("foods")
    public List<com.jones.Restaurant_Management_api.model.Food> getAllFoodItems()
    {
        return food.getAllFoodItems();
    }


}
