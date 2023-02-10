package rs.raf.core.dto.reservationservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReviewDto {
    private Long id;
    private Long client_user_id;
    private Long firm_id;
    private String text;
    private Double grade;
}
