package ie.spring.version11jpa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NewMoonDto(
    @NotBlank
    String name,
    @Positive
    @NotNull
    float diameterKm,
    @Positive
    @NotNull
    float orbitalPeriodDays,
    @Positive
    @NotNull
    Integer planetId
) {


}