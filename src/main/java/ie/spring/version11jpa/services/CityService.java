package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
    void deleteById(int id);
}
