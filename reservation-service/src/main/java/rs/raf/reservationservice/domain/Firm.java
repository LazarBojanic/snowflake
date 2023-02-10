package rs.raf.reservationservice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "firm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Firm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firm_name")
    private String firm_name;
    @Column(name = "description")
    private String description;
    @Column(name = "number_of_vehicles")
    private Integer number_of_vehicles;
    @Column(name = "city")
    private String city;
}
