
public class ReviewJoined {
    public long id { get; set; }
    public long client_user_id { get; set; }
    public long firm_id { get; set; }
    public string firm_name{ get; set; }
    public string firm_city { get; set; }
    public string text { get; set; }
    public double grade { get; set; }

    public ReviewJoined() {
    }

    public ReviewJoined(long id, long client_user_id, long firm_id, string firm_name, string firm_city, string text, double grade) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.firm_id = firm_id;
        this.firm_name = firm_name;
        this.firm_city = firm_city;
        this.text = text;
        this.grade = grade;
        this.firm_id = firm_id;
    }
}
