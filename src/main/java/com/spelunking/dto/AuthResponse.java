package com.spelunking.dto;

public record AuthResponse(
        String token,
        String tokenType,
        long expiresIn
) {
}