package rs.raf.core.dto.reservationservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleModelDto {
    private Long id;
    private String vehicle_model;
}
