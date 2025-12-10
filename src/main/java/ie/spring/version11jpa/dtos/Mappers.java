package ie.spring.version11jpa.dtos;

import ie.spring.version11jpa.entities.Planet;
import ie.spring.version11jpa.entities.Moon;

import java.util.List;

public class Mappers {

    public static MoonDto mapMoonToMoonDTO(Moon m){
        return new MoonDto(
                m.getMoonId(),
                m.getName(),
                m.getDiameterKm(),
                m.getOrbitalPeriodDays(),
                m.getPlanet()
        );
    }

    public static MoonDto mapMoonToMoonDTONoPlanet(Moon m){
        return new MoonDto(
                m.getMoonId(),
                m.getName(),
                m.getDiameterKm(),
                m.getOrbitalPeriodDays(),
                m.getPlanet()
        );
    }

    public static PlanetDto mapPlanetToPlanetDTO(Planet p){
        List<MoonDto> moonDtos =
                p.getMoons()
                .stream()
                .map(Mappers::mapMoonToMoonDTONoPlanet)
                .toList();
        return new PlanetDto(
                p.getPlanetId(),
                p.getName(),
                p.getType(),
                p.getRadiusKm(),
                p.getMassKg(),
                p.getOrbitalPeriodDays(),
                moonDtos);
    }

    public static Planet mapNewPlanetDtoToPlanet(NewPlanetDto newPlanetDto) {
        Planet planet = new Planet();
        planet.setName(newPlanetDto.name());
        planet.setType(newPlanetDto.type());
        planet.setRadiusKm(newPlanetDto.radiusKm());
        planet.setMassKg(newPlanetDto.massKg());
        planet.setOrbitalPeriodDays(newPlanetDto.orbitalPeriodDays());
        return planet;
    }

    public static Moon mapNewMoonDtoToMoon(NewMoonDto newMoonDto, Planet planet) {
        Moon moon = new Moon();
        moon.setName(newMoonDto.name());
        moon.setDiameterKm(newMoonDto.diameterKm());
        moon.setOrbitalPeriodDays(newMoonDto.orbitalPeriodDays());
        moon.setPlanet(planet);
        return moon;
    }


}

