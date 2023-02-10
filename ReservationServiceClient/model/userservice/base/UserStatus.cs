
public class UserStatus {
    public long id { get; set; }
    public long client_user_id { get; set; }
    public long rank_id { get; set; }
    public int discount_percent { get; set; }
    public int number_of_days_reserved { get; set; }
    public int current_number_of_reservations { get; set; }

    public UserStatus() {
    }

    public UserStatus(long id, long client_user_id, long rank_id, int discount_percent, int number_of_days_reserved, int current_number_of_reservations) {
        this.id = id;
        this.client_user_id = client_user_id;
        this.rank_id = rank_id;
        this.discount_percent = discount_percent;
        this.number_of_days_reserved = number_of_days_reserved;
        this.current_number_of_reservations = current_number_of_reservations;
    }
}
