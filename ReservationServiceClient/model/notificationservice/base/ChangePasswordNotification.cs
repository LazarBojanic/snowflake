
public class ChangePasswordNotification {
    public long id{ get; set; }
    public int notification_type_id{ get; set; }
    public string from{ get; set; }
    public string to{ get; set; }
    public string subject{ get; set; }
    public string text{ get; set; }
    public DateTime date_sent{ get; set; }

    public ChangePasswordNotification(string to, string firstName, string lastName, string token){
        this.notification_type_id = 1;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Password change request";
        this.text = $"Dear {firstName} {lastName}, please paste the following token in your client app to change your password: {token}";
        this.date_sent = DateTime.Now;
    }

    public ChangePasswordNotification() {
    }

    public ChangePasswordNotification(long id, int notification_type_id, string from, string to, string subject, string text, DateTime date_sent) {
        this.id = id;
        this.notification_type_id = notification_type_id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = date_sent;
    }
}