package com.comanDaBack.comanDa.security.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record AuthCreateRoleRequest(
        @NotBlank( message = "Role is mandatory") String role) {
}
