package ie.spring.version11jpa.dtos;

import ie.spring.version11jpa.entities.Planet;

public record MoonDto(
        int moonId,
        String name,
        float diameterKm,
        float orbitalPeriodDays,
        Planet planet
) {}

