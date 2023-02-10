package rs.raf.core.dto.userservice.view;

import lombok.*;
import rs.raf.core.dto.userservice.base.ClientUserDto;
import rs.raf.core.dto.userservice.base.RankDto;
import rs.raf.core.dto.userservice.base.ServiceUserDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserStatusViewDto {
    private Long id;
    private ClientUserDto client_user;
    private RankDto rank;
    private Integer discount_percent;
    private Integer number_of_days_reserved;
    private Integer current_number_of_reservations;
}
