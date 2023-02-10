public class NotificationView {
    public long id { get; set; }
    public NotificationType notification_type { get; set; }
    public string from { get; set; }
    public string to { get; set; }
    public string subject { get; set; }
    public string text { get; set; }
    public DateTime date_sent { get; set; }

    public NotificationView(NotificationType notification_type, string to, string subject, string text){
        this.notification_type = notification_type;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = DateTime.Now;
    }
}