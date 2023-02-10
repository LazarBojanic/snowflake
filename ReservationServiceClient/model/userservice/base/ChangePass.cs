
public class ChangePass {
    public long user_id{ get; set; }
    public string oldPass{ get; set; }
    public string newPass { get; set; }

    public ChangePass() {
    }

    public ChangePass(long user_id, string oldPass, string newPass) {
        this.user_id = user_id;
        this.oldPass = oldPass;
        this.newPass = newPass;
    }
}
