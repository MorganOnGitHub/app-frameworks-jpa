package ie.spring.version11jpa.dtos;

import ie.spring.version11jpa.entities.Planet;
import ie.spring.version11jpa.entities.Moon;

import java.util.List;

public class Mappers {

    public static HeroDTO mapHeroToHeroDTO(Moon h){
        return new HeroDTO(
                h.getMoonId(),
                h.getName()+ " " + h.getLastName(),
                h.getAlias(),
                h.getOrigin(),
                h.getUniverse(),
                h.getDiameterKm(),
                h.getPlanet() != null ?
                new CityDTO(h.getPlanet().getPlanetId(), h.getPlanet().getName(), h.getPlanet().getCountry(), null)
                : null
        );
    }

    public static HeroDTO mapHeroToHeroDTONoCity(Moon h){
        return new HeroDTO(
                h.getMoonId(),
                h.getName()+ " " + h.getLastName(),
                h.getAlias(),
                h.getOrigin(),
                h.getUniverse(),
                h.getDiameterKm(),
                null
        );
    }

    public static CityDTO mapCityToCityDTO(Planet c){
        List<HeroDTO> heroDTOs =
                c.getMoons()
                .stream()
                .map(Mappers::mapHeroToHeroDTONoCity)
                .toList();
        return new CityDTO(
                c.getPlanetId(),
                c.getName(),
                c.getCountry(),
                heroDTOs);
    };

}

