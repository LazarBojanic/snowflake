
public class ReviewView {
    public long id { get; set; }
    public long client_user_id { get; set; }
    public Firm firm{ get; set; }
    public string text { get; set; }
    public double grade { get; set; }

    public ReviewView() {
    }

    public ReviewView(long id, long client_user_id, Firm firm, string text, double grade) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.firm = firm;
        this.text = text;
        this.grade = grade;
    }
}
