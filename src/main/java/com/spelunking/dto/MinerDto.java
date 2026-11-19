package com.spelunking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MinerDto(
        Long id,
        @NotBlank @Size(max = 30) String name) {
}