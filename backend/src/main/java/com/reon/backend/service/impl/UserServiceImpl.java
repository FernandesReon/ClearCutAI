package com.reon.backend.service.impl;

import com.reon.backend.dto.UserDTO;
import com.reon.backend.mapper.UserMapper;
import com.reon.backend.model.User;
import com.reon.backend.repository.UserRepository;
import com.reon.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepository.existsByClerkId(userDTO.getClerkId())){
            User existingUser = new User();
            UserMapper.responseToUser(existingUser);

            existingUser = userRepository.save(existingUser);
            return UserMapper.responseToUser(existingUser);
        }

        User newUser = UserMapper.mapToEntity(userDTO);
        User savedUser = userRepository.save(newUser);
        return UserMapper.responseToUser(savedUser);
    }
}
