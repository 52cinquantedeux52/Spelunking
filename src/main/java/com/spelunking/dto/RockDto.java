package com.spelunking.dto;

import com.spelunking.entity.RockType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RockDto(
        Long id,
        @NotBlank @Size(max = 60) String name,
        @NotNull RockType type,
        @NotNull @Min(1) @Max(10) Integer mohsScale,
        @NotNull @Positive Double weight,
        @NotBlank @Size(max = 8) String reference,
        @Size(max = 50) String color,
        @Size(max = 90) String discoveredPlace,
        @Size(max = 500) String description,
        @NotNull Long ownerId) {
}