package com.comanDaBack.comanDa.security.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreatUserRequest(@NotBlank String username,
                                   @NotBlank String password,
                                   @Valid AuthCreateRoleRequest roleRequest) {
}
