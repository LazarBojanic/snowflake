
public class NotificationType {
    public int id{ get; set; }
    public string notification_type{ get; set; }

    public NotificationType(string notification_type) {
        this.notification_type = notification_type;
    }

    public NotificationType() {
    }

    public NotificationType(int id, string notification_type) {
        this.id = id;
        this.notification_type = notification_type;
    }
}