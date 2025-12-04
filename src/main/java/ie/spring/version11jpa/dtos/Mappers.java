package ie.spring.version11jpa.dtos;

import ie.spring.version11jpa.entities.City;
import ie.spring.version11jpa.entities.Hero;

import java.util.List;

public class Mappers {

    public static HeroDTO mapHeroToHeroDTO(Hero h){
        return new HeroDTO(
                h.getHeroId(),
                h.getFirstName()+ " " + h.getLastName(),
                h.getAlias(),
                h.getOrigin(),
                h.getUniverse(),
                h.getYearCreated(),
                h.getCity() != null ?
                new CityDTO(h.getCity().getCityId(), h.getCity().getName(), h.getCity().getCountry(), null)
                : null
        );
    }

    public static HeroDTO mapHeroToHeroDTONoCity(Hero h){
        return new HeroDTO(
                h.getHeroId(),
                h.getFirstName()+ " " + h.getLastName(),
                h.getAlias(),
                h.getOrigin(),
                h.getUniverse(),
                h.getYearCreated(),
                null
        );
    }

    public static CityDTO mapCityToCityDTO(City c){
        List<HeroDTO> heroDTOs =
                c.getHeroes()
                .stream()
                .map(Mappers::mapHeroToHeroDTONoCity)
                .toList();
        return new CityDTO(
                c.getCityId(),
                c.getName(),
                c.getCountry(),
                heroDTOs);
    };

}

