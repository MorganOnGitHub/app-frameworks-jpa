package ie.spring.version11jpa.repositories;

import ie.spring.version11jpa.dtos.MoonDto;
import ie.spring.version11jpa.entities.Moon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoonRepository extends JpaRepository<Moon, Integer> {
//    List<Moon> findByUniverseIgnoreCaseOrderByAliasDesc(String universe);

    List<Moon> findAllByPlanet_NameIgnoreCase(String planetName);

    // The provided deleteById() returns void.
    // I need it to return int. So I create my own.
    @Transactional
    @Modifying
    @Query("DELETE FROM Moon m WHERE m.moonId = :id")
    int deleteById(@Param("id") int id);

//    @Query("SELECT m FROM Moon m WHERE m.planet.planetId = :planetId")
//    List<Moon> findByPlanetId(@Param("planetId") int planetId);

}
