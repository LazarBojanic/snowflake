package rs.raf.userservice.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("1")
@Getter
@Setter
@NoArgsConstructor
public class ClientUser extends ServiceUser {
    @Column(name = "passport_number")
    private Long passport_number;

    public ClientUser(Long id, String email, String username, String pass, String phone_number, Date date_of_birth, String first_name, String last_name, String enabled, Long passport_number) {
        super(id, email, username, pass, phone_number, date_of_birth, first_name, last_name, enabled);
        this.passport_number = passport_number;
    }

    public ClientUser(Long passport_number) {
        this.passport_number = passport_number;
    }
}
