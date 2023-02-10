package rs.raf.core.dto.reservationservice.view;

import lombok.*;
import rs.raf.core.dto.reservationservice.base.VehicleInFirmDto;
import rs.raf.core.dto.userservice.base.ClientUserDto;
import rs.raf.core.dto.userservice.base.ServiceUserDto;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReservationViewDto {
    private Long id;
    private Long client_user_id;
    private VehicleInFirmViewDto vehicle_in_firm;
    private Date start_date;
    private Date end_date;

}
