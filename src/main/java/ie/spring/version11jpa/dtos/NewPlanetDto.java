package ie.spring.version11jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record NewPlanetDto(
    @NotBlank
    String name,
    @NotBlank
    String type,
    @NotNull
    @Positive
    float radiusKm,
    @NotNull
    @Positive
    float massKg,
    @NotNull
    @Positive
    float orbitalPeriodDays
) {

}