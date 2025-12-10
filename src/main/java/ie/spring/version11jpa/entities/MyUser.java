package ie.spring.version11jpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "my_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    @Column(nullable=false, unique=true)
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean unlocked;
    private String role;

}
