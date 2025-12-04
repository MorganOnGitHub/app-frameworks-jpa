package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.HeroDTO;
import ie.spring.version11jpa.dtos.Name;

import java.util.List;

public interface HeroService {
    List<HeroDTO> findAll();
    List<Name> findAllNames();
    List<String> findAllAlias();
    void deleteById(int id);
    List<HeroDTO> findAllInCity(String city);
}
