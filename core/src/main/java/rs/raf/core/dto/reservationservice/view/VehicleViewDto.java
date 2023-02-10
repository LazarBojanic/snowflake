package rs.raf.core.dto.reservationservice.view;

import lombok.*;
import rs.raf.core.dto.reservationservice.base.VehicleModelDto;
import rs.raf.core.dto.reservationservice.base.VehicleTypeDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleViewDto {
    private Long id;
    private VehicleTypeDto vehicle_type;
    private VehicleModelDto vehicle_model;
    private String vehicle_name;
    private Integer production_year;
    private Double horse_power;
}
