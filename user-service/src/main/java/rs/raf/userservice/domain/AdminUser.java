package rs.raf.userservice.domain;

import javax.persistence.*;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import java.util.Date;


@Entity
@DiscriminatorValue("0")
@Getter
@Setter
public class AdminUser extends ServiceUser {
    public AdminUser(Long id, String email, String username, String pass, String phone_number, Date date_of_birth, String first_name, String last_name, String enabled) {
        super(id, email, username, pass, phone_number, date_of_birth, first_name, last_name, enabled);
    }

    public AdminUser() {
    }
}
