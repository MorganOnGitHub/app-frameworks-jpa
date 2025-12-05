package ie.spring.version11jpa.controllers;

import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.dtos.Name;
import ie.spring.version11jpa.services.CityService;
import ie.spring.version11jpa.services.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {
    private HeroService heroService;
    private CityService cityService;

    @GetMapping("/heroes")
    List<MoonDto> findAllHeroes(){
        return heroService.findAll();
    }

    @GetMapping("/cities")
    List<PlanetDto> findAllCities(){
        return cityService.findAll();
    }

    @GetMapping("/heroes/alias")
    public List<String> findAllAliases() {
        return heroService.findAllAlias();
    }

    @GetMapping("/heroes/names")
    public List<Name> findAllNames() {
        return heroService.findAllNames();
    }

    @GetMapping("/heroes/city/{cityName}")
    List<MoonDto> findAllHeroesByCity(@PathVariable String cityName){
        return heroService.findAllInCity(cityName);
    }

    @DeleteMapping("/cities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCityById(@PathVariable int id){
        cityService.deleteById(id);
    }

    @DeleteMapping("/heroes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteHeroById(@PathVariable int id){
        heroService.deleteById(id);
    }
}