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
    public partial class CreateFirmForm : Form {
        private ManagerUser managerUser;
        public CreateFirmForm(ManagerUser parManagerUser) {
            InitializeComponent();
            this.managerUser = parManagerUser;
        }

        private void CreateFirmForm_Load(object sender, EventArgs e) {
            textBoxNumberOfVehicles.Text = "0";
        }

        private void buttonCancel_Click(object sender, EventArgs e) {
            this.Close();
        }

        private async void buttonConfirm_Click(object sender, EventArgs e) {
            Firm firm = new Firm();
            firm.firm_name = textBoxFirmName.Text;
            firm.description = textBoxDescription.Text;
            firm.number_of_vehicles = Convert.ToInt32(textBoxNumberOfVehicles.Text);
            firm.city = textBoxCity.Text;

            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();

            await RestClient.sendPost(firm, RestClient.RESERVATION_SERVICE_URL + "firm/create", tokenString);
        }
    }
}
