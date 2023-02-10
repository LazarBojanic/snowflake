package rs.raf.core.dto.reservationservice.view;

import lombok.*;
import rs.raf.core.dto.reservationservice.base.FirmDto;
import rs.raf.core.dto.reservationservice.base.VehicleDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleInFirmViewDto {
    private Long id;
    private FirmViewDto firm;
    private VehicleViewDto vehicle;
    private Double price;
}
