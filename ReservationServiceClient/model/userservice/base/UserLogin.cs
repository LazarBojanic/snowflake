
public class UserLogin {
    public String email{ get; set; }
    public String pass{ get; set; }
    public UserLogin() {

    }
    public UserLogin(string email, string pass) {
        this.email = email;
        this.pass = pass;
    }
}