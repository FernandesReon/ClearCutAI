package com.reon.backend.controller;

import com.reon.backend.dto.UserDTO;
import com.reon.backend.response.RemoveBgResponse;
import com.reon.backend.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public RemoveBgResponse createUpdateUser(@RequestBody UserDTO userDTO){
        try {
            UserDTO user = userService.saveUser(userDTO);
            return RemoveBgResponse.builder()
                    .success(true)
                    .statusCode(HttpStatus.CREATED)
                    .data(user)
                    .build();
        } catch (Exception e) {
            return RemoveBgResponse.builder()
                    .success(false)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .data(e.getMessage())
                    .build();
        }
    }
}
