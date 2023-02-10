package rs.raf.reservationservice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vehicle_type")
    private String vehicle_type;
}
