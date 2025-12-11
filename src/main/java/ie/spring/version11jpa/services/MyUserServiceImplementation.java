package ie.spring.version11jpa.services;

import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.dtos.NewUserDto;
import ie.spring.version11jpa.entities.MyUser;
import ie.spring.version11jpa.exceptions.NotFoundException;
import ie.spring.version11jpa.repositories.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserServiceImplementation implements MyUserService {
    private final PasswordEncoder passwordEncoder;
    private MyUserRepository myUserRepository;

    @Override
    public MyUser getMyUser(String username){
        Optional<MyUser> myUser = myUserRepository.findById(username);
        if(myUser.isPresent()){
            return myUser.get();
        } else throw new NotFoundException("User not found");
    }

    @Override
    public MyUser createUser(MyUser myUser) {
        NewUserDto newUserDto = Mappers.mapUserToUserDto(myUser);
        newUserDto.setPassword(passwordEncoder.encode(newUserDto.getPassword()));
        if(myUserRepository.findByUsername(newUserDto.getUsername()).isPresent()){
            throw new DataIntegrityViolationException(newUserDto.getUsername() + " already exists");
        }
        return myUserRepository.save(Mappers.mapUserDtoToUser(newUserDto));
    }

}