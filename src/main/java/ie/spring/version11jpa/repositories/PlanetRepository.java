package ie.spring.version11jpa.repositories;

import ie.spring.version11jpa.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {


    @Modifying
    @Transactional
    @Query("DELETE FROM Planet p WHERE p.planetId = :id")
    int deleteById(@Param("id") int id);

    @Query("SELECT p FROM Planet p WHERE p.type = :type")
    List<Planet> findByType(@Param("type") String type);

}
