using ReservationServiceClient.http;
using ReservationServiceClient.util;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.Design.AxImporter;
using System.Xml.Linq;

namespace ReservationServiceClient.view {
    public partial class UserStatusForm : Form {
        private ClientUser clientUser;
        private UserStatusView userStatus;
        public UserStatusForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;
            

        }
        public async Task getUserStatus() {
            String tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            String userStatusJson = await RestClient.sendGet(RestClient.USER_SERVICE_URL + "user_status/get/" + clientUser.id, tokenString);
            userStatus = JsonUtil.deserialize<UserStatusView>(userStatusJson);
            textBoxRank.Text = userStatus.rank.rank;
            textBoxDiscountPercent.Text = Convert.ToString(userStatus.discount_percent);
            textBoxNumberOfDaysReserved.Text = Convert.ToString(userStatus.number_of_days_reserved);
            textBoxCurrentNumberOfReservations.Text = Convert.ToString(userStatus.current_number_of_reservations);
        }

        private void buttonOk_Click(object sender, EventArgs e) {

        }

        private async void UserStatusForm_Load(object sender, EventArgs e) {
            await getUserStatus();
        }
    }
}
