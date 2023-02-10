
public class ManagerUser {
    public long id{ get; set; }
    public int user_role_id{ get; set; }
    public String email{ get; set; }
    public String username{ get; set; }
    public String pass{ get; set; }
    public String phone_number{ get; set; }
    public DateTime date_of_birth{ get; set; }
    public String first_name{ get; set; }
    public String last_name{ get; set; }
    public long firm_id{ get; set; }
    public DateTime hire_date{ get; set; }
    public string enabled { get; set; }
    public ManagerUser() {

    }
    public ManagerUser(long id, int user_role_id, string email, string username, string pass, string phone_number, DateTime date_of_birth, string first_name, string last_name, long firm_id, DateTime hire_date, string enabled) {
        this.id = id;
        this.user_role_id = user_role_id;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.first_name = first_name;
        this.last_name = last_name;
        this.firm_id = firm_id;
        this.hire_date = hire_date;
        this.enabled = enabled; 
    }
}