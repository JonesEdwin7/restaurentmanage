package com.jones.Restaurant_Management_api.repository;

import com.jones.Restaurant_Management_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
