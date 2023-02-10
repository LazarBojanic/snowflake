package rs.raf.userservice.domain;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("2")
@Getter
@Setter
@NoArgsConstructor
public class ManagerUser extends ServiceUser {
    @Column(name = "firm_id")
    private Long firm_id;
    @Column(name = "hire_date")
    private Date hire_date;

    public ManagerUser(Long id, String email, String username, String pass, String phone_number, Date date_of_birth, String first_name, String last_name, String enabled, Long firm_id, Date hire_date) {
        super(id, email, username, pass, phone_number, date_of_birth, first_name, last_name, enabled);
        this.firm_id = firm_id;
        this.hire_date = hire_date;
    }

    public ManagerUser(Long firm_id, Date hire_date) {
        this.firm_id = firm_id;
        this.hire_date = hire_date;
    }
}
