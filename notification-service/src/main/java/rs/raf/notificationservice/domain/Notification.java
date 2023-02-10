package rs.raf.notificationservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private NotificationType notification_type;
    @Column(name = "from_email")
    private String from;
    @Column(name = "to_email")
    private String to;
    @Column(name = "subject")
    private String subject;
    @Column(name = "text", length = 1000)
    private String text;
    @Column(name = "date_sent")
    private Date date_sent;

    public Notification(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = new Date();
    }
}