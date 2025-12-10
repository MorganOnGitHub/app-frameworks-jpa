package ie.spring.version11jpa.services;


import ie.spring.version11jpa.entities.MyUser;
import org.springframework.stereotype.Service;

@Service
public interface MyUserService {
    MyUser getMyUser(String username);
}
