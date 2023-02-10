package rs.raf.userservice.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

}
