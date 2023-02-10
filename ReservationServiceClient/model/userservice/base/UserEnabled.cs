public class UserEnabled {
    public long userId { get; set; }
    public string enabled { get; set; }
    public UserEnabled() {

    }
    public UserEnabled(long userId, string enabled) {
        this.userId = userId;
        this.enabled = enabled;
    }
}