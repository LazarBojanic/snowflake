package rs.raf.userservice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "rank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rank {
    @Id
    private Integer id;
    @Column(name = "rank")
    private String rank;
    @Column(name = "min_number_of_days")
    private Integer min_number_of_days;
    @Column(name = "max_number_of_days")
    private Integer max_number_of_days;
}
