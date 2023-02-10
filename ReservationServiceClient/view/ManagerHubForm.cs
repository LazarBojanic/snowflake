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
    public partial class ManagerHubForm : Form {
        private ManagerUser managerUser;
        public ManagerHubForm() {
            InitializeComponent();
        }
        public ManagerHubForm(ManagerUser parManagerUser) {
            InitializeComponent();
            managerUser = parManagerUser;
            
        }

        private void buttonCreateFirm_Click(object sender, EventArgs e) {
            CreateFirmForm createFirmForm= new CreateFirmForm(managerUser);
            createFirmForm.ShowDialog();
        }

        private void buttonUpdateFirm_Click(object sender, EventArgs e) {

        }

        private void buttonDeleteFirm_Click(object sender, EventArgs e) {

        }
        public async Task refreshDataGridViewFirms() {
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
            catch (Exception e) {

            }
        }

        private async void ManagerHubForm_Load(object sender, EventArgs e) {
            await refreshDataGridViewFirms();
        }
    }
}
