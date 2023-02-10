
public class Review {
    public long id{ get; set; }
    public long client_user_id{ get; set; }
    public long firm_id{ get; set; }
    public string text{ get; set; }
    public double grade{ get; set; }

    public Review() {
    }

    public Review(long id, long client_user_id, long firm_id, string text, double grade) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.firm_id = firm_id;
        this.text = text;
        this.grade = grade;
    }
}
