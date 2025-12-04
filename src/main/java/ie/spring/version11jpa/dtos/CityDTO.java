package ie.spring.version11jpa.dtos;

import java.util.List;

public record CityDTO(
        int id,
        String city,
        String country,
        List<HeroDTO> heroes
) {}
