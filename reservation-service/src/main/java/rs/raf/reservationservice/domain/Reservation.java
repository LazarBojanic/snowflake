package rs.raf.reservationservice.domain;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_user_id")
    private Long client_user_id;
    @ManyToOne
    private VehicleInFirm vehicle_in_firm;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
}
