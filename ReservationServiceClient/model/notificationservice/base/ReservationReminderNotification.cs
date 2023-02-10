
public class ReservationReminderNotification {
    public long id { get; set; }
    public int notification_type_id { get; set; }
    public string from { get; set; }
    public string to { get; set; }
    public string subject { get; set; }
    public string text { get; set; }
    public DateTime date_sent { get; set; }

    public ReservationReminderNotification(string to, string firstName, string lastName, string fullVehicleName, DateTime startDate, DateTime endDate){
        this.notification_type_id = 2;
        this.from = "bojanic.lazar50@gmail.com";
        this.to = to;
        this.subject = "Reservation Reminder";
        this.text = $"Dear {firstName} {lastName}, you have a reservation due in 3 days of the vehicle {fullVehicleName}, from {Convert.ToString(startDate)} to {Convert.ToString(endDate)}.";
        this.date_sent = DateTime.Now;
    }

    public ReservationReminderNotification() {
    }

    public ReservationReminderNotification(long id, int notification_type_id, string from, string to, string subject, string text, DateTime date_sent) {
        this.id = id;
        this.notification_type_id = notification_type_id;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.date_sent = date_sent;
    }
}