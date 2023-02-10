package rs.raf.core.dto.userservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserEnabledDto {
    private Long userId;
    private String enabled;
}
