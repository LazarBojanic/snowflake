package rs.raf.core.dto.notificationservice.view;

import lombok.*;
import rs.raf.core.dto.notificationservice.base.NotificationDto;
import rs.raf.core.dto.notificationservice.base.NotificationTypeDto;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationViewDto {
    private Long id;
    private NotificationTypeDto notification_type;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public NotificationViewDto(NotificationTypeDto notification_type, String to, String subject, String text){
        this.notification_type = notification_type;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = new Date();
    }
}