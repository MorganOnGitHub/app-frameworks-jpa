package ie.spring.version11jpa.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Boolean enabled;
    @NotNull
    private Boolean unlocked;
    @NotBlank
    private String role;
}