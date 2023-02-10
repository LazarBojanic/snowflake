package rs.raf.core.dto.notificationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReservationReminderNotificationDto {
    private Long id;
    private Integer notification_type_id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public ReservationReminderNotificationDto(String to, String firstName, String lastName, String fullVehicleName, Date startDate, Date endDate){
        this.notification_type_id = 2;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Reservation Reminder";
        this.text = String.format("Dear %s %s, you have a reservation due in 3 days of the vehicle %s, from %s to %s.", firstName, lastName, fullVehicleName, startDate.toString(), endDate.toString());
        this.date_sent = new Date();
    }
}