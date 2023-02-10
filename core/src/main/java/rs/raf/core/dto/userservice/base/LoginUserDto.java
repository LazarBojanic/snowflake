package rs.raf.core.dto.userservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginUserDto {
    private String email;
    private String pass;
}