package rs.raf.core.dto.notificationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegistrationConfirmationNotificationDto {
    private Long id;
    private Integer notification_type_id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public RegistrationConfirmationNotificationDto(String to, String firstName, String lastName, String route, String token){
        this.notification_type_id = 0;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Registration Confirmation";
        this.text = String.format("Dear %s %s, please click the following link to confirm your registration: %s%s", firstName, lastName, route, token);
        this.date_sent = new Date();
    }
}