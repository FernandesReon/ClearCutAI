package com.reon.clearcutai_backend.dto;

import com.reon.clearcutai_backend.model.Provider;
import com.reon.clearcutai_backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private Integer credits;
    private String photoUrl;
    private Set<Role> roles;
    private boolean accountEnabled;
    private boolean emailVerified;
    private Provider provider;
    private String providerId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
