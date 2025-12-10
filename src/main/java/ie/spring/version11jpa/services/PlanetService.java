package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.entities.Planet;

import java.util.List;

public interface PlanetService {
    void save(Planet planet);
    List<PlanetDto> findAll();
    PlanetDto findById(Integer id);
    void deleteById(int id);
    List<PlanetDto> findByType(String type);
    void updateOrbitalPeriodDays(Integer id, float orbitalPeriodDays);
}
