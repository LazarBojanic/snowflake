package rs.raf.reservationservice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_in_firm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleInFirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Firm firm;
    @OneToOne
    private Vehicle vehicle;
    @Column(name = "price")
    private Double price;
}