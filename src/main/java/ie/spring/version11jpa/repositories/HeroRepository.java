package ie.spring.version11jpa.repositories;

import ie.spring.version11jpa.dtos.Name;
import ie.spring.version11jpa.entities.Hero;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
    List<Hero> findByUniverseIgnoreCaseOrderByAliasDesc(String universe);
    Optional<Hero> findByFirstNameAndLastNameIgnoreCase(String f, String l);

    List<Hero> findAllByCity_NameIgnoreCase(String cityName);

    // The provided deleteById() returns void.
    // I need it to return int. So I create my own.
    @Transactional
    @Modifying
    @Query("DELETE FROM Hero h WHERE h.heroId = :id")
    int deleteById(@Param("id") int id);

    @Query("select new ie.spring.version11jpa.dtos.Name(h.alias, concat(h.firstName,' ', h.lastName)) FROM Hero h")
    List<Name> findAllName();

    @Modifying
    @Transactional
    @Query("UPDATE Hero h SET h.universe = :universe WHERE h.heroId = :id")
    int changeUniverse(@Param("id") int id, @Param("universe") String universe);

    @Query("SELECT h.alias FROM Hero h WHERE h.alias IS NOT NULL")
    List<String> findAllAlias();
}
