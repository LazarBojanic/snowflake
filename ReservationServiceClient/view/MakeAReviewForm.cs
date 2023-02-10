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
    public partial class MakeAReviewForm : Form {
        private ClientUser clientUser;
        public MakeAReviewForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;
            
        }

        private async void buttonConfirm_Click(object sender, EventArgs e) {
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            DataGridViewRow selectedRow = dataGridViewFirms.SelectedRows[0];
            int firmId = Convert.ToInt32(selectedRow.Cells[0].Value);
            string reviewText = textBoxReviewText.Text;
            double grade = Convert.ToDouble(textBoxGrade.Text);

            Review review = new Review();
            review.client_user_id = clientUser.id;
            review.firm_id = firmId;
            review.text = reviewText;
            review.grade = grade;

            await RestClient.sendPost(review, RestClient.RESERVATION_SERVICE_URL + "review/create", tokenString);
        }

        public async Task refreshFirmDataGridView() {
            try {
                dataGridViewFirms.Rows.Clear();
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                string firmListJson = await RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "firm/getAll", tokenString);
                List<Firm> firmList = JsonUtil.deserialize<List<Firm>>(firmListJson);
                if (firmList != null) {
                    BindingList<Firm> bindingList = new BindingList<Firm>(firmList);
                    BindingSource source = new BindingSource(bindingList, null);
                    dataGridViewFirms.DataSource = source;
                }
            }
            catch(Exception e) {

            }
        }

        private void buttonClose_Click(object sender, EventArgs e) {
            this.Close();
        }

        private async void MakeAReviewForm_Load(object sender, EventArgs e) {
            await refreshFirmDataGridView();
        }
    }
}
