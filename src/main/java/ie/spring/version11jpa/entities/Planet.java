package ie.spring.version11jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="planets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planetId;
    @Column(nullable=false, unique=true)
    private String name;
    @Column(nullable=false, unique=true)
    private String country;

    @OneToMany(mappedBy = "planet",  fetch = FetchType.LAZY)
    private List<Moon> moons;
}