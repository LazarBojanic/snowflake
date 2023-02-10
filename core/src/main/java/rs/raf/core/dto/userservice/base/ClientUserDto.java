package rs.raf.core.dto.userservice.base;

import java.util.Date;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientUserDto {
    private Long id;
    private Integer user_role_id;
    private String email;
    private String username;
    private String pass;
    private String phone_number;
    private Date date_of_birth;
    private String first_name;
    private String last_name;
    private Long passport_number;
    private String enabled;
}