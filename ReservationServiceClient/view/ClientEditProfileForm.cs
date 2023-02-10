using ReservationServiceClient.http;
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

namespace ReservationServiceClient.view {
    public partial class ClientEditProfileForm : Form {
        private ClientUser clientUser { get; set; }
        public ClientEditProfileForm(ClientUser parClientUser) {
            InitializeComponent();
            clientUser = parClientUser;

            textBoxEmail.Text = clientUser.email;
            textBoxUsername.Text = clientUser.username;
            textBoxPhoneNumber.Text = clientUser.phone_number;
            dateTimePickerDateOfBirth.Value = clientUser.date_of_birth;
            textBoxFirstName.Text = clientUser.first_name;
            textBoxLastName.Text = clientUser.last_name;
            textBoxPassportNumber.Text = Convert.ToString(clientUser.passport_number);

        }

        private async void buttonConfirm_Click(object sender, EventArgs e) {
            ClientUser newClientUser = new ClientUser();
            if (!textBoxEmail.Text.Equals("")) {
                newClientUser.email = textBoxEmail.Text;
            }
            if (!textBoxUsername.Text.Equals("")) {
                newClientUser.username = textBoxUsername.Text;
            }
            if (!textBoxPhoneNumber.Text.Equals("")) {
                newClientUser.phone_number = textBoxPhoneNumber.Text;
            }
            if (!dateTimePickerDateOfBirth.Value.Equals(new DateTime(1800, 1, 1))) {
                newClientUser.date_of_birth = dateTimePickerDateOfBirth.Value;
            }
            if (!textBoxFirstName.Text.Equals("")) {
                newClientUser.first_name = textBoxFirstName.Text;
            }
            if (!textBoxLastName.Text.Equals("")) {
                newClientUser.last_name = textBoxLastName.Text;
            }
            if (!textBoxPassportNumber.Text.Equals("")) {
                newClientUser.passport_number = Convert.ToInt32(textBoxPassportNumber.Text);
            }
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            await RestClient.sendPut(newClientUser, RestClient.USER_SERVICE_URL + "user/client/update/" + clientUser.id, tokenString);
        }

        private void buttonCancel_Click(object sender, EventArgs e) {
            this.Close();
        }

        private async void buttonRequestPasswordChange_Click(object sender, EventArgs e) {
            string tokenString = SessionManager.getInstance().getTokenOfCurrentUser();
            await RestClient.sendGet(RestClient.USER_SERVICE_URL + "user/client/requestPasswordChange/" + clientUser.id, tokenString);
        }

        private void buttonChangePassword_Click(object sender, EventArgs e) {
            JwtSecurityToken decodedToken = Util.decodeToken(textBoxPassChangeToken.Text);
            if(Util.getTokenClaimsValue(decodedToken, "allowPasswordChange").Equals("yes")) {
                ChangePassForm changePassForm = new ChangePassForm(clientUser);
                changePassForm.ShowDialog();
            }
        }

        private void ClientEditProfileForm_Load(object sender, EventArgs e) {

        }
    }
}
