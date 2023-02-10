package rs.raf.core.dto.notificationservice.base;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReservationMadeNotificationDto {
    private Long id;
    private Integer notification_type_id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date date_sent;

    public ReservationMadeNotificationDto(String to, String firstName, String lastName, String fullVehicleName, Date startDate, Date endDate){
        this.notification_type_id = 2;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Reservation Made";
        this.text = String.format("Dear %s %s, you have made a reservation of the vehicle: %s from %s to %s.", firstName, lastName, fullVehicleName, startDate.toString(), endDate.toString());
        this.date_sent = new Date();
    }
}