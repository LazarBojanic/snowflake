package rs.raf.userservice.domain;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_status")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private ClientUser client_user;
    @ManyToOne/*(optional = true, cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = true)*/
    private Rank rank;
    @Column(name = "discount_percent")
    private Integer discount_percent;
    @Column(name = "number_of_days_reserved")
    private Integer number_of_days_reserved;
    @Column(name = "current_number_of_reservations")
    private Integer current_number_of_reservations;

    public UserStatus(ClientUser client_user, Rank rank, Integer discount_percent, Integer number_of_days_reserved, Integer current_number_of_reservations) {
        this.client_user = client_user;
        this.rank = rank;
        this.discount_percent = discount_percent;
        this.number_of_days_reserved = number_of_days_reserved;
        this.current_number_of_reservations = current_number_of_reservations;
    }
}