package rs.raf.core.dto.userservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RankDto {
    private Integer id;
    private String rank;
    private Integer min_number_of_days;
    private Integer max_number_of_days;
}
