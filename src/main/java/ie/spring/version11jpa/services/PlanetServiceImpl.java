package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.entities.Planet;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private PlanetRepository planetRepository;

    @Override
    public void save(Planet planet) {
        planetRepository.save(planet);
    }

    public List<PlanetDto> findAll() {
        return planetRepository.findAll().stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }

    @Override
    public PlanetDto findById(Integer id) {
        Optional<Planet> planet = planetRepository.findById(id);
        return Mappers.mapPlanetToPlanetDTO(planet.get());
    }
//
//    @Override
//    public void update(PlanetDto planetDto) {
//        PlanetDto planet = planetRepository.findPlanetByPlanetId(planetDto.planetId());
//        planetRepository.save(planet);
//    }

    @Override
    public void deleteById(int id) {
        if(!planetRepository.existsById(id)) {
            throw new NotFoundException("Planet with planetId " + id + " was not found");
        }
        planetRepository.deleteById(id);
    }

    @Override
    public List<PlanetDto> findByType(String type) {
        return planetRepository.findByType(type).stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }
}
