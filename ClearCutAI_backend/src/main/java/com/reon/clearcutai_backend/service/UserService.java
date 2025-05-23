package com.reon.clearcutai_backend.service;

import com.reon.clearcutai_backend.dto.UserLoginDTO;
import com.reon.clearcutai_backend.dto.UserRegistrationDTO;
import com.reon.clearcutai_backend.dto.UserResponseDTO;
import com.reon.clearcutai_backend.jwt.JwtAuthenticationResponse;

public interface UserService {
    UserResponseDTO registration(UserRegistrationDTO register);
    UserResponseDTO fetchByEmail(String email);
    JwtAuthenticationResponse authenticateUser(UserLoginDTO loginDTO);
    void sendResetOtp(String email);
    void resetPassword(String email, String otp, String newPassword);
}
