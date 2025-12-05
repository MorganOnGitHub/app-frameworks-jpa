package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.dtos.Name;

import java.util.List;

public interface HeroService {
    List<MoonDto> findAll();
    List<Name> findAllNames();
    List<String> findAllAlias();
    void deleteById(int id);
    List<MoonDto> findAllInCity(String city);
}
