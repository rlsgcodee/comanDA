package com.comanDaBack.comanDa.security.dto;


import jakarta.validation.constraints.NotNull;

public record AuthLoginRequest(@NotNull String username,
                               @NotNull String password) {
}
