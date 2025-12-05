package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    public List<PlanetDto> findAll() {
        return cityRepository.findAll().stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        int rowsDeleted = cityRepository.deleteById(id);
        if(rowsDeleted== 0) {
            throw new NotFoundException("City with id " + id + " was not found");
        }
    }
}
