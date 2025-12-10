package ie.spring.version11jpa.security;

import ie.spring.version11jpa.entities.MyUser;
import ie.spring.version11jpa.services.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private MyUserService myUserService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserService.getMyUser(username);
        SimpleGrantedAuthority simpleGrantedAuthority =  new SimpleGrantedAuthority(myUser.getRole());

        return new User(
                myUser.getUsername(),
                myUser.getPassword(),
                myUser.getEnabled(),
                true,
                true,
                myUser.getUnlocked(),
                Collections.singletonList(simpleGrantedAuthority));
    }
}
