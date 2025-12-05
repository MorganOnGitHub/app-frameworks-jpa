package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.PlanetDto;

import java.util.List;

public interface CityService {
    List<PlanetDto> findAll();
    void deleteById(int id);
}
