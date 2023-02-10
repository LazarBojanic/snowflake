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
    public partial class ChangePassForm : Form {
        private AdminUser adminUser;
        private ClientUser clientUser;
        private ManagerUser managerUser;
        public ChangePassForm() {
            InitializeComponent();
        }
        public ChangePassForm(AdminUser parAdminUser) {
            InitializeComponent();
            adminUser = parAdminUser;
            textBoxEmail.Text = adminUser.email;
        }
        public ChangePassForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;
            textBoxEmail.Text = clientUser.email;
        }
        public ChangePassForm(ManagerUser parManagerUser) {
            InitializeComponent();
            managerUser = parManagerUser;
            textBoxEmail.Text = managerUser.email;
        }

        private async void buttonConfirm_Click(object sender, EventArgs e) {
            long userId = 0;
            string oldPass = textBoxOldPass.Text;
            string newPass = textBoxNewPass.Text;
            if (adminUser != null && clientUser == null && managerUser == null) {
                userId = adminUser.id;
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                ChangePass changePass = new ChangePass(userId, oldPass, newPass);
                await RestClient.sendPost(changePass, RestClient.USER_SERVICE_URL + "user/admin/changePassword/" + userId, tokenString);
            }
            if (adminUser == null && clientUser != null && managerUser == null) {
                userId = clientUser.id;
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                ChangePass changePass = new ChangePass(userId, oldPass, newPass);
                await RestClient.sendPost(changePass, RestClient.USER_SERVICE_URL + "user/client/changePassword/" + userId, tokenString);
            }
            if (adminUser == null && clientUser == null && managerUser != null) {
                userId = managerUser.id;
                string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
                ChangePass changePass = new ChangePass(userId, oldPass, newPass);
                await RestClient.sendPost(changePass, RestClient.USER_SERVICE_URL + "user/manager/changePassword/" + userId, tokenString);
            }
            

            
        }

        private void buttonCancel_Click(object sender, EventArgs e) {
            this.Close();
        }

        private void ChangePassForm_Load(object sender, EventArgs e) {

        }
    }
}
