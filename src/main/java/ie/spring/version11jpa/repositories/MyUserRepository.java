package ie.spring.version11jpa.repositories;

import ie.spring.version11jpa.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser,String>{
    Optional<MyUser> findByUsername(String username);
}
