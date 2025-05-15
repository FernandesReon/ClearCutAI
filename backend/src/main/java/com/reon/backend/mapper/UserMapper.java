package com.reon.backend.mapper;

import com.reon.backend.dto.UserDTO;
import com.reon.backend.model.User;

public class UserMapper {

    public static User mapToEntity(UserDTO registerDTO){
        User user = new User();
        user.setClerkId(registerDTO.getClerkId());
        user.setEmail(registerDTO.getEmail());
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setPhotoUrl(registerDTO.getPhotoUrl());
        user.setCredits(registerDTO.getCredits());
        return user;
    }

    public static UserDTO responseToUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setClerkId(user.getClerkId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhotoUrl(user.getPhotoUrl());

        if (userDTO.getCredits() != null){
            user.setCredits(userDTO.getCredits());
        }
        return userDTO;
    }
}
