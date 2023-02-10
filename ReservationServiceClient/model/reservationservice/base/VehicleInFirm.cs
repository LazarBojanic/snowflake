
public class VehicleInFirm {
    public long id { get; set; }
    public long firm_id { get; set; }
    public long vehicle_id { get; set; }
    public Double price { get; set; }
    public long reservation_id { get; set; }
    public VehicleInFirm() {
    }

    public VehicleInFirm(long id, long firm_id, long vehicle_id, double price, long reservation_id) {
        this.id = id;
        this.firm_id = firm_id;
        this.vehicle_id = vehicle_id;
        this.price = price;
        this.reservation_id = reservation_id;
    }

    
}
