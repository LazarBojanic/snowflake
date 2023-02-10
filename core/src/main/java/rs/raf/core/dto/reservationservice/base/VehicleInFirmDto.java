package rs.raf.core.dto.reservationservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleInFirmDto {
    private Long id;
    private Long firm_id;
    private Long vehicle_id;
    private Double price;
}
