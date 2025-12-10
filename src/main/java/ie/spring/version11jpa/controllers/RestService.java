package ie.spring.version11jpa.controllers;

import ie.spring.version11jpa.dtos.*;
import ie.spring.version11jpa.entities.Moon;
import ie.spring.version11jpa.entities.Planet;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.PlanetRepository;
import ie.spring.version11jpa.services.PlanetService;
import ie.spring.version11jpa.services.MoonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {
    private final PlanetRepository planetRepository;
    private MoonService moonService;
    private PlanetService planetService;

    @GetMapping("/moons")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    List<MoonDto> findAllMoons(){
        return moonService.findAll();
    }

    @GetMapping("/planets")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    List<PlanetDto> findAllPlanets(){
        return planetService.findAll();
    }

    @PostMapping("/planets")
    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    void save(@Valid @RequestBody NewPlanetDto newPlanetDto) {
        Planet planet = Mappers.mapNewPlanetDtoToPlanet(newPlanetDto);
        planetService.save(planet);
    }

    @PostMapping("/moons")
    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    void save(@Valid @RequestBody NewMoonDto newMoonDto) {
        Planet planet = planetRepository.findById(newMoonDto.planetId())
                .orElseThrow( () -> new NotFoundException("Planet not found."));
        Moon moon = Mappers.mapNewMoonDtoToMoon(newMoonDto, planet);
        moonService.save(moon);
    }

    @GetMapping("/planets/{id}")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    PlanetDto findByPlanetId(@PathVariable("id") Integer id){
        return planetService.findById(id);
    }

    @GetMapping("/planets/type/{type}")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    List<PlanetDto> findByType(@PathVariable("type") String type){
        return planetService.findByType(type);
    }

    @GetMapping("/moons/{id}")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    MoonDto findByMoonId(@PathVariable("id") Integer id){
        return moonService.findById(id);
    }



    @GetMapping("/moons/planet/{planetName}")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    List<MoonDto> findAllMoonsByPlanet(@PathVariable("planetName") String planetName){
        return moonService.findAllByPlanet(planetName);
    }

    @GetMapping("/moons/count/{planetName}")
    @PreAuthorize("hasAnyRole('STUDENT', 'STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    int getMoonCountByPlanet(@PathVariable("planetName") String planetName){
        return moonService.findAllByPlanet(planetName).size();
    }


    @DeleteMapping("/moons/{id}")
    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMoonById(@PathVariable("id") Integer id){
        moonService.deleteById(id);
    }

    @DeleteMapping("/planets/{id}")
    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("id") Integer id){planetService.deleteById(id);}

    @PatchMapping("/planets/{id}")
    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePlanetById(@PathVariable("id") Integer id, @Valid @RequestBody NewPlanetDto newPlanetDto) {
        planetService.updateOrbitalPeriodDays(id, newPlanetDto.orbitalPeriodDays());
    }
}