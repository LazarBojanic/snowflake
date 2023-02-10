
public class Vehicle {
    public long id { get; set; }
    public long vehicle_type_id { get; set; }
    public long vehicle_model_id { get; set; }
    public String vehicle_name { get; set; }
    public int production_year { get; set; }
    public Double horse_power { get; set; }
    public Vehicle() {
    }

    public Vehicle(long id, long vehicle_type_id, long vehicle_model_id, string vehicle_name, int production_year, double horse_power) {
        this.id = id;
        this.vehicle_type_id = vehicle_type_id;
        this.vehicle_model_id = vehicle_model_id;
        this.vehicle_name = vehicle_name;
        this.production_year = production_year;
        this.horse_power = horse_power;
    }

    
}
