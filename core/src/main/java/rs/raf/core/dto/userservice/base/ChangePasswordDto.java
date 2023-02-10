package rs.raf.core.dto.userservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChangePasswordDto {
    private Long user_id;
    private String oldPass;
    private String newPass;
}
