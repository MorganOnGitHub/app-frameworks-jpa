package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.dtos.Name;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.MoonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceImplementation implements HeroService {
    private MoonRepository moonRepository;

    @Override
    public List<MoonDto> findAll() {
        return moonRepository
                .findAll()
                .stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public List<Name> findAllNames() {
        return moonRepository.findAllName();
    }

    @Override
    public List<String> findAllAlias() {
        return moonRepository.findAllAlias();
    }

    @Override
    public void deleteById(int id) {
        int deleted = moonRepository.deleteById(id);
        if (deleted == 0)
            throw new NotFoundException("Hero with planetId " + id + " was not found");
    }

    @Override
    public List<MoonDto> findAllInCity(String cityName) {
        return moonRepository
                .findAllByPlanet_NameIgnoreCase(cityName)
                .stream()
                .map(Mappers::mapHeroToHeroDTONoCity)
                .toList();
    }
}
