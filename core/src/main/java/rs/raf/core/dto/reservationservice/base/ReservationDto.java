package rs.raf.core.dto.reservationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReservationDto {

    private Long id;
    private Long client_user_id;
    private Long vehicle_in_firm_id;
    private Date start_date;
    private Date end_date;


}
