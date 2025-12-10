package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.entities.Moon;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.MoonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoonServiceImplementation implements MoonService {
    private MoonRepository moonRepository;

    @Override
    public void save(Moon moon) {
        moonRepository.save(moon);
    }

    @Override
    public List<MoonDto> findAll() {
        return moonRepository
                .findAll().stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public MoonDto findById(Integer id) {
        Optional<Moon> moon = moonRepository.findById(id);
        return Mappers.mapMoonToMoonDTO(moon.get());
    }


    @Override
    public void deleteById(Integer id) {
        moonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Moon Not Found"));
        moonRepository.deleteById(id);
    }

    @Override
    public List<MoonDto> findAllByPlanet(String planetName) {
        return moonRepository
                .findAllByPlanet_NameIgnoreCase(planetName)
                .stream()
                .map(Mappers::mapMoonToMoonDTONoPlanet)
                .toList();
    }
}
