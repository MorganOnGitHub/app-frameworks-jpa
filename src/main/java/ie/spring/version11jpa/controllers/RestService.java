package ie.spring.version11jpa.controllers;

import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.dtos.PlanetDto;
import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.entities.Moon;
import ie.spring.version11jpa.entities.Planet;
import ie.spring.version11jpa.services.PlanetService;
import ie.spring.version11jpa.services.MoonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {
    private MoonService moonService;
    private PlanetService planetService;

    @GetMapping("/moons")
    @ResponseStatus(HttpStatus.OK)
    List<MoonDto> findAllMoons(){
        return moonService.findAll();
    }

    @GetMapping("/planets")
    @ResponseStatus(HttpStatus.OK)
    List<PlanetDto> findAllPlanets(){
        return planetService.findAll();
    }

    @PostMapping("/planets")
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody Planet planet) {
        planetService.save(planet);
    }

    @PostMapping("/moons")
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody Moon moon) {
        moonService.save(moon);
    }

    @GetMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    PlanetDto findByPlanetId(@PathVariable("id") Integer id){
        return planetService.findById(id);
    }

    @GetMapping("/planets/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    List<PlanetDto> findByType(@PathVariable String type){
        return planetService.findByType(type);
    }

    @GetMapping("/moons/{id}")
    @ResponseStatus(HttpStatus.OK)
    MoonDto findByMoonId(@PathVariable("id") Integer id){
        return moonService.findById(id);
    }



    @GetMapping("/moons/planet/{planetName}")
    @ResponseStatus(HttpStatus.OK)
    List<MoonDto> findAllMoonsByPlanet(@PathVariable String planetName){
        return moonService.findAllByPlanet(planetName);
    }

    @GetMapping("/moons/count/{planetName}")
    @ResponseStatus(HttpStatus.OK)
    int getMoonCountByPlanet(@PathVariable("planetName") String planetName){
        return moonService.findAllByPlanet(planetName).size();
    }

//    @DeleteMapping("/planets/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteCityById(@PathVariable int id){
//        planetService.deleteById(id);
//    }

    @DeleteMapping("/moons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMoonById(@PathVariable("id") Integer id){
        moonService.deleteById(id);
    }

    @DeleteMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("id") Integer id){planetService.deleteById(id);}

    @PatchMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePlanetById(@PathVariable("id") Integer id, @RequestBody Planet planet) {
        planet.setPlanetId(id);
        planetService.save(planet);
    }
}