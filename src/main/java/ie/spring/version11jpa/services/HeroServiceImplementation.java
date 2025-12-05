package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.dtos.Name;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceImplementation implements HeroService {
    private HeroRepository heroRepository;

    @Override
    public List<MoonDto> findAll() {
        return heroRepository
                .findAll()
                .stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public List<Name> findAllNames() {
        return heroRepository.findAllName();
    }

    @Override
    public List<String> findAllAlias() {
        return heroRepository.findAllAlias();
    }

    @Override
    public void deleteById(int id) {
        int deleted = heroRepository.deleteById(id);
        if (deleted == 0)
            throw new NotFoundException("Hero with id " + id + " was not found");
    }

    @Override
    public List<MoonDto> findAllInCity(String cityName) {
        return heroRepository
                .findAllByCity_NameIgnoreCase(cityName)
                .stream()
                .map(Mappers::mapHeroToHeroDTONoCity)
                .toList();
    }
}
