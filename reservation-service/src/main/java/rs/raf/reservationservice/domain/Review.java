package rs.raf.reservationservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_user_id", nullable = true)
    private Long client_user_id;
    @ManyToOne
    private Firm firm;
    @Column(name = "text")
    private String text;
    @Column(name = "grade")
    private Double grade;
}
