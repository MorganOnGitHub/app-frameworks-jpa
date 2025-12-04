package ie.spring.version11jpa.dtos;

public record HeroDTO(
        int heroId,
      String name,
      String hero,
      String lifeform,
      String publisher,
      int year,
      CityDTO city
) {}

