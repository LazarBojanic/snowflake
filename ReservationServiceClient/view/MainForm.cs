using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using ReservationServiceClient.http;
using ReservationServiceClient.model;
using ReservationServiceClient.util;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace ReservationServiceClient.view {
    public partial class MainForm : Form {
        private string email { set; get; }
        private string pass { set; get; }
        public MainForm() {
            InitializeComponent();
        }

        private async void buttonLoginAsAdmin_Click(object sender, EventArgs e) {
            email = textBoxEmail.Text;
            pass = textBoxPass.Text;
            UserLogin userLogin = new UserLogin(email, pass);
            string tokenJson = await RestClient.sendPost(userLogin, RestClient.USER_SERVICE_URL + "user/admin/login", RestClient.MASTER_TOKEN);
            string tokenString = "";
            try {
                Token token = JsonUtil.deserialize<Token>(tokenJson);
                if (token != null) {
                    tokenString = token.token;
                    String serviceUserJson = await RestClient.sendGet(RestClient.USER_SERVICE_URL + "service_user/getByEmail/" + email, tokenString);
                    ServiceUser serviceUser = JsonUtil.deserialize<ServiceUser>(serviceUserJson);

                    AdminUser adminUser = new AdminUser(
                        serviceUser.id,
                        serviceUser.user_role_id,
                        serviceUser.email,
                        serviceUser.username,
                        serviceUser.pass,
                        serviceUser.phone_number,
                        serviceUser.date_of_birth,
                        serviceUser.first_name,
                        serviceUser.last_name,
                        "yes"
                        );
                    SessionManager.getInstance().userWithTokenList.Add(new UserWithToken(userLogin.email, token.token));
                    SessionManager.getInstance().currentUser = serviceUser;
                    AdminHubForm adminHubForm = new AdminHubForm(adminUser);
                    adminHubForm.ShowDialog();
                }
                else {
                    labelMessage.Text = ("Email not found");
                    labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
                }
            }

            catch (Exception ex) {
                labelMessage.Text = ex.Message;
                labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
            }
        }

        private async void buttonLoginAsClient_Click(object sender, EventArgs e) {
            email = textBoxEmail.Text;
            pass = textBoxPass.Text;
            UserLogin userLogin = new UserLogin(email, pass);
            string tokenJson = await RestClient.sendPost(userLogin, RestClient.USER_SERVICE_URL + "user/client/login", RestClient.MASTER_TOKEN);
            string tokenString = "";
            try {
                Token token = JsonUtil.deserialize<Token>(tokenJson);
                if (token != null) {
                    tokenString = token.token;
                    JwtSecurityToken decodedToken = Util.decodeToken(tokenString);
                    string enabled = Util.getTokenClaimsValue(decodedToken, "enabled");
                    if (enabled.Equals("yes")) {
                        String serviceUserJson = await RestClient.sendGet(RestClient.USER_SERVICE_URL + "service_user/getByEmail/" + email, tokenString);
                        ServiceUser serviceUser = JsonUtil.deserialize<ServiceUser>(serviceUserJson);
                        ClientUser clientUser = new ClientUser(
                            serviceUser.id,
                            serviceUser.user_role_id,
                            serviceUser.email,
                            serviceUser.username,
                            serviceUser.pass,
                            serviceUser.phone_number,
                            serviceUser.date_of_birth,
                            serviceUser.first_name,
                            serviceUser.last_name,
                            serviceUser.passport_number,
                            "yes");
                        SessionManager.getInstance().userWithTokenList.Add(new UserWithToken(userLogin.email, token.token));
                        SessionManager.getInstance().currentUser = serviceUser;
                        ClientHubForm clientForm = new ClientHubForm(clientUser);
                        clientForm.ShowDialog();
                    }
                    else {
                        labelMessage.Text = ("Email not found or your account has been disabled");
                        labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
                    }
                }
                else {
                    labelMessage.Text = ("Email not found or your account has been disabled");
                    labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
                }
            }

            catch (Exception ex) {
                labelMessage.Text = ex.Message;
                labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
            }

        }

        private async void buttonLoginAsManager_Click(object sender, EventArgs e) {
            email = textBoxEmail.Text;
            pass = textBoxPass.Text;
            UserLogin userLogin = new UserLogin(email, pass);
            string tokenJson = await RestClient.sendPost(userLogin, RestClient.USER_SERVICE_URL + "user/manager/login", RestClient.MASTER_TOKEN);
            string tokenString = "";
            try {
                Token token = JsonUtil.deserialize<Token>(tokenJson);
                if (token != null) {
                    tokenString = token.token;
                    JwtSecurityToken decodedToken = Util.decodeToken(tokenString);
                    string enabled = Util.getTokenClaimsValue(decodedToken, "enabled");
                    if (enabled.Equals("yes")) {
                        String serviceUserJson = await RestClient.sendGet(RestClient.USER_SERVICE_URL + "service_user/getByEmail/" + email, tokenString);
                        ServiceUser serviceUser = JsonUtil.deserialize<ServiceUser>(serviceUserJson);
                        ManagerUser managerUser = new ManagerUser(
                            serviceUser.id,
                            serviceUser.user_role_id,
                            serviceUser.email,
                            serviceUser.username,
                            serviceUser.pass,
                            serviceUser.phone_number,
                            serviceUser.date_of_birth,
                            serviceUser.first_name,
                            serviceUser.last_name,
                            serviceUser.firm_id,
                            serviceUser.hire_date,
                            "yes");
                        SessionManager.getInstance().userWithTokenList.Add(new UserWithToken(userLogin.email, token.token));
                        SessionManager.getInstance().currentUser = serviceUser;
                        ManagerHubForm managerHubForm = new ManagerHubForm(managerUser);
                        managerHubForm.ShowDialog();
                    }
                    else {
                        labelMessage.Text = ("Email not found or your account has been disabled");
                        labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
                    }
                }
                else {
                    labelMessage.Text = ("Email not found or your account has been disabled");
                    labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
                }
            }

            catch (Exception ex) {
                labelMessage.Text = ex.Message;
                labelMessage.Left = (this.Size.Width - labelMessage.Width) / 2;
            }
        }

        private void buttonRegisterAsClient_Click(object sender, EventArgs e) {
            RegisterAsClientForm registerAsClientForm = new RegisterAsClientForm();
            registerAsClientForm.ShowDialog();
        }

        private void buttonRegisterAsManager_Click(object sender, EventArgs e) {
            RegisterAsManagerForm registerAsManagerForm = new RegisterAsManagerForm();
            registerAsManagerForm.ShowDialog();
        }

        private void buttonExit_Click(object sender, EventArgs e) {
            this.Close();
        }

        private void MainForm_Load(object sender, EventArgs e) {

        }
    }
}
