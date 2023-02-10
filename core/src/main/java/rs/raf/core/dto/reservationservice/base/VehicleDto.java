package rs.raf.core.dto.reservationservice.base;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleDto {
    private Long id;
    private Long vehicle_type_id;
    private Long vehicle_model_id;
    private String vehicle_name;
    private Integer production_year;
    private Double horse_power;
}
