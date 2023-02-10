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

namespace ReservationServiceClient.view {
    public partial class ClientHubForm : Form {
        private ClientUser clientUser { get; set; }
        private List<ReservationView> reservationViewDtoList { get; set; }
        public ClientHubForm() {
            InitializeComponent();
        }
        public ClientHubForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;
            labelUsername.Text = clientUser.username;
        }

        private void buttonEditProfile_Click(object sender, EventArgs e) {
            ClientEditProfileForm clientEditProfileForm = new ClientEditProfileForm(clientUser);
            clientEditProfileForm.ShowDialog();
        }
        private void buttonViewStatus_Click(object sender, EventArgs e) {
            UserStatusForm userStatusForm = new UserStatusForm(clientUser);
            userStatusForm.ShowDialog();
        }

        private void buttonMakeAReservation_Click(object sender, EventArgs e) {

        }

        private void buttonViewPastReservations_Click(object sender, EventArgs e) {

        }

        private void buttonClose_Click(object sender, EventArgs e) {
            this.Close();
        }

        private void buttonReviews_Click(object sender, EventArgs e) {
            ReviewsForm reviewsFrom = new ReviewsForm(clientUser);
            reviewsFrom.ShowDialog();
        }

        private async void ClientHubForm_Load(object sender, EventArgs e) {
            await refreshDataGridViewReservations();
        }
        public async Task refreshDataGridViewReservations() {
            try {
                dataGridViewReservations.Rows.Clear();
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                string reservationList = await RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "reservation/getAllByClientUserId/" + clientUser.id, tokenString);
                List<ReservationView> reviewViewList = JsonUtil.deserialize<List<ReservationView>>(reservationList);
                if (reviewViewList != null) {
                    List<ReservationJoined> reservationJoinedList = Util.reservationViewListToReservationJoinedList(reviewViewList);
                    BindingList<ReservationJoined> bindingList = new BindingList<ReservationJoined>(reservationJoinedList);
                    BindingSource source = new BindingSource(bindingList, null);
                    dataGridViewReservations.DataSource = source;
                }
            }
            catch (Exception e) {

            }
        }
    }
}
