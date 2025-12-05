package ie.spring.version11jpa.repositories;

import ie.spring.version11jpa.dtos.Name;
import ie.spring.version11jpa.entities.Moon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends JpaRepository<Moon, Integer> {
    List<Moon> findByUniverseIgnoreCaseOrderByAliasDesc(String universe);
    Optional<Moon> findByFirstNameAndLastNameIgnoreCase(String f, String l);

    List<Moon> findAllByCity_NameIgnoreCase(String cityName);

    // The provided deleteById() returns void.
    // I need it to return int. So I create my own.
    @Transactional
    @Modifying
    @Query("DELETE FROM Moon h WHERE h.MoonId = :id")
    int deleteById(@Param("id") int id);

    @Query("select new ie.spring.version11jpa.dtos.Name(h.alias, concat(h.name,' ', h.lastName)) FROM Moon h")
    List<Name> findAllName();

    @Modifying
    @Transactional
    @Query("UPDATE Moon h SET h.universe = :universe WHERE h.MoonId = :id")
    int changeUniverse(@Param("id") int id, @Param("universe") String universe);

    @Query("SELECT h.alias FROM Moon h WHERE h.alias IS NOT NULL")
    List<String> findAllAlias();
}
