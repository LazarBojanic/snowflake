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
    public partial class ReviewsForm : Form {
        private ClientUser clientUser;
        private List<ReviewJoined> reviewJoinedList = new List<ReviewJoined>();
        public ReviewsForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;
            
        }

        private void buttonMakeAReview_Click(object sender, EventArgs e) {
            MakeAReviewForm makeAReviewForm = new MakeAReviewForm(clientUser);
            makeAReviewForm.ShowDialog();
        }
        public async Task refreshDataGridViewReviews() {
            try {
                dataGridViewReviews.Rows.Clear();
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                string reviewListJson = await RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "review/getAllByClientUserId/" + clientUser.id, tokenString);
                List<ReviewView> reviewViewList = JsonUtil.deserialize<List<ReviewView>>(reviewListJson);
                if (reviewViewList != null) {
                    reviewJoinedList = Util.reviewViewListToReviewJoinedList(reviewViewList);
                    BindingList<ReviewJoined> bindingList = new BindingList<ReviewJoined>(reviewJoinedList);
                    BindingSource source = new BindingSource(bindingList, null);
                    dataGridViewReviews.DataSource = source;
                }
            }
            catch (Exception e) {

            }
        }

        private void buttonSortByFirmName_Click(object sender, EventArgs e) {
            reviewJoinedList.Sort((x, y) => x.firm_name.CompareTo(y.firm_name));
            BindingList<ReviewJoined> bindingList = new BindingList<ReviewJoined>(reviewJoinedList);
            BindingSource source = new BindingSource(bindingList, null);
            dataGridViewReviews.DataSource = source;
        }

        private void buttonSortByFirmCity_Click(object sender, EventArgs e) {
            reviewJoinedList.Sort((x, y) => x.firm_city.CompareTo(y.firm_city));
            BindingList<ReviewJoined> bindingList = new BindingList<ReviewJoined>(reviewJoinedList);
            BindingSource source = new BindingSource(bindingList, null);
            dataGridViewReviews.DataSource = source;
        }

        private async void ReviewsForm_Load(object sender, EventArgs e) {
            await refreshDataGridViewReviews();
        }
    }
}
