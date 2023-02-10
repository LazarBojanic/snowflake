
public class ReservationJoined {
    public long id { get; set; }
    public long client_user_id { get; set; }
    public long vehicle_in_firm_id { get; set; }
    public long firm_id { get; set; }
    public string firm_name { get; set; }
    public string firm_description { get; set; }
    public int firm_number_of_vehicles { get; set; }
    public string firm_city { get; set; }
    public long vehicle_id { get; set; }
    public long vehicle_type_id { get; set; }
    public String vehicle_type { get; set; }
    public long vehicle_model_id { get; set; }
    public String vehicle_model { get; set; }
    public String vehicle_name { get; set; }
    public int vehicle_production_year { get; set; }
    public Double vehicle_horse_power { get; set; }
    public Double vehicle_in_firm_price { get; set; }
    public DateTime reservation_start_date { get; set; }
    public DateTime reservation_end_date { get; set; }

}
