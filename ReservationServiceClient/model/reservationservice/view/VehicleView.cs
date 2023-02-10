
public class VehicleView {
    public long id { get; set; }
    public VehicleType vehicle_type { get; set; }
    public VehicleModel vehicle_model { get; set; }
    public String vehicle_name { get; set; }
    public int production_year { get; set; }
    public Double horse_power { get; set; }
    public VehicleView() {
    }

    public VehicleView(long id, VehicleType vehicle_type, VehicleModel vehicle_model, string vehicle_name, int production_year, double horse_power) {
        this.id = id;
        this.vehicle_type = vehicle_type;
        this.vehicle_model = vehicle_model;
        this.vehicle_name = vehicle_name;
        this.production_year = production_year;
        this.horse_power = horse_power;
    }

    
}
