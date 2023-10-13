package com.jones.Restaurant_Management_api.service;

import com.jones.Restaurant_Management_api.model.UserAuthenticationToken;
import com.jones.Restaurant_Management_api.model.dto.AuthenticationInput;
import com.jones.Restaurant_Management_api.repository.IUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Usertoken {

    @Autowired
    IUserTokenRepository iUserTokenRepository;

    // It creates Token
    public void createToken(UserAuthenticationToken token) {
        iUserTokenRepository.save(token);
    }

    // This method checks email is valid or not
    public boolean authenticate(AuthenticationInput authenticationInput) {
        String existingEmail = authenticationInput.getEmail();
        String tokenValue = authenticationInput.getTokenValue();

        UserAuthenticationToken token = iUserTokenRepository.findFirstByTokenValue(tokenValue);

        if(token != null){
            return token.getUser().getEmail().equals(existingEmail);
        }
        else {
            return false;
        }
    }

    // This method delete the token
    public void deleteToken(String tokenValue) {

        UserAuthenticationToken existingToken = iUserTokenRepository.findFirstByTokenValue(tokenValue);
        iUserTokenRepository.delete(existingToken);

    }
}
