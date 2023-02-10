package rs.raf.core.dto.userservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserStatusDto {
    private Long id;
    private Long client_user_id;
    private Integer rank_id;
    private Integer discount_percent;
    private Integer number_of_days_reserved;
    private Integer current_number_of_reservations;
}
