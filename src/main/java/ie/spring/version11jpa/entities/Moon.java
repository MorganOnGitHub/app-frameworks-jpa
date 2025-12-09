package ie.spring.version11jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="moons")
public class Moon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer moonId;
    private String name;
    private float diameterKm;
    private float orbitalPeriodDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="planet_id")
    private Planet planet;
}
