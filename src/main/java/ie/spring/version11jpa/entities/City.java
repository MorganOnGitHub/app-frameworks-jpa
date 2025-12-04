package ie.spring.version11jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    @Column(nullable=false, unique=true)
    private String name;
    @Column(nullable=false, unique=true)
    private String country;

    @OneToMany(mappedBy = "city",  fetch = FetchType.LAZY)
    private List<Hero> heroes;
}