package com.jones.Restaurant_Management_api.repository;

import com.jones.Restaurant_Management_api.model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTokenRepository extends JpaRepository<UserAuthenticationToken,Long> {
    UserAuthenticationToken findFirstByTokenValue(String tokenValue);
}
