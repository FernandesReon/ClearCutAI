package com.reon.clearcutai_backend.mapper;

import com.reon.clearcutai_backend.dto.UserRegistrationDTO;
import com.reon.clearcutai_backend.dto.UserResponseDTO;
import com.reon.clearcutai_backend.model.User;

public class UserMapper {
    public static User mapToEntity(UserRegistrationDTO register){
        /*
        during registration, the data that user will fill will be saved to database.
         */
        User user = new User();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());
        return user;
    }

    public static UserResponseDTO responseToUser(User user){
        /*
        here we are fetching the data from database and displaying only required information
         */
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setCredits(user.getCredits());
        response.setPhotoUrl(user.getPhotoUrl());
        response.setRoles(user.getRoles());
        response.setAccountEnabled(user.isAccountEnabled());
        response.setEmailVerified(user.isEmailVerified());
        response.setProvider(user.getProvider());
        response.setProviderId(user.getProviderId());
        response.setCreatedOn(user.getCreatedOn());
        response.setUpdatedOn(user.getUpdatedOn());
        return response;
    }
}
