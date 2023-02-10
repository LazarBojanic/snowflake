
public class Reservation {
    public long id { get; set; }
    public long client_user_id { get; set; }
    public long vehicle_in_firm_id { get; set; }
    public DateTime start_date { get; set; }
    public DateTime end_date { get; set; }
    public Reservation() {
    }

    public Reservation(long id, long client_user_id, long vehicle_in_firm_id, DateTime start_date, DateTime end_date) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.vehicle_in_firm_id = vehicle_in_firm_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    


}
