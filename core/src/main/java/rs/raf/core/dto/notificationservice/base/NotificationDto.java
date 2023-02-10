package rs.raf.core.dto.notificationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationDto {
    private Long id;
    private Integer notification_type_id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public NotificationDto(Integer notification_type_id, String to, String subject, String text){
        this.notification_type_id = notification_type_id;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = new Date();
    }
}