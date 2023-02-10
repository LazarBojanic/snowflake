
public class VehicleInFirmView {
    public long id { get; set; }
    public Firm firm { get; set; }
    public VehicleView vehicle { get; set; }
    public Double price { get; set; }
    public VehicleInFirmView() {
    }

    public VehicleInFirmView(long id, Firm firm, VehicleView vehicle, double price) {
        this.id = id;
        this.firm = firm;
        this.vehicle = vehicle;
        this.price = price;
    }

    
}
