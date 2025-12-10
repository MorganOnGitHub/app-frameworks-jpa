package ie.spring.version11jpa.services;

import ie.spring.version11jpa.entities.MyUser;
import ie.spring.version11jpa.repositories.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserServiceImplementation implements MyUserService {
    private MyUserRepository myUserRepository;

    @Override
    public MyUser getMyUser(String username){
        Optional<MyUser> myUser = myUserRepository.findById(username);
        if(myUser.isPresent()){
            return myUser.get();
        }
        throw new UsernameNotFoundException("User not found");
    }

}
