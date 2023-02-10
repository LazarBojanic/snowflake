package rs.raf.reservationservice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private VehicleType vehicle_type;
    @ManyToOne
    private VehicleModel vehicle_model;
    @Column(name = "vehicle_name")
    private String vehicle_name;
    @Column(name = "production_year")
    private Integer production_year;
    @Column(name = "horse_power")
    private Double horse_power;
}