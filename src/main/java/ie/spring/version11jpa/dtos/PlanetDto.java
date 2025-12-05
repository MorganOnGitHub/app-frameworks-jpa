package ie.spring.version11jpa.dtos;

import java.util.List;

public record PlanetDto(
        int planetId,
        String name,
        String type,
        float radiusKm,
        float massKg,
        float orbitalPeriodDays,
        List<MoonDto> moons
) {}
