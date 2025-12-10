package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.entities.Moon;

import java.util.List;
import java.util.NoSuchElementException;

public interface MoonService {
    void save(Moon moon);
    List<MoonDto> findAll();
    MoonDto findById(Integer id);
    void deleteById(Integer id);
    List<MoonDto> findAllByPlanet(String planetName);
}
