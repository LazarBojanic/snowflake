package rs.raf.core.dto.reservationservice.view;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FirmViewDto {
    private Long id;
    private String firm_name;
    private String description;
    private Integer number_of_vehicles;
    private String city;
}
