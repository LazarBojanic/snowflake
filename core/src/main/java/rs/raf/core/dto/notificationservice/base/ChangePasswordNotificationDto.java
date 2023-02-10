package rs.raf.core.dto.notificationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChangePasswordNotificationDto {
    private Long id;
    private Integer notification_type_id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public ChangePasswordNotificationDto(String to, String firstName, String lastName, String token){
        this.notification_type_id = 1;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Password change request";
        this.text = String.format("Dear %s %s, please paste the following token in your client app to change your password: %s", firstName, lastName, token);
        this.date_sent = new Date();
    }
}