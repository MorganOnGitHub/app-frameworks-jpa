package ie.spring.version11jpa.controllers;

import ie.spring.version11jpa.dtos.Mappers;
import ie.spring.version11jpa.dtos.NewUserDto;
import ie.spring.version11jpa.entities.MyUser;
import ie.spring.version11jpa.services.MyUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final MyUserService myUserService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @QueryMapping
    public NewUserDto getUserById(@Argument String id) {
        MyUser myUser = myUserService.getMyUser(id);
        return Mappers.mapUserToUserDto(myUser);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @MutationMapping
    public NewUserDto createUser(@Valid @Argument("newUser") NewUserDto newUserDto) {
        MyUser myUser = Mappers.mapUserDtoToUser(newUserDto);
        MyUser savedUser = myUserService.createUser(myUser);
        return Mappers.mapUserToUserDto(savedUser);
    }

}