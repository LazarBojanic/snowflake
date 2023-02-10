

public class ReservationView {
    public long id { get; set; }
    public long client_user_id{ get; set; }
    public VehicleInFirmView vehicle_in_firm { get; set; }
    public DateTime start_date { get; set; }
    public DateTime end_date { get; set; }
    public ReservationView() {
    }

    public ReservationView(long id, long client_user_id, VehicleInFirmView vehicle_in_firm, DateTime start_date, DateTime end_date) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.vehicle_in_firm = vehicle_in_firm;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    

}
