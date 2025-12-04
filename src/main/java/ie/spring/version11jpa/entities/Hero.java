package ie.spring.version11jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int heroId;
    private String firstName;
    private String lastName;
    private String alias;
    private String origin;
    private String universe;
    private int yearCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id")
    private City city;
}
