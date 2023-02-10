
public class Firm {
    public long id{ get; set; }
    public string firm_name{ get; set; }
    public string description{ get; set; }
    public int number_of_vehicles{ get; set; }
    public string city { get; set; }
    public Firm(long id, string firm_name, string description, int number_of_vehicles, string city) {
        this.id = id;
        this.firm_name = firm_name;
        this.description = description;
        this.number_of_vehicles = number_of_vehicles;
        this.city = city;
    }
    public Firm() {

    }
}
