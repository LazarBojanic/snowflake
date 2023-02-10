
public class UserStatusView {
    public long id { get; set; }
    public ClientUser client_user { get; set; }
    public Rank rank { get; set; }
    public int discount_percent { get; set; }
    public int number_of_days_reserved { get; set; }
    public int current_number_of_reservations { get; set; }

    public UserStatusView() {
    }

    public UserStatusView(long id, ClientUser client_user, Rank rank, int discount_percent, int number_of_days_reserved, int current_number_of_reservations) {
        this.id = id;
        this.client_user = client_user;
        this.rank = rank;
        this.discount_percent = discount_percent;
        this.number_of_days_reserved = number_of_days_reserved;
        this.current_number_of_reservations = current_number_of_reservations;
    }
}
