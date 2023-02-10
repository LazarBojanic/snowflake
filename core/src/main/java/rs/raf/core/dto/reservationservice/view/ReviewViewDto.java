package rs.raf.core.dto.reservationservice.view;

import lombok.*;
import rs.raf.core.dto.reservationservice.base.FirmDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReviewViewDto {
    private Long id;
    private Long client_user_id;
    private FirmDto firm;
    private String text;
    private Double grade;

}
