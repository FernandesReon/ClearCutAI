package com.reon.clearcutai_backend.controller;

import com.reon.clearcutai_backend.dto.ResetPasswordDTO;
import com.reon.clearcutai_backend.dto.UserLoginDTO;
import com.reon.clearcutai_backend.dto.UserRegistrationDTO;
import com.reon.clearcutai_backend.dto.UserResponseDTO;
import com.reon.clearcutai_backend.jwt.JwtAuthenticationResponse;
import com.reon.clearcutai_backend.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userService;
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO registration){
        logger.info("Controller: Incoming request for registration.");
        UserResponseDTO register = userService.registration(registration);
        logger.info("Controller: Registration success.");
        return ResponseEntity.ok().body(register);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginDTO){
        try {
            logger.info("Controller :: Login request from email address: " + loginDTO.getEmail());

            // authenticate the user and generate a Jwt token
            JwtAuthenticationResponse jwtToken = userService.authenticateUser(loginDTO);
            logger.info("Controller :: Login successful.");
            return ResponseEntity.ok().body(jwtToken);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/send-reset-otp")
    public void sendResetOtp(@RequestParam String email){
        try {
            logger.info("Controller :: Sending OTP for email: " + email);
            userService.sendResetOtp(email);
            logger.info("Controller :: Reset OTP send successfully.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/reset-password")
    public void resetPassword(@Valid @RequestBody ResetPasswordDTO resetPassword){
        try {
            logger.info("Controller :: Incoming request for changing password from email: " + resetPassword.getEmail());
            userService.resetPassword(resetPassword.getEmail(), resetPassword.getOtp(), resetPassword.getNewPassword());
            logger.info("Controller :: Password reset successful.");
        } catch (Exception e) {
            logger.error("Controller :: Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
