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
    public partial class AdminHubForm : Form {
        private AdminUser adminUser { get; set; }
        public AdminHubForm() {
            InitializeComponent();
        }
        public AdminHubForm(AdminUser adminUser) {
            InitializeComponent();
            this.adminUser = adminUser;
            

        }
        public async Task refreshUserTable() {
            dataGridViewUsers.Rows.Clear();
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            String serviceUserListJson = await RestClient.sendGet(RestClient.USER_SERVICE_URL + "service_user/getAll", tokenString);
            List<ServiceUser> serviceUserList = JsonUtil.deserialize<List<ServiceUser>>(serviceUserListJson);
            BindingList<ServiceUser> bindingList = new BindingList<ServiceUser>(serviceUserList);
            BindingSource source = new BindingSource(bindingList, null);
            dataGridViewUsers.DataSource = source;
        }

        private void buttonClose_Click(object sender, EventArgs e) {
            this.Close();
        }

        private async void buttonEnableUser_Click(object sender, EventArgs e) {
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            DataGridViewRow selectedRow = dataGridViewUsers.SelectedRows[0];
            int userId = Convert.ToInt32(selectedRow.Cells[0].Value);

            UserEnabled userEnabled = new UserEnabled(userId, "yes");

            await RestClient.sendPut(userEnabled, RestClient.USER_SERVICE_URL + "user/admin/setUserEnabledState", tokenString);
            await refreshUserTable();
        }

        private async void buttonDisableUser_Click(object sender, EventArgs e) {
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            DataGridViewRow selectedRow = dataGridViewUsers.SelectedRows[0];
            int userId = Convert.ToInt32(selectedRow.Cells[0].Value);

            UserEnabled userEnabled = new UserEnabled(userId, "no");

            await RestClient.sendPut(userEnabled, RestClient.USER_SERVICE_URL + "user/admin/setUserEnabledState", tokenString);
            await refreshUserTable();
        }

        private async void AdminHubForm_Load(object sender, EventArgs e) {
            await refreshUserTable();
        }
    }
}
