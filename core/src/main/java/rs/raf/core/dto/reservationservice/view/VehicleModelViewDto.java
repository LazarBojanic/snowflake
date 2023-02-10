package rs.raf.core.dto.reservationservice.view;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VehicleModelViewDto {
    private Long id;
    private String vehicle_model;
}
