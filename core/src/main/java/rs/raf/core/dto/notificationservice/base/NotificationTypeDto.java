package rs.raf.core.dto.notificationservice.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationTypeDto {
    private Integer id;
    private String notification_type;

    public NotificationTypeDto(String notification_type) {
        this.notification_type = notification_type;
    }
}