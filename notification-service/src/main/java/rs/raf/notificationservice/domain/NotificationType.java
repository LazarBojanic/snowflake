package rs.raf.notificationservice.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class NotificationType {
    @Id
    private Integer id;
    @Column(name = "notification_type")
    private String notification_type;

    public NotificationType(String notification_type) {
        this.notification_type = notification_type;
    }
}
