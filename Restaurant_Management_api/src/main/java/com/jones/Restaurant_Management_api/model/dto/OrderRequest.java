package com.jones.Restaurant_Management_api.model.dto;

import com.jones.Restaurant_Management_api.model.Order;
import lombok.Data;

@Data
public class OrderRequest {
    private Order order;
    private AuthenticationInput authenticationInput;
}
