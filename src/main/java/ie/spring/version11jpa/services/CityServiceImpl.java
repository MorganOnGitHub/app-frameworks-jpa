package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private PlanetRepository planetRepository;

    public List<PlanetDto> findAll() {
        return planetRepository.findAll().stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        int rowsDeleted = planetRepository.deleteById(id);
        if(rowsDeleted== 0) {
            throw new NotFoundException("City with planetId " + id + " was not found");
        }
    }
}
